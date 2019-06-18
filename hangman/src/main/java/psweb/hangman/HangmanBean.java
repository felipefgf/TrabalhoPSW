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
	
	
	//
	// Construtor
	//
	public HangmanBean()
	{
		pokemon = new Pokemon();
		hangman = new Hangman();
		hangman.reset(pokemon.getNome());
	}
	
	//
	// Operações da Página
	//
	public void guess()
	{
		char chr = letter.toCharArray()[0];
		if(!hangman.historyHas(chr)) {
			hangman.input(chr);
			mensagem = "";
		}else {
			mensagem = "Essa Letra já foi usada!";
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
		pokemon = new Pokemon();
		hangman.reset(pokemon.getNome());
	}
	
	public boolean isGameOver()
	{
		return hangman.isComplete() || hangman.getChances()==0;
	}
	
	public boolean isGameWin()
	{
		return hangman.isComplete();
	}
	
	public boolean isGameLose()
	{
		return hangman.getChances()==0;
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
	
	public String getWordWithoutMask() {
		return hangman.getAnswerAsString();
	}
}  




















