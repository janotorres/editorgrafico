package br.com.furb.editorgrafico;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

public class Render {
	
	private GL gl;
	private GLU glu;
	private GLAutoDrawable glDrawable;
	
	public void inicializate(GLAutoDrawable drawable){
		glDrawable = drawable;
		gl = drawable.getGL();
		glu = new GLU();
		glDrawable.setGL(new DebugGL(gl));
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	}

	public GL getGl() {
		return gl;
	}

	public GLU getGlu() {
		return glu;
	}

	public GLAutoDrawable getGlDrawable() {
		return glDrawable;
	}

}
