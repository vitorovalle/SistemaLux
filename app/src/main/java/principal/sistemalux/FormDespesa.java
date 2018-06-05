package principal.sistemalux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import principal.sistemalux.modelo.Ambiente;
import principal.sistemalux.modelo.Despesa;
import principal.sistemalux.modelo.Dispositivo;
import principal.sistemalux.modelo.Tarifa;

public class FormDespesa extends AppCompatActivity {

    Despesa despesa;
    Ambiente ambiente;
    Dispositivo dispositivo;
    Tarifa consumo;

    int ambienteEscolhido, despesaTotal, dispositivoEscolhido, tempoDeUsoDiario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        consumo = (Tarifa) i.getSerializableExtra("consumo-enviado");

        }

    public int calculaDespesa(){

        ambienteEscolhido = ambiente.getIdAmbiente();
        dispositivoEscolhido = dispositivo.getConsumoDispositivo();
        tempoDeUsoDiario = dispositivo.getTempoDeUsoDiario();

        List<Despesa> somaConsumo = new ArrayList<>();



        return despesaTotal;
    }
}
