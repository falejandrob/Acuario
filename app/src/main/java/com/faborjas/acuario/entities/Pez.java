package com.faborjas.acuario.entities;

public class Pez {
    private String id;
    private String nombre;
    private int alimentoMax;
    private int alimentoActual;
    private String especia;
    private boolean vivo;

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
        return especia;
    }

    public void setEspecia(String especia) {
        this.especia = especia;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
