package psweb.hangman;

import java.util.ArrayList;
import java.util.List;

public class Hangman 
{
	private int chances = 6;
	private Word currentWord;
	private List<Character> history;
	
	public Hangman()
	{
		history = new ArrayList<Character>();
	}
	
	// Sorteia uma nova palavra
	public void reset()
	{
		currentWord = new Word("Teste");
		history.clear();
		chances = 6;
	}
	
	public void reset(String forcedWord)
	{
		currentWord = new Word(forcedWord);
		history.clear();
		chances = 6;
	}
	
	// Faz input de um caractere
	public boolean input(char chr)
	{
		boolean match = currentWord.input(chr);				
		if (!match)
			chances--;
		history.add(Character.toUpperCase(chr));
		return match;
	}
	
	//testa se o caractere está no history
	public boolean historyHas(char chEntrada) {
		for (int i=0;i<history.size();i++) {
			Character char1 = new Character(history.get(i));
			Character char2 = new Character(chEntrada);
			char1 = Character.toUpperCase(char1);
			char2 = Character.toUpperCase(char2);
			if(char1.equals(char2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isComplete()
	{
		return currentWord.isComplete();
	}	
	
	
	//
	// Métodos de acesso
	//
	public int getChances() {
		return chances;
	}
	
	public String getWordAsString() {
		return currentWord.getWordAsString();
	}
	
	public String getAnswerAsString() {
		return currentWord.getAnswerAsString();
	}
	
	public List<Character> getInputHistory() {
		return history;
	}
}
