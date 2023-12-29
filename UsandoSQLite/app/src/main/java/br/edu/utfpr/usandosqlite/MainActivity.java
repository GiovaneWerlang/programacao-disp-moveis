package br.edu.utfpr.usandosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etNome;
    private EditText etIdade;

    private DatabaseHandler alunoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCod = findViewById(R.id.etCod);
        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);

        alunoDao = new DatabaseHandler(this);
    }

    public void btIncluirOnClick(View view) {
        String nome = etNome.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);

        alunoDao.incluir(aluno);


        Toast.makeText(this, "Registro inserido com sucesso!", Toast.LENGTH_LONG).show();

    }

    public void btAlterarOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());
        String nome = etNome.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());

        Aluno aluno = new Aluno();
        aluno.setCod(cod);
        aluno.setNome(nome);
        aluno.setIdade(idade);

        alunoDao.alterar(aluno);
        Toast.makeText(this, "Registro alterado com sucesso!", Toast.LENGTH_LONG).show();

    }

    public void btExcluirOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());

        alunoDao.excluir(cod);

        Toast.makeText(this, "Registro excluído com sucesso!", Toast.LENGTH_LONG).show();
    }

    public void btPesquisarOnClick(View view) {
        int cod = Integer.parseInt(etCod.getText().toString());

        String msg = alunoDao.pesquisar(cod);



        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();


    }

    public void btListarOnClick(View view) {

        String msg = alunoDao.listar();

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }
}