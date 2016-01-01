package psamolysov.demo.spring.restws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import psamolysov.demo.spring.restws.service.MessageService;

@RestController
public class MessageController {

	private MessageService service;
	
	@Autowired
	public void setMessageService(MessageService service) {
		this.service = service;
	}
	
	@RequestMapping(path = "/message", method = RequestMethod.GET, 
			produces = "text/plain")
	public String textMessage() {
		return service.textMessage();
	}
}
