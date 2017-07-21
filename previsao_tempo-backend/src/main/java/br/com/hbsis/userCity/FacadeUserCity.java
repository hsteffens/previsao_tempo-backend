package br.com.hbsis.userCity;

import java.util.Arrays;

import br.com.hbsis.city.BOCity;
import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.entities.ResultDTO;
import br.com.hbsis.status.EnStatus;

/**
 * Classe com os facilidadores de manipulação das cidades do usuário.
 * 
 * @author  Hélinton P. Steffens
 *
 */
public final class FacadeUserCity {

	private FacadeUserCity(){
		
	}
	
	public static ResultDTO<String> addUserCity(CityDTO cityDTO){
		ResultDTO<String> resultDTO = new ResultDTO<>();
		
		CityDTO city = BOCity.getCity(cityDTO.getName());
		if (city == null) {
			resultDTO.setStatus(EnStatus.ERROR.getStatus());
			resultDTO.setMessages(Arrays.asList("Cidade não cadastrada na API."));
		}else if (BOUserCity.create(city)) {
			resultDTO.setStatus(EnStatus.SUCCESS.getStatus());
		}else {
			resultDTO.setStatus(EnStatus.ERROR.getStatus());
		}
		
		return resultDTO;
	} 
	
	public static ResultDTO<CityDTO> getCity(){
		ResultDTO<CityDTO> resultDTO = new ResultDTO<>();
		
		try{
			resultDTO.setResult(BOUserCity.getCities());
			resultDTO.setStatus(EnStatus.SUCCESS.getStatus());
		} catch (RuntimeException e) {
			resultDTO.setStatus(EnStatus.ERROR.getStatus());
			resultDTO.setMessages(Arrays.asList(e.getMessage()));
		}
		
		return resultDTO;
	}
}
