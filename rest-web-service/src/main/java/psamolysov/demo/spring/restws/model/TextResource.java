package psamolysov.demo.spring.restws.model;

import org.springframework.stereotype.Component;

@Component
public class TextResource {

	public String message() {
		return "Message#" + System.currentTimeMillis();
	}
}
