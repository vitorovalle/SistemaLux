package principal.sistemalux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listAmbientes;
    Button btnNovoAmbiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAmbientes = (ListView) findViewById(R.id.listAmbientes);
        btnNovoAmbiente = (Button) findViewById(R.id.btnNovoAmbiente);

        btnNovoAmbiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FormAmbiente.class);
                startActivity(i);
            }
        });
    }
}
