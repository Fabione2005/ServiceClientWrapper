package com.index.client.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	
	public static LocalDateTime getDateFormated(String date) 
	{
		LocalDateTime result = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		date = date.contains("T") ? date.replace("T", " ").substring(0, 16) : date.substring(0, 16);

		result = LocalDateTime.parse(date, formatter);
		
		return result;
	}
	
}
