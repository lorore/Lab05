package it.polito.tdp.anagrammi.model;

public class Anagramma {
	private String anagramma;
	private boolean isCorrect;
	
	
	public Anagramma(String anagramma, boolean isCorrect) {
		super();
		this.anagramma = anagramma;
		this.isCorrect = isCorrect;
	}
	public String getAnagramma() {
		return anagramma;
	}
	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anagramma == null) ? 0 : anagramma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (anagramma == null) {
			if (other.anagramma != null)
				return false;
		} else if (!anagramma.equals(other.anagramma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return this.anagramma;
	}
	
	

}
