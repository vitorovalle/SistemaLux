package principal.sistemalux.modelo;

import java.io.Serializable;

/**
 * Created by Alfa on 09/05/2018.
 */

public class Tarifa implements Serializable {

    private int idTarifa, precoKwh;
    private String distribuidorTarifa;

    public Tarifa() {
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getPrecoKwh() {
        return precoKwh;
    }

    public void setPrecoKwh(int precoKwh) {
        this.precoKwh = precoKwh;
    }

    public String getDistribuidorTarifa() {
        return distribuidorTarifa;
    }

    public void setDistribuidorTarifa(String distribuidorTarifa) {
        this.distribuidorTarifa = distribuidorTarifa;
    }
}
