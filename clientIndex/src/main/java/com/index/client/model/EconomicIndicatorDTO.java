package com.index.client.model;

import java.util.List;

public class EconomicIndicatorDTO {
	
	private String code;
	private String name;
	private String measure_unit;
	private List<EconomicIndicatorSeriesDTO> seriesList;
	
	
	public EconomicIndicatorDTO() {
		super();
	}

	public EconomicIndicatorDTO(String code, String name, String measure_unit,
			List<EconomicIndicatorSeriesDTO> seriesList) {
		super();
		this.code = code;
		this.name = name;
		this.measure_unit = measure_unit;
		this.seriesList = seriesList;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasure_unit() {
		return measure_unit;
	}
	public void setMeasure_unit(String measure_unit) {
		this.measure_unit = measure_unit;
	}
	public List<EconomicIndicatorSeriesDTO> getSeriesList() {
		return seriesList;
	}
	public void setSeriesList(List<EconomicIndicatorSeriesDTO> seriesList) {
		this.seriesList = seriesList;
	}
	
	
	
}
