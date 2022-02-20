package com.example.myapplication.mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mensaje.Mandar_Mensaje;

//Clase para hacer el login al mensaje del cual nos servira para mandar mensaje

public class LoginMensaje extends AppCompatActivity {



    public static final String EXTRA_MESSAGE ="dsad" ;
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mensaje);




    }
    public  void boton (View view){
        EditText editText = findViewById(R.id.editTextTextPersonName4);
        String text = editText.getText().toString();
        String texto = getIntent().getStringExtra("mensaje");
        if (texto.equals(text)){
            Intent intent = new Intent(this , Mandar_Mensaje.class);
            intent.putExtra(EXTRA_MESSAGE , text);
            startActivity(intent);
        }else {
            textView = findViewById(R.id.textView27);
            textView.setText("Error el usuario no coincide");
        }
    }








}