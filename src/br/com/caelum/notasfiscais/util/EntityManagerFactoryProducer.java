package br.com.caelum.notasfiscais.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProducer {
	
	@ApplicationScoped
	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("notas");
	}
}