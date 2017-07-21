package br.com.hbsis.resources;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

/**
 * Filtro com as validações a serem executadas antes do request ser realizado.
 * 
 * @author Hélinton P. Steffens
 *
 */
@Provider
public class CheckRequestFilter implements ContainerRequestFilter {

	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Context
	private HttpHeaders httRequest;

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String authCredentials = request.getHeaderValue(AUTHENTICATION_HEADER);

		if (!"eb8b1a9405e659b2ffc78f0a520b1a46".equals(authCredentials)) {
			throw new RuntimeException("Not Authorized request!");
		}

		return request;
	}

}
