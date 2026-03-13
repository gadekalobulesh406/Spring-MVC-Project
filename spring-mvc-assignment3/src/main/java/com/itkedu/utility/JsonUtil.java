package com.itkedu.utility;

import org.springframework.stereotype.Component;

import tools.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {

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
