package br.com.hbsis.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hbsis.city.FacadeCity;
import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.entities.ResultDTO;

/**
 * Serviço para informar as cidades disponiveis.
 * 
 * @author Hélinton P. Steffens
 *
 */
@Path("/city")
public class CityService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResultDTO<CityDTO> getCity(){
		return FacadeCity.getCity();
	}
}
