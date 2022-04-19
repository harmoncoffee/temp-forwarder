package com.pharmondev.temp.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="vivariumindex")
public class TemperatureData {
	@Field(type=FieldType.Double)
	private double fahrenheit;
	@Field(type=FieldType.Date)
	private Date currentTime;
	@Id
	private String uuid;
	@Field(type=FieldType.Keyword )
	private String sensor;
	
	public double getFahrenheit() {
		return fahrenheit;
	}
	public void setFahrenheit(double fahrenheit) {
		this.fahrenheit = fahrenheit;
	}
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	public String getSensor() {
		return sensor;
	}
	public void setSensor(String sensor) {
		this.sensor = sensor;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "TemperatureData [fahrenheit=" + fahrenheit + ", currentTime=" + currentTime + ", uuid=" + uuid
				+ ", sensor=" + sensor + "]";
	}
	
	
}
