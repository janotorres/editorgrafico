package br.com.furb.editorgrafico.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.furb.editorgrafico.enumerations.Cor;
import br.com.furb.editorgrafico.objetos.Mundo;

public class ViewListener implements KeyListener {

	private Mundo mundo;

	public ViewListener(Mundo mundo) {
		this.mundo = mundo;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_O:
			mundo.getCamera().zoomOut();
			mundo.desenha();
			break;

		case KeyEvent.VK_I:
			mundo.getCamera().zoomIn();
			mundo.desenha();
			break;

		case KeyEvent.VK_E:
			mundo.getCamera().moveEsquerda();
			mundo.desenha();
			break;

		case KeyEvent.VK_D:
			mundo.getCamera().moveDireita();
			mundo.desenha();
			break;

		case KeyEvent.VK_B:
			mundo.getCamera().moveBaixo();
			mundo.desenha();
			break;

		case KeyEvent.VK_C:
			mundo.getCamera().moveCima();
			mundo.desenha();
			break;
			
		case KeyEvent.VK_RIGHT:
			mundo.moverObjetosDireta();
			mundo.desenha();
			break;
		case KeyEvent.VK_LEFT:
			mundo.moverObjetosEsquerda();
			mundo.desenha();
			break;
		case KeyEvent.VK_UP:
			mundo.moverObjetosAcima();
			mundo.desenha();
			break;
		case KeyEvent.VK_DOWN:
			mundo.moverObjetosAbaixo();
			mundo.desenha();
			break;
		case KeyEvent.VK_1:
			mundo.aumentarObjeto();
			mundo.desenha();
			break;	
		case KeyEvent.VK_2:
			mundo.diminuirObjeto();
			mundo.desenha();
			break;
		case KeyEvent.VK_3:
			mundo.rotacaoObjeto();
			mundo.desenha();
			break;
		case KeyEvent.VK_R:
			mundo.pintarObjeto(Cor.VERMELHO);
			mundo.desenha();
			break;
		case KeyEvent.VK_G:
			mundo.pintarObjeto(Cor.VERDE);
			mundo.desenha();
			break;
		case KeyEvent.VK_A:
			mundo.pintarObjeto(Cor.AZUL);
			mundo.desenha();
			break;
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
}
