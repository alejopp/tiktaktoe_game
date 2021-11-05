 package com.example.triqui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

 public class MainActivity extends Activity {
    private Partida partida;
    private int[] casillas;
    private int jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casillas = new int[9];
        casillas[0] = R.id.a1; casillas[1] = R.id.a2; casillas[2] = R.id.a3;
        casillas[3] = R.id.b1; casillas[4] = R.id.b2; casillas[5] = R.id.b3;
        casillas[6] = R.id.c1; casillas[7] = R.id.c2; casillas[8] = R.id.c3;

    }

    public void aJugar(View view){
        ImageView imagen;

        for (int img : casillas){
            imagen = (ImageView) findViewById(img);
            imagen.setImageResource(R.drawable.casilla);
        }

        jugadores = 1;
        if(view.getId() == R.id.dosjugadores){
            jugadores = 2;
        }

        //Configuración de dificultad
        RadioGroup configDificultad = (RadioGroup) findViewById(R.id.configDif);
        int id = configDificultad.getCheckedRadioButtonId();

        int dificultad = 0;
        if(id == R.id.normal){
            dificultad = 1;
        }
        else if (id == R.id.imposible){
            dificultad = 2;
        }

        // Iniciar partida
        partida = new Partida(dificultad);

        // Inhabilitar botones
        ((Button) findViewById(R.id.unjugador)).setEnabled(false);
        ((Button) findViewById(R.id.dosjugadores)).setEnabled(false);
        ((RadioGroup) findViewById(R.id.configDif)).setAlpha(0);

    }
}