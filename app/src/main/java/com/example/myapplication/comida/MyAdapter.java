package com.example.myapplication.comida;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.R;
import com.example.myapplication.basededatos.Global;
import com.example.myapplication.mensaje.Mandar_Mensaje;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {
    //This is the constructor for MyAdapter: You can edit its second parameter a/c to your requirements
    //I used Array List of strings

    ListView listView;
    String item;

    public MyAdapter(Context context, ArrayList<String> records) {
        super(context, 0, records);
    }

    @Override
    //Important method: You can write your own code in this function
    //You can set your textview/ button methods
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        item = getItem(position);

        //Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_custom, parent, false);
        }

        try {
            listView = convertView.findViewById(R.id.listView);
            final TextView list_txt = (TextView) convertView.findViewById(R.id.List_txt);
            EditText editText = new EditText(getContext());
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());

            list_txt.setTextSize(15);


            list_txt.setText(item);

            list_txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                            dialogo1.setTitle("Importante");
                            dialogo1.setMessage("¿ Eliminar todo el chat? ?");
                            editText.setText(list_txt.getText().toString());
                            dialogo1.setView(editText);
                            dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                    list_txt.setText(editText.getText().toString());
                                }
                            });
                            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                }
                            });
                            dialogo1.show();
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }

    @Override
    public void remove(@Nullable String object) {
        super.remove(object);
    }
}