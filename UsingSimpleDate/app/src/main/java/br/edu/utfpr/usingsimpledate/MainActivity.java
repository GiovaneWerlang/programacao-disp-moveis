package br.edu.utfpr.usingsimpledate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TextView tvAlarme;

    private final static int TIME_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAlarme = findViewById(R.id.tvAlarme);
    }

    public void btConfigurarOnClick(View view) {

        showDialog(TIME_DIALOG_ID);

    }

    protected Dialog onCreteDialog(int id){
        if(id == TIME_DIALOG_ID){
            TimePickerDialog td = new TimePickerDialog(this,
                    null,12,0,false);
            return td;
        }

        return null;
    }

    TimePickerDialog.OnTimeSetListener mTimeSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            tvAlarme.setText("Alarm configured to " + hour + ":" + minute);
        }
    };
}