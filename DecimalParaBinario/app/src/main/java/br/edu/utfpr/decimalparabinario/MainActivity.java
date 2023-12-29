package br.edu.utfpr.decimalparabinario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText num;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.etNumero);
        resultado = findViewById(R.id.tvResultado);
    }

    public void btCalcularOnClick(View view) {
        if(num.getText().toString().equals("")){

            num.setError(getString(R.string.msg_erro_numero));

            return;
        }
        resultado.setText(Integer.toBinaryString(Integer.parseInt(num.getText().toString())));
    }
}