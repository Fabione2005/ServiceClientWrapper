package com.index.client.model;

import java.time.LocalDateTime;

public class EconomicIndicatorSeriesDTO {
	
	private LocalDateTime date;
	private double value;
	
	public EconomicIndicatorSeriesDTO() {
		super();
	}
	
	public EconomicIndicatorSeriesDTO(LocalDateTime date, double value) {
		super();
		this.date = date;
		this.value = value;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
