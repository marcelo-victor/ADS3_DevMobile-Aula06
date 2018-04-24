package usjt.com.br.paises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */

public class MainActivity extends AppCompatActivity {

    public static final String NOME = "br.usjt.paises.regiao";
    private Spinner spinnerRegiao;
    private static final String[] REGIAO = new String[]{"Todas", "Africa", "Americas", "Asia", "Europe", "Oceania"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner combo = (Spinner) findViewById(R.id.regiao);
        ArrayAdapter adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, REGIAO);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerRegiao = (Spinner) findViewById(R.id.regiao);
        combo.setAdapter(adp);
    }

    public void buscarPaises(View view) {
        Intent intent = new Intent(this, ListarPaisesActivity.class);
        String regiao = spinnerRegiao.getSelectedItem().toString();
        intent.putExtra(NOME, regiao);
        startActivity(intent);
    }
}
