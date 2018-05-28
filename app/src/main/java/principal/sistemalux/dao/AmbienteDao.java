package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;

import principal.sistemalux.R;
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
    private static final String ID_DISPOSITIVO = "idDispositivo";

    public AmbienteDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_AMBIENTE+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+NOME_AMBIENTE+" TEXT, "+
                " "+ID_DISPOSITIVO+" TEXT );";
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

    public long alterarAmbiente(Ambiente a){
        ContentValues valuesAmbiente = new ContentValues();
        long retorno_ambienteDB;

        valuesAmbiente.put(NOME_AMBIENTE, a.getNomeAmbiente());

        String[] args = {(String.valueOf(a.getIdAmbiente()))};
        retorno_ambienteDB = getWritableDatabase().update(TABELA, valuesAmbiente, ID_AMBIENTE+"=?", args);

        return retorno_ambienteDB;

    }

    public long excluirAmbiente(Ambiente a) {
        long retorno_ambienteDB;

        String[] args = {(String.valueOf(a.getIdAmbiente()))};
        retorno_ambienteDB = getWritableDatabase().delete(TABELA, ID_AMBIENTE + "=?", args);

        return retorno_ambienteDB;
    }


    public ArrayList<Ambiente> selectAllAmbiente() {
        String[] coluna = {ID_AMBIENTE, NOME_AMBIENTE};

        Cursor cursor = getWritableDatabase().query(TABELA, coluna, null, null, null, null, "ambiente", null);

        ArrayList<Ambiente> listAmbiente = new ArrayList<Ambiente>();

        while (cursor.moveToNext()){

            Ambiente a = new Ambiente();

            a.setIdAmbiente(cursor.getInt(0));
            a.setNomeAmbiente(cursor.getString(1));

            listAmbiente.add(a);

          }

        return listAmbiente;
    }

}
