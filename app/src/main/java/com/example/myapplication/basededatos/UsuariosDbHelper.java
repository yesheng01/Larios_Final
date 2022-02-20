package com.example.myapplication.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDbHelper extends SQLiteOpenHelper {


    //Clase de base de datos en donde creamos las tablas de los usuarios

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Usuarioss.db";
    public static final String COL_ID = "ID";
    public static final String COL_NAME="NAME";
    public static final String COL_PASSWORD="PASSWORD";
    public static final String COL_ADMIN="ADMIN";
    public static final String COL_AVATAR="AVATAR";

    public UsuariosDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TableUsers.UsuariosEntry.TABLE_NAME + " ("
                + TableUsers.UsuariosEntry.ID + " INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,"
                + TableUsers.UsuariosEntry.NOMBRE + " TEXT NOT NULL,"
                + TableUsers.UsuariosEntry.PASSWORD + " TEXT NOT NULL,"
                + TableUsers.UsuariosEntry.ADMIN + " TEXT NOT NULL,"
                + TableUsers.UsuariosEntry.AVATAR_URI + " TEXT NOT NULL)");


        Usuarios sheng = new Usuarios("1","sheng" , "shengye" , "1" , "hola.jpg");
        Usuarios irene = new Usuarios("2","irene" , "irene" , "1" , "");
        Usuarios dani = new Usuarios("3","dani" , "dani" , "0" , "");
        Usuarios jojo = new Usuarios("4", "jojo" , "jojo" , "0" , "");

        saveUser(sqLiteDatabase , sheng);
        saveUser(sqLiteDatabase , irene);
        saveUser(sqLiteDatabase, dani);
        saveUser(sqLiteDatabase, jojo);



    }


    public long saveUser(SQLiteDatabase db , Usuarios usuarios) {
        return db.insert(TableUsers.UsuariosEntry.TABLE_NAME,
                null, usuarios.toContentValues());

    }

    public ArrayList<Usuarios> getAllObjects()
    {
        // Get the isntance of the database
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(
                TableUsers.UsuariosEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Usuarios> objectList = new ArrayList<Usuarios>();

        try
        {
            if (cursor.moveToFirst()) {
                do {
                    Usuarios object= new Usuarios(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    );

                    objectList.add(object);
                } while (cursor.moveToNext());
            }
        }
        catch (SQLiteException e)
        {
            Log.d("SQL Error", e.getMessage());
            return null;
        }
        finally
        {
            cursor.close();
            sqLiteDatabase.close();
        }
        return objectList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void Olvidocontra(String nombre , String contra){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("password" , contra);
        sqLiteDatabase.update(TableUsers.UsuariosEntry.TABLE_NAME , cv , "nombre = ?" , new String[]{nombre});
    }

    public void addusuario( String nombre , String contra , String admin , String url){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableUsers.UsuariosEntry.NOMBRE,nombre);
        cv.put(TableUsers.UsuariosEntry.PASSWORD,contra);
        cv.put(TableUsers.UsuariosEntry.ADMIN,admin);
        cv.put(TableUsers.UsuariosEntry.AVATAR_URI,url);

        sqLiteDatabase.insert(TableUsers.UsuariosEntry.TABLE_NAME , "" ,cv );

    }


    public List<String> list(){
        List<String> stringList = new ArrayList<>();
        for (Usuarios usuarios : getAllObjects()){
            if (usuarios.getAdmin().equals("0")) {
                stringList.add(usuarios.getNombre());
            }
        }
        return stringList;
    }

}
