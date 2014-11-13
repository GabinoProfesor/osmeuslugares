package com.example.osmeuslugares;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ListLugares extends ListActivity {
	private ListLugaresAdapter listLugaresAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_lugares);
		/*
		String []lista = {"Sitio1", "Sitio2", "Sitio3"};
		Vector<String> vector = new Vector<String>(3);
		vector.add(lista[0]);
		vector.add(lista[1]);
		vector.add(lista[2]);
		setListAdapter(new ListLugaresAdapter(this,vector));
		*/
		//Crear el objeto adaptador
		// 
		listLugaresAdapter = new ListLugaresAdapter(this);
		listLugaresAdapter.abrir();
		setListAdapter(listLugaresAdapter);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
