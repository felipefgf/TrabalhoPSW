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
	
	//
	// Construtor
	//
	public HangmanBean()
	{
		hangman = new Hangman();
		hangman.reset();
	}
	
	//
	// Operações da Página
	//
	public void guess()
	{
		char chr = letter.toCharArray()[0];
		hangman.input(chr);
		letter="";
	}
	
	public void reset()
	{
		hangman.reset();		
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
		return hangman.getInputHistory().toString();
	}
	
	public String getLetter() {
		return letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
}  



















