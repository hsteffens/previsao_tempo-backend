package br.com.hbsis.city;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.hbsis.entities.CityDTO;

/**
 * Classe de teste referente a leitura do arquivo das cidades disponiveis.
 * 
 * @author Hélinton P. Steffens
 *
 */
public class BOCityTest {

	@Test
	public void testCity001(){
		List<CityDTO> city = BOCity.getCity();
		assertEquals(209579, city.size());
		
		assertEquals(707860, city.get(0).getId(), 0);
		assertEquals("Hurzuf", city.get(0).getName());
		assertEquals("UA", city.get(0).getCountry());
		assertEquals(34.283333, city.get(0).getLongitude(), 0);
		assertEquals(44.549999, city.get(0).getLatitude(), 0);
	}
}
