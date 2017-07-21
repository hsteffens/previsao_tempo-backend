package br.com.hbsis.userCity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.hbsis.controller.CityJPAController;
import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.persistencia.City;
import br.com.hbsis.provider.EntityManager;

/**
 * Classe com as regras de negocio das cidades do usuário.
 * 
 * @author  Hélinton P. Steffens
 *
 */
public final class BOUserCity {

	private BOUserCity(){
		
	}
	
	public static boolean create(CityDTO cityDTO){
		EntityManager.createEntityManagerFactory();
		EntityManagerFactory factory = null;
		try{
			factory = EntityManager.getFactory();
			
			City city = new City();
			city.setId(cityDTO.getId());
			city.setName(cityDTO.getName());
			city.setCountry(cityDTO.getCountry());
			city.setLatitude(cityDTO.getLatitude());
			city.setLongitude(cityDTO.getLongitude());

			CityJPAController controller = new CityJPAController(factory);
			return controller.create(city);
		}finally {
			if (factory.isOpen()) {
				EntityManager.destroyEntityManagerFactory();
			}
		}
	}
	
	public static List<CityDTO> getCities(){
		EntityManager.createEntityManagerFactory();
		EntityManagerFactory factory = null;
		
		try{
			factory = EntityManager.getFactory();
			CityJPAController controller = new CityJPAController(factory);
			List<City> cities = controller.findCity();
			
			if (cities != null && !cities.isEmpty()) {
				List<CityDTO> citiesDTO = new ArrayList<>();
				for (City city : cities) {
					CityDTO cityDTO = new CityDTO();
					cityDTO.setId(city.getId());
					cityDTO.setName(city.getName());
					cityDTO.setCountry(city.getCountry());
					cityDTO.setLatitude(city.getLatitude());
					cityDTO.setLongitude(city.getLongitude());
					
					citiesDTO.add(cityDTO);
				}
				
				return citiesDTO;
			}
			
		}finally {
			if (factory.isOpen()) {
				EntityManager.destroyEntityManagerFactory();
			}
		}
		return null;
	}
	
	public static boolean remove(Long id){
		EntityManager.createEntityManagerFactory();
		EntityManagerFactory factory = null;
		
		try{
			factory = EntityManager.getFactory();
			CityJPAController controller = new CityJPAController(factory);
			
			return controller.remove(id);
		}finally {
			if (factory.isOpen()) {
				EntityManager.destroyEntityManagerFactory();
			}
		}	
	}
	
}
