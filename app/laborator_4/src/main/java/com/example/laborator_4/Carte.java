package com.example.laborator_4;

import java.io.Serializable;

public class Carte implements Serializable {
    private String titlu;
    private String autor;
    private int anPublicare;
    private boolean esteDisponibila;

    public Carte(){

    }

    public Carte(String titlu, String autor, int anPublicare, boolean esteDisponibila){
        this.titlu=titlu;
        this.autor=autor;
        this.anPublicare=anPublicare;
        this.esteDisponibila=esteDisponibila;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnPublicare() {
        return anPublicare;
    }

    public void setAnPublicare(int anPublicare) {
        this.anPublicare = anPublicare;
    }

    public boolean isEsteDisponibila() {
        return esteDisponibila;
    }

    public void setEsteDisponibila(boolean esteDisponibila) {
        this.esteDisponibila = esteDisponibila;
    }

    @Override
    public String toString(){
        return "Carte: "+titlu+" de "+autor+" (an aparitie: "+anPublicare+", disponibilitate: "+esteDisponibila;
    }
}
