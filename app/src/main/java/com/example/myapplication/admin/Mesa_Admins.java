package com.example.myapplication.admin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.basededatos.UsuariosDbHelper;
import com.example.myapplication.comida.Carta_Comida;
import com.example.myapplication.mensaje.LoginMensaje;
import com.example.myapplication.user.Mesa_Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mesa_Admins extends AppCompatActivity {


    //Clase de java que es la mesa de admin
    //Los metodos que tienen view basicamente son de ir a la clase que queremos

    public ImageView imageView;
    ImageView i1;
    public TextView textView;
    public ListPopupWindow listPopupWindow;
    int sa;
    int sas;
    TextView t;
    ArrayList<Integer> is ;
    ArrayList<String> isat ;
    ArrayList<String> recibo ;
    ArrayList<String> mens ;


    Map<Object, ArrayList<String>> isata ;


    ImageView im ;
    ImageView ima ;
    ImageView imag ;
    ImageView image ;
    ImageView imagen ;
    ImageView imagens;
    ImageButton imageButton;
    ImageButton imageButtons;

    int a;

    String  num;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mesa_admins);
        im = findViewById(R.id.mesa1);
        ima = findViewById(R.id.mesa2);
        imag = findViewById(R.id.mesa3);
        image = findViewById(R.id.mesa4);
        imagen = findViewById(R.id.mesa5);
        imagens = findViewById(R.id.mesa6);
        imageButtons = findViewById(R.id.imageButton13);
        is = ((Global) this.getApplication()).getMesa();
        isat = ((Global) this.getApplication()).getCam();
        isata = ((Global) this.getApplication()).getHashMap();
        recibo = ((Global) this.getApplication()).getMessages();
        String texto = getIntent().getStringExtra("usuario");
        t = findViewById(R.id.textView28);
        t.setText(texto);
        sa = R.drawable.mesa;
        ((Global) this.getApplication()).add_mesa((sa));
        asignarmesa();


        if (!recibo.isEmpty()){
            imageButtons.setImageResource(R.drawable.mensaje);
            Toast toast = Toast.makeText(this,"Mesansaje: " + recibo + "\n", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            imageButtons.setImageResource(R.drawable.ic_baseline_message_24);

        }
    }

    //Asignamos la mesa , que es cambiar el icono de la mesa
    public void asignarmesa(){
        if (!is.isEmpty()){
            if (is.contains(im.getId())){
                im.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(ima.getId())){
                ima.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imag.getId())){
                imag.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(image.getId())){
                image.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imagen.getId())){
                imagen.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
            if (is.contains(imagens.getId())){
                imagens.setImageResource(((Global) this.getApplication()).getMesa().get(0));
            }
        }

    }

//    public void clicar (View view){
//        setPopupList(view);
//        listPopupWindow.show();
//    }

    //Metodo para añadir en el arraylist de las mesas
    public Object addmesass(int is ){
        ((Global) this.getApplication()).add_mesa(is);
        return null;
    }




    //metodo para cambiar el icono
    public void imagen (View view){
        i1 = findViewById(view.getId());
        if (!is.contains(i1)){
            addmesass(i1.getId());
        }
        setPopupList(view);
        listPopupWindow.show();
    }


    //metodo para ir a la carta
    public void pedido (View view) {
        Intent intent = new Intent(this, Carta_Comida.class);
        imageButton = findViewById(view.getId());

        if (imageButton.getId() == R.id.imageButton6) {
            if (im.getId() == R.id.mesa1) {
                a = im.getId();
                intent.putExtra("asginomesa", a);
                intent.putExtra("name", t.getText().toString());
                startActivity(intent);
            }
        }

        if (imageButton.getId() == R.id.imageButton7) {
            if (ima.getId() == R.id.mesa2) {
                a = ima.getId();
                intent.putExtra("name", t.getText().toString());
                intent.putExtra("asginomesa", a);
                startActivity(intent);
            }
        }

        if (imageButton.getId() == R.id.imageButton9) {
            if (imag.getId() == R.id.mesa3) {
                a = imag.getId();
                intent.putExtra("asginomesa", a);
                intent.putExtra("name", t.getText().toString());

                startActivity(intent);
            }
        }

        if (imageButton.getId() == R.id.imageButton10) {

            if (image.getId() == R.id.mesa4) {
                a = image.getId();
                intent.putExtra("asginomesa", a);
                intent.putExtra("name", t.getText().toString());
                startActivity(intent);

            }
        }

        if (imageButton.getId() == R.id.imageButton11) {
            if (imagen.getId() == R.id.mesa5) {
                a = imagen.getId();
                intent.putExtra("asginomesa", a);
                intent.putExtra("name", t.getText().toString());

                startActivity(intent);
            }
        }
        if (imageButton.getId() == R.id.imageButton12) {

            if (imagens.getId() == R.id.mesa6) {
                a = imagens.getId();
                intent.putExtra("asginomesa", a);
                intent.putExtra("name", t.getText().toString());

                startActivity(intent);
            }
        }
    }



    //metodo de avisos
    private void setPopupList(View vi) {
        UsuariosDbHelper usuariosDbHelper = new UsuariosDbHelper(getBaseContext());
        List<String> strings = usuariosDbHelper.list();
        imageView = findViewById(vi.getId());
        listPopupWindow = new ListPopupWindow(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this , R.layout.item_simple_status , R.id.tv_element , strings);
        listPopupWindow.setAnchorView(imageView);
        listPopupWindow.setAdapter(arrayAdapter);
        listPopupWindow.setOnItemClickListener((parent , view , position , id) ->{
            Toast toast = Toast.makeText(this,"Mesa resignado por: " + strings.get(position), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            listPopupWindow.dismiss();
            ((Global) this.getApplication()).addValues(strings.get(position) , String.valueOf(imageView.getId()));


        });
    }

//    public void vueltas (View view){
//        Intent intent = new Intent(this , mensajes.class);
//        startActivity(intent);
//    }


    public void vuelta (View view){

        Intent intent = new Intent(this , Menu_Usuarios.class);
        startActivity(intent);
    }


    public void chat(View view){
        Intent intent = new Intent(this , LoginMensaje.class);
        intent.putExtra("mensaje" ,t.getText().toString());
        startActivity(intent);
    }

    public void Pajamas(View view){
        Intent intent = new Intent(this , CajaAdmin.class);
        startActivity(intent);
    }




    public void crear (View view){
        Intent intent = new Intent(this , Add_user.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12){
            if (resultCode == 90){
                Toast toast = Toast.makeText(Mesa_Admins.this, "hola", Toast.LENGTH_SHORT);
                toast.show();
            }else {
                Toast toast = Toast.makeText(Mesa_Admins.this, "Ha vuelto por barra", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}