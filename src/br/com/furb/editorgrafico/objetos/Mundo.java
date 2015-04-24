package br.com.furb.editorgrafico.objetos;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import br.com.furb.editorgrafico.enumerations.Cor;
import br.com.furb.editorgrafico.enumerations.Estado;
import br.com.furb.editorgrafico.listeners.MouseListener;
import br.com.furb.editorgrafico.listeners.ViewListener;

public class Mundo extends GLCanvas implements GLEventListener{

	private static final long serialVersionUID = 1L;

	private GL gl;
	
	private GLU glu;
	
	private GLAutoDrawable glDrawable;
	
	private List<ObjetoGrafico> objetos;
	
	private Camera camera;
	
	private Estado estado;

	private static GLCapabilities getGLCapabilities() {
		GLCapabilities glCaps = new GLCapabilities();
		glCaps.setRedBits(8);
		glCaps.setBlueBits(8);
		glCaps.setGreenBits(8);
		glCaps.setAlphaBits(8); 
		return glCaps;

	}
	public Mundo() {
		super(getGLCapabilities());
		this.camera = new Camera(this);
		this.objetos = new ArrayList<ObjetoGrafico>();
		this.estado = Estado.DESENHO;
		MouseListener mouseListener = new MouseListener(this);
		
		Ponto ponto1 = new Ponto(100, 100, 0);
		Ponto ponto2 = new Ponto(100, 200, 0);
		Ponto ponto3 = new Ponto(200, 200, 0);
		Ponto ponto4 = new Ponto(200, 100, 0);
		
		this.addGLEventListener(this);        
		this.addKeyListener(new ViewListener(this));
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		this.requestFocus();
		
		criaObjeto(ponto1);
		this.objetos.get(0).getPontos().add(ponto2);
		this.objetos.get(0).getPontos().add(ponto3);
		this.objetos.get(0).getPontos().add(ponto4);
	}
	
	public List<ObjetoGrafico> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<ObjetoGrafico> objetos) {
		this.objetos = objetos;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		try 
		{
			gl.glClear(GL.GL_COLOR_BUFFER_BIT);
			gl.glMatrixMode(GL.GL_MODELVIEW);
			gl.glLoadIdentity();
			glu.gluOrtho2D(camera.getOrtho2D_minX(), camera.getOrtho2D_maxX(), camera.getOrtho2D_minY(), camera.getOrtho2D_maxY());
			desenhaSRU();
			desenhaObjetosGraficos();			
			gl.glFlush();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void desenhaSRU() {
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
			gl.glVertex2f(-200.0f, 0.0f);
			gl.glVertex2f(200.0f, 0.0f);
		gl.glEnd();
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
			gl.glVertex2f(0.0f, -200.0f);
			gl.glVertex2f(0.0f, 200.0f);
		gl.glEnd();
	}

	private void desenhaObjetosGraficos() {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoGrafico objetoGrafico = objetos.get(i);
			objetoGrafico.setGl(gl);
			objetoGrafico.desenha();
			if (objetoGrafico.isSelected())
				objetoGrafico.getBoundBox().desenha();
		}
		
	}
	
	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;
		gl = glDrawable.getGL();
		glu = new GLU();
		glDrawable.setGL(new DebugGL(gl));
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		
	}
	
	public void desenha(){
		glDrawable.display();
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void criaObjeto(Ponto ponto) {
		ObjetoGrafico objetoGrafico = new ObjetoGrafico(ponto);
		objetoGrafico.setPrimitivaGrafica(GL.GL_LINE_LOOP);
		objetoGrafico.setCor(Cor.PRETO);
		this.objetos.add(objetoGrafico);
	}
	
	public void moverObjetosDireta(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).moveDireta();
		}
	}
	
	public void moverObjetosEsquerda(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).moveEsquerda();
		}
	}
	
	public void moverObjetosAbaixo(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).moveAbaixo();
		}
	}
	
	public void moverObjetosAcima(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).moveAcima();
		}
	}
	
	public void aumentarObjeto(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).aumentaDesenho();
		}
	}
	
	public void diminuirObjeto(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).diminuiDesenho();
		}
	}
	
	public void rotacaoObjeto(){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).rotacaoDesenho();
		}
	}
	
	public void pintarObjeto(Cor cor){
		for (int i = 0; i < objetos.size(); i++) {
			objetos.get(i).setCor(cor);
		}
	}

}
