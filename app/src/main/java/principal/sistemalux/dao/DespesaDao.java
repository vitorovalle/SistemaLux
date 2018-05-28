package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import principal.sistemalux.modelo.Despesa;

/**
 * Created by Alfa on 09/05/2018.
 */

public class DespesaDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBLUX.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "despesa";

    private static final String ID_DESPESA = "idDespesa";
    private static final String DESPESA_DIARIA = "despesaDiaria";
    private static final String DESPESA_TOTAL = "despesaTotal";
    private static final String DATA_DESPESA = "dataDespesa";
    private static final String ID_AMBIENTE = "idAmbiente";
    private static final String ID_TARIFA = "idTarifa";

    public DespesaDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_DESPESA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+DESPESA_DIARIA+" INTEGER "+
                " "+DESPESA_TOTAL+" INTEGER "+
                " "+DATA_DESPESA+" DATETIME "+
                " "+ID_TARIFA+" TEXT "+
                " "+ID_AMBIENTE+" TEXT);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long criarDespesa(Despesa s){
        ContentValues valuesDespesa = new ContentValues();
        long retorno_despesaDB;

        valuesDespesa.put(DESPESA_DIARIA, s.getDespesaDiaria());
        valuesDespesa.put(DESPESA_TOTAL, s.getDespesaTotal());
        /** valuesDespesa.put(DATA_DESPESA, s.getDataDespesa()); */

        retorno_despesaDB = getWritableDatabase().insert(TABELA, null, valuesDespesa);

        return retorno_despesaDB;

    }

    public long alterarDespesa(Despesa s){
        ContentValues valuesDespesa = new ContentValues();
        long retorno_despesaDB;

        valuesDespesa.put(DESPESA_DIARIA, s.getDespesaDiaria());
        valuesDespesa.put(DESPESA_TOTAL, s.getDespesaTotal());

        String[] args = {(String.valueOf(s.getIdDespesa()))};
        retorno_despesaDB = getWritableDatabase().update(TABELA, valuesDespesa, ID_DESPESA+"=?", args);

        return retorno_despesaDB;

    }

    public long excluirDespesa(Despesa s) {
        long retorno_despesaDB;

        String[] args = {(String.valueOf(s.getIdDespesa()))};
        retorno_despesaDB = getWritableDatabase().delete(TABELA, ID_DESPESA + "=?", args);

        return retorno_despesaDB;
    }


    public ArrayList<Despesa> selectAllDespesa() {
        String[] coluna = {ID_DESPESA, DESPESA_DIARIA, DESPESA_TOTAL, DATA_DESPESA};

        Cursor cursor = getWritableDatabase().query(TABELA, coluna, null, null, null, null, "despesa", null);

        ArrayList<Despesa> listDespesa = new ArrayList<Despesa>();

        while (cursor.moveToNext()){

            Despesa s = new Despesa();

            s.setIdDespesa(cursor.getInt(0));
            s.setDespesaDiaria(cursor.getInt(1));
            s.setDespesaTotal(cursor.getInt(2));
            /** s.setDataDespesa(cursor.getTime(3)); */

            listDespesa.add(s);

        }

        return listDespesa;
    }
}
