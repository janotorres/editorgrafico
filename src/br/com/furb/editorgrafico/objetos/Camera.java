package br.com.furb.editorgrafico.objetos;


public class Camera  {

	private float ortho2D_minX;

	private float ortho2D_maxX;

	private float ortho2D_minY;

	private float ortho2D_maxY;
	
	public Camera(Mundo mundo) {
		
	}

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

	public void addOrtho2D_maxY(int ortho2D_maxY) {
		this.ortho2D_maxY += ortho2D_maxY;
		
	}

	public void addOrtho2D_minY(int ortho2D_minY) {
		this.ortho2D_minY += ortho2D_minY;
		
	}

	public void addOrtho2D_maxX(int ortho2D_maxX) {
		this.ortho2D_maxX += ortho2D_maxX;
		
	}

	public void addOrtho2D_minX(int ortho2D_minX) {
		this.ortho2D_minX = ortho2D_minX; 
		
	}

	public void moveEsquerda() {
		this.addOrtho2D_minX(10);
		this.addOrtho2D_maxX(10);
	}
	
	public void moveDireita() {
		this.addOrtho2D_minX(-10);
		this.addOrtho2D_maxX(-10);
	}
	
	public void moveBaixo() {
		this.addOrtho2D_minY(10);
		this.addOrtho2D_maxY(10);
	}
	
	public void moveCima(){
		this.addOrtho2D_minY(-10);
		this.addOrtho2D_maxY(-10);
	}
	
	public void zoomIn(){
		this.addOrtho2D_minX(-10);
		this.addOrtho2D_maxX(10);
		this.addOrtho2D_minY(-10);
		this.addOrtho2D_maxY(10);
		if ((this.getOrtho2D_minX() == 0 || this.getOrtho2D_maxX() == 0)
		||  (this.getOrtho2D_minY() == 0 || this.getOrtho2D_maxY() == 0)) {
			this.addOrtho2D_minX(10);
			this.addOrtho2D_maxX(-10);
			this.addOrtho2D_minY(10);
			this.addOrtho2D_maxY(-10);
		}
	}
	public void zoomOut(){
		this.addOrtho2D_minX(10);
		this.addOrtho2D_maxX(-10);
		this.addOrtho2D_minY(10);
		this.addOrtho2D_maxY(-10);
		if ((this.getOrtho2D_minX() == 0 || this.getOrtho2D_maxX() == 0)
		||  (this.getOrtho2D_minY() == 0 || this.getOrtho2D_maxY() == 0)) {
			this.addOrtho2D_minX(-10);
			this.addOrtho2D_maxX(10);
			this.addOrtho2D_minY(-10);
			this.addOrtho2D_maxY(10);
		}
	}
	

	


}
