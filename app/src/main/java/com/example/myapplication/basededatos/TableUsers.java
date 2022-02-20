package com.example.myapplication.basededatos;

import android.provider.BaseColumns;

public class TableUsers implements BaseColumns {

    //Tablas que tendra el base de datos

        public static abstract class UsuariosEntry {
            public static final String TABLE_NAME ="usuarios";
            public static final String ID = "id";
            public static final String NOMBRE = "nombre";
            public static final String PASSWORD = "password";
            public static final String ADMIN = "admin";
            public static final String AVATAR_URI = "avatarUri";
        }
}
