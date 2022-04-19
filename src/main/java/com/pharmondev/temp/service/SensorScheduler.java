package com.pharmondev.temp.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pharmondev.temp.model.TemperatureData;
import com.pharmondev.temp.repositories.TemperatureRepository;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.io.w1.W1Master;

@Component
@EnableScheduling
public class SensorScheduler {
	@Autowired
	TemperatureRepository repo;
	
	@Scheduled(fixedDelay = 10000)
	public void getTemperature() {
		
		W1Master coordinator = new W1Master();
		
		for(TemperatureSensor device: coordinator.getDevices(TemperatureSensor.class)) {
			System.out.println("Device:"+device);
			TemperatureData data = new TemperatureData();
			
			device.getName();
			double celsius = device.getTemperature();
			double fahrenheit = (9.0/5.0)*celsius + 32;
			data.setCurrentTime(new Date());
			data.setFahrenheit(fahrenheit);
			if(device.getName().contains("28-3c01d075cba9")) {
				data.setSensor("sunlamp");
			}
			else {
				data.setSensor("coolnightlamp");
			}
			data.setUuid(UUID.randomUUID().toString());
			System.out.println("Attempting to send to elasticsearch");
			repo.save(data);
			System.out.println("Sent to elasticsearch");
			//send data to somewhere;
			
			System.out.println(data);
		}
	}
	
}
