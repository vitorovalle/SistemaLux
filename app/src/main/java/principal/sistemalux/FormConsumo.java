package principal.sistemalux;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import principal.sistemalux.modelo.Dispositivo;

public class FormConsumo extends AppCompatActivity {

    Dispositivo altdispositivo;

    RadioGroup seletorConsumo;
    RadioButton botaoConsumo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_consumo);

        Intent i = getIntent();
        altdispositivo = (Dispositivo) i.getSerializableExtra("dispositivo-enviado");

        seletorConsumo = (RadioGroup) findViewById(R.id.seletorConsumo);

        seletorConsumo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                int consumoEnviado = seletorConsumo.getCheckedRadioButtonId();
                botaoConsumo = (RadioButton) findViewById(consumoEnviado);

                Intent i = new Intent(FormConsumo.this, FormDespesa.class);
                i.putExtra("consumo-enviado", consumoEnviado);
                startActivity(i);
            }
        });
    }
}
