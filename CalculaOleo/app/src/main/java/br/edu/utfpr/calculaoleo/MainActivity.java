package br.edu.utfpr.calculaoleo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText qtdGas;
    private EditText proporcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qtdGas = findViewById(R.id.etQtdGasolina);
        proporcao = findViewById(R.id.etProporcao);
    }

    public void btTabelaOnClick(View view) {
        Intent intent = new Intent(this, ListaActivity.class);

        startActivityForResult(intent, 0);
    }

    public void btCalcularOnClick(View view) {


        int gas = Integer.parseInt(String.valueOf(qtdGas.getText()));
        String partes[] = proporcao.getText().toString().split(":");

        double res = gas/(Double.parseDouble(partes[0])/Double.parseDouble(partes[1]));

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Sucesso");
        alert.setMessage("Qtd. de Óleo: " + res + "l.");
        alert.setNeutralButton("OK", null);
        alert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null){
            if(requestCode == 0){
                String proporcoes = data.getStringExtra("proporcao");
                proporcao.setText(proporcoes);
            }
        }
    }
}