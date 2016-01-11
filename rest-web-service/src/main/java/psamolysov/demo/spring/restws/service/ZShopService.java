package psamolysov.demo.spring.restws.service;

import org.springframework.stereotype.Service;

import psamolysov.demo.spring.restws.model.ZShop;

@Service
public class ZShopService {
	
	public static final String IBM_Z_SHOP_NAME = "IBM zShop";
	
	public ZShop getRandomShop() {
		// TODO add some caching and randomization logic
		return new ZShop(IBM_Z_SHOP_NAME, (int) (Math.random() * 1000));
	}
}
