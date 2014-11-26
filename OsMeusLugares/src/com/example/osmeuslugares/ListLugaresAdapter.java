package com.example.osmeuslugares;

import java.util.Vector;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListLugaresAdapter extends BaseAdapter {

	private final Activity activity;
	private Vector<Lugar> lista;
	private LugaresDb lugaresDb;

	/**
	 * @param activity
	 * @param lista
	 */
	public ListLugaresAdapter(Activity activity) {
		super();
		this.activity = activity;
		this.lista = new Vector<Lugar>();
		actualizarDesdeBd();
	}

	public void actualizarDesdeBd() throws SQLException{
		lugaresDb = new LugaresDb(activity);
		this.lista = lugaresDb.cargarLugaresDesdeBD();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista.elementAt(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		Lugar lugar = (Lugar)getItem(position);
		return lugar.getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = activity.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null, true);
		ImageView imgViewIcono = (ImageView) view.findViewById(R.id.icono);
		TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
		TextView textViewInfo = (TextView) view.findViewById(R.id.textViewInfo);
		Lugar lugar = (Lugar)lista.elementAt(position);
		textViewTitulo.setText(lugar.getNombre());
		textViewInfo.setText(lugar.toString());
		
		Drawable icon = obtenDrawableIcon("XXXXXX");
		imgViewIcono.setImageDrawable(icon);

		return view;
	}
	
	public Drawable obtenDrawableIcon(String icon) {
		Resources res =  activity.getResources();
		TypedArray iconosLugares = res.obtainTypedArray(R.array.iconos_lugares);
		//
		return iconosLugares.getDrawable(0);
	}
	
}
