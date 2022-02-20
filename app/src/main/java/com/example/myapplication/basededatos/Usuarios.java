package com.example.myapplication.basededatos;

import android.content.ContentValues;

import com.example.myapplication.basededatos.TableUsers;

public class Usuarios {

    //Clase de usuarios

    private String id;
    private String nombre;
    private String password;
    private String admin;
    private String avatarUri;


    public Usuarios(String id, String nombre , String password , String admin , String avatarUri){

        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.admin = admin;
        this.avatarUri = avatarUri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TableUsers.UsuariosEntry.ID , id );
        values.put(TableUsers.UsuariosEntry.NOMBRE, nombre);
        values.put(TableUsers.UsuariosEntry.PASSWORD, password);
        values.put(TableUsers.UsuariosEntry.ADMIN, admin);
        values.put(TableUsers.UsuariosEntry.AVATAR_URI, avatarUri);
        return values;
    }
}
