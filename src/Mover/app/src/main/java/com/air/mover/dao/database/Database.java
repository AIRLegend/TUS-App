package com.air.mover.dao.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.air.mover.dao.model.Parada;


/**
 * Clase que representa la DB en SQLite y ayuda a manejarla (escribir, leer...)
 * Created by air on 22/11/17.
 */
public final class Database {
    private Database() {}

    /**
     * Descripcion de la tabla de detalles de una parada. Contiene el nombre, su id y los
     * comentarios que haya hecho el usuario en la misma.
     */
    public static class ParadasTable {
        private ParadasTable() {}

        public static final String TABLE_NAME = "paradas";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_PARADA_NAME = "name";
        public static final String COLUMN_COMMENT = "comment";

        public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ " ("+ COLUMN_ID +" INT PRIMARY KEY, "+COLUMN_PARADA_NAME
                +" VARCHAR(200), "+ COLUMN_COMMENT+" TEXT)";

        public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    /**
     * Clase manejadora de la DB.
     * @see "https://developer.android.com/training/basics/data-storage/databases.html?hl=es-419"
     */
    public static class DBHelper extends SQLiteOpenHelper {

        public  static final int DATABASE_VERSION = 1;
        public  static final String DATABASE_NAME = "ParadasDB.db";

        public DBHelper(Context context) {
            super  (context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(ParadasTable.DROP_TABLE);
            db.execSQL(ParadasTable.CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Si se upgradea se resetea la DB
            db.execSQL(ParadasTable.DROP_TABLE);
            onCreate(db);
        }
    }


    /**
     * Leer los comentarios para una parada dada
     * @param nombre Nombre de la parada.
     * @param context Contexto de la aplicación
     * @return Objeto parada con los comentarios. El Nombre de parada sera Null si no
     *         se ha encontrado.
     */
    public static Parada getCommentParada(int id, String nombre, Context context) {
        Parada p = new Parada(null, 0, 0, 0);
        Database.DBHelper helper= new Database.DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {ParadasTable.COLUMN_COMMENT};
        String selection = ParadasTable.COLUMN_ID+ " = ? ";
        String[] selectionArgs = {String.valueOf(id)};
        String sortOrder = ParadasTable.COLUMN_ID + " ASC";
        Cursor c = db.query(Database.ParadasTable.TABLE_NAME, projection, selection, selectionArgs,
                null, null, sortOrder);

        if (c.getCount()>0) {
            c.moveToNext();
            p.setNombre(nombre);
            p.setComentarios(c.getString(c.getColumnIndex(ParadasTable.COLUMN_COMMENT)));
        }
        c.close();
        return p;
    }

    /**
     * Añade o actualiza los comentarios de una parada dada. Si no existe la crea,
     * si no, la actualiza.
     * @param id de la parada
     * @param nombre de la parada a buscar
     * @param comment comentario que se quiere anadir
     * @param context contexto de la app. para que pueda funcionar el DBHelper.
     */
    public static void addComment(int id, String nombre, String comment, Context context) {
        Parada exists = getCommentParada(id, nombre, context);
        Database.DBHelper dbHelper = new Database.DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (exists.getNombre() == null) {
            //INSERT
            try {
                values.put(ParadasTable.COLUMN_ID, id);
                values.put(ParadasTable.COLUMN_PARADA_NAME, nombre);
                values.put(ParadasTable.COLUMN_COMMENT, comment);
                db.insert(Database.ParadasTable.TABLE_NAME, null, values);
            } catch (SQLException e) {
                Log.e("[DATABASE ERROR]: ", "No se ha podido insertar. ¿Valor duplicado?");
            }
        } else {
            //UPDATE
            values.put(ParadasTable.COLUMN_COMMENT, comment);
            String selection = ParadasTable.COLUMN_ID +" = ?";
            String[] selectionArgs = {String.valueOf(id)};
            db.update(ParadasTable.TABLE_NAME, values, selection, selectionArgs);
        }
    }

}
