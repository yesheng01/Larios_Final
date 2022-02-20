package com.example.myapplication.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.comida.Carta_Comida;
import com.example.myapplication.comida.Cocina;
import com.example.myapplication.mensaje.LoginMensaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ticket extends AppCompatActivity {

    //Clase donde enseña el tiquet en donde esta los platos al añadir por el camarero


    TextView textView;
    TextView textView1;
    ArrayList<String> pla ;
    ListView chat;
    TextView textView2;
    TextView textView11;
    TextView textView12;

    Map<String, ArrayList<String>> als;


    public ArrayList<String> getPla() {
        return pla;
    }

    public void setPla(ArrayList<String> pla) {
        this.pla = pla;
    }

    Button button;
    Button button1;

    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        als = ((Global) this.getApplication()).getHashMapa();

        pla = ((Global) this.getApplication()).getPlatos();


        textView = findViewById(R.id.nombremesas);

        textView11 = findViewById(R.id.preciosa);

        textView12 = findViewById(R.id.List_txt);


        AlertDialog.Builder dialogo2 = new AlertDialog.Builder(Ticket.this);

        EditText editText2 = new EditText(Ticket.this);


        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo2.setTitle("Importante");
                dialogo2.setMessage("¿ Eliminar todo el chat? ?");
                dialogo2.setView(editText2);
                editText2.setText(textView11.getText().toString());
                dialogo2.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo2, int id) {
                        textView11.setText(editText2.getText().toString());

                    }
                });
                dialogo2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo2, int id) {
                    }
                });
                dialogo2.show();
            }
        });



        textView1 = findViewById(R.id.textView33);


        textView2 = findViewById(R.id.tv_element);
        String ass = getIntent().getStringExtra("nom_je");
        textView1.setText(ass);

        Intent intent = getIntent();
        String a = intent.getStringExtra("tiquet");
        textView.setText(a);

        Iterator it = als.keySet().iterator();
        ArrayList tempList = null;
        total = 0;


        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = als.get(key);
            if (tempList != null) {
                for (Object value : tempList) {
                    if (key.equals(a)){
                        total = total   + Double.parseDouble(String.valueOf(value));
                    }
                }
                textView11.setText(String.valueOf(total));

            }
        }





//        MyAdapter adapter = new MyAdapter(this, pla);
//        adapter.getFilter().filter(textView.getText().toString());
//        chat.setAdapter(adapter);
//
//        textView12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Ticket.this);
//
//                EditText editText1 = new EditText(Ticket.this);
//                dialogo1.setTitle("Importante");
//                dialogo1.setMessage("¿ Eliminar todo el chat? ?");
//                dialogo1.setView(editText1);
//                editText1.setText(textView12.getText().toString());
//                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogo1, int id) {
//                        for (String s : pla){
//                            if (s.equals(editText1.getText().toString())){
//                                pla.remove(s);
//                            }
//                        }
//                    }
//                });
//                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogo1, int id) {
//                    }
//                });
//                dialogo1.show();
//
//            }
//        });
//
//
//
//        chat.setAdapter(adapter);


//        pla.remove(Integer.parseInt(editText1.getText().toString()));
//        MyAdapter adapter = new MyAdapter(Ticket.this,pla);
//        adapter.getFilter().filter(textView.getText().toString());
//        chat.setAdapter(adapter);







        ArrayAdapter<String> list = new ArrayAdapter(this, android.R.layout.simple_list_item_1,  pla);
        chat = findViewById(R.id.listView);
        list.getFilter().filter(textView.getText().toString());
        chat.setAdapter(list);
            chat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                    ArrayAdapter<String> list = new ArrayAdapter(Ticket.this, android.R.layout.simple_list_item_1,  pla);
//                    list.getFilter().filter(textView.getText().toString());
//                    chat.setAdapter(list);
                    pla.remove(list.getItem(i));
                    list.notifyDataSetChanged();
                    ArrayAdapter<String> list = new ArrayAdapter(Ticket.this, android.R.layout.simple_list_item_1,  pla);
                    list.getFilter().filter(textView.getText().toString());
                    chat.setAdapter(list);

                }
            });

    }

    public void cocina(View view){
        Intent intent = new Intent(Ticket.this , Cocina.class);
        startActivity(intent);
    }



    public void carta(View view){
        Intent intent  = new Intent(Ticket.this , Carta_Comida.class);
        button = findViewById(R.id.button7);
        Toast toast = Toast.makeText(Ticket.this, "tiquet enviado" , Toast.LENGTH_SHORT);
        toast.show();
        setResult(this.RESULT_OK, intent);
        finish();
//        pla.clear();
//        als.clear();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 21){
            if (resultCode == 213124){
                String s = data.getStringExtra("tiquet");
                Toast toast = Toast.makeText(Ticket.this, s, Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(Ticket.this, "Ha vuelto por barra", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}