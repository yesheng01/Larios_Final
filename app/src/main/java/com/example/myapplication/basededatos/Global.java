package com.example.myapplication.basededatos;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Clase Global en donde hacemos el arraylist o el hashmap de esta forma alcenamos la informacion que queremos
//Como los platos , las mesas , los mensajes.

public class Global extends Application {

    
    private ArrayList<String> messages;
    private ArrayList<String> meseta;

    private ArrayList<Integer> mesa;
    private ArrayList<List<String>> nombre_mesa;
    private ArrayList<String> platos;

    private ArrayList<String> cam;
    private Map<Object, ArrayList<String>> hashMap = new HashMap<Object, ArrayList<String>>();
    private Map<String, ArrayList<String>> hashMapa = new HashMap<String, ArrayList<String>>();


    public ArrayList<String> getMeseta() {
        return meseta;
    }

    public void setMeseta(ArrayList<String> meseta) {
        this.meseta = meseta;
    }

    public String add_meseta(String men){
        meseta.add(men);
        return men;
    }



    public Map<String, ArrayList<String>> getHashMapa() {
        return hashMapa;
    }

    public void setHashMapa(Map<String, ArrayList<String>> hashMapa) {
        this.hashMapa = hashMapa;
    }




    public void addValuesa(String keys, String values) {
        ArrayList tempLista = null;
        if (hashMapa.containsKey(keys)) {
            tempLista = hashMapa.get(keys);
            if(tempLista == null)
                tempLista = new ArrayList();
            tempLista.add(values);
        } else {
            tempLista = new ArrayList();
            tempLista.add(values);
        }
        hashMapa.put(keys,tempLista);
    }

    public void addValues(String key, String value) {
        ArrayList tempList = null;
        if (hashMap.containsKey(key)) {
            tempList = hashMap.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        hashMap.put(key,tempList);
    }

    public Map<Object, ArrayList<String>> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<Object, ArrayList<String>> hashMap) {
        this.hashMap = hashMap;
    }

    public ArrayList<String> getCam() {
        return cam;
    }

    public void setCam(ArrayList<String> cam) {
        this.cam = cam;
    }

    public void add_cam(String cama){
        cam.add(cama);
    }

    private HashMap<String , Integer> precio = new HashMap<>();

    public HashMap<String, Integer> getPrecio() {
        return precio;
    }

    public void setPrecio(HashMap<String, Integer> precio) {
        this.precio = precio;
    }


    private ArrayList<String> silla;

    public ArrayList<String> getSilla() {
        return silla;
    }

    public void setSilla(ArrayList<String> silla) {
        this.silla = silla;
    }

    public void add_silla(String sillas){
        messages.add(sillas);
    }

    public void add(String mensaje){
        messages.add(mensaje);
    }

    public void add_nombre_mesas(List<String> nombre){
        nombre_mesa.add(nombre);
    }
    public String add_platos(String plato){
        platos.add(plato);
        return plato;
    }

    public ArrayList<List<String>> getNombre_mesa() {
        return nombre_mesa;
    }

    public void setNombre_mesa(ArrayList<List<String>> nombre_mesa) {
        this.nombre_mesa = nombre_mesa;
    }

    public ArrayList<String> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<String> platos) {
        this.platos = platos;
    }

    public int add_mesa(int mesas){
        mesa.add(mesas);
        return mesas;
    }

    public void remove (String mensaje) {
        messages.remove(mensaje);
    }


    public ArrayList<Integer> getMesa() {
        return mesa;
    }

    public void setMesa(ArrayList<Integer> mesa) {
        this.mesa = mesa;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }



    //Inicializamos los arraylist y el hashmap en el momento de que el programa este iniciado

    public void Inicializar(){
       this.messages =new ArrayList<>();
    }

    public void Inicializar_meseta(){
        this.meseta =new ArrayList<>();
    }


    public void Inicializar_mesa(){
        this.mesa =new ArrayList<>();
    }

    public void Inicializar_nombre_mesas(){
        this.nombre_mesa =new ArrayList<List<String>>();
    }
    public void Inicializar_platos(){
        this.platos =new ArrayList<>();
    }


    public void Inicializar_sillas(){
        this.silla =new ArrayList<>();
    }


    public void Inicializar_cam(){
        this.cam =new ArrayList<>();
    }

    public void Inicializar_hash(){
        this.hashMap = new HashMap<>();
    }

    public void Inicializar_hasha(){
        this.hashMapa = new HashMap<>();
    }



}
