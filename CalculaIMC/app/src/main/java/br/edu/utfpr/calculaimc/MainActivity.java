package br.edu.utfpr.calculaimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Calcula IMC");

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btCalcularOnClick();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLimparOnClick();
            }
        });
    }

    private void btLimparOnClick() {
        etPeso.setText("");
        etAltura.setText("");

        tvResultado.setText("0.0");

    }

    private void btCalcularOnClick() {

        if(etPeso.getText().toString().equals("")){
            etPeso.setError("Campo peso deve ser digitado");
            return;
        }

        if(etAltura.getText().toString().equals("")){
            etAltura.setError("Campo altura deve ser digitado");
            return;
        }

        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        double result = peso / Math.pow(altura, 2);

        DecimalFormat df = new DecimalFormat("0.0");

        tvResultado.setText(String.valueOf(df.format(result)));
    }
}