package usjt.com.br.paises;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */


public class ListarPaisesActivity extends Activity {
    private List<Pais> lista;
    public static final String DESCRICAO = "br.usjt.paises.descricao";
    private PaisDAO paisDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent origemIntent = getIntent();
        String chave = origemIntent.getStringExtra(MainActivity.NOME);
        paisDAO = new PaisDAO(this);

        if (chave.equals("Todas")) {
                lista = paisDAO.listarPaisesAll();
            if(lista.size() > 0){
                createView();
            }
            else{
                new ConsomeWS().execute("https://restcountries.eu/rest/v2/all?fields=name;capital;region;flag");
            }
        } else {
            lista = paisDAO.listarPaisesRegiao(chave);
                if(lista.size() > 0){
                    createView();
                }
                else{
                    new ConsomeWS().execute("https://restcountries.eu/rest/v2/region/" + chave + "?fields=name;capital;region;flag");
                }
        }
    }

    public void createView(){
        setContentView(R.layout.activity_listar_paises);

        ListarPaisesAdapter<Pais> adapter =
                new ListarPaisesAdapter<>(this, lista);


        ListView listView =
                findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(ListarPaisesActivity.this, DetalhePaisActivity.class);
                intent.putExtra(DESCRICAO, lista.get(pos).getNome());
                startActivity(intent);
            }
        });
    }

    private class ConsomeWS extends AsyncTask <String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(strings[0])
                    .build();
            try{
                Response response = client.newCall(request).execute();
                return response.body().string();
            }
            catch(IOException e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String json) {
            try {
                List<Pais> listaNomes = new ArrayList<>();
                int count = 1;
                JSONArray names = new JSONArray(json);


                while(count > 0){
                    try {
                        Pais pais = new Pais();

                        JSONObject paisInfo =
                                names.getJSONObject(count);

                        pais.setNome(paisInfo.getString("name"));
                        pais.setRegiao(paisInfo.getString("region"));
                        pais.setCapital(paisInfo.getString("capital"));
                        pais.setBandeira(paisInfo.getString("flag"));

                        count += 1;
                        listaNomes.add(pais);
                        paisDAO.inserirSimples(pais);
                    }catch(Exception ex){
                        count = -1;
                    }
                }
                lista = listaNomes;
                createView();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}






