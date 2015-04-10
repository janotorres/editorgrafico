package br.com.furb.exercicio2_7;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class Desenho implements GLEventListener, KeyListener, MouseListener,
		MouseMotionListener {

	private Render render = new Render();
	private float ortho2D_minX = -400.0f, ortho2D_maxX = 400.0f,
			ortho2D_minY = -400.0f, ortho2D_maxY = 400.0f;
	private int posicaoXCirculo = 200, posicaoYCirculo = 200;
	private int antigoX, antigoY = 0;

	public void SRU() {

		// eixo x
		render.getGl().glColor3f(1.0f, 0.0f, 0.0f);
		render.getGl().glLineWidth(1.0f);
		render.getGl().glBegin(GL.GL_LINES);
		render.getGl().glVertex2f(-200.0f, 0.0f);
		render.getGl().glVertex2f(200.0f, 0.0f);
		render.getGl().glEnd();
		// eixo y
		render.getGl().glColor3f(0.0f, 1.0f, 0.0f);
		render.getGl().glBegin(GL.GL_LINES);
		render.getGl().glVertex2f(0.0f, -200.0f);
		render.getGl().glVertex2f(0.0f, 200.0f);
		render.getGl().glEnd();
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		render.getGl().glClear(GL.GL_COLOR_BUFFER_BIT);
		render.getGl().glMatrixMode(GL.GL_PROJECTION);
		render.getGl().glLoadIdentity();
		render.getGlu().gluOrtho2D(ortho2D_minX, ortho2D_maxX, ortho2D_minY,
				ortho2D_maxY);
		render.getGl().glMatrixMode(GL.GL_MODELVIEW);
		render.getGl().glLoadIdentity();

		SRU();

		desenhaMaiorCirculo();
		desenhaQuadrado();
		desenhaMenorCirculo();

		render.getGl().glFlush();
	}

	private void desenhaMaiorCirculo() {
		float circle_points = 100.0f;
		float angle, raioX = 150.0f, raioY = 150.0f;
		float lado1, lado2;

		render.getGl().glColor3f(0.0f, 0.0f, 0.0f);
		render.getGl().glLineWidth(3.0f);

		// Cria o círculo superior a direita
		render.getGl().glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i < circle_points; i++) {
			angle = 2 * conveterDoubleToFloat(Math.PI) * i / circle_points;
			lado1 = conveterDoubleToFloat(Math.cos(angle) * raioX);
			lado2 = conveterDoubleToFloat(Math.sin(angle) * raioY);
			render.getGl().glVertex2f(lado1 + 200, lado2 + 200);
		}
		render.getGl().glEnd();

	}

	private void desenhaQuadrado() {

		if ((posicaoXCirculo > 120) && (posicaoXCirculo < 280)
				&& (posicaoYCirculo > 120) && (posicaoYCirculo < 280)) {
			render.getGl().glColor3f(1.0f, 0.0f, 0.0f);
		} else {
			render.getGl().glColor3f(0.0f, 0.0f, 1.0f);
		}
		render.getGl().glLineWidth(1.0f);

		render.getGl().glBegin(GL.GL_LINE_STRIP);
		render.getGl().glVertex2f(300.0f, 300.0f);
		render.getGl().glVertex2f(100.0f, 300.0f);
		render.getGl().glVertex2f(100.0f, 100.0f);
		render.getGl().glVertex2f(300.0f, 100.0f);
		render.getGl().glVertex2f(300.0f, 300.0f);

		render.getGl().glEnd();
	}

	private void desenhaMenorCirculo() {
		float circle_points = 100.0f;
		float angle, raioX = 50.0f, raioY = 50.0f;
		float lado1, lado2;

		render.getGl().glColor3f(0.0f, 0.0f, 0.0f);
		render.getGl().glLineWidth(3.0f);

		// Cria o círculo superior a direita
		render.getGl().glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i < circle_points; i++) {
			angle = 2 * conveterDoubleToFloat(Math.PI) * i / circle_points;
			lado1 = conveterDoubleToFloat(Math.cos(angle) * raioX);
			lado2 = conveterDoubleToFloat(Math.sin(angle) * raioY);
			render.getGl().glVertex2f(lado1 + posicaoXCirculo,
					lado2 + posicaoYCirculo);
		}
		render.getGl().glEnd();

	}

	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {

	}

	@Override
	public void init(GLAutoDrawable arg0) {
		render.inicializate(arg0);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {

	}

	public float conveterDoubleToFloat(Double f) {
		return new Float(f.toString());
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		int movtoX = e.getX() - antigoX;
		int movtoY = e.getY() - antigoY;
		int atualX = posicaoXCirculo + movtoX;
		int atualY = posicaoYCirculo - movtoY;

		System.out.println("POSIÇÃO X " + atualX + " POSIÇÃO Y " + atualY);

		if ((((posicaoXCirculo + movtoX)) > 90)
				&& (((posicaoXCirculo + movtoX)) < 310)
				&& (((posicaoYCirculo - movtoY)) > 90)
				&& (((posicaoYCirculo - movtoY)) < 310)) {
			posicaoXCirculo += movtoX;
			posicaoYCirculo -= movtoY;

			System.out.println("POSIÇÃO X " + posicaoXCirculo + " POSIÇÃO Y "
					+ posicaoYCirculo);

			antigoX = e.getX();
			antigoY = e.getY();

			render.getGlDrawable().display();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		antigoX = e.getX();
		antigoY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
