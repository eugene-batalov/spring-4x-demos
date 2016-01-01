package psamolysov.demo.spring.restws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psamolysov.demo.spring.restws.model.TextResource;

@Service
public class MessageService {

	private TextResource textResource;
	
	@Autowired
	public void setTextResource(TextResource textResource) {
		this.textResource = textResource;
	}
	
	public String textMessage() {
		return textResource.message();
	}
}
