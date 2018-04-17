package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import principal.sistemalux.modelo.Ambiente;

/**
 * Created by Alfa on 18/11/2017.
 */

public class AmbienteDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBLUX.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "ambiente";

    private static final String ID_AMBIENTE = "idAmbiente";
    private static final String NOME_AMBIENTE = "ambiente";

    public AmbienteDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_AMBIENTE+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+NOME_AMBIENTE+" TEXT );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public long criarAmbiente(Ambiente a){
        ContentValues valuesAmbiente = new ContentValues();
        long retorno_ambienteDB;

        valuesAmbiente.put(NOME_AMBIENTE, a.getNomeAmbiente());

        retorno_ambienteDB = getWritableDatabase().insert(TABELA, null, valuesAmbiente);

        return retorno_ambienteDB;

    }
}
