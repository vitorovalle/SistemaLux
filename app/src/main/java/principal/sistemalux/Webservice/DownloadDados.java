package principal.sistemalux.Webservice;

import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import principal.sistemalux.FormDespesa;
import principal.sistemalux.modelo.Tarifa;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Alfa on 05/06/2018.
 */



public class DownloadDados extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("http://www.aneel.gov.br/dados/relatorios?p_p_id=dadosabertos_WAR_dadosabertosportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=gerarTarifaFornecimentoResidencialJSON&p_p_cacheability=cacheLevelPage&p_p_col_id=column-2&p_p_col_count=1");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String linha;
                StringBuffer buffer = new StringBuffer();
                while((linha = reader.readLine()) != null) {
                    buffer.append(linha);
                    buffer.append("\n");
                }
                return buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String dados) {
            String distribuidorTarifa, in, precoKwh = null;
            Tarifa tarifa = null;

            JSONObject reader = new JSONObject();

            try {
                JSONObject sys = reader.getJSONObject("90");
                precoKwh = sys.getString("vlrTarifa");
                distribuidorTarifa = sys.getString("nomDistribuidora");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //precoKwh = (Tarifa) tarifa.setPrecoKwh();
            //distribuidorTarifa = (Tarifa) tarifa.setDistribuidorTarifa();
        }
    }
