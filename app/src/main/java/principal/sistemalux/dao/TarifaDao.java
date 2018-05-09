package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import principal.sistemalux.modelo.Tarifa;

/**
 * Created by Alfa on 09/05/2018.
 */

public class TarifaDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBLUX.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "tarifa";

    private static final String ID_TARIFA = "idTarifa";
    private static final String DISTRIBUIDOR_TARIFA = "distribuidoraTarifa";
    private static final String PRECO_KWH = "precoKwh";

    public TarifaDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_TARIFA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+DISTRIBUIDOR_TARIFA+" TEXT "+
                " "+PRECO_KWH+" INTEGER );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long criarTarifa(Tarifa t){
        ContentValues valuesTarifa = new ContentValues();
        long retorno_tarifaDB;

        valuesTarifa.put(DISTRIBUIDOR_TARIFA, t.getDistribuidorTarifa());
        valuesTarifa.put(PRECO_KWH, t.getPrecoKwh());

        retorno_tarifaDB = getWritableDatabase().insert(TABELA, null, valuesTarifa);

        return retorno_tarifaDB;

    }

    public long alterarTarifa(Tarifa t){
        ContentValues valuesTarifa = new ContentValues();
        long retorno_tarifaDB;

        valuesTarifa.put(DISTRIBUIDOR_TARIFA, t.getDistribuidorTarifa());
        valuesTarifa.put(PRECO_KWH, t.getPrecoKwh());

        String[] args = {(String.valueOf(t.getIdTarifa()))};
        retorno_tarifaDB = getWritableDatabase().update(TABELA, valuesTarifa, ID_TARIFA+"=?", args);

        return retorno_tarifaDB;

    }

    public long excluirTarifa(Tarifa t) {
        long retorno_tarifaDB;

        String[] args = {(String.valueOf(t.getIdTarifa()))};
        retorno_tarifaDB = getWritableDatabase().delete(TABELA, ID_TARIFA + "=?", args);

        return retorno_tarifaDB;
    }


    public ArrayList<Tarifa> selectAllTarifa() {
        String[] coluna = {ID_TARIFA, DISTRIBUIDOR_TARIFA, PRECO_KWH};

        Cursor cursor = getWritableDatabase().query(TABELA, coluna, null, null, null, null, "tarifa", null);

        ArrayList<Tarifa> listTarifa = new ArrayList<Tarifa>();

        while (cursor.moveToNext()){

            Tarifa t = new Tarifa();

            t.setIdTarifa(cursor.getInt(0));
            t.setDistribuidorTarifa(cursor.getString(1));
            t.setPrecoKwh(cursor.getInt(2));

            listTarifa.add(t);

        }

        return listTarifa;
    }
}
