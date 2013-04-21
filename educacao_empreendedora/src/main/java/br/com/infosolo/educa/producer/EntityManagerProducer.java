package br.com.infosolo.educa.producer;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.infosolo.educa.listener.EMF;

public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	@Produces
    @RequestScoped
	protected EntityManager createEntityManager() {
		entityManager = EMF.createEntityManager();
		return entityManager;
	}

	protected void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
