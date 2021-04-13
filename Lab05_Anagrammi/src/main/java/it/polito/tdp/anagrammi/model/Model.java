package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	private List<Anagramma> soluzione;
	private AnagrammaDAO anagrammaDAO;
	
	public List<Anagramma> generaAnagrammi(String parola){
		soluzione=new ArrayList<Anagramma>();
		anagrammaDAO=new AnagrammaDAO();
		StringBuilder lettere=new StringBuilder(parola);
		StringBuilder parziale=new StringBuilder();
		anagrammi(parziale, lettere, 0);
		return soluzione;
	}
	
	private void anagrammi(StringBuilder parziale, StringBuilder lettere, int livello) {
		if(lettere.length()==0) {
			String anagramma=new String(parziale.toString());
			boolean isCorrect=this.isCorrect(anagramma);
			soluzione.add(new Anagramma(anagramma, isCorrect));
		}
		else {
			for(int i=0; i<lettere.length(); i++) {
				parziale.append(lettere.charAt(i));
				lettere.deleteCharAt(i);
				anagrammi(parziale, lettere, livello+1);
				lettere.insert(i, parziale.charAt(livello));
				parziale.deleteCharAt(livello);
			}
		}
	}
	
	private boolean isCorrect(String anagramma) {
		return this.anagrammaDAO.isCorrect(anagramma);
	}
	

}
