package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.myapplication.admin.Menu_Usuarios;
import com.example.myapplication.basededatos.Global;


public class MainActivity extends AppCompatActivity {


    //Esta clase es el main en donde inicializamos todos los arraylist que tenemos en el clase "Global"
    //y tambien tenemos un metodo para ir a la clase al que queremos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Larios");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ((Global) this.getApplication()).Inicializar();
        ((Global) this.getApplication()).Inicializar_mesa();
        ((Global) this.getApplication()).Inicializar_nombre_mesas();
        ((Global) this.getApplication()).Inicializar_platos();
        ((Global) this.getApplication()).Inicializar_meseta();


        ((Global) this.getApplication()).Inicializar_sillas();
        ((Global) this.getApplication()).Inicializar_cam();
        ((Global) this.getApplication()).Inicializar_hash();
        ((Global) this.getApplication()).Inicializar_hasha();








    }

    public void vuelta (View view){
        Intent intent = new Intent(this , Menu_Usuarios.class);
        startActivity(intent);
    }

}
