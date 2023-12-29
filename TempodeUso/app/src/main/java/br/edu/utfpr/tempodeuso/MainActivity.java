package br.edu.utfpr.tempodeuso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double stop;
    private double start;
    private double pause;
    private double resume;
    private double create;
    private double pausado = 0;
    private double parado = 0;
    private TextView tvParado;
    private TextView tvPausado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvParado = findViewById(R.id.tvParado);
        tvPausado = findViewById(R.id.tvPausado);
        create = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        stop = System.currentTimeMillis();

        super.onStop();
    }

    @Override
    protected void onStart() {
        start = System.currentTimeMillis();
        if(start - stop > 0){
            parado+= start - stop;
            tvParado.setText("Tempo Parado: " + parado);
        }
        super.onStart();
    }

    @Override
    protected void onPause() {
        pause =  System.currentTimeMillis();

        super.onPause();
    }

    @Override
    protected void onResume() {

        resume = System.currentTimeMillis();
        if(pause - resume > 0){
            pausado+= pause - resume;
            tvPausado.setText("Tempo Pausado: " + pausado);
        }
        super.onResume();
    }



    public void btTempoOnClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Tempo de Uso");
        double uso = System.currentTimeMillis();
        double res = (uso - create) - (pausado + parado);
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        alert.setMessage(decimalFormat.format(res));
        alert.setNeutralButton("OK", null);
        alert.show();
    }
}