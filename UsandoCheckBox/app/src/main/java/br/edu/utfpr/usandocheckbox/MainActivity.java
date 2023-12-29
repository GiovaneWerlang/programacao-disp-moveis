package br.edu.utfpr.usandocheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbCaminhada;
    private CheckBox cbNatacao;
    private CheckBox cbEsporteIndividual;
    private CheckBox cbEsporteColetivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCaminhada = findViewById(R.id.cbCaminhada);
        cbNatacao = findViewById(R.id.cbNatacao);
        cbEsporteIndividual = findViewById(R.id.cbEsporteIndividual);
        cbEsporteColetivo = findViewById(R.id.cbEsporteColetivo);
    }

    public void btTestarComponenteOnClick(View view) {

        String texto = "Pratica: ";

        if(cbCaminhada.isChecked()){
            texto += "Caminhada. \n";
        }
        if(cbNatacao.isChecked()){
            texto += "Natacao. \n";
        }
        if(cbEsporteIndividual.isChecked()){
            texto += "Esporte Individual. \n";
        }
        if(cbEsporteColetivo.isChecked()){
            texto += "Esporte Coletivo. \n";
        }

        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}