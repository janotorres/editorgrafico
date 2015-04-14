package br.com.furb.editorgrafico.objetos;

public enum Cor {

	
	BRANCO(255,255,255),
	AZUL(0,0,255),
	VERMELHO(255,0,0),
	VERDE(0,255,0),
	AMARELO(255,255,0),
	MAGENTA(255,0,255),
	CIANO(0,255,255),
	PRETO(0,0,0);
	
	private int red;
	private int green;
	private int blue;

	private Cor(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public int getRed() {
		return red;
	}
}
