package br.edu.utfpr.usandotogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tbLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbLog = findViewById(R.id.tbLog);

    }

    public void btTestarComponenteOnClick(View view) {
        if(tbLog.isChecked()){
            Toast.makeText(this, "Log Habilitado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Log Desabilitado", Toast.LENGTH_LONG).show();

        }
    }
}