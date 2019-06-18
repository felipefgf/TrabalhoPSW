package psweb.hangman;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class HangmanBean
{    
	//
	// Dados da Página
	//
	private Hangman hangman;
	private String letter;
	private Pokemon pokemon;
	private String mensagem;
	private String musica;
	private String sound;
	
	
	//
	// Construtor
	//
	public HangmanBean()
	{
		pokemon = new Pokemon();
		hangman = new Hangman();
		hangman.reset(pokemon.getNome());
		musica = "musicaTema.mp3";
	}
	
	//
	// Operações da Página
	//
	public void guess()
	{
		char chr = letter.toCharArray()[0];
		if(!hangman.historyHas(chr)) {
			if(hangman.input(chr)) {
				sound = "lvlup.mp3";
			}else {
				sound = "damage.mp3";
			}
			mensagem = "";
		}else {
			mensagem = "Essa Letra já foi usada!";
			sound = "confuse.mp3";
		}
		letter="";
	}
	
	public boolean hasMensagem() {
		if(mensagem == "") {
			return false;
		}
		return true;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void reset()
	{
		sound = "recovery.mp3";
		pokemon = new Pokemon();
		hangman.reset(pokemon.getNome());
	}
	
	public boolean isNotGameOver()
	{
		return !(hangman.isComplete() || hangman.getChances()==0);
	}
	
	public boolean isGameOver()
	{
		return hangman.isComplete() || hangman.getChances()==0;
	}
	
	public boolean isGameWin()
	{
		boolean retorno = false;
		if(hangman.isComplete()) {
			sound = "ending.mp3";
			retorno = true;
		}
		return retorno;
	}
	
	public boolean isGameLose()
	{
		boolean retorno = false;
		if(hangman.getChances()==0) {
			sound = "gameover.mp3";
			retorno = true;
		}
		return retorno;
	}	
	
	//
	// Métodos de Acesso
	//
	public String getWord()
	{
		return hangman.getWordAsString();
	}
	
	public int getChances()
	{
		return hangman.getChances();
	}
	
	public String getAttempts()
	{
		return hangman.getInputHistory().toString().replace("[", "").replace("]", "");
	}
	
	public String getLetter() {
		return letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public String getDica() {
		return pokemon.getDica(this.getChances());
	}
	
	public String giveDica(String dica) {
		dica = dica + " " + getDica();
		return dica;
	}
	
	public String getPokedex() {
		return pokemon.getPokedex();
	}
	
	public String getMusic() {
		return musica;
	}
	
	public String getSound() {
		String som = sound;
		sound = "";
		return som;
	}
	
	public String getWordWithoutMask() {
		return hangman.getAnswerAsString();
	}
}  




















