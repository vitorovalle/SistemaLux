package principal.sistemalux.modelo;

import java.util.Date;

/**
 * Created by Alfa on 09/05/2018.
 */

public class Meta {

    private int idMeta, pontosMeta, despesaMeta;
    private Date dataMeta;

    public Meta() {
    }

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public int getPontosMeta() {
        return pontosMeta;
    }

    public void setPontosMeta(int pontosMeta) {
        this.pontosMeta = pontosMeta;
    }

    public int getDespesaMeta() {
        return despesaMeta;
    }

    public void setDespesaMeta(int despesaMeta) {
        this.despesaMeta = despesaMeta;
    }

    public Date getDataMeta() {
        return dataMeta;
    }

    public void setDataMeta(Date dataMeta) {
        this.dataMeta = dataMeta;
    }
}
