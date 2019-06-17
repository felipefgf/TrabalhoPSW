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
	
	public String getDica(int chances) {
		if(chances == 6)return "Olá, sou a GLaDOS, você já deve ter esbarrado comigo em um dos testes da Aperture Science, mas estou fazendo um freela aqui, o que não sinifica que gosto de te ajudar. Enfim, sou sua ajudante para tentar acertar nesse jogo difíiiiiicillll, nossa, nem imagina o quanto... A sim, eles me proibíram de te dar um bolo, caso vença. Divirta-se, ou não...";
		if(chances == 5)return "Você ainda não tem direito a Dica, pq não tenta errar mais? Falar nisso, acho que você deu uma engorada desde o começo do jogo...";
		if(chances == 4)return "Já errou de novo... Mas ok, meu trabalho é tentar te ajudar, né? Afinal você é só um nerd jogando um jogo da forca de pokemon...";
		if(chances == 3)return "Tá, essa é fácil! Pra não dificultar para você, vou ajudar dizendo, SÓ POKEMONS da PRIMEIRA geração, já que aparentemente você não leu o título do jogo.";
		if(chances == 2) {
			if(tipo2.toString().contentEquals("---")) {
				return "Agora vai, né? Esse pokemon não tem um segundo tipo, é apenas aquele que falei antes de você errar, como tem feito com maestria. Como vejo que sua memória não é tão boa assim, deixo aqui o tipo que eu já tinha te falado: "+tipo1;
			}else{
				return "Você está errando com maestria... Vamos a mais uma dica: esse pokemon não tem um segundo tipo, o que significa que ele tem DOIS tipos, curioso, não? Como vejo que sua memória não é tão boa assim, deixo aqui o tipo que eu já tinha te falado: "+tipo1+" e o tipo novo" +tipo2;
			}
		}
		if(chances == 1)return "Vou dar a maior dica, vai pesquisar no google, vai... Seu número na Pokedex é: "+pokedex;
		if(chances == 0)return "Começa de novo, você não é o Fodão?";
		return "";
	}

	@Override
	public String toString() {
		return "Pokemon: "+nome;
	}
	
}