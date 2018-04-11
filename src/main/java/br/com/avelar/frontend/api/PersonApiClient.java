package br.com.avelar.frontend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.avelar.backend.api.PersonApi;
import br.com.avelar.backend.model.Person;
import br.com.avelar.frontend.util.ApiProxyProducer;

@Component
public class PersonApiClient implements PersonApi {
	
	@Autowired
	private ApiProxyProducer proxyProducer;
	
	@Override
	public void savePerson(Person person) {
		proxyProducer.makeProxy(PersonApi.class).savePerson(person);
	}

	@Override
	public List<Person> findAll() {
		return proxyProducer.makeProxy(PersonApi.class).findAll();
	}

}
