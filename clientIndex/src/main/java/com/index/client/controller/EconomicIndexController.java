package com.index.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.client.model.GeneralInfoEconomicIndicatorDTO;
import com.index.client.service.EconomicIndexService;

@RestController
public class EconomicIndexController {

	@Autowired
	EconomicIndexService service;
	
	@GetMapping(value="/generalIndicatorWrapper",produces=MediaType.APPLICATION_JSON_VALUE)
	public GeneralInfoEconomicIndicatorDTO retrieveGeneralEconomicIndicator() {
		return service.retrieveAllGeneralEconomicIndexInfo();
	}
	
}
