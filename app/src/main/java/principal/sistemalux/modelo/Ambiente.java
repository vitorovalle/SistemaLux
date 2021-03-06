package principal.sistemalux.modelo;

import java.io.Serializable;

/**
 * Created by Alfa on 18/11/2017.
 */

public class Ambiente implements Serializable {

    private int idAmbiente;
    private String nomeAmbiente;

    public Ambiente() {
    }

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public void setNomeAmbiente(String nomeAmbiente) {
        this.nomeAmbiente = nomeAmbiente;
    }

    @Override
    public String toString() {
        return nomeAmbiente.toString();
    }

}