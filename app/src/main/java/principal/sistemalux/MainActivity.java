package principal.sistemalux;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
        registerForContextMenu(listAmbientes);

        btnNovoAmbiente = (Button) findViewById(R.id.btnNovoAmbiente);

        btnNovoAmbiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormAmbiente.class);
                startActivity(i);
            }
        });

        listAmbientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ambiente ambienteEnviado = (Ambiente) arrayAdapterAmbiente.getItem(position);
                Ambiente idambiente = (Ambiente) arrayAdapterAmbiente.getItem(position);

                Intent i = new Intent(MainActivity.this, FormAmbiente.class);
                i.putExtra ("ambiente-enviado", ambienteEnviado);
                i.putExtra("id-ambiente", idambiente);
                startActivity(i);
            }
        });

        listAmbientes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ambiente = arrayAdapterAmbiente.getItem(position);
                return false;
            }
        })
    ;}

    public void populaLista(){

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
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Apagar Ambiente");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                long retornoDB;
                ambienteDao = new AmbienteDao(MainActivity.this);
                retornoDB = ambienteDao.excluirAmbiente(ambiente);
                ambienteDao.close();

                if(retornoDB == -1) {
                    aviso("Falha de exclusão");
                }
                else {
                    aviso("Ambiente excluído com sucesso");
                }
                populaLista();

                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
        }

    private void aviso(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}