package br.com.furb.editorgrafico.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import br.com.furb.editorgrafico.enumerations.Estado;
import br.com.furb.editorgrafico.objetos.Mundo;
import br.com.furb.editorgrafico.objetos.Ponto;

/**Listener do Mouse, utilizado quando o usuário está iteragindo com o Editor (movendo e clicando o mouse) */
public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

	private Mundo mundo;

	public MouseListener(Mundo mundo) {
		this.mundo = mundo;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (mundo.getEstado()){
		
		case DESENHANDO:
			
			int x = (int)mundo.getCamera().getOrtho2D_minX() + (2 * e.getX());
			int y = (int)mundo.getCamera().getOrtho2D_maxY() - (2 * e.getY());
			Ponto ponto = new Ponto(e.getX(), e.getY(), 0);
			System.out.println(e.getX());
			System.out.println(e.getY());
			int pos = mundo.getObjetos().get(1).getPontos().size() - 1;
			mundo.getObjetos().get(1).getPontos().set(pos,ponto);
			mundo.desenha();
			break;
		
		case SELECAO:
			
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (mundo.getEstado()){
		
		case DESENHO:
			
			int x = (int)mundo.getCamera().getOrtho2D_minX() + (2 * e.getX());
			int y = (int)mundo.getCamera().getOrtho2D_maxY() - (2 * e.getY());
			Ponto ponto = new Ponto(e.getX() , e.getY(), 0);
			System.out.println(e.getX());
			System.out.println(e.getY());
			mundo.criaObjeto(ponto);
			mundo.setEstado(Estado.DESENHANDO);
			break;
			
		case DESENHANDO:
			
			break;
		
		case SELECAO:
			
			break;
		}
		mundo.desenha();
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
