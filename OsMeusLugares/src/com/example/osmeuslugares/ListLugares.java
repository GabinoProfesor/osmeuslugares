package com.example.osmeuslugares;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class ListLugares extends ListActivity {
	private ListLugaresAdapter listLugaresAdapter;
	Bundle extras = new Bundle();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_lugares);
		registerForContextMenu(super.getListView());

		listLugaresAdapter = new ListLugaresAdapter(this);
		setListAdapter(listLugaresAdapter);
		/* Leer preferencia de info */
		boolean infoAmpliada = getPreferenciaVerInfoAmpliada();
		if (infoAmpliada) {
			Toast.makeText(getBaseContext(), "Info Ampliada ON",
					Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getBaseContext(), "Info Ampliada OFF",
					Toast.LENGTH_LONG).show();
		}
	}

	public void imageButtonAddLugarOnClick(View v) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView,
	 * android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Lugar itemLugar = (Lugar) getListAdapter().getItem(position);
		Bundle extras = itemLugar.getBundle();
		extras.putBoolean("add", false);
		lanzarEditLugar(extras);

		/*
		 * Toast.makeText(this, "Selecci�n: " + Integer.toString(position) +
		 * " - " + itemLugar.toString(),Toast.LENGTH_LONG).show();
		 */
	}

	private void lanzarEditLugar(Bundle extras) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, EditLugarActivity.class);
		i.putExtras(extras);
		startActivityForResult(i, 1234);
	}

	public boolean getPreferenciaVerInfoAmpliada() {
		SharedPreferences preferencias = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		return preferencias.getBoolean("ver_info_ampliada", false);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			String resultado = data.getExtras().getString("resultado");
			Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_LONG)
					.show();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_lugares, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.add_lugar) {
			extras.clear();
			extras.putBoolean("add", true);
			lanzarEditLugar(extras);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateContextMenu(android.view.ContextMenu,
	 * android.view.View, android.view.ContextMenu.ContextMenuInfo)
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_lugares_contextual, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		Lugar lugar = (Lugar)listLugaresAdapter.getItem(info.position);
		switch (item.getItemId()) {
		case R.id.edit_lugar:
			Toast.makeText(getBaseContext(), "Editar: " + lugar.getNombre(),
					Toast.LENGTH_SHORT).show();
			return true;

		case R.id.delete_lugar:
			Toast.makeText(getBaseContext(), "Eliminar: " + lugar.getNombre(),
					Toast.LENGTH_SHORT).show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
