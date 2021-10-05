package ar.edu.unlam.pb1.finalAgosto;

public class Celular {
	
	
	private int numero;
	private int codigoPais;
	private int codigoArea;
	
	public Celular(int numero, int codigoPais, int codigoArea) {
		
		this.numero = numero;
		this.codigoPais = codigoPais;
		this.codigoArea = codigoArea;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	public String toString() {
		
		
		return getCodigoPais() + " " + getCodigoArea() + " " + getNumero();
	}
	
	


  



}
