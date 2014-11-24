package com.example.osmeuslugares;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListLugares extends ListActivity {
	private ListLugaresAdapter listLugaresAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_lugares);

		listLugaresAdapter = new ListLugaresAdapter(this);
		setListAdapter(listLugaresAdapter);
	}

	public void imageButtonAddLugarOnClick(View v){
		Bundle extras = new Bundle();
		extras.putBoolean("add", true);
		lanzarEditLugar(extras);
	}
	
	/* (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Lugar itemLugar = (Lugar)getListAdapter().
				getItem(position);
		Bundle extras = itemLugar.getBundle();
		extras.putBoolean("add", false);
		lanzarEditLugar(extras);
		
		/*
		Toast.makeText(this, "Selecci—n: " + Integer.toString(position)
		          +  " - " + itemLugar.toString(),Toast.LENGTH_LONG).show();
		*/
	}

	private void lanzarEditLugar(Bundle extras) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, EditLugarActivity.class);
		i.putExtras(extras);
		startActivityForResult(i, 1234);
	}

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1234 && resultCode==RESULT_OK) {
			String resultado = data.getExtras().getString("resultado");
			Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_LONG).show();
			
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
