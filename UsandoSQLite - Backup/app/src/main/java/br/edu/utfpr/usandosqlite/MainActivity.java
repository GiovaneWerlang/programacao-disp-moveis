package br.edu.utfpr.usandosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etNome;
    private EditText etIdade;

    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCod = findViewById(R.id.etCod);
        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);

        banco = this.openOrCreateDatabase("banco", Context.MODE_PRIVATE,null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS aluno (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER)");

    }

    public void btIncluirOnClick(View view) {
        String nome = etNome.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());

        ContentValues registro = new ContentValues();
        registro.put("nome", nome);
        registro.put("idade", idade);

        banco.insert("aluno",null, registro);


        Toast.makeText(this, "Registro inserido com sucesso!", Toast.LENGTH_LONG).show();

    }

    public void btAlterarOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());
        String nome = etNome.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());

        ContentValues registro = new ContentValues();
        registro.put("nome", nome);
        registro.put("idade", idade);

        banco.update("aluno", registro,"cod = ?" + cod, new String[] {String.valueOf(cod)});

        Toast.makeText(this, "Registro alterado com sucesso!", Toast.LENGTH_LONG).show();

    }

    public void btExcluirOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());

        banco.delete("aluno", "cod = " + cod, null);

        Toast.makeText(this, "Registro excluído com sucesso!", Toast.LENGTH_LONG).show();
    }

    public void btPesquisarOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());

        Cursor registros = banco.query("aluno", null, "cod=?", new String[]{String.valueOf(cod)}, null, null, null);


        if(registros.moveToNext()){
            String nome = registros.getString( registros.getColumnIndexOrThrow("nome"));
            int idade = registros.getInt( registros.getColumnIndexOrThrow("idade"));

            etNome.setText(nome);
            etIdade.setText(idade);

            Toast.makeText(this, "Sucesso!!", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Registro não Encontrado!", Toast.LENGTH_LONG).show();

            etNome.setText("");
            etIdade.setText("");
        }

    }

    public void btListarOnClick(View view) {

        Cursor registros = banco.query("aluno", null, null, null, null, null, null);

        String msg = "";

        while(registros.moveToNext()){
            String nome = registros.getString(registros.getColumnIndexOrThrow("nome"));
            int idade = registros.getInt(registros.getColumnIndexOrThrow("idade"));

            msg += nome + " - " + idade + "\n";
        }

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}