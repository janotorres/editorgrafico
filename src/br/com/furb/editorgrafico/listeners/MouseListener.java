package br.com.furb.editorgrafico.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import br.com.furb.editorgrafico.enumerations.Estado;
import br.com.furb.editorgrafico.objetos.Mundo;
import br.com.furb.editorgrafico.objetos.Ponto;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

	private Mundo mundo;

	public MouseListener(Mundo mundo) {
		this.mundo = mundo;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (mundo.getEstado()){
		
		case DESENHO:
			Ponto ponto = new Ponto(e.getX(), e.getY(), 0);
			mundo.criaObjeto(ponto);
			mundo.setEstado(Estado.DESENHANDO);
			break;
			
		case DESENHANDO:
			
			break;
		
		case SELECAO:
			
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
