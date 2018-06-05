package principal.sistemalux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import principal.sistemalux.modelo.Ambiente;
import principal.sistemalux.modelo.Despesa;
import principal.sistemalux.modelo.Dispositivo;

public class FormDespesa extends AppCompatActivity {

    Despesa despesa;
    Ambiente ambiente;
    Dispositivo dispositivo;

    int ambienteEscolhido, despesaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    public int calculaDespesa(){

        ambienteEscolhido = ambiente.getIdAmbiente();

        List<Despesa> somaConsumo = new ArrayList<>();

       // for (ambienteEscolhido == dispositivo.getIdDispositivo()


        return despesaTotal;
    }
}
