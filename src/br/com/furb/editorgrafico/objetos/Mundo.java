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
		
		this.addGLEventListener(this);        
		this.addKeyListener(new ViewListener(this));
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		this.requestFocus();			
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
			gl.glMatrixMode(GL.GL_PROJECTION);
			gl.glLoadIdentity();
			glu.gluOrtho2D(camera.getOrtho2D_minX(), camera.getOrtho2D_maxX(), camera.getOrtho2D_minY(), camera.getOrtho2D_maxY());
			gl.glMatrixMode(GL.GL_MODELVIEW);
			desenhaObjetosGraficos();
			gl.glLoadIdentity();
			gl.glFlush();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	private void desenhaObjetosGraficos() {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoGrafico objetoGrafico = objetos.get(i);
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
		this.objetos.add(objetoGrafico);
	}

}
