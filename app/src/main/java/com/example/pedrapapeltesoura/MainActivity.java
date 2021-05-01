package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void selecionadoPedra(View view){
        System.out.println("selecionado pedra");
        this.opcaoSelecionada("pedra");

    }
    public void selecionadoPapel(View View){
        this.opcaoSelecionada("papel");

    }


    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);
        TextView  derrotas = findViewById(R.id.derrotas);
        TextView vitorias = findViewById(R.id.vitorias);
        TextView empates = findViewById(R.id.empates);
        int derrota= 0;
        int vitoria = 0;
        int empate =0;

        System.out.println(opcaoSelecionada);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opçaoApp = opcoes[numero];

        switch (opçaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if (

        (opçaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                        (opçaoApp == "papel" && opcaoSelecionada == "pedra") ||
                        (opçaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ) {
            textoResultado.setText("Voce perdeu.");
derrota ++;
            derrotas.setText(String.valueOf(derrota));

        } else if (
             (opcaoSelecionada == "tesoura" && opçaoApp == "papel") ||
             (opcaoSelecionada == "papel" && opçaoApp == "pedra") ||
            (opcaoSelecionada == "pedra" && opçaoApp == "tesoura")
        ){
            textoResultado.setText("Voçe ganhou!");
vitoria ++;
            vitorias.setText(String.valueOf(vitoria));
        } else{
        textoResultado.setText("Empate!");
        empate += 1;
        empates.setText(String.valueOf(empate));
        }

    }

}