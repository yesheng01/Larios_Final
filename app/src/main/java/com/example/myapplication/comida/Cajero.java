package com.example.myapplication.comida;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.admin.Mesa_Admins;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.user.Mesa_Usuarios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


//Clase donde esta el tiquet del administrador deld cajero , donde se puede borrar y modificar el plato

public class Cajero extends AppCompatActivity {

    ListView chat;
    TextView textView;
    TextView textView1;

    double total;


    ArrayList<String> pla;

    Map<String, ArrayList<String>> als;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cajero);

        button = findViewById(R.id.button9);

        pla = ((Global) this.getApplication()).getPlatos();

        als = ((Global) this.getApplication()).getHashMapa();



        textView = findViewById(R.id.textView37);
        textView1 = findViewById(R.id.preciosa);


        String te = getIntent().getStringExtra("me");

        textView.setText(te);

        MyAdapter list = new MyAdapter(this, pla);

        chat = findViewById(R.id.platocaja);
        list.getFilter().filter(te);
        chat.setAdapter(list);



        Iterator it = als.keySet().iterator();
        ArrayList tempList = null;
        total = 0;


        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = als.get(key);
            if (tempList != null) {
                for (Object value : tempList) {
                    if (key.equals(te)){
                        total = total   + Double.parseDouble(String.valueOf(value));
                    }
                }
                textView1.setText(String.valueOf(total));

            }
        }
        AlertDialog.Builder dialogo2 = new AlertDialog.Builder(Cajero.this);
        EditText editText2 = new EditText(Cajero.this);




        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo2.setTitle("Importante");
                dialogo2.setMessage("¿ Eliminar todo el chat? ?");
                dialogo2.setView(editText2);
                editText2.setText(textView1.getText().toString());
                dialogo2.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo2, int id) {
                        textView1.setText(editText2.getText().toString());

                    }
                });
                dialogo2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo2, int id) {
                    }
                });
                dialogo2.show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Cajero.this);



                EditText editText1 = new EditText(Cajero.this);

                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Eliminar todo el chat? ?");
                dialogo1.setView(editText1);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        pla.remove(list.getItem(Integer.parseInt(editText1.getText().toString())));
                        MyAdapter adapter = new MyAdapter(Cajero.this,pla);
                        adapter.getFilter().filter(textView.getText().toString());
                        chat.setAdapter(adapter);
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

            }
        });
    }

    public void salida(View view){
        Intent intent = new Intent(this , Mesa_Admins.class);
        Toast toast = Toast.makeText(Cajero.this, "Pagado" + textView.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();

        als.remove(textView.getText().toString());
        setResult(90, intent);
        finish();
    }
}