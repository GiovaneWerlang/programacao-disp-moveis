package br.edu.utfpr.marcadortruco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int pontuacaoJogador1;
    private int pontuacaoJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btAdd1Player1OnClick(View view) {
        pontuacaoJogador1+=1;
        if(ganhou(pontuacaoJogador1)){
            alerta("Jogador1");
        }
    }

    public void btAdd3Player1OnClick(View view) {
        pontuacaoJogador1+=3;
    }

    public void btAdd6Player1OnClick(View view) {
        pontuacaoJogador1+=6;
    }

    public void btAdd9Player1OnClick(View view) {
        pontuacaoJogador1+=9;
    }

    public void btAdd12Player1OnClick(View view) {
        pontuacaoJogador1+=12;
        if(ganhou(pontuacaoJogador1)){
            alerta("Jogador1");
        }
    }

    public void btAdd1Player2OnClick(View view) {
        pontuacaoJogador2+=1;
    }

    public void btAdd3Player2OnClick(View view) {
        pontuacaoJogador2+=3;

    }

    public void btAdd6Player2OnClick(View view) {
        pontuacaoJogador2+=6;

    }

    public void btAdd9Player2OnClick(View view) {
        pontuacaoJogador2+=9;

    }

    public void btAdd12Player2OnClick(View view) {
        pontuacaoJogador2+=12;
    }

    public void btHistoricoOnClick(View view) {
        Intent intent = new Intent(null, HistoricoActivity.class);
        intent.putExtra("pontuacaoJogador1", pontuacaoJogador1);
        intent.putExtra("pontuacaoJogador2", pontuacaoJogador2);
        startActivity(intent);
    }

    public void btZerarOnClick(View view) {
        pontuacaoJogador1 = 0;
        pontuacaoJogador2 = 0;
    }

    public boolean ganhou(Integer pontos){
        return pontos >= 12;
    }

    public AlertDialog.Builder alerta(String nome){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Vencedor!");
        alert.setMessage("O jogador " + nome + " ganhou!");
        alert.setNeutralButton("OK", null);
        alert.show();
        return alert;
    }
}