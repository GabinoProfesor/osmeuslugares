package com.example.osmeuslugares;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class EditLugarActivity extends Activity {

	private Spinner spinnerCategoria;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_lugar);
		
		spinnerCategoria = (Spinner)findViewById(R.id.spinnerTipo);
		//String []listaTipos = {"Praias", "Restaurantes", "Outros"};
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		//		this, android.R.layout.simple_spinner_item,
		//		listaTipos);
		
	
	    
		CategoriasAdapter categoriasAdapter= new CategoriasAdapter(this); 
		spinnerCategoria.setAdapter(categoriasAdapter);
		
		Bundle extras = new Bundle();
	    extras = getIntent().getExtras();
	    if (extras.getBoolean("add")) {
	    		Toast.makeText(getBaseContext(), "ADD",
					Toast.LENGTH_LONG).show();
	    } else {
	    	Toast.makeText(getBaseContext(), extras.getString(Lugar.C_NOMBRE),
					Toast.LENGTH_LONG).show();
	    }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_lugar, menu);
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
