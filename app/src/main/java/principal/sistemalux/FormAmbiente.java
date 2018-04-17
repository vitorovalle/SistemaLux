package principal.sistemalux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import principal.sistemalux.dao.AmbienteDao;
import principal.sistemalux.modelo.Ambiente;

public class FormAmbiente extends AppCompatActivity {

    EditText editAmbiente;
    Button btnAmbiente;

    Ambiente ambiente, altambiente;
    AmbienteDao ambienteDao;
    long retorno_ambiente;

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

        if(altambiente != null){
            btnAmbiente.setText("Alterar");}
        else{
            btnAmbiente.setText("Salvar");
        }

        btnAmbiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ambiente.setNomeAmbiente(editAmbiente.getText().toString());
                ambiente.setIdAmbiente(Integer.parseInt(editAmbiente.getText().toString()));

                if (btnAmbiente.getText().toString().equals("Salvar")) {
                    retorno_ambiente = ambienteDao.criarAmbiente(ambiente);
                    if (retorno_ambiente == -1) {
                        aviso("Erro ao cadastrar ambiente");
                    } else {
                        aviso("Ambiente cadastrado com sucesso");
                    }


                }

                finish();

            }
        });
    }


    private void aviso(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}