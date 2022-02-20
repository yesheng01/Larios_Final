package com.example.myapplication.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.basededatos.Usuarios;
import com.example.myapplication.admin.Menu_Usuarios;
import com.example.myapplication.comida.Carta_Comida;
import com.example.myapplication.mensaje.LoginMensaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Mesa_Usuarios extends AppCompatActivity {

    //Clase de las mesas de un usuario que es lo mismo que el de clase admin

    public static final String EXTRA_MESSAGES ="dsad" ;
    ImageView im ;
    ImageView ima ;
    ImageView imag ;
    ImageView image ;
    ImageView imagen ;
    ImageView imagens;
    ImageView imageView ;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;




    Map<Object, ArrayList<String>> isata ;
    ArrayList<String> memes ;



    TextView textView ;
    int a;

    ArrayList<Integer> is ;

    int i ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mesa_usuarios);
        im = findViewById(R.id.mesa1);
        ima = findViewById(R.id.mesa2);
        imag = findViewById(R.id.mesa3);
        image = findViewById(R.id.mesa4);
        imagen = findViewById(R.id.mesa5);
        imagens = findViewById(R.id.mesa6);
        isata = ((Global) this.getApplication()).getHashMap();

        memes = ((Global) this.getApplication()).getMeseta();

        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView20);
        textView3 = findViewById(R.id.textView21);
        textView4 = findViewById(R.id.textView22);
        textView5 = findViewById(R.id.textView24);
        textView6 = findViewById(R.id.textView25);



        textView =findViewById(R.id.textView4);

        i = R.drawable.mesa;
        ((Global) this.getApplication()).add_mesa((i));
        is = ((Global) this.getApplication()).getMesa();



        String message = getIntent().getStringExtra(Menu_Usuarios.EXTRA_MESSAGE);
        textView.setText(message);

        asignarmesa();


        Iterator ita = isata.keySet().iterator();
        ArrayList tempListas = null;

        while (ita.hasNext()) {
            String key = ita.next().toString();
            tempListas = isata.get(key);
            if (tempListas != null) {
                for (Object value : tempListas) {
                    if (value.equals(String.valueOf(im.getId()))) {
                        textView1.setText(key);
                    }
                    else if (value.equals(String.valueOf(ima.getId()))) {
                        textView2.setText(key);
                    }
                    else if (value.equals(String.valueOf(imag.getId()))) {
                        textView3.setText(key);
                    }
                    else if (value.equals(String.valueOf(image.getId()))) {
                        textView4.setText(key);
                    }
                    else if (value.equals(String.valueOf(imagen.getId()))) {
                        textView5.setText(key);
                    }
                    else if (value.equals(String.valueOf(imagens.getId()))) {
                        textView6.setText(key);
                    }
                }
            }
        }




    }

    public void asignarmesa() {
        if (!is.isEmpty()){
            if (is.contains(im.getId())) {
                im.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(ima.getId())) {
                ima.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imag.getId())) {
                imag.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(image.getId())) {
                image.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imagen.getId())) {
                imagen.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imagens.getId())) {
                imagens.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
        }

    }

    public void elegirMesa(View view){
        Intent intent = new Intent(this , Carta_Comida.class);
        imageView = findViewById(view.getId());
        a = imageView.getId();
        imageView.setImageResource(R.drawable.mesa);


        Iterator it = isata.keySet().iterator();
        ArrayList tempList = null;

        while (it.hasNext()) {
            String key = it.next().toString();
            tempList = isata.get(key);
            if (tempList != null) {
                for (Object value : tempList) {
                    if (key.equals(textView.getText().toString()) && value.equals(String.valueOf(a))){

                        String s = String.valueOf(memes);
                        Toast toast = Toast.makeText(this,"Mesa resignado por: " + s, Toast.LENGTH_SHORT);
                        toast.show();
                        intent.putExtra("asginomesa" , a);
                        startActivity(intent);

                    }else if (!(key.equals(textView.getText().toString())) && value.equals(String.valueOf(a))){
                        if (memes.isEmpty()){
                            memes.add("El camarero : " + textView.getText().toString() + " Ha entrado");
                            intent.putExtra("asginomesa" , a);
                            startActivity(intent);
                        }else{
                            memes.remove(memes.size() - 1);
                        }

                    }
                }
            }
        }





    }



    public void chat(View view){
        Intent intent = new Intent(this , LoginMensaje.class);
        intent.putExtra("mensaje" ,textView.getText().toString());
        startActivity(intent);
    }

    public void vuelta (View view){
        Intent intent = new Intent(this , Menu_Usuarios.class);
        startActivity(intent);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 212){
            if (resultCode == 2131242){
                Toast toast = Toast.makeText(Mesa_Usuarios.this, "hola", Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(Mesa_Usuarios.this, "Ha vuelto por barra", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }


}