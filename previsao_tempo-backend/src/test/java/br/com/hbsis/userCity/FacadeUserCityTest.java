package br.com.hbsis.userCity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.entities.ResultDTO;
import br.com.hbsis.status.EnStatus;

/**
 * Classe de teste referente dos facilitadores de City.
 * 
 * @author Hélinton P. Steffens
 *
 */
public class FacadeUserCityTest {

	@Test
	public void testInsert001(){
		CityDTO cityDTO = new CityDTO();
		cityDTO.setName("Batatinha");

		ResultDTO<String> result = FacadeUserCity.addUserCity(cityDTO);
		assertEquals(EnStatus.ERROR.getStatus(), result.getStatus());
		assertEquals(1, result.getMessages().size());
		assertEquals("Cidade não cadastrada na API.", result.getMessages().get(0));

	}
}
