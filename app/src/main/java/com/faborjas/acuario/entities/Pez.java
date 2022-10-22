package com.faborjas.acuario.entities;

import android.util.Log;
import android.widget.Toast;

public class Pez {
    private String id;
    private String nombre;
    private int alimentoMax;
    private int alimentoActual;
    private String especie;
    private boolean vivo;

    public Pez(String id, String nombre, int alimentoMax, String especie) {
        this.id = id;
        this.nombre = nombre;
        this.alimentoMax = alimentoMax;
        this.alimentoActual = 0;
        this.especie = especie;
        this.vivo = true;
    }

    public Pez() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlimentoMax() {
        return alimentoMax;
    }

    public void setAlimentoMax(int alimentoMax) {
        this.alimentoMax = alimentoMax;
    }

    public int getAlimentoActual() {
        return alimentoActual;
    }

    public void setAlimentoActual(int alimentoActual) {
        this.alimentoActual = alimentoActual;
    }

    public String getEspecia() {
        return especie;
    }

    public void setEspecia(String especia) {
        this.especie = especia;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "Pez{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", alimentoMax=" + alimentoMax +
                ", alimentoActual=" + alimentoActual +
                ", especie='" + especie + '\'' +
                ", vivo=" + vivo +
                '}';
    }
    public static void incrementarComida(Pez pez){
        int aliAcTemp = pez.getAlimentoActual();
        int aliMaxTemp = pez.getAlimentoMax();

        if (aliAcTemp < aliMaxTemp ){
            pez.setAlimentoActual(aliAcTemp + 1);
        }else {
            Log.e("INFO","Ya no hay mas espacio");
        }
    }
}
