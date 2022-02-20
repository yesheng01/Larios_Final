package com.example.myapplication.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Usuarios;
import com.example.myapplication.admin.Menu_Usuarios;
import com.example.myapplication.basededatos.UsuariosDbHelper;

import java.util.ArrayList;

public class Olvido_Contra extends AppCompatActivity {

    //Clase de cambiar la contraseña a traves del base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.olvido_contra);
    }


    public void password(View view) {
        UsuariosDbHelper dbHelper = new UsuariosDbHelper(getBaseContext());


        TextView textView = findViewById(R.id.editTextTextPersonName3);
        TextView textView2 = findViewById(R.id.textView2);
        EditText editText = findViewById(R.id.editTextTextPassword2);
        EditText editTexto = findViewById(R.id.editTextTextPassword3);

        Usuarios user = SearchUser(dbHelper.getAllObjects(), textView.getText().toString());

        if (editText.getText().toString().equals(editTexto.getText().toString())) {
            if (user == null) {
                textView2.setText("usuario no encontrado");
                textView2.setTextColor(Color.parseColor("#FF0000"));
            }else if (editText.getText().toString().equals("")){
                textView2.setText("Campo en blanco");
                textView2.setTextColor(Color.parseColor("#FF0000"));
            }else {
                dbHelper.Olvidocontra(textView.getText().toString(), editText.getText().toString());
                Intent intent = new Intent(this, Menu_Usuarios.class);
                startActivity(intent);
            }
        } else {
            textView2.setText("contraseña incorrecta o no son iguales");
            textView2.setTextColor(Color.parseColor("#FF0000"));
        }
    }


    public Usuarios SearchUser(ArrayList<Usuarios> list , String nombre){
        for (Usuarios usuarios : list) {
            EditText username = findViewById(R.id.editTextTextPersonName3);
            if (username.getText().toString().equals(usuarios.getNombre())) {
                return usuarios;
            }
        }
        return null;
    }

    public void retorno(View view){
        Intent intent = new Intent(this, Menu_Usuarios.class);
        startActivity(intent);

    }

}