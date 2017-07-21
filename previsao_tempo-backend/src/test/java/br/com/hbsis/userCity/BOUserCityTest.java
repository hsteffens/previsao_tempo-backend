package br.com.hbsis.userCity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.hbsis.entities.CityDTO;

public class BOUserCityTest {

	@Test
	public void testInsert001(){
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId(707860l);
		cityDTO.setName("Hurzuf");
		cityDTO.setCountry("UA");
		cityDTO.setLatitude(44.549999);
		cityDTO.setLongitude(34.283333);
		
		try{
			boolean isCreate = BOUserCity.create(cityDTO);
			assertTrue(isCreate);
			
			List<CityDTO> cities = BOUserCity.getCities();
			assertEquals(1, cities.size());
			
			assertEquals(cityDTO.getId(), cities.get(0).getId());
			assertEquals(cityDTO.getName(), cities.get(0).getName());
			assertEquals(cityDTO.getCountry(), cities.get(0).getCountry());
			assertEquals(cityDTO.getLongitude(), cities.get(0).getLongitude());
			assertEquals(cityDTO.getLatitude(), cities.get(0).getLatitude());
			
		}finally {
			BOUserCity.remove(cityDTO.getId());
		}
	}
	
	@Test
	public void testInsert002(){
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId(707860l);
		cityDTO.setName("Hurzuf");
		cityDTO.setCountry("UA");
		cityDTO.setLatitude(44.549999);
		cityDTO.setLongitude(34.283333);
		
		CityDTO cityDTO2 = new CityDTO();
		cityDTO2.setId(707861l);
		cityDTO2.setName("Blumenau");
		cityDTO2.setCountry("BR");
		cityDTO2.setLatitude(42.249999);
		cityDTO2.setLongitude(33.283333);
		
		try{
			boolean isCreate = BOUserCity.create(cityDTO);
			assertTrue(isCreate);
			
			isCreate = BOUserCity.create(cityDTO2);
			assertTrue(isCreate);
			
			List<CityDTO> cities = BOUserCity.getCities();
			assertEquals(2, cities.size());
			
			assertEquals(cityDTO.getId(), cities.get(0).getId());
			assertEquals(cityDTO.getName(), cities.get(0).getName());
			assertEquals(cityDTO.getCountry(), cities.get(0).getCountry());
			assertEquals(cityDTO.getLongitude(), cities.get(0).getLongitude());
			assertEquals(cityDTO.getLatitude(), cities.get(0).getLatitude());
			
			assertEquals(cityDTO2.getId(), cities.get(1).getId());
			assertEquals(cityDTO2.getName(), cities.get(1).getName());
			assertEquals(cityDTO2.getCountry(), cities.get(1).getCountry());
			assertEquals(cityDTO2.getLongitude(), cities.get(1).getLongitude());
			assertEquals(cityDTO2.getLatitude(), cities.get(1).getLatitude());
			
		}finally {
			BOUserCity.remove(cityDTO.getId());
			BOUserCity.remove(cityDTO2.getId());
		}
	}
}