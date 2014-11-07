package com.example.osmeuslugares;

public class TipoLugar {
	private int id;
	private String tipo;
	//private String icon;
	/**
	 * @param id
	 * @param tipo
	 */
	public TipoLugar(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoLugar [id=" + id + ", tipo=" + tipo + "]";
	}

	
}
