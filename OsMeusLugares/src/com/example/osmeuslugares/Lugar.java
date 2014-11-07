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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lugar [nombre=" + nombre + ", tipoLugar=" + tipoLugar.toString()
				+ ", direccion=" + direccion.toString() + ", url=" + url + ", telefono="
				+ telefono + ", comentario=" + comentario + "]";
	}
	
	
	
}
