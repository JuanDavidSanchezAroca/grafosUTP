package modelo;

public class Nodo {
	
	private double cordenadaX;
	private double cordenadaY;
	private int numero;
	private int peso;
	
	public Nodo(double cordenadaX, double cordenadaY,int numero) {
		super();
		this.cordenadaX = cordenadaX;
		this.cordenadaY = cordenadaY;
		this.numero = numero;
	}
	

	public Nodo(double cordenadaX, double cordenadaY,int numero,int peso) {
		super();
		this.cordenadaX = cordenadaX;
		this.cordenadaY = cordenadaY;
		this.numero = numero;
		this.peso = peso;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public double getCordenadaX() {
		return cordenadaX;
	}

	public void setCordenadaX(double cordenadaX) {
		this.cordenadaX = cordenadaX;
	}

	public double getCordenadaY() {
		return cordenadaY;
	}

	public void setCordenadaY(double cordenadaY) {
		this.cordenadaY = cordenadaY;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
