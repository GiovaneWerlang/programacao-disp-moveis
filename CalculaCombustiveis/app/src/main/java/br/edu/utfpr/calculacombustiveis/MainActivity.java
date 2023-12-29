package br.edu.utfpr.calculacombustiveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etValorEtanol;
    private EditText etValorGasolina;
    private EditText etConsumoEtanol;
    private EditText etConsumoGasolina;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValorEtanol = findViewById(R.id.etValorEtanol);
        etValorGasolina = findViewById(R.id.etValorGasolina);

        etConsumoEtanol = findViewById(R.id.etConsumoEtanol);
        etConsumoGasolina = findViewById(R.id.etConsumoGasolina);

        tvResultado = findViewById(R.id.tvResultado);

        btCalcular = findViewById(R.id.btCalcular);
        btSair = findViewById(R.id.btSair);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btCalcularOnClick();
            }
        });

        btCalcular.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Clique para calcular.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return true;
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btSairOnClick();
            }
        });

        btSair.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view){
                Context context = getApplicationContext();
                CharSequence text = "Clique para sair do aplicativo.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                return true;
            }
        });

    }

    private boolean btSairOnClick() {
        System.exit(0);
        return false;
    }

    private void btCalcularOnClick() {

        if(etValorEtanol.getText().toString().equals("")){
            etValorEtanol.setError("Campo [Valor Etanol] deve ser digitado");
            return;
        }

        if(etValorGasolina.getText().toString().equals("")){
            etValorGasolina.setError("Campo [Valor Gasolina] deve ser digitado");
            return;
        }

        if(etConsumoEtanol.getText().toString().equals("")){
            etConsumoEtanol.setError("Campo [Consumo Etanol] deve ser digitado");
            return;
        }

        if(etConsumoGasolina.getText().toString().equals("")){
            etConsumoGasolina.setError("Campo [Consumo Gasolina] deve ser digitado");
            return;
        }

        double valorEtanol = Double.parseDouble(etValorEtanol.getText().toString());
        double consumoEtanol = Double.parseDouble(etConsumoEtanol.getText().toString());

        double valorGasolina = Double.parseDouble(etValorGasolina.getText().toString());
        double consumoGasolina = Double.parseDouble(etConsumoGasolina.getText().toString());

        if( (valorEtanol/consumoEtanol) > (valorGasolina/consumoGasolina) ){
            tvResultado.setText("GASOLINA");
        }else{
            tvResultado.setText("ETANOL");
        }
    }
}