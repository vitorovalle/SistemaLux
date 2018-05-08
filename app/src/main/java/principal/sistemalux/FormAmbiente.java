package principal.sistemalux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import principal.sistemalux.dao.AmbienteDao;
import principal.sistemalux.dao.DispositivoDao;
import principal.sistemalux.modelo.Ambiente;
import principal.sistemalux.modelo.Dispositivo;

public class FormAmbiente extends AppCompatActivity {

    EditText editAmbiente;
    Button btnAmbiente, btnDispositivo;

    long retorno_ambiente, retorno_dispositivo;

    Ambiente ambiente, altambiente;
    AmbienteDao ambienteDao;

    Dispositivo dispositivo, altdispositivo;
    DispositivoDao dispositivoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ambiente);

        Intent i = getIntent();
        altambiente = (Ambiente) i.getSerializableExtra("ambiente-enviado");
        ambiente = new Ambiente();
        ambienteDao = new AmbienteDao(FormAmbiente.this);

        editAmbiente = (EditText) findViewById(R.id.editAmbiente);
        btnAmbiente = (Button) findViewById(R.id.btnAmbiente);
        btnDispositivo = (Button) findViewById(R.id.btnDispositivo);

        if (altambiente != null) {
            btnAmbiente.setText("Alterar");
            editAmbiente.setText(altambiente.getNomeAmbiente());
            ambiente.setIdAmbiente(altambiente.getIdAmbiente());
        } else {
            btnAmbiente.setText("Salvar");
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

        if (altdispositivo != null) {
            btnDispositivo.setVisibility(View.VISIBLE);
        } else {
            btnDispositivo.setVisibility(View.INVISIBLE);
        }

        /**btnDispositivo.setOnClickListener(new View.OnClickListener() {
         }*/
    }

    private void aviso(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
