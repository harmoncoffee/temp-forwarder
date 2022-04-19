package com.pharmondev.temp.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.pharmondev.temp.model.TemperatureData;

public interface TemperatureRepository extends ElasticsearchRepository<TemperatureData,String>{

}
