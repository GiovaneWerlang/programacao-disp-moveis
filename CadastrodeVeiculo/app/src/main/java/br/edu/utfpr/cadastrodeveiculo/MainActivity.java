package br.edu.utfpr.cadastrodeveiculo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPlaca;
    private Spinner spMarca;
    private Spinner spModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlaca = findViewById(R.id.etPlaca);




        etPlaca.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int tecla, KeyEvent keyEvent) {
                if(tecla >= KeyEvent.KEYCODE_A && tecla <= KeyEvent.KEYCODE_Z){
                    if(etPlaca.getText().length() > 2){
                        return true;
                    }
                    return false;
                }else if(tecla >= KeyEvent.KEYCODE_0 && tecla <= KeyEvent.KEYCODE_9 && etPlaca.getText().length() > 2){
                    return false;
                }else{

                    return true;
                }
            }
        });

        spMarca = findViewById(R.id.spMarca);
        spModelo = findViewById(R.id.spModelo);

        String marca[] = getResources().getStringArray(R.array.marcas);

        ArrayAdapter<String> adapterMarca = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, marca);

        spMarca.setAdapter(adapterMarca);
        
        spMarca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int id, long l) {
                tratarEventoSelecaoMarca(id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void tratarEventoSelecaoMarca(int id) {
        String modelos[] = getResources().getStringArray(R.array.modelo);



        switch (id){
            case 0:{
                String modelosFiat[] = {modelos[0], modelos[1]};
                ArrayAdapter<String> adapterModelo =
                        new ArrayAdapter<String>(
                                this, android.R.layout.simple_list_item_1, modelosFiat);

                spModelo.setAdapter(adapterModelo);
                break;
            }
            case 1:{
                String modelosFord[] = {modelos[2], modelos[3]};

                ArrayAdapter<String> adapterModelo =
                        new ArrayAdapter<String>(
                                this, android.R.layout.simple_list_item_1, modelosFord);

                spModelo.setAdapter(adapterModelo);
                break;
            }
            case 2:{
                String modelosKia[] = {modelos[4], modelos[5]};

                ArrayAdapter<String> adapterModelo =
                        new ArrayAdapter<String>(
                                this, android.R.layout.simple_list_item_1, modelosKia);

                spModelo.setAdapter(adapterModelo);
                break;
            }
            case 3:{
                String modelosNissan[] = {modelos[6], modelos[7]};

                ArrayAdapter<String> adapterModelo =
                        new ArrayAdapter<String>(
                                this, android.R.layout.simple_list_item_1, modelosNissan);

                spModelo.setAdapter(adapterModelo);
                break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_salvar:
                Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show();
                return(true);
            case R.id.menu_limpar:
                etPlaca.setText("");
                return(true);


        }
        return(super.onOptionsItemSelected(item));
    }
}