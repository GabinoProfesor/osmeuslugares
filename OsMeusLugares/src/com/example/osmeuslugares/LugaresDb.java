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
	

	public LugaresDb(Context context) {
		super(context, nombre, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i(LugaresDb.LOGTAG, "Creando Base de datos...");

		String sql = "CREATE TABLE lugar(";
		sql = sql.concat(" _id INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sql = sql.concat(" nombre TEXT NOT NULL, ");
		sql = sql.concat(" categoria INTEGER NOT NULL, ");
		sql = sql.concat(" direccion TEXT, ");
		sql = sql.concat(" poblacion TEXT, ");
		sql = sql.concat(" telefono TEXT, ");
		sql = sql.concat(" url TEXT, ");
		sql = sql.concat(" comentario TEXT);");
		Log.i(getClass().toString(), sql);
		db.execSQL(sql);

		Log.i(LugaresDb.LOGTAG, "Base de datos creada");
		// Crear indice por nombre

		sql = "CREATE UNIQUE INDEX nombre ON Lugar(nombre ASC)";
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public Vector<Lugar> cargarListadoLugares() {
		Vector<Lugar> resultado = new Vector<Lugar>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM Lugar", null);
		while (cursor.moveToNext()) {
			Lugar lugar = new Lugar();
			lugar.setId(cursor.getLong(C_ID));
		}
		return resultado;
	}

}
