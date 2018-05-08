package principal.sistemalux.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                " "+NOME_DISPOSITIVO+" TEXT );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }
}
