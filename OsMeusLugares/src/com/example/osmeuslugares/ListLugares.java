package com.example.osmeuslugares;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ListLugares extends ListActivity {
	private ListLugaresAdapter listLugaresAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_lugares);

		listLugaresAdapter = new ListLugaresAdapter(this);
		listLugaresAdapter.abrir();
		setListAdapter(listLugaresAdapter);
	}

	private void imageButtonAddLugarOnClick(View v){
		lanzarEditLugar();
	}
	
	private void lanzarEditLugar() {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, EditLugarActivity.class);
		Bundle bundle = new Bundle();
		bundle.putBoolean("add", true);
		i.putExtras(bundle);
		startActivity(i);
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
