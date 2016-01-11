package psamolysov.demo.spring.restws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import psamolysov.demo.spring.restws.model.ZShop;
import psamolysov.demo.spring.restws.service.MessageService;
import psamolysov.demo.spring.restws.service.ZShopService;

@RestController
public class MessageController {

	private MessageService messageService;
	
	private ZShopService zshopService;
	
	@Autowired
	public void setMessageService(MessageService service) {
		this.messageService = service;
	}
	
	@Autowired
	public void setZShopService(ZShopService service) {
		this.zshopService = service;
	}
	
	@RequestMapping(path = "/message", method = RequestMethod.GET, 
			produces = "text/plain")
	public String textMessage() {
		return messageService.textMessage();
	}
	
	@RequestMapping(path = "/message", method = RequestMethod.GET, 
			produces = "application/json")
	public ZShop jsonMessage() {
		return zshopService.getRandomShop();
	}
	
	@RequestMapping(path = "/message", method = RequestMethod.GET, 
			produces = "text/xml")
	public ZShop xmlMessage() {	
		return zshopService.getRandomShop();
	}
}
