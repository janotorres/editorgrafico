package br.com.furb.editorgrafico.objetos;

public class Camera {

	private float ortho2D_minX;
	
	private float ortho2D_maxX;
	
	private float ortho2D_minY;
	
	private float ortho2D_maxY;

	public float getOrtho2D_minX() {
		return ortho2D_minX;
	}

	public void setOrtho2D_minX(float ortho2d_minX) {
		ortho2D_minX = ortho2d_minX;
	}

	public float getOrtho2D_maxX() {
		return ortho2D_maxX;
	}

	public void setOrtho2D_maxX(float ortho2d_maxX) {
		ortho2D_maxX = ortho2d_maxX;
	}

	public float getOrtho2D_minY() {
		return ortho2D_minY;
	}

	public void setOrtho2D_minY(float ortho2d_minY) {
		ortho2D_minY = ortho2d_minY;
	}

	public float getOrtho2D_maxY() {
		return ortho2D_maxY;
	}

	public void setOrtho2D_maxY(float ortho2d_maxY) {
		ortho2D_maxY = ortho2d_maxY;
	}
}
