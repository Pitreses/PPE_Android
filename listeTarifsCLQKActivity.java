package com.example.autocool;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.autocool.R;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class listeTarifsCLQKActivity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    ArrayList arrayListClasses;
    JSONArray jsonArrayClasses;
    Spinner spinnerClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_tarifs_clqk);
        final Spinner spinnerClasses = (Spinner) findViewById(R.id.spinnerClasses);
        new listeTarifsCLQKActivity.BackTaskClasses().execute();
    }
    private class BackTaskClasses extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            arrayListClasses = new ArrayList<String>();
            spinnerClasses = (Spinner) findViewById(R.id.spinnerClasses);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Request request = new Request.Builder()
                        .url("http://10.0.2.2/PPE/DAO/listeCLQKDAO.php")
                        .build();
                Response response = client.newCall(request).execute();
                String responseStr = response.body().string();
                jsonArrayClasses = new JSONArray(responseStr);
                for (int i = 0; i < jsonArrayClasses.length(); i++) {
                    JSONObject jsonClasse = jsonArrayClasses.getJSONObject(i);
                    String tarif = jsonClasse.getString("CodeCateg") + " " + jsonClasse.getString("tarifKm")+"€"+ " "+jsonClasse.getString("minKM")+"-"+jsonClasse.getString("maxKM")+"km";
                    arrayListClasses.add(tarif);
                }
            } catch (Exception e) {
                Log.d("Test", "Erreur de connexion");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            ArrayAdapter<String> arrayAdapterClasses = new
                    ArrayAdapter<String>(listeTarifsCLQKActivity.this,
                    android.R.layout.simple_spinner_item, arrayListClasses);
            arrayAdapterClasses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerClasses.setAdapter(arrayAdapterClasses);
        }
    }
}
