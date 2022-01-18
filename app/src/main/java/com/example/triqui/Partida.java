package com.example.triqui;

import java.util.Random;

public class Partida {
    private final int dificultad;
    public int jugador;
    private int[] casillas;
    private  int[][]COMBINACIONES =  {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public Partida(int dificultad) {
        this.dificultad = dificultad;
        jugador = 1;
        casillas = new int[9];

        for(int i=0;i<9;i++){
            casillas[i]= 0;
        }
    }

    public boolean compruebaCasilla(int casilla){
        if(casillas[casilla] != 0){
            return false;
        }
        else {
            casillas[casilla]= jugador;
        }
        return true;
    }

    public int dosEnRaya(int jugadorEnTurno){
        int casilla = -1;
        int cuantasLLeva = 0;
        for(int i = 0; i< COMBINACIONES.length; i++){
            for(int pos : COMBINACIONES[i]){
                if(casillas[pos]== jugadorEnTurno) cuantasLLeva++;
                if(casillas[pos]==0) casilla=pos;
            }
            if(cuantasLLeva == 2 && casilla != -1) return casilla;
            casilla = -1;
            cuantasLLeva=0;
        }
        return -1;
    }

    //Inteligencia artificial
    public int ia(){
        int casilla;
        casilla = dosEnRaya(2);

        if(casilla != -1) return casilla;
        if(dificultad >0){
            casilla = dosEnRaya(1);
            if(casilla != -1) return casilla;
        }
        if(dificultad == 2) {
            if(casillas[0]==0) return 0;
            if(casillas[2]==0) return 2;
            if(casillas[6]==0) return 6;
            if(casillas[8]==0) return 8;
        }
        Random casilla_azar = new Random();
        casilla = casilla_azar.nextInt(9);

        return casilla;
    }

    public int turno(){

        //Este método retorna:
        // 0 En caso de que el juego continúe
        // 1 En caso de que el jugador uno gane
        // 2 En caco de que el jugdor 2 gane
        // 3 En caso de empate

        boolean empate = true;

        for(int i=0; i <COMBINACIONES.length; i++){
            boolean ultimoMovimiento = true;
            System.out.println("ultimo mov: " + ultimoMovimiento);
            System.out.println("jugador: " + jugador);
            for(int pos: COMBINACIONES[i]){
                System.out.println("posicion:" + pos + " " + casillas[pos]);
                if(casillas[pos] != jugador) ultimoMovimiento = false;
                if (casillas[pos] ==0){
                    empate = false;
                }
            }
            if(ultimoMovimiento) return jugador;
            System.out.println("-----------------");
        }


        if(empate){
            return 3;
        }

        jugador++;

        if (jugador > 2){
            jugador = 1;
        }

        return 0;
    }


}
