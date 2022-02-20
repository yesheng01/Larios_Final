package com.example.myapplication.comida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;

import java.util.ArrayList;

//Clase de cocina en donde se enseña los comandos de los platos de la llegada de las mesas
public class Cocina extends AppCompatActivity {


    ListView chata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);

        ArrayAdapter<String> list = new ArrayAdapter(this, android.R.layout.simple_list_item_1,  ((Global) this.getApplication()).getPlatos());
        chata = findViewById(R.id.lista);
        chata.setAdapter(list);

    }
}