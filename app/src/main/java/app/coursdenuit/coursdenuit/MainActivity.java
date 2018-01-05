package app.coursdenuit.coursdenuit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import app.coursdenuit.coursdenuit.entities.Etudiant;
import app.coursdenuit.coursdenuit.entities.Requete;
import app.coursdenuit.coursdenuit.entities.Utilisateur;
import app.coursdenuit.coursdenuit.iService.IRequeteService;
import app.coursdenuit.coursdenuit.service.RequeteService;

public class MainActivity extends AppCompatActivity {

    private IRequeteService iRequeteService;

    public void setIRequeteService(IRequeteService iRequeteService){
        this.iRequeteService = iRequeteService;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setIRequeteService(new RequeteService());
    }

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask(2l).execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Etudiant> {
        Long id;
        public HttpRequestTask(Long id) {
            this.id=id;
        }

        @Override
        protected Etudiant doInBackground(Void... params) {
            try {
                final String url = StaticVars.url+"etudiants/"+id;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Etudiant etudiant = restTemplate.getForObject(url, Etudiant.class);
                return etudiant;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Etudiant etudiant) {
            TextView greetingIdText = (TextView) findViewById(R.id.requete);
            Toast.makeText(getApplicationContext(),etudiant.getNom().toString(),Toast.LENGTH_LONG).show();
            greetingIdText.setText(etudiant.getEmail());
        }


        public void login(RestTemplate restTemplate){
            String plainCreds = "ayoub@gmail.com:123456789";
            byte[] plainCredsBytes = plainCreds.getBytes();
            byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
            String base64Creds = new String(base64CredsBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<Utilisateur> response = restTemplate.exchange(StaticVars.url+"/login", HttpMethod.GET, request, Utilisateur.class);
            Utilisateur u = response.getBody();
        }

    }
}
