package com.example.osmeuslugares;

public class Direccion {
	private String ciudad;
	private String direccion;
	/**
	 * @param ciudad
	 * @param direccion
	 */
	public Direccion(String ciudad, String direccion) {
		super();
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Direccion [ciudad=" + ciudad + ", direccion=" + direccion + "]";
	}

	
}
