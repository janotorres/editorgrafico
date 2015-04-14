package br.com.furb.editorgrafico.objetos;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.editorgrafico.enumerations.Cor;

public class ObjetoGrafico {

	private Cor cor;
	
	private int primitivaGrafica;
	
	private List<Ponto> pontos;
	
	private Transformacao transformacao;
	
	private BoundBox boundBox;
	
	private List<ObjetoGrafico> objetoGraficos;
	
	private boolean selected;

	public ObjetoGrafico(Ponto ponto) {
		this.pontos = new ArrayList<Ponto>();
		this.pontos.add(ponto);
		this.pontos.add(ponto.copy());
		
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public int getPrimitivaGrafica() {
		return primitivaGrafica;
	}

	public void setPrimitivaGrafica(int primitivaGrafica) {
		this.primitivaGrafica = primitivaGrafica;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public Transformacao getTransformacao() {
		return transformacao;
	}

	public void setTransformacao(Transformacao transformacao) {
		this.transformacao = transformacao;
	}

	public BoundBox getBoundBox() {
		return boundBox;
	}

	public void setBoundBox(BoundBox boundBox) {
		this.boundBox = boundBox;
	}

	public List<ObjetoGrafico> getObjetoGraficos() {
		return objetoGraficos;
	}

	public void setObjetoGraficos(List<ObjetoGrafico> objetoGraficos) {
		this.objetoGraficos = objetoGraficos;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void desenha() {
		
	}
	
}
