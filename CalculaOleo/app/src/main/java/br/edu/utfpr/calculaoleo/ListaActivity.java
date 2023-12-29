package br.edu.utfpr.calculaoleo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    private ListView lvProporcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvProporcoes = findViewById(R.id.lvProporcoes);

        lvProporcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String proporcao = String.valueOf(lvProporcoes.getItemAtPosition(i)).substring(0,4);

                Intent intent = getIntent();
                intent.putExtra("proporcao", proporcao);
                setResult(0, intent);
                finish();
            }
        });

    }
}