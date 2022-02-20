package com.example.myapplication.comida;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.admin.CajaAdmin;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.user.Mesa_Usuarios;
import com.example.myapplication.user.Ticket;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Carta_Comida extends AppCompatActivity {

    //Clase para mostrar los carta de las comidas y bebidas a traves de la lectura de xml


    ArrayList<HashMap<String, String>> userList = new ArrayList<>();
    HashMap<String, String> user = new HashMap<>();
    Map<String, ArrayList<String>> als;

    ImageButton imageButton;
    TextView textView233;
    TextView textView301;
    ArrayList<String> platos;
    String ttt;
    int valor;
    String  num;
    String jete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta_comida);
        ttt = getIntent().getStringExtra("platoss");
        valor = getIntent().getIntExtra("asginomesa", 1);
        jete = getIntent().getStringExtra("name");
        als = ((Global) this.getApplication()).getHashMapa();


        textView301 = findViewById(R.id.textView29);
        textView233 = findViewById(R.id.numero_platos);

        platos = ((Global) this.getApplication()).getPlatos();

            if (valor == R.id.mesa1) {
                num = "1";
            } else if (valor == R.id.mesa2) {
                num = "2";
            } else if (valor == R.id.mesa3) {
                num = "3";
            } else if (valor == R.id.mesa4) {
                num = "4";
            } else if (valor == R.id.mesa5) {
                num = "5";
            } else if (valor == R.id.mesa6) {
                num = "6";
            }

        if (num.equals("")){
            textView301.setText("No hay nada");
        }else{
            textView301.setText("Mesa" + num);
        }


        try {
            ListView lv = (ListView) findViewById(R.id.user_list);
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                String currentValue = "";
                boolean currentElement = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    currentElement = true;
                    currentValue = "";
                    if (localName.equals("plato")) {
                        user = new HashMap<>();
                    }
                    if (localName.equals("bebida")) {
                        user = new HashMap<>();
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    currentElement = false;
                    if (localName.equalsIgnoreCase("nombre"))
                        user.put("nombre", currentValue);
                    else if (localName.equalsIgnoreCase("categoria"))
                        user.put("categoria", currentValue);
                    else if (localName.equalsIgnoreCase("tipo"))
                        user.put("tipo", currentValue);
                    else if (localName.equalsIgnoreCase("precio"))
                        user.put("precio", currentValue);
                    else if (localName.equalsIgnoreCase("ingredientes"))
                        user.put("ingredientes", currentValue);
                    else if (localName.equalsIgnoreCase("verduras"))
                        user.put("verduras", currentValue);
                    else if (localName.equalsIgnoreCase("aceitunas"))
                        user.put("aceitunas", currentValue);
                    else if (localName.equalsIgnoreCase("harina"))
                        user.put("harina", currentValue);
                    else if (localName.equalsIgnoreCase("lacteos"))
                        user.put("lacteos", currentValue);
                    else if (localName.equalsIgnoreCase("carne"))
                        user.put("carne", currentValue);
                    else if (localName.equalsIgnoreCase("pescado"))
                        user.put("pescado", currentValue);
                    else if (localName.equalsIgnoreCase("marisco"))
                        user.put("marisco", currentValue);
                    else if (localName.equalsIgnoreCase("arroz"))
                        user.put("arroz", currentValue);
                    else if (localName.equalsIgnoreCase("pasta"))
                        user.put("pasta", currentValue);
                    else if (localName.equalsIgnoreCase("azúcar"))
                        user.put("azúcar", currentValue);
                    else if (localName.equalsIgnoreCase("chocolate"))
                        user.put("chocolate", currentValue);
                    else if (localName.equalsIgnoreCase("huevos"))
                        user.put("huevos", currentValue);
                    else if (localName.equalsIgnoreCase("frutos_secos"))
                        user.put("frutos_secos", currentValue);
                    else if (localName.equalsIgnoreCase("nombre"))
                        user.put("nombre", currentValue);
                    else if (localName.equalsIgnoreCase("categoria"))
                        user.put("categoria", currentValue);
                    else if (localName.equalsIgnoreCase("tipo"))
                        user.put("tipo", currentValue);
                    else if (localName.equalsIgnoreCase("precio"))
                        user.put("precio", currentValue);
                    else if (localName.equalsIgnoreCase("plato"))
                        userList.add(user);
                    else if (localName.equalsIgnoreCase("bebida"))
                        userList.add(user);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (currentElement) {
                        currentValue = currentValue + new String(ch, start, length);
                    }
                }
            };

            SearchView searchView = findViewById(R.id.search);
            InputStream istream = getAssets().open("base_de_platos.xml");
            InputStream istreams = getAssets().open("base_de_bebidas.xml");
            parser.parse(istream, handler);
            parser.parse(istreams, handler);

            SimpleAdapter adapter = new SimpleAdapter(this, userList, R.layout.list_row, new String[]{"nombre", "categoria", "precio", "tipo", "ingredientes", "verduras", "aceitunas", "harina", "lacteos", "carne", "pescado", "marisco", "arroz", "pasta", "azúcar", "chocolate", "huevos", "frutos_secos" }, new int[]{R.id.name, R.id.designation, R.id.precio});
            lv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    adapter.getFilter().filter(s);

                    return false;
                }
            });

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    HashMap<String, String> selectedProduct = (HashMap<String, String>) adapter.getItem(i);


                    Intent intent = new Intent(Carta_Comida.this, Plato_Ingrediente.class);
                    if (!selectedProduct.get("categoria").equals("Bebida")){
                        intent.putExtra("nombre", selectedProduct.get("nombre"));
                        intent.putExtra("categoria", selectedProduct.get("categoria"));
                        intent.putExtra("precio", selectedProduct.get("precio"));
                        intent.putExtra("verduras", selectedProduct.get("verduras"));
                        intent.putExtra("aceitunas", selectedProduct.get("aceitunas"));
                        intent.putExtra("harina", selectedProduct.get("harina"));
                        intent.putExtra("lacteos", selectedProduct.get("lacteos"));
                        intent.putExtra("carne", selectedProduct.get("carne"));
                        intent.putExtra("pescado", selectedProduct.get("pescado"));
                        intent.putExtra("marisco", selectedProduct.get("marisco"));
                        intent.putExtra("arroz", selectedProduct.get("arroz"));
                        intent.putExtra("pasta", selectedProduct.get("pasta"));
                        intent.putExtra("azúcar", selectedProduct.get("azúcar"));
                        intent.putExtra("chocolate", selectedProduct.get("chocolate"));
                        intent.putExtra("huevos", selectedProduct.get("huevos"));
                        intent.putExtra("frutos_secos", selectedProduct.get("frutos_secos"));
                        intent.putExtra("mesasa" , textView301.getText().toString());
                        startActivityForResult(intent , 2);
                    }else{
                        addbebida(  textView301.getText().toString() + " " + selectedProduct.get("nombre") + "\n" + "Precio: " + selectedProduct.get("precio"));
                        addpreciobe(textView301.getText().toString() , selectedProduct.get("precio"));

                        Toast toast = Toast.makeText(Carta_Comida.this, "Plato seleccionado : " , Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    if (ttt == null) {
                        Toast patio = Toast.makeText(Carta_Comida.this, "Plato seleccionado : " + ttt, Toast.LENGTH_SHORT);
                        patio.show();
                    }else{
                        Toast patio = Toast.makeText(Carta_Comida.this, "Plato seleccionado : " + ttt, Toast.LENGTH_SHORT);
                        patio.show();
                    }
                }
            });

//            llegadaplato();

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }




    }

    public Object addbebida(String ca){
        ((Global) this.getApplication()).add_platos(ca);
        return null;
    }

    public Object addpreciobe(String csa , String lo){
        ((Global) this.getApplication()).addValuesa(csa , lo);
        return null;
    }



    public void tiquet (View view) {
        Intent intent = new Intent(this, Ticket.class);
        String pla = textView301.getText().toString();
        if (pla.equals("Mesa1")) {
            intent.putExtra("tiquet", textView301.getText().toString());
            intent.putExtra("nom_je" , jete);
            startActivityForResult(intent , 21);

        }
        if (pla.equals("Mesa2")) {
            intent.putExtra("tiquet", textView301.getText().toString());
            intent.putExtra("nom_je" , jete);

            startActivityForResult(intent , 21);

        }
        if (pla.equals("Mesa3")) {
            intent.putExtra("tiquet", textView301.getText().toString());
            intent.putExtra("nom_je" , jete);

            startActivityForResult(intent , 21);

        }
        if (pla.equals("Mesa4")) {
                intent.putExtra("tiquet", textView301.getText().toString());
            startActivityForResult(intent , 21);

        }
        if (pla.equals("Mesa5")) {
                intent.putExtra("tiquet", textView301.getText().toString());
            intent.putExtra("nom_je" , jete);

            startActivityForResult(intent , 21);

        }
        if (pla.equals("Mesa6")) {
                intent.putExtra("tiquet", textView301.getText().toString());
            intent.putExtra("nom_je" , jete);

            startActivityForResult(intent , 21);

        }
    }
    

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2){
            if (resultCode == RESULT_OK){
                String s = data.getStringExtra("platoss");
                Toast toast = Toast.makeText(Carta_Comida.this, s, Toast.LENGTH_SHORT);

                toast.show();
            }else {
                Toast toast = Toast.makeText(Carta_Comida.this, "Ha vuelto por barra", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }


    public void salimos(View view){
        Intent intent = new Intent(this , Mesa_Usuarios.class);
        setResult(2131242, intent);
        finish();
    }
}