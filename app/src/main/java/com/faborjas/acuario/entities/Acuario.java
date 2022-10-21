package com.faborjas.acuario.entities;

import java.util.ArrayList;
import java.util.List;

public class Acuario {
    private String id;
    private int numPez;
    private int numLitros;
    private boolean limpio;
    private List<Pez> listaPeces;

    public Acuario(String id, int numPez, int numLitros, boolean limpio) {
        this.id = id;
        this.numPez = numPez;
        this.numLitros = numLitros;
        this.limpio = limpio;
        this.listaPeces = new ArrayList<>();
    }

    public Acuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumPez() {
        return numPez;
    }

    public void setNumPez(int numPez) {
        this.numPez = numPez;
    }

    public int getNumLitros() {
        return numLitros;
    }

    public void setNumLitros(int numLitros) {
        this.numLitros = numLitros;
    }

    public boolean isLimpio() {
        return limpio;
    }

    public void setLimpio(boolean limpio) {
        this.limpio = limpio;
    }

    @Override
    public String toString() {
        return "Acuario{" +
                "id='" + id + '\'' +
                ", numPez='" + numPez + '\'' +
                ", numLitros=" + numLitros +
                ", limpio=" + limpio +
                '}';
    }

    public List<Pez> getListaPeces() {
        return listaPeces;
    }

    public void setListaPeces(List<Pez> listaPeces) {
        this.listaPeces = listaPeces;
    }

    public static void insertarPez(Acuario acuario, Pez pez){
    int litros = acuario.getNumLitros();
    int numPeces = acuario.getNumPez();
    int capacidad = litros/10;
    List<Pez> listaPeces = new ArrayList<>();
    if (capacidad > numPeces){
        listaPeces.add(pez);
    }
    acuario.setListaPeces(listaPeces);
    listaPeces.clear();
    }
    public static int mostrarPez(Acuario acuario){
        return acuario.getListaPeces().size();
    }
    public static void linpiarAcuario(Acuario acuario) {
        List<Pez> listaPeces = acuario.getListaPeces();
        for (int i = 0; i < listaPeces.size(); i++) {
            if (!listaPeces.get(i).isVivo()) {
                listaPeces.remove(i);
            }
        }
    }
}
