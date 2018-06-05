package principal.sistemalux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FormMeta extends AppCompatActivity {

    TextView ambienteShow;
    ProgressBar progressoMeta;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_meta);

        ambienteShow = (TextView) findViewById(R.id.ambienteShow);
        progressoMeta = (ProgressBar) findViewById(R.id.progressoMeta);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        int maxValor = progressoMeta.getMax();
        int progValor = progressoMeta.getProgress();
    }
}
