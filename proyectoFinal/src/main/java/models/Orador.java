package models;

import java.util.UUID;

public class Orador {
	
	private UUID idUUID;
	private String nombre;
	private String apellido;
	private String email;
	private String tema;
	
	
	public Orador(int id, String nombre, String apellido, String email, String tema) {
		this.idUUID = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
	}


	public Orador(String nombre, String apellido, String email, String tema) {
		this.idUUID = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
		
	}
	


	public UUID getIdUUID() {
		return idUUID;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getEmail() {
		return email;
	}


	public String getTema() {
		return tema;
	}
	
	
	
}
