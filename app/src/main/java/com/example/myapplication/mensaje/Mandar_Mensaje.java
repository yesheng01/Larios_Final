package com.example.myapplication.mensaje;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Usuarios;
import com.example.myapplication.basededatos.Global;

import java.util.ArrayList;


//Clase para mandar mensajes
public class Mandar_Mensaje extends AppCompatActivity {

    EditText message;
    private ArrayAdapter<String> adapter;
    public static final String EXTRA_MESSAGE ="dsad" ;
    Usuarios usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_mensaje);
        setTitle("Chat General");
        message = findViewById(R.id.message);
        adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,((Global) this.getApplication()).getMessages());
        ListView chat =findViewById(R.id.chatListView);
        chat.setAdapter(adapter);
        borrar();
    }



    public void borrar (){
        ImageButton imageButton = findViewById(R.id.imageButton4);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 int i = 0;
                final int posicion=i;
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Mandar_Mensaje.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Eliminar todo el chat? ?");
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        adapter.clear();
                        adapter.notifyDataSetChanged();
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



    public void mensaje(View view){
        Intent intent = getIntent();
        String mensache = intent.getStringExtra(LoginMensaje.EXTRA_MESSAGE);
        ((Global) this.getApplication()).add( mensache + ": " + message.getText().toString());
        adapter.notifyDataSetChanged();
        message.setText("");
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



}