package com.example.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.user.Mesa_Usuarios;
import com.example.myapplication.user.Olvido_Contra;
import com.example.myapplication.R;
import com.example.myapplication.basededatos.Usuarios;
import com.example.myapplication.basededatos.UsuariosDbHelper;
import com.example.myapplication.mensaje.Mandar_Mensaje;

import java.util.ArrayList;

public class Menu_Usuarios extends AppCompatActivity {

    //Clase de parte de login , aqui lo que hemos pasado es el login en donde buscamos los usuarios de
    //si es admin o es usuario normal entonces enviara a la clase que les toca por lo que hay 1 metodo de buscar y luego
    //el login que nos envia

    public static final String EXTRA_MESSAGE ="dsad" ;
    public static final String EXTRA_MESSAGES ="dsad" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_usuarios);
    }
    

    public void login(View view) {

        UsuariosDbHelper dbHelper = new UsuariosDbHelper(getBaseContext());
        TextView textView = findViewById(R.id.textView2);
        EditText editText = findViewById(R.id.editTextTextPersonName2);
        Usuarios user = BuscarUsuario(dbHelper.getAllObjects());
        if (user == null){
            textView.setText("Contraseña o usuario incorrecto");
            textView.setTextColor(Color.parseColor("#FF0000"));
            //correcct password
        } else {
            if (user.getAdmin().equals("1")){
                Intent intent = new Intent(this , Mesa_Admins.class);
                intent.putExtra("usuario" , user.getNombre());
                startActivity(intent);
            }else{
                Intent intent = new Intent(this , Mesa_Usuarios.class);
                intent.putExtra(EXTRA_MESSAGE , user.getNombre());
                startActivity(intent);
            }
        }
    }

    public Usuarios BuscarUsuario(ArrayList<Usuarios> list){
        for (Usuarios usuarios : list) {
            EditText username = findViewById(R.id.editTextTextPersonName2);
            EditText password = findViewById(R.id.editTextTextPassword);
            if (username.getText().toString().equals(usuarios.getNombre()) && password.getText().toString().equals(usuarios.getPassword())) {

                return usuarios;

            }
        }
        return null;
    }







    public void olvidocontra(View view){
        Intent intent = new Intent(this , Olvido_Contra.class);
        startActivity(intent);
    }
}