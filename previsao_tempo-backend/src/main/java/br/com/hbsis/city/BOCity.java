package br.com.hbsis.city;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.hbsis.entities.CityDTO;

/**
 * Classe com as regras de negocio de cidade.
 * 
 * @author Hélinton P. Steffens
 *
 */
public final class BOCity {

	public static String PATH = "/src/main/resources/"; 

	private BOCity(){

	}
	
	public static CityDTO getCity(String name){
		List<CityDTO> city = getCity();
		for (CityDTO cityDTO : city) {
			if (name.equalsIgnoreCase(cityDTO.getName())) {
				return cityDTO;
			}
		}
		
		return null;
	}

	public static List<CityDTO> getCity(){
		List<CityDTO> cities = new ArrayList<>();
		try {
			URL resource = BOCity.class.getClassLoader().getResource("city.list.json.gz");
			File file = new File(resource.toURI());
			InputStream inputStream = new GZIPInputStream(new FileInputStream(file));

			JSONParser jsonParser = new JSONParser();
			JSONArray json = (JSONArray)jsonParser.parse(
					new InputStreamReader(inputStream, "UTF-8"));

			Iterator iterator = json.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				cities.add(convert(jsonObject));
			}
		} catch (IOException | ParseException | URISyntaxException e) {
			throw new RuntimeException(e.getMessage());
		}
		return cities;
	}

	private static CityDTO convert(JSONObject jsonObject){
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId((Long) jsonObject.get("id"));
		cityDTO.setName((String) jsonObject.get("name"));
		cityDTO.setCountry((String) jsonObject.get("country"));
		JSONObject object = (JSONObject) jsonObject.get("coord");
		if (object != null) {
			cityDTO.setLatitude(((Number) object.get("lat")).doubleValue());
			cityDTO.setLongitude(((Number) object.get("lon")).doubleValue());
		}

		return cityDTO;
	}
}
