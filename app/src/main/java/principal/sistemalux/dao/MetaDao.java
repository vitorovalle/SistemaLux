package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import principal.sistemalux.modelo.Meta;

/**
 * Created by Alfa on 09/05/2018.
 */

public class MetaDao extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "DBLUX.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "meta";

    private static final String ID_META = "idMeta";
    private static final String DESPESA_META = "despesaMeta";
    private static final String PONTOS_META = "pontosMeta";
    private static final String DATA_META= "dataMeta";
    private static final String ID_DESPESA= "idDespesa";

    public MetaDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_META+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+DESPESA_META+" INTEGER "+
                " "+PONTOS_META+" INTEGER "+
                " "+DATA_META+" DATETIME "+
                " "+ID_DESPESA+" TEXT );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long criarMeta(Meta m){
        ContentValues valuesMeta = new ContentValues();
        long retorno_metaDB;

        valuesMeta.put(DESPESA_META, m.getDespesaMeta());
        valuesMeta.put(PONTOS_META, m.getDespesaMeta());
        /** valuesMeta.put(DATA_META, m.getDataMeta()); */

        retorno_metaDB = getWritableDatabase().insert(TABELA, null, valuesMeta);

        return retorno_metaDB;

    }

    public long alterarMeta(Meta m){
        ContentValues valuesMeta = new ContentValues();
        long retorno_metaDB;

        valuesMeta.put(DESPESA_META, m.getDespesaMeta());
        valuesMeta.put(PONTOS_META, m.getDespesaMeta());
        /** valuesMeta.put(DATA_META, m.getDataMeta()); */

        String[] args = {(String.valueOf(m.getIdMeta()))};
        retorno_metaDB = getWritableDatabase().update(TABELA, valuesMeta, ID_META+"=?", args);

        return retorno_metaDB;

    }

    public long excluirMeta(Meta m) {
        long retorno_metaDB;

        String[] args = {(String.valueOf(m.getIdMeta()))};
        retorno_metaDB = getWritableDatabase().delete(TABELA, ID_META + "=?", args);

        return retorno_metaDB;
    }


    public ArrayList<Meta> selectAllMeta() {
        String[] coluna = {ID_META, DESPESA_META, PONTOS_META, DATA_META};

        Cursor cursor = getWritableDatabase().query(TABELA, coluna, null, null, null, null, "meta", null);

        ArrayList<Meta> listMeta = new ArrayList<Meta>();

        while (cursor.moveToNext()){

            Meta m = new Meta();

            m.setIdMeta(cursor.getInt(0));
            m.setDespesaMeta(cursor.getInt(1));
            m.setPontosMeta(cursor.getInt(2));
            /** m.setDataMeta(cursor.getInt(3)); */

            listMeta.add(m);

        }

        return listMeta;
    }
}
