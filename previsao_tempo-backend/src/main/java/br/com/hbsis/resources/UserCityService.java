package br.com.hbsis.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hbsis.entities.CityDTO;
import br.com.hbsis.entities.ResultDTO;
import br.com.hbsis.userCity.FacadeUserCity;

/**
 * Serviço disponibilizado para manipulação das cidades do usuário.
 * 
 * @author Hélinton P. Steffens
 *
 */
@Path("/user")
public class UserCityService {

	@GET
	@Path("/city")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultDTO<CityDTO> getUserCity(){
		return FacadeUserCity.getCity();
	}
	
	@POST
	@Path("/city")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultDTO<String> addUserCity(CityDTO cityDTO){
		return FacadeUserCity.addUserCity(cityDTO);
	}
}
