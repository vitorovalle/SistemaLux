package principal.sistemalux;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import principal.sistemalux.dao.AmbienteDao;
import principal.sistemalux.dao.DispositivoDao;
import principal.sistemalux.modelo.Ambiente;
import principal.sistemalux.modelo.Dispositivo;

public class FormAmbiente extends AppCompatActivity {

    EditText editAmbiente;
    Button btnAmbiente;

    long retorno_ambiente;

    Ambiente ambiente, altambiente, idambiente;
    AmbienteDao ambienteDao;

    Dispositivo altdispositivo, dispositivo;
    DispositivoDao dispositivoDao;

    ListView listDispositivo;

    ArrayList<Dispositivo> arrayListDispositivo;
    ArrayAdapter<Dispositivo> arrayAdapterDispositivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ambiente);

        Intent i = getIntent();
        altambiente = (Ambiente) i.getSerializableExtra("ambiente-enviado");
        idambiente = (Ambiente) i.getSerializableExtra("id-ambiente");

        ambiente = new Ambiente();
        ambienteDao = new AmbienteDao(FormAmbiente.this);

        editAmbiente = (EditText) findViewById(R.id.editAmbiente);
        btnAmbiente = (Button) findViewById(R.id.btnAmbiente);
        listDispositivo = (ListView) findViewById(R.id.listDispositivos);

        registerForContextMenu(listDispositivo);

        if (altambiente != null) {
            btnAmbiente.setText("Alterar");
            editAmbiente.setText(altambiente.getNomeAmbiente());
            ambiente.setIdAmbiente(altambiente.getIdAmbiente());
            listDispositivo.setVisibility(View.VISIBLE);

        }

        else {
            btnAmbiente.setText("Salvar");
            listDispositivo.setVisibility(View.INVISIBLE);
        }

        btnAmbiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambiente.setNomeAmbiente(editAmbiente.getText().toString());

                if (btnAmbiente.getText().toString().equals("Salvar")) {
                    retorno_ambiente = ambienteDao.criarAmbiente(ambiente);
                    ambienteDao.close();
                    if (retorno_ambiente == -1) {
                        aviso("Erro ao cadastrar ambiente");
                    } else {
                        aviso("Ambiente cadastrado com sucesso");
                    }

                } else {
                    retorno_ambiente = ambienteDao.alterarAmbiente(ambiente);
                    ambienteDao.close();


                    if (retorno_ambiente == -1) {
                        aviso("Erro ao alterar");
                    } else {
                        aviso("Atualização realizada com sucesso");
                    }
                }

                finish();

            }

        });

        listDispositivo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dispositivo dispositivoEnviado = (Dispositivo) arrayAdapterDispositivo.getItem(position);

                Intent i = new Intent(FormAmbiente.this, FormConsumo.class);
                i.putExtra("dispositivo-enviado", dispositivoEnviado);
                startActivity(i);
            }
        });

        }

    private void aviso(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    public void populaDispositivo(){

        dispositivoDao = new DispositivoDao(FormAmbiente.this);

        arrayListDispositivo = dispositivoDao.selectAllDispositivo();
        dispositivoDao.close();

        arrayAdapterDispositivo = new ArrayAdapter<Dispositivo>(FormAmbiente.this, android.R.layout.simple_list_item_1,arrayListDispositivo);
        listDispositivo.setAdapter(arrayAdapterDispositivo);

    }

}