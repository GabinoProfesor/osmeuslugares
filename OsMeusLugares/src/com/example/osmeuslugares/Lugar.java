package com.example.osmeuslugares;

import android.content.Context;

public class Lugar {
	private Context context;
	
	private Long id;
	private String nombre;
	private Categoria categoria;
	private Direccion direccion;
	private String url;
	private String telefono;
	private String comentario;
	/**
	 * @param nombre
	 * @param tipoLugar
	 */
	public Lugar(Context context, String nombre, Categoria categoria) {
		super();
		this.context = context;
		this.nombre = nombre;
		this.categoria = categoria;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lugar [context=" + context + ", id=" + id + ", nombre="
				+ nombre + ", categoria=" + categoria + ", direccion="
				+ direccion + ", url=" + url + ", telefono=" + telefono
				+ ", comentario=" + comentario + "]";
	}


	
	
	
}
