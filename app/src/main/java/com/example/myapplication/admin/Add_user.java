package com.example.myapplication.admin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Usuarios;
import com.example.myapplication.basededatos.UsuariosDbHelper;
import com.example.myapplication.mensaje.LoginMensaje;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Add_user extends AppCompatActivity {

    //Clase para añadir un usuario al base de datos

    ImageView imageView;
    private String mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        cargaimagen();

    }

    //Metodo para insertar un imagen al icono
    public void cargaimagen (){
        imageView = findViewById(R.id.imageView3);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(Add_user.this);
                mydialog.setTitle("Pon tu imagen de perfil: ");
                final EditText editText = new EditText(Add_user.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(editText);
                mydialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface , int i) {
                        mytext= editText.getText().toString();
                        Toast.makeText(Add_user.this ,mytext ,Toast.LENGTH_LONG).show();
                        Picasso.get() .load(mytext) .error(R.mipmap.ic_launcher_round).into(imageView);

                    }
                });
                mydialog.show();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    //Metodo para añadir un usuario
    public void adduser(View view) {
        UsuariosDbHelper dbHelper = new UsuariosDbHelper(getBaseContext());

        TextView textView = findViewById(R.id.editTextTextPersonName);
        TextView textView12 = findViewById(R.id.textView26);
        TextView textView2 = findViewById(R.id.error);
        EditText editText = findViewById(R.id.editTextTextPassword4);
        EditText editTexto = findViewById(R.id.editTextTextPassword5);
        String texto = "0";

        textView12.setText(texto);


        Usuarios user = SearchUser(dbHelper.getAllObjects(), textView.getText().toString());

        if (editText.getText().toString().equals(editTexto.getText().toString())) {
            if (user == null ) {
                dbHelper.addusuario(textView.getText().toString(), editText.getText().toString(),textView12.getText().toString(), mytext);
                Intent intent = new Intent(this, Mesa_Admins.class);
                setResult(90, intent);
                finish();
            } else if (editText.getText().toString().equals("")) {
                textView2.setText("Campo en blanco");
                textView2.setTextColor(Color.parseColor("#FF0000"));
            }else {
                textView2.setText("usuario existe o id en uso");
                textView2.setTextColor(Color.parseColor("#FF0000"));
            }
        } else {
            textView2.setText("contraseña incorrecta o no son iguales o solo camareros");
            textView2.setTextColor(Color.parseColor("#FF0000"));
        }
    }

    public void salir(View view){
        Intent intent = new Intent(this , Mesa_Admins.class);
        setResult(90, intent);
        finish();
    }








    public Usuarios SearchUser(ArrayList<Usuarios> list , String nombre){
        for (Usuarios usuarios : list) {
            EditText username = findViewById(R.id.editTextTextPersonName);
            if (username.getText().toString().equals(usuarios.getNombre())) {
                return usuarios;
            }
        }
        return null;
    }

//    public Usuarios SearchID(ArrayList<Usuarios> list , String id){
//        for (Usuarios usuarios : list) {
//            TextView username = findViewById(R.id.textView4);
//            if (username.getText().toString().equals(usuarios.getId())) {
//                return usuarios;
//            }
//        }
//        return null;
//    }




}