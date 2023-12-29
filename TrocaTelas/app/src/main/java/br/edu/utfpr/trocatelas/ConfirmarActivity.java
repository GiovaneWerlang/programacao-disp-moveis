package br.edu.utfpr.trocatelas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {

    private TextView tvCod;
    private TextView tvQtd;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        tvCod = findViewById(R.id.tvCod);
        tvQtd = findViewById(R.id.tvQtd);
        tvValor = findViewById(R.id.tvValor);

        Intent intent = getIntent();
        int cod = intent.getIntExtra("cod", 0);
        double qtd = intent.getDoubleExtra("qtd", 0);
        double valor = intent.getDoubleExtra("valor", 0);

        tvCod.setText(String.valueOf(cod));
        tvQtd.setText(String.valueOf(qtd));
        tvValor.setText(String.valueOf(valor));


    }

    public void btConfirmarFinalOnClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Erro");
        alert.setMessage("Operação Indisponível no nomento.");
        alert.setNeutralButton("OK", null);
        alert.show();
    }
}