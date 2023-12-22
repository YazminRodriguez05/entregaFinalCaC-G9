package infrastructure.persistence;

import java.util.ArrayList;

import models.Orador;

public interface IPersistencia {
	
	//CREATE
	void guardarOrador(Orador newOrador);
		
	//READ	
	Orador getOradorById(String idOradorBuscado);
	ArrayList<Orador> getAll();
	
	//UPDATE
	void update(String idModificar, String datoModificar, String nuevoDato);
	
	//DELETE
	void delete(String id);
}
