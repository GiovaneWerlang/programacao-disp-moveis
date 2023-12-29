package br.edu.utfpr.marcadortruco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HistoricoActivity extends AppCompatActivity {

    private TextView tvPontuacaoJogador1;
    private TextView tvPontuacaoJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        tvPontuacaoJogador1 = findViewById(R.id.tvPontuacaoJogador1);
        tvPontuacaoJogador2 = findViewById(R.id.tvPontuacaoJogador2);

        Intent intent = getIntent();
        int ptJg1 = intent.getIntExtra("pontuacaoJogador1",0);
        int ptJg2 = intent.getIntExtra("pontuacaoJogador2",0);

        tvPontuacaoJogador1.setText(String.valueOf(ptJg1));

    }
}