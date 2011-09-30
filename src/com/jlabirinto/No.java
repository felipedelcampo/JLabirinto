
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

	public No(Integer posicaoX, Integer posicaoY) {
		
		this.setPosicaoX(posicaoX);
		this.setPosicaoY(posicaoY);
		
	}

}
