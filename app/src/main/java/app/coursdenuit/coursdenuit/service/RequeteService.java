package app.coursdenuit.coursdenuit.service;


import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import app.coursdenuit.coursdenuit.entities.Requete;
import app.coursdenuit.coursdenuit.iService.IRequeteService;

public class RequeteService extends AsyncTask<Void, Void, Requete> implements IRequeteService  {


	@Override
	public void accepterRequete(Requete requete) {

	}

	@Override
	public void refuserRequete(Requete requete) {

	}

	@Override
	public void annulerRequete(Requete requete) {

	}

	@Override
	public void supprimerRequete(Requete requete) {

	}

	@Override
	public List<Requete> retournerLesRequetes() {


		return null;
	}

	@Override
	public Requete retournerRequeteParId(Long id) {

		try{
			final String url = "http://localhost:8081/requetes/"+id;
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			Requete requete = restTemplate.getForObject(url, Requete.class);
			return requete;

		} catch (Exception e) {
			Log.e("MainActivity", e.getMessage(), e);
		}


		return null;
	}


	@Override
	protected Requete doInBackground(Void... voids) {
		return null;
	}
}
