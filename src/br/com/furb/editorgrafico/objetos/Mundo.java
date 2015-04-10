package br.com.furb.editorgrafico.objetos;

import java.util.List;

public class Mundo {

	private List<ObjetoGrafico> objetos;
	
	private Camera camera;
	
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

}
