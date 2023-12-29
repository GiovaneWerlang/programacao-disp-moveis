package br.edu.utfpr.prova2giovanewerlang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.utfpr.prova2giovanewerlang.DAO.DataBaseHandlerConta;
import br.edu.utfpr.prova2giovanewerlang.Entidades.Conta;
import br.edu.utfpr.prova2giovanewerlang.Enums.TipoConta;

public class MainActivity extends AppCompatActivity {


    private EditText etData;
    private EditText etDescricao;
    private EditText etValor;

    private RadioGroup rgTipo;
    private RadioButton rbCredito;
    private RadioButton rbDebito;

    private DataBaseHandlerConta openConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        etDescricao = findViewById(R.id.etDescricao);
        etValor = findViewById(R.id.etValor);

        rgTipo = findViewById(R.id.rgTipo);
        rbCredito = findViewById(R.id.rbCredito);
        rbDebito = findViewById(R.id.rbDebito);

        openConta = new DataBaseHandlerConta(this);

    }

    public void btCadastrarOnClick(View view) {
        Conta conta = new Conta();
        String date = etData.getText().toString();

        try{
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(date);

            conta.setData(data);

            conta.setDescricao(etDescricao.getText().toString());

            if(rgTipo.getCheckedRadioButtonId() == rbCredito.getId()){
                conta.setTipo(TipoConta.CREDITO);
            }else{
                conta.setTipo(TipoConta.DEBITO);
            }

            Float valor = new Float(0);

            try {
                valor = Float.parseFloat(etValor.getText().toString().replace(',', '.'));
                conta.setValor(valor);
            }catch (NumberFormatException e){
                e.printStackTrace();
                etValor.setError("Formato não suportado. Use apenas pontos.");
            }


        if(conta.getValor() != 0){

            if(openConta.incluir(conta)){
                Toast.makeText(this, "Conta Cadastrada com Sucesso.", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "A Conta Não Foi Cadastrada.", Toast.LENGTH_LONG).show();
            }

        }

        }catch (ParseException e){
            e.printStackTrace();
            etData.setError("Insira a data no formato XX/XX/XXXX");
        }
    }

    public void btLimparOnClick(View view) {
        etData.setText("");
        etDescricao.setText("");
        etValor.setText("");
        rbCredito.setChecked(true);
        rbDebito.setChecked(false);
    }

    public void btTotalPagarOnClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        float totalPagar = openConta.totalPagar();

        DecimalFormat df = new DecimalFormat("#.##");
        String pagar = df.format(totalPagar);

        alert.setMessage("Total a Pagar: " + pagar);
        alert.setNeutralButton("OK", null);
        alert.show();
    }

    public void btTotalReceberOnClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        float totalReceber = openConta.totalReceber();

        DecimalFormat df = new DecimalFormat("#.##");
        String receber = df.format(totalReceber);

        alert.setMessage("Total a Receber: " + receber);
        alert.setNeutralButton("OK", null);
        alert.show();
    }

    public void btSaldoFluxoOnClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        float saldoFluxo = openConta.SaldoFluxo();

        DecimalFormat df = new DecimalFormat("#.##");
        String saldo = df.format(saldoFluxo);

        alert.setMessage("Saldo Fluxo: " + saldo);
        alert.setNeutralButton("OK", null);
        alert.show();
    }
}