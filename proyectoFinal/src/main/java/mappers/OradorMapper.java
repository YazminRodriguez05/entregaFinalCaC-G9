package mappers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Orador;

public class OradorMapper {

	ObjectMapper mapper;

	public OradorMapper() {
		this.mapper = new ObjectMapper();

	}

	public String toJason(Orador orador) {

		try {
			return mapper.writeValueAsString(orador);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[]";
		}
	}

	public String toJason(ArrayList<Orador> listaDeOradores) {

		try {
			return mapper.writeValueAsString(listaDeOradores);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[]";
		}
	}

}
