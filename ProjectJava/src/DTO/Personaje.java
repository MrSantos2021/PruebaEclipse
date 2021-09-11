package DTO;

public abstract class Personaje {
	public Armas arma;
	public Personaje() {
		// TODO Auto-generated constructor stub
	}
	public String getArmas() {
		 return arma.performArmas();
	}
	public void setArma(Armas a) {
		arma = a;
	}
	public abstract String description();

}
