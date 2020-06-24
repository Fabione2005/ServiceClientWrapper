package com.index.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.index.client.model.EconomicIndicatorDTO;
import com.index.client.model.EconomicIndicatorSeriesDTO;
import com.index.client.model.GeneralInfoEconomicIndicatorDTO;
import com.index.client.utils.DateUtils;

@Service
public class EconomicIndexServiceImpl implements EconomicIndexService {

	String GeneralInfoUrl = "https://mindicador.cl/api";
	String InfoUrl = "https://mindicador.cl/api/";

	@Autowired
	RestTemplate template;

	@Override
	public GeneralInfoEconomicIndicatorDTO retrieveAllGeneralEconomicIndexInfo() {

		String result = template.getForObject(GeneralInfoUrl, String.class);
		ObjectMapper maper = new ObjectMapper();
		maper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GeneralInfoEconomicIndicatorDTO infoDto = new GeneralInfoEconomicIndicatorDTO();

		try {
			// obtenemos ArrayJoson con los datos de la respuesta
			JsonNode json = maper.readTree(result);
			// obtenemos el objeto Json y extraemos
			// las propiedades que nos interesan
			infoDto.setAutor(json.get("autor").asText());

			String date = json.get("fecha").asText();
			
			infoDto.setDate(DateUtils.getDateFormated(date));

			infoDto.setVersion(json.get("version").asText());

			List<EconomicIndicatorDTO> listEconomic = new ArrayList<>();
			
			List<String> fieldNamesList = new ArrayList<>();
			
			json.fieldNames().forEachRemaining(item -> fieldNamesList.add(item));
			
			for(int i = 3;i < json.size();i++) 
			{
				EconomicIndicatorDTO economicIndicator = new EconomicIndicatorDTO();
				ObjectNode objectJson = (ObjectNode) json.get(fieldNamesList.get(i));
				
				economicIndicator.setCode(objectJson.get("codigo").asText());
				economicIndicator.setName(objectJson.get("nombre").asText());
				economicIndicator.setMeasure_unit(objectJson.get("unidad_medida").asText());
				
				String resultIndicator = template.getForObject(InfoUrl+fieldNamesList.get(i), String.class);
				
				ObjectMapper maperIndicator = new ObjectMapper();
				
				JsonNode jsonIndicator = maperIndicator.readTree(resultIndicator);
				ArrayNode array;
				
				List<EconomicIndicatorSeriesDTO> seriesList = new ArrayList<>();
				
				array = (ArrayNode)jsonIndicator.get("serie");
				for(Object ob:array) {
					//obtenemos el objeto Json y extraemos
					//las propiedades que nos interesan
					ObjectNode node =(ObjectNode)ob;
					
					EconomicIndicatorSeriesDTO serie = 
							new EconomicIndicatorSeriesDTO(DateUtils.getDateFormated(node.get("fecha").asText())
									,node.get("valor").asDouble());
					
					seriesList.add(serie);
				}
				
				economicIndicator.setSeriesList(seriesList);
				
				listEconomic.add(economicIndicator);
				
			}
			
			infoDto.setEconomicIndicatorList(listEconomic);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infoDto;
	}

}
