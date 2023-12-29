package br.edu.utfpr.usingprogressbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);

    }

    public void btEnviarOnClick(View view) {
        new IncrementaThread().start();
    }

    class  IncrementaThread extends Thread{
//        public void ruin(){
//            for (int i = 0; i <= 100; i++){
//                progressBar.setProgress(i);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            h.post(new Runnable() {
//                @Override
//                public void run() {
//                    progressBar.setVisibility(View.GONE);
//                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
//                    alerta.setTitle("Sucesso");
//                    alerta.setMessage("Upload realizado com sucesso");
//                    alerta.setNeutralButton("OK", null);
//                    alerta.show();
//                }
//            });
//        }
            public void run() {
                try {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setProgress(i);
                        Thread.sleep(100);
                    }
                } catch ( Exception e ) {

                }
            }
    }
}