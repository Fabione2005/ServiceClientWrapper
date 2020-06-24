package com.index.client.model;

import java.time.LocalDateTime;
import java.util.List;

public class GeneralInfoEconomicIndicatorDTO {

	private String version;
	private String autor;
	private LocalDateTime date;
	private List<EconomicIndicatorDTO> economicIndicatorList;
	
	public GeneralInfoEconomicIndicatorDTO() {
		super();
	}
	
	public GeneralInfoEconomicIndicatorDTO(String version, String autor, LocalDateTime date,
			List<EconomicIndicatorDTO> economicIndicatorList) {
		super();
		this.version = version;
		this.autor = autor;
		this.date = date;
		this.economicIndicatorList = economicIndicatorList;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public List<EconomicIndicatorDTO> getEconomicIndicatorList() {
		return economicIndicatorList;
	}
	public void setEconomicIndicatorList(List<EconomicIndicatorDTO> economicIndicatorList) {
		this.economicIndicatorList = economicIndicatorList;
	}
}
