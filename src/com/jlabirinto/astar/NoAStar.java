
/**
 * @author felipe
 * Classe para definir nós do A*
 */

package com.jlabirinto.astar;

import com.jlabirinto.No;

public class NoAStar extends No {
	
	private Integer custoF;
	private Integer custoG;
	private Integer custoH;
	private No pai;
	
		
	public No getPai() {
		return pai;
	}

	private void setPai(No pai) {
		this.pai = pai;
	}

	public Integer getCustoF() {
		return custoF;
	}

	private void setCustoF(Integer custoF) {
		this.custoF = custoF;
	}

	private Integer getCustoG() {
		return custoG;
	}

	private void setCustoG(Integer custoG) {
		this.custoG = custoG;
	}

	private Integer getCustoH() {
		return custoH;
	}

	private void setCustoH(Integer custoH) {
		this.custoH = custoH;
	}

    //	Cria o no e calcula as distâncias
	public NoAStar(Integer posicaoX, Integer posicaoY, No origem, No alvo, No pai) {
		
		super(posicaoX, posicaoY);
		// Distância da origem
		this.setCustoG(calculaDistancia(origem));
		// Distância do final (Manhattan)
		this.setCustoH(calculaDistancia(alvo));
		// Custo F
		this.setCustoF(this.getCustoG()+this.getCustoH());
		// Define o pai
		this.setPai(pai);
		
	}
	
	public Boolean mesmaPosicao(No no) {
		
		return (this.getPosicaoX() == no.getPosicaoX() && this.getPosicaoY() == no.getPosicaoY());
		
	}
	
	
	private Integer calculaDistancia(No alvo) {
		
		Integer distanciaX, distanciaY;
		distanciaX = Math.abs(this.getPosicaoX() - alvo.getPosicaoX());
		distanciaY = Math.abs(this.getPosicaoY() - alvo.getPosicaoY());
		return distanciaX + distanciaY;
		
	}


}
