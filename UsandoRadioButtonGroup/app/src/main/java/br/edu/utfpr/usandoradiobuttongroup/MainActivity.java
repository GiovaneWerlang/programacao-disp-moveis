package br.edu.utfpr.usandoradiobuttongroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private RadioButton rbSolteiro;
    private RadioButton rbCasado;
    private RadioButton rbDivorciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);
        rbSolteiro = findViewById(R.id.rbSolteiro);
        rbCasado = findViewById(R.id.rbCasado);
        rbDivorciado = findViewById(R.id.rbDivorciado);

    }

    public void btTestarComponenteOnClick(View view) {
        String texto = "";

        if(rbMasculino.isChecked()){
            texto = "Masculino Selecionado. \n";
        }else{
            texto = "Feminino Selecionado. \n";
        }
        if(rbSolteiro.isChecked()){
            texto += "Solteiro Selecionado.";
        }else if(rbCasado.isChecked()){
            texto += "Casado Selecionado.";
        }else{
            texto += "Divorciado Selecionado.";
        }

        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}