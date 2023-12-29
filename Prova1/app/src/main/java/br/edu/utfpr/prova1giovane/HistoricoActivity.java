package br.edu.utfpr.prova1giovane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HistoricoActivity extends AppCompatActivity {

    private TextView tvPartidasGanhasJogador1;
    private TextView tvPartidasGanhasJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        tvPartidasGanhasJogador1 = findViewById(R.id.tvPartidasGanhasJogador1);
        tvPartidasGanhasJogador2 = findViewById(R.id.tvPartidasGanhasJogador2);

        Intent intent = getIntent();
        int partidasGanhasJogador1 = intent.getIntExtra("partidasGanhasJogador1", 0);
        int partidasGanhasJogador2 = intent.getIntExtra("partidasGanhasJogador2", 0);

        tvPartidasGanhasJogador1.setText(String.valueOf(partidasGanhasJogador1));
        tvPartidasGanhasJogador2.setText(String.valueOf(partidasGanhasJogador2));

    }

    public void btVoltarOnClick(View view) {
        finish();
    }
}