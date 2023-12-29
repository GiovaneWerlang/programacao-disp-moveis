package br.edu.utfpr.prova1giovane;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int pontosJogador1 = 0;
    private int pontosJogador2 = 0;
    private int partidasGanhasJogador1 = 0;
    private int partidasGanhasJogador2 = 0;

    private TextView tvPontosJogador1;
    private TextView tvPontosJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPontosJogador1 = findViewById(R.id.tvPontosJogador1);
        tvPontosJogador2 = findViewById(R.id.tvPontosJogador2);

    }

    public void btAdicionar1PontoJogador1OnClick(View view) {
        atualizaPontosJogador1(1);
        if(ganhou(pontosJogador1)){
            marcarVitoria("Jogador1");
        }
    }

    public void btAdicionar3PontoJogador1OnClick(View view) {
        atualizaPontosJogador1(3);
        if(ganhou(pontosJogador1)){
            marcarVitoria("Jogador1");
        }
    }

    public void btAdicionar6PontoJogador1OnClick(View view) {
        atualizaPontosJogador1(6);
        if(ganhou(pontosJogador1)){
            marcarVitoria("Jogador1");
        }
    }

    public void btAdicionar9PontoJogador1OnClick(View view) {
        atualizaPontosJogador1(9);
        if(ganhou(pontosJogador1)){
            marcarVitoria("Jogador1");
        }
    }

    public void btAdicionar12PontoJogador1OnClick(View view) {
        atualizaPontosJogador1(12);
        if(ganhou(pontosJogador1)){
            marcarVitoria("Jogador1");
        }
    }

    public void btAdicionar1PontoJogador2OnClick(View view) {
        atualizaPontosJogador2(1);
        if(ganhou(pontosJogador2)){
            marcarVitoria("Jogador2");
        }
    }

    public void btAdicionar3PontoJogador2OnClick(View view) {
        atualizaPontosJogador2(3);
        if(ganhou(pontosJogador2)){
            marcarVitoria("Jogador2");
        }
    }

    public void btAdicionar6PontoJogador2OnClick(View view) {
        atualizaPontosJogador2(6);
        if(ganhou(pontosJogador2)){
            marcarVitoria("Jogador2");
        }
    }

    public void btAdicionar9PontoJogador2OnClick(View view) {
        atualizaPontosJogador2(9);
        if(ganhou(pontosJogador2)){
            marcarVitoria("Jogador2");
        }
    }

    public void btAdicionar12PontoJogador2OnClick(View view) {
        atualizaPontosJogador2(12);
        if(ganhou(pontosJogador2)){
            marcarVitoria("Jogador2");
        }
    }


    public void btHistoricoOnClick(View view) {
        Intent intent = new Intent(this, HistoricoActivity.class);
        intent.putExtra("partidasGanhasJogador1", partidasGanhasJogador1);
        intent.putExtra("partidasGanhasJogador2", partidasGanhasJogador2);
        startActivity(intent);
    }

    public void btZerarOnClick(View view) {
        pontosJogador1 = 0;
        pontosJogador2 = 0;
        partidasGanhasJogador1 = 0;
        partidasGanhasJogador2 = 0;
        tvPontosJogador1.setText("");
        tvPontosJogador2.setText("");

        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, "Pontuações e Histórico Zerados.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void atualizaPontosJogador1(Integer ponto){
        pontosJogador1 += ponto;
        tvPontosJogador1.setText(String.valueOf(pontosJogador1));
    }

    public void atualizaPontosJogador2(Integer ponto){
        pontosJogador2 += ponto;
        tvPontosJogador2.setText(String.valueOf(pontosJogador2));
    }


    public boolean ganhou(Integer pontos){
        if(pontos == 12 || pontos > 12){

            return true;
        }
        return false;
    }

    public void marcarVitoria(String jogador){


        switch (jogador){
            case "Jogador1":{
                partidasGanhasJogador1 += 1;
                criaAlerta(jogador);
                break;
            }
            case "Jogador2" :{
                partidasGanhasJogador2 += 1;
                criaAlerta(jogador);
                break;
            }
        }

        pontosJogador1 = 0;
        pontosJogador2 = 0;
        tvPontosJogador1.setText("");
        tvPontosJogador2.setText("");

    }

    public void criaAlerta(String jogador){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Vitória");
        alert.setMessage("O " + jogador + " ganhou essa partida!");
        alert.setNeutralButton("OK", null);
        alert.show();
    }

}