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
	
	//
	// Construtor
	//
	public HangmanBean()
	{
		hangman = new Hangman();
		hangman.reset();
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
		return hangman.getInputHistory().toString();
	}
	
	public void reset()
	{
		hangman.reset();
	}
	
	public void input(char chr) {
		hangman.input(chr);
	}
}  


















