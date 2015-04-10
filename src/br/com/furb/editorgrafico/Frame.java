package br.com.furb.editorgrafico;

import java.awt.BorderLayout;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private int janelaLargura  = 400, janelaAltura = 400;
	
	public Frame() {		
		
		super("CG-N2_7");   
		setBounds(300,250,janelaLargura,janelaAltura+22); 
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		GLCapabilities glCaps = new GLCapabilities();
		Desenho desenho = new Desenho();
		glCaps.setRedBits(8);
		glCaps.setBlueBits(8);
		glCaps.setGreenBits(8);
		glCaps.setAlphaBits(8); 

		GLCanvas canvas = new GLCanvas(glCaps);
		add(canvas,BorderLayout.CENTER);
		canvas.addGLEventListener(desenho);        
		canvas.addKeyListener(desenho);
		canvas.addMouseListener(desenho);
		canvas.addMouseMotionListener(desenho);
		canvas.requestFocus();			
	}		
	
	public static void main(String[] args) {
		new Frame().setVisible(true);
	}

}
