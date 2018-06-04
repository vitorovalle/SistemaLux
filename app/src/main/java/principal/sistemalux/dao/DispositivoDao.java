package principal.sistemalux.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import principal.sistemalux.modelo.Dispositivo;

/**
 * Created by Alfa on 07/05/2018.
 */

public class DispositivoDao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBLUX.db";
    private static final int VERSAO = 1;
    private static final String TABELA = "dispositivo";

    private static final String ID_DISPOSITIVO = "idDispositivo";
    private static final String CONSUMO_DISPOSITIVO = "consumoDispositivo";
    private static final String TEMPO_DE_USO_DIARIO = "tempoDeUsoDiario";
    private static final String NOME_DISPOSITIVO = "dispositivo";

    public DispositivoDao(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+" ( " +
                " "+ID_DISPOSITIVO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " "+CONSUMO_DISPOSITIVO+" INTEGER "+
                " "+TEMPO_DE_USO_DIARIO+" INTEGER "+
                " "+NOME_DISPOSITIVO+" TEXT );"+
                "INSERT INTO "+TABELA+" ( "+NOME_DISPOSITIVO+" ) "+"VALUES "+
                " ( Geladeira ) "+" ( Computador ) "+" ( Lavadora de Roupas )"+
                " ( Ar Condicionado ) "+
                "INSERT INTO "+TABELA+" ( "+CONSUMO_DISPOSITIVO+" ) "+"VALUES "+
                " ( 200 ) "+" ( 50 ) "+" ( 1500 )"+
                " ( 3500 ) ";
        db.execSQL(sql);

        //carregarDispositivo();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long criarDispositivo(Dispositivo d){
        ContentValues valuesDispositivo = new ContentValues();
        long retorno_dispositivoDB;

        valuesDispositivo.put(NOME_DISPOSITIVO, d.getNomeDispositivo());
        valuesDispositivo.put(CONSUMO_DISPOSITIVO, d.getConsumoDispositivo());
        valuesDispositivo.put(TEMPO_DE_USO_DIARIO, d.getTempoDeUsoDiario());

        retorno_dispositivoDB = getWritableDatabase().insert(TABELA, null, valuesDispositivo);

        return retorno_dispositivoDB;

    }

    public long alterarDispositivo(Dispositivo d){
        ContentValues valuesDispositivo = new ContentValues();
        long retorno_dispositivoDB;

        valuesDispositivo.put(NOME_DISPOSITIVO, d.getNomeDispositivo());
        valuesDispositivo.put(CONSUMO_DISPOSITIVO, d.getNomeDispositivo());
        valuesDispositivo.put(TEMPO_DE_USO_DIARIO, d.getTempoDeUsoDiario());

        String[] args = {(String.valueOf(d.getIdDispositivo()))};
        retorno_dispositivoDB = getWritableDatabase().update(TABELA, valuesDispositivo, ID_DISPOSITIVO+"=?", args);

        return retorno_dispositivoDB;

    }

    public long excluirDispositivo(Dispositivo d) {
        long retorno_dispositivoDB;

        String[] args = {(String.valueOf(d.getIdDispositivo()))};
        retorno_dispositivoDB = getWritableDatabase().delete(TABELA, ID_DISPOSITIVO + "=?", args);

        return retorno_dispositivoDB;
    }


    public ArrayList<Dispositivo> selectAllDispositivo() {
        String[] coluna = {ID_DISPOSITIVO, NOME_DISPOSITIVO, CONSUMO_DISPOSITIVO, TEMPO_DE_USO_DIARIO};

        Cursor cursor = getWritableDatabase().query(TABELA, coluna, null, null, null, null, "dispositivo", null);

        ArrayList<Dispositivo> listDispositivo = new ArrayList<Dispositivo>();

        while (cursor.moveToNext()){

            Dispositivo d = new Dispositivo();

            d.setIdDispositivo(cursor.getInt(0));
            d.setNomeDispositivo(cursor.getString(1));
            d.setConsumoDispositivo(cursor.getInt(2));
            d.setTempoDeUsoDiario(cursor.getInt(3));

            listDispositivo.add(d);

        }

        return listDispositivo;
    }

    /*public void carregarDispositivo() {

        String sql = ;

    }*/
}
