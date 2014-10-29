package com.example.osmeuslugares;

public class Lugar {
	private String nombre;
	private TipoLugar tipoLugar;
	private Direccion direccion;
	private String url;
	private String telefono;
	private String comentario;
	/**
	 * @param nombre
	 * @param tipoLugar
	 */
	public Lugar(String nombre, TipoLugar tipoLugar) {
		super();
		this.nombre = nombre;
		this.tipoLugar = tipoLugar;
	}
	
	
}
