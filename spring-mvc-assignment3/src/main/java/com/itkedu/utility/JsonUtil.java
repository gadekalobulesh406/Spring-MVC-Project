package com.itkedu.utility;

import org.springframework.stereotype.Component;

import tools.jackson.databind.ObjectMapper;

//import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class JsonUtil {

	//com.fasterxml.jackson.core  is relocated to jackson-databind 
	private  ObjectMapper objectMapper;
	
	public JsonUtil(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public String converProductToJson(Object object) throws Exception{
		return objectMapper.writeValueAsString(object);
	}
	
	public String converOrderToJson(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}
}
