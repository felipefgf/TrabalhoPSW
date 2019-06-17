package psweb.hangman;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Pokemon {
	String nome;
	String pokedex;
	String tipo1;
	String tipo2;
	
	public Pokemon() {
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("https://api.felipefgf.com.br/pegaPokemonAleatorio");
			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			this.nome = output;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public String getPokedex() {
		return pokedex;
	}
	
	public String gettipo1() {
		return tipo1;
	}
	
	public String gettipo2() {
		return tipo2;
	}

	@Override
	public String toString() {
		return "Pokemon: "+nome;
	}
	
}