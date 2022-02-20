package com.example.myapplication.comida;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plato_Ingrediente extends AppCompatActivity {

    //Clase para mostrar los ingredientes a traves de la lectura de xml

    ArrayList<String> platos;
    Map<String, ArrayList<String>> als;



    HashMap<String , Integer> precio;

    String string;
    String text;
    TextView textView1;
    TextView textView20;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;

    TextView textView21;
    TextView textView22;
    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;
    TextView textView29;
    TextView textView30;
    TextView textView31;
    TextView textView32;
    TextView textView33;
    TextView textView34;
    TextView textView35;


    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;



    CheckBox checkBox;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    CheckBox checkBox9;
    CheckBox checkBox10;
    CheckBox checkBox11;
    CheckBox checkBox12;
    ArrayList<String> lista = new ArrayList<String>();
    String textos;
    String tete;
    String tex;

//    public ArrayList<String> getMesass() {
//        return mesass;
//    }
//
//    public void setMesass(ArrayList<String> mesass) {
//        this.mesass = mesass;
//    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plato_ingrediente);

        als = ((Global) this.getApplication()).getHashMapa();

        platos   = ((Global) this.getApplication()).getPlatos();

        precio = ((Global) this.getApplication()).getPrecio();

        String te = getIntent().getStringExtra("mesasa");
        textView35 = findViewById(R.id.textView30);
        textView35.setText(te);

        textos = getIntent().getStringExtra("nombre");
        textView1 = findViewById(R.id.textView19);
        textView1.setText(textos);
        String texto20 = getIntent().getStringExtra("categoria");
        textView20 = findViewById(R.id.textView23);
        textView20.setText(texto20);
        tete = getIntent().getStringExtra("precio");
        textView34 = findViewById(R.id.in);
        textView34.setText(tete);
        String texto = getIntent().getStringExtra("verduras");
        textView = findViewById(R.id.tv_name);
        textView.setText(texto);
        String texto1 = getIntent().getStringExtra("aceitunas");
        textView2 = findViewById(R.id.tv_name1);
        textView2.setText(texto1);
        String texto2 = getIntent().getStringExtra("harina");
        textView3 = findViewById(R.id.tv_name2);
        textView3.setText(texto2);
        String texto3 = getIntent().getStringExtra("lacteos");
        textView4 = findViewById(R.id.tv_name3);
        textView4.setText(texto3);
        String texto4 = getIntent().getStringExtra("carne");
        textView5 = findViewById(R.id.tv_name4);
        textView5.setText(texto4);
        String texto5 = getIntent().getStringExtra("pescado");
        textView6 = findViewById(R.id.tv_name5);
        textView6.setText(texto5);
        String texto6 = getIntent().getStringExtra("marisco");
        textView7 = findViewById(R.id.tv_name6);
        textView7.setText(texto6);
        String texto7 = getIntent().getStringExtra("arroz");
        textView8 = findViewById(R.id.tv_name7);
        textView8.setText(texto7);
        String texto8 = getIntent().getStringExtra("pasta");
        textView9 = findViewById(R.id.tv_name8);
        textView9.setText(texto8);
        String texto9 = getIntent().getStringExtra("azúcar");
        textView10 = findViewById(R.id.tv_name9);
        textView10.setText(texto9);
        String texto10 = getIntent().getStringExtra("chocolate");
        textView11 = findViewById(R.id.tv_name10);
        textView11.setText(texto10);
        String texto11 = getIntent().getStringExtra("huevos");
        textView12 = findViewById(R.id.tv_name11);
        textView12.setText(texto11);
        String texto12 = getIntent().getStringExtra("frutos_secos");
        textView13 = findViewById(R.id.tv_name12);
        textView13.setText(texto12);

        checkBox = findViewById(R.id.check_box);
        checkBox1 = findViewById(R.id.check_box1);
        checkBox2 = findViewById(R.id.check_box2);
        checkBox3 = findViewById(R.id.check_box3);
        checkBox4 = findViewById(R.id.check_box4);
        checkBox5 = findViewById(R.id.check_box5);
        checkBox6 = findViewById(R.id.check_box6);
        checkBox7 = findViewById(R.id.check_box7);
        checkBox8 = findViewById(R.id.check_box8);
        checkBox9 = findViewById(R.id.check_box9);
        checkBox10 = findViewById(R.id.check_box10);
        checkBox11 = findViewById(R.id.check_box11);
        checkBox12 = findViewById(R.id.check_box12);



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView.setText("1");
                }else{
                    textView.setText("0");
                }
            }
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView2.setText("1");
                }else{
                    textView2.setText("0");
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView3.setText("1");
                }else{
                    textView3.setText("0");
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView4.setText("1");
                }else{
                    textView4.setText("0");
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView5.setText("1");
                }else{
                    textView5.setText("0");
                }
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView6.setText("1");
                }else{
                    textView6.setText("0");
                }
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView7.setText("1");
                }else{
                    textView7.setText("0");
                }
            }
        });
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView8.setText("1");
                }else{
                    textView8.setText("0");
                }
            }
        });
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView9.setText("1");
                }else{
                    textView9.setText("0");
                }
            }
        });
        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView10.setText("1");
                }else{
                    textView10.setText("0");
                }
            }
        });
        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView11.setText("1");
                }else{
                    textView11.setText("0");
                }
            }
        });
        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView12.setText("1");
                }else{
                    textView12.setText("0");
                }
            }
        });
        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView13.setText("1");
                }else{
                    textView13.setText("0");
                }
            }
        });





        if (texto.equals("1")) {
            checkBox.setChecked(true);
        }
        if (texto1.equals("1")) {
            checkBox1.setChecked(true);
        }
        if (texto2.equals("1")) {

            checkBox2.setChecked(true);
        }
        if (texto3.equals("1")) {

            checkBox3.setChecked(true);
        }
        if (texto4.equals("1")) {

            checkBox4.setChecked(true);
        }
        if (texto5.equals("1")) {

            checkBox5.setChecked(true);
        }
        if (texto6.equals("1")) {

            checkBox6.setChecked(true);
        }
        if (texto7.equals("1")) {

            checkBox7.setChecked(true);
        }
        if (texto8.equals("1")) {

            checkBox8.setChecked(true);
        }
        if (texto9.equals("1")) {

            checkBox9.setChecked(true);
        }
        if (texto10.equals("1")) {

            checkBox10.setChecked(true);
        }
        if (texto11.equals("1")) {

            checkBox11.setChecked(true);
        }
        if (texto12.equals("1")) {

            checkBox12.setChecked(true);
        }

//            SimpleAdapter adapter = new SimpleAdapter(this, userList, R.layout.item_row,new String[]{textos,texto}, new int[]{R.id.tv_name1,R.id.check_box});
//            lv.setAdapter(adapter);
    }


    public void vuelta(View view) {
        Intent intent = new Intent(this, Carta_Comida.class);
        setResult(this.RESULT_OK, intent);
        finish();
    }


    public void aceptado(View view) {
        Intent intent = new Intent(this, Carta_Comida.class);

        if (checkBox.isChecked()) {
            textView21 = findViewById(R.id.textView6);
            lista.add(textView21.getText().toString());
        }
        if (checkBox1.isChecked()) {
            textView22 = findViewById(R.id.textView7);
            lista.add(textView22.getText().toString());
        }
        if (checkBox2.isChecked()) {
            textView23 = findViewById(R.id.textView8);

            lista.add(textView23.getText().toString());
        }
        if (checkBox3.isChecked()) {
            textView24 = findViewById(R.id.textView9);

            lista.add(textView24.getText().toString());
        }
        if (checkBox4.isChecked()) {
            textView25 = findViewById(R.id.textView10);


            lista.add(textView25.getText().toString());
        }
        if (checkBox5.isChecked()) {
            textView26 = findViewById(R.id.textView11);


            lista.add(textView26.getText().toString());
        }
        if (checkBox6.isChecked()) {
            textView27 = findViewById(R.id.textView12);


            lista.add(textView27.getText().toString());
        }
        if (checkBox7.isChecked()) {
            textView28 = findViewById(R.id.textView13);


            lista.add(textView28.getText().toString());
        }
        if (checkBox8.isChecked()) {
            textView29 = findViewById(R.id.textView14);


            lista.add(textView29.getText().toString());
        }
        if (checkBox9.isChecked()) {
            textView30 = findViewById(R.id.textView15);

            lista.add(textView30.getText().toString());
        }
        if (checkBox10.isChecked()) {
            textView31 = findViewById(R.id.textView16);


            lista.add(textView31.getText().toString());
        }

        if (checkBox11.isChecked()) {
            textView32 = findViewById(R.id.textView17);


            lista.add(textView32.getText().toString());
        }
        if (checkBox12.isChecked()) {

            textView33 = findViewById(R.id.textView18);


            lista.add(textView33.getText().toString());
        }

        String pla = textView35.getText().toString();
        String dasnkld = String.valueOf(lista);

        if (pla.equals("Mesa1")) {
            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa1 " + " " + textos + " " + dasnkld + "\n" + "precio: " + tete));
            ((Global) this.getApplication()).addValuesa("Mesa1" , tete);

            setResult(this.RESULT_OK, intent);
            finish();
        }
        if (pla.equals("Mesa2")) {

            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa2" + " " + textos + " " + dasnkld + "\n" + "precio: " + tete));
            ((Global) this.getApplication()).addValuesa("Mesa2" , tete);
            setResult(this.RESULT_OK, intent);
            finish();
        }
        if (pla.equals("Mesa3")) {

            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa3" + " " + textos + " " + dasnkld + "\n" + "precio: " + tete));
            ((Global) this.getApplication()).addValuesa("Mesa3" , tete);

            setResult(this.RESULT_OK, intent);
            finish();
        }
        if (pla.equals("Mesa4")) {
            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa4" + " " + textos + " " + dasnkld + "\n" + "precio: " + tete));
            ((Global) this.getApplication()).addValuesa("Mesa4" , tete);

            setResult(this.RESULT_OK, intent);
            finish();
        }
        if (pla.equals("Mesa5")) {
            ((Global) this.getApplication()).addValuesa("Mesa5" , tete);

            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa5" + " " + textos + " " + dasnkld + "\n" + "precio: " + tete));

            setResult(this.RESULT_OK, intent);
            finish();
        }
        if (pla.equals("Mesa6")) {
            ((Global) this.getApplication()).addValuesa("Mesa6" , tete);

            intent.putExtra("platoss", ((Global) this.getApplication()).add_platos("Mesa6" + " " + textos + " " + text + "\n" + "precio: " + tete));

            setResult(this.RESULT_OK, intent);
            finish();
        }
    }

}