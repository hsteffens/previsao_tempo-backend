package br.com.hbsis.city;

import java.util.Arrays;
import java.util.List;

import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.entities.ResultDTO;
import br.com.hbsis.status.EnStatus;

/**
 * Classe com as facilitadores para manipulação de uma cidade.
 * 
 * @author Hélinton P. Steffens
 *
 */
public final class FacadeCity {

	private FacadeCity(){}
	
	public static ResultDTO<CityDTO> getCity(){
		ResultDTO<CityDTO> resultDTO = new ResultDTO<>();
		
		try{
			List<CityDTO> city = BOCity.getCity();
			resultDTO.setResult(city.subList(0, 2));
			resultDTO.setStatus(EnStatus.SUCCESS.getStatus());
		} catch (RuntimeException e) {
			resultDTO.setStatus(EnStatus.ERROR.getStatus());
			resultDTO.setMessages(Arrays.asList(e.getMessage()));
		}
		
		return resultDTO;
	}
}
