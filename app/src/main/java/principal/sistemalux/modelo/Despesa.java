package principal.sistemalux.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alfa on 09/05/2018.
 */

public class Despesa implements Serializable {

    private int idDespesa, despesaDiaria, despesaTotal;
    private Date dataDespesa;

    public Despesa() {
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public int getDespesaDiaria() {
        return despesaDiaria;
    }

    public void setDespesaDiaria(int despesaDiaria) {
        this.despesaDiaria = despesaDiaria;
    }

    public int getDespesaTotal() {
        return despesaTotal;
    }

    public void setDespesaTotal(int despesaTotal) {
        this.despesaTotal = despesaTotal;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }
}
