
/**
 * @author felipe
 * Classe para definir nós padrões
 */

package com.jlabirinto;

public class No {
	
	private Integer posicaoX;
	private Integer posicaoY;
	
	
	
	public Integer getPosicaoX() {
		return posicaoX;
	}



	public void setPosicaoX(Integer posicaoX) {
		this.posicaoX = posicaoX;
	}



	public Integer getPosicaoY() {
		return posicaoY;
	}



	public void setPosicaoY(Integer posicaoY) {
		this.posicaoY = posicaoY;
	}
	//Retorna a posicacao do no em relacao a outro no 1 Acima, 2 Abaixo, 3 Direita, 4 Esquerda	
	public Integer verificaPosicaoRelativa(No no){
		
		if (this.getPosicaoX() < no.getPosicaoX()){
			return 1;
		} else if (this.getPosicaoX() > no.getPosicaoX()){
			return 2;
		} else if (this.getPosicaoY() < no.getPosicaoY()) {
			return 3;
		} else if (this.getPosicaoY() > no.getPosicaoY()) {
			return 4;
		} else return 0;
		
	}

	public No(Integer posicaoX, Integer posicaoY) {
		
		this.setPosicaoX(posicaoX);
		this.setPosicaoY(posicaoY);
		
	}

}
