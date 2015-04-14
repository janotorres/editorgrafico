package br.com.furb.editorgrafico.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.com.furb.editorgrafico.objetos.Mundo;


public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private int janelaLargura  = 400, janelaAltura = 400;
	
	public Frame() {		
		
		super("CG-N3");   
		Mundo mundo = new Mundo();
		setBounds(300,250,janelaLargura,janelaAltura+22); 
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		add(mundo,BorderLayout.CENTER);
		mundo.requestFocus();
	}		
	

}
