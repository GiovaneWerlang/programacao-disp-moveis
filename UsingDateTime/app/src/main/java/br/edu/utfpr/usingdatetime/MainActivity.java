package br.edu.utfpr.usingdatetime;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DatePicker dpDate;
    private TimePicker tpTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dpDate = findViewById(R.id.dpData);
        tpTime = findViewById(R.id.tpTime);

    }

    public void btConfirmarOnClick(View view) {
        String formatDate = dpDate.getDayOfMonth() + "/" + (dpDate.getMonth() +1) + "/" + dpDate.getYear();
        String formatTime = tpTime.getHour() + ":" + tpTime.getMinute();

        Toast.makeText(this, formatDate + "\n" + formatTime, Toast.LENGTH_LONG).show();
    }

    public void btRetornarOnClick(View view) {

        Date agora = new Date();
        Calendar cal = Calendar.getInstance();

//        dpDate.init(agora.getYear(),agora.getDate(),agora.getMonth(),null);
        dpDate.init(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),null);
    }

    public void btDiaSemanaOnClick(View view) {
        int dia = dpDate.getDayOfMonth();
        int mes = dpDate.getMonth();
        int ano = dpDate.getYear();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH , dia);
        cal.set(Calendar.MONTH , mes);
        cal.set(Calendar.YEAR , ano);

        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

        String diasDaSemana[] ={"", "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira"
                , "Quinta-Feira", "Sexta-Feira", "Sábado"};

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Dia da Semana");
        alerta.setMessage("Dia da Semana: " + diasDaSemana[diaSemana]);
        alerta.setNeutralButton("OK", null);
        alerta.show();


    }
}