package principal.sistemalux.modelo;

import java.io.Serializable;

/**
 * Created by Alfa on 07/05/2018.
 */

public class Dispositivo implements Serializable {

    private int idDispositivo, consumoDispositivo,tempoDeUsoDiario;
    private String nomeDispositivo;

    public Dispositivo() {
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int getConsumoDispositivo() {
        return consumoDispositivo;
    }

    public void setConsumoDispositivo(int consumoDispositivo) {
        this.consumoDispositivo = consumoDispositivo;
    }

    public int getTempoDeUsoDiario() {
        return tempoDeUsoDiario;
    }

    public void setTempoDeUsoDiario(int tempoDeUsoDiario) {
        this.tempoDeUsoDiario = tempoDeUsoDiario;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    @Override
    public String toString() {return nomeDispositivo.toString();}
}
