package br.com.furb.editorgrafico.objetos;

/** Classe que armazena as coordenadas do vetor do objeto gráfico. */
public class Ponto implements Cloneable {

	public Ponto(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	private float x;
	
	private float y;
	
	private float z;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Ponto copy() {
		try {
			return (Ponto) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
}
