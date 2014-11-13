package com.example.osmeuslugares;

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LugaresDb extends SQLiteOpenHelper {

	private static String LOGTAG = "LugaresDb";

	private static String nombre = "lugares.db";
	private static CursorFactory factory = null;
	private static int version = 1;

	public static final int C_ID = 0;
	public static final int C_NOMBRE = 1;
	public static final int C_CATEGORIA = 2;
	public static final int C_DIRECCION = 3;
	public static final int C_CIUDAD = 4;
	public static final int C_TELEFONO = 5;
	public static final int C_URL = 6;
	public static final int C_COMENTARIO = 7;

	public LugaresDb(Context context) {
		super(context, nombre, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i(LugaresDb.LOGTAG, "Creando Base de datos...");

		String sql = "CREATE TABLE lugar(" +
				"_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"nombre TEXT NOT NULL, " +
				"categoria INTEGER NOT NULL," +
				"direccion TEXT," +
				"ciudad TEXT," +
				"telefono TEXT, " +
				"url TEXT," +
				"comentario TEXT);";
		
		Log.i(LugaresDb.LOGTAG, sql);
		
		db.execSQL(sql);

		Log.i(LugaresDb.LOGTAG, "Base de datos creada");
		// Crear indice por nombre

		sql = "CREATE UNIQUE INDEX nombre ON Lugar(nombre ASC)";
		db.execSQL(sql);

		//Insertar datos de prueba
		db.execSQL("INSERT INTO Lugar(nombre, categoria, direccion, ciudad, telefono, url, comentario) " +
				"VALUES('Playa Riazor',1, 'Riazor','A Coru–a','981000000','','')");
		   
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public Vector<Lugar> cargarLugaresDesdeBD() {
		Vector<Lugar> resultado = new Vector<Lugar>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM Lugar", null);
		// Se podr’a usar query() en vez de rawQuery
		// join para recoger nombre categoria, previamente crear tabla de categorias
		while (cursor.moveToNext()) {
			Lugar lugar = new Lugar();
			lugar.setId(cursor.getLong(C_ID));
			lugar.setNombre(cursor.getString(C_NOMBRE));
			Long idCategoria = cursor.getLong(C_CATEGORIA);
			String nombreCategoria = "ND";
			lugar.setCategoria(new Categoria(idCategoria, nombreCategoria));
			//completar
			resultado.add(lugar);
		}
		return resultado;
	}

}
