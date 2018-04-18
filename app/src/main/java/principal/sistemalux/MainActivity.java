package principal.sistemalux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import principal.sistemalux.dao.AmbienteDao;
import principal.sistemalux.modelo.Ambiente;

public class MainActivity extends AppCompatActivity {

    ListView listAmbientes;
    Button btnNovoAmbiente;
    Ambiente ambiente;
    AmbienteDao ambienteDao;
    ArrayList<Ambiente> arrayListAmbiente;
    ArrayAdapter<Ambiente> arrayAdapterAmbiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAmbientes = (ListView) findViewById(R.id.listAmbientes);
        btnNovoAmbiente = (Button) findViewById(R.id.btnNovoAmbiente);

        btnNovoAmbiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormAmbiente.class);
                startActivity(i);
            }
        });
    }

    /**public void populaLista(){

        ambienteDao = new AmbienteDao(MainActivity.this);

        arrayListAmbiente = ambienteDao.selectAllAmbiente();
        ambienteDao.close();

        if (listAmbientes != null) {
            arrayAdapterAmbiente = new ArrayAdapter<Ambiente>(MainActivity.this, android.R.layout.simple_list_item_1,arrayListAmbiente);
            listAmbientes.setAdapter(arrayAdapterAmbiente);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        populaLista();
    }*/
}
