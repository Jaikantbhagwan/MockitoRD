package com.example.demo;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties//(prefix = "mail")
@Component
public class SampleProperty {
	
	private String stringProp1;
	 private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String getStringProp1() {
		return stringProp1;
	}

	public void setStringProp1(String stringProp1) {
		this.stringProp1 = stringProp1;
	} 
	 

}
