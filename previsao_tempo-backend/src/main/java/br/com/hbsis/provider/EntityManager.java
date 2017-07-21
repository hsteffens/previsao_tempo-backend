package br.com.hbsis.provider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * F�brica de acesso a dados.
 * 
 * @author H�linton P. Steffens
 *
 */
public final class EntityManager {

	private static EntityManagerFactory factory;
	
	private EntityManager(){
		
	}
	
	public static void createEntityManagerFactory(){
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("CityPU");
		}
		
	}
	
	public static void destroyEntityManagerFactory(){
		if (factory != null) {
			factory.close();
		}
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
}
