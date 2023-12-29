package br.edu.utfpr.trocatelas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etQtd;
    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etCod = findViewById(R.id.etCod);
        etQtd = findViewById(R.id.etQtd);
        etValor = findViewById(R.id.etValor);


    }

    public void btConfirmarOnClick(View view) {
        Intent intent = new Intent(this, ConfirmarActivity.class);

        if( etCod.getText().toString().equals("")){
            etCod.setError(getString(R.string.msg_erro_cod));
            return;
        }

        intent.putExtra("cod", Integer.parseInt(etCod.getText().toString()));
        intent.putExtra("qtd", Double.parseDouble(etQtd.getText().toString()));
        intent.putExtra("valor", Double.parseDouble(etValor.getText().toString()));

        startActivity(intent);
    }

    public void btListarOnClick(View view) {
        Intent intent =  new Intent(this, ListarActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null){
            if(requestCode== 0){
                int cod = data.getIntExtra("cod", 0);
                etCod.setText(String.valueOf(cod));
            }
        }
    }
}