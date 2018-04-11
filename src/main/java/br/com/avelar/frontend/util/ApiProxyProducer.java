package br.com.avelar.frontend.util;

import org.springframework.stereotype.Component;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Component
public class ApiProxyProducer {
	
	// TODO Carregar via JNDI. Hardcoded apenas para simplificar.
	private String baseUrl = "http://localhost:8080/backend";
	
	public <T> T makeProxy(Class<T> cls) {
		return Feign.builder()
						.encoder(new JacksonEncoder())
						.decoder(new JacksonDecoder())
						.target(cls, baseUrl);
	}
	
}
