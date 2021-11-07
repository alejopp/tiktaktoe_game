package com.example.triqui;

import java.util.Random;

public class Partida {
    private final int dificultad;
    public int jugador;

    public Partida(int dificultad) {
        this.dificultad = dificultad;
        jugador = 1;
    }

    //Inteligencia artificial
    public int ia(){
        int casilla;
        Random casilla_azar = new Random();
        casilla = casilla_azar.nextInt(9);

        return casilla;
    }

    public void turno(){
        jugador++;
        if (jugador > 2){
            jugador = 1;
        }
    }


}
