package com.example.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.comida.Cajero;

import java.util.ArrayList;


//Clase en donde el adminsitrador puede ver las mesas a las que hay el ticket del cual esta los platos

public class CajaAdmin extends AppCompatActivity {

    ListView chat;

    ArrayList<String> Mesas;

    ArrayAdapter<String> lista;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja_admin);
        Mesas = new ArrayList<>();

        Mesas.add("Mesa1");
        Mesas.add("Mesa2");
        Mesas.add("Mesa3");
        Mesas.add("Mesa4");
        Mesas.add("Mesa5");
        Mesas.add("Mesa6");

        chat = findViewById(R.id.caixa);

        lista = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Mesas );

        chat.setAdapter(lista);

        chat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (Mesas.get(i).equals("Mesa1")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));
                    startActivity(intent);
                }
                if (Mesas.get(i).equals("Mesa2")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));
                    startActivity(intent);

                }
                if (Mesas.get(i).equals("Mesa3")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));

                    startActivity(intent);

                }
                if (Mesas.get(i).equals("Mesa4")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));

                    startActivity(intent);

                }
                if (Mesas.get(i).equals("Mesa5")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));

                    startActivity(intent);

                }
                if (Mesas.get(i).equals("Mesa6")){
                    Intent intent = new Intent(CajaAdmin.this , Cajero.class);
                    intent.putExtra("me" , Mesas.get(i));

                    startActivity(intent);

                }


            }
        });



    }
}