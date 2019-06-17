package psweb.hangman;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

public class Pokemon {
	String nome;
	String pokedex;
	String tipo1;
	String tipo2;
	String sprite;
	
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
			
			JSONObject pokeJson = new JSONObject(output.toString());  // Fonte: https://www.devmedia.com.br/trabalhando-com-json-em-java-o-pacote-org-json/25480
			this.nome = pokeJson.getString("pokemon");
			this.pokedex = pokeJson.getString("pokedex");
			this.tipo1 = pokeJson.getString("tipo1");
			this.tipo2 = pokeJson.getString("tipo2");
			this.sprite = pokeJson.getString("sprite");
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