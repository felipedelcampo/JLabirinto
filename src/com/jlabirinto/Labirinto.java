package com.jlabirinto;

import java.util.ArrayList;

public class Labirinto {
	
	private Integer tamanhoDoLado;
	private ArrayList<No> caminhoLivre = new ArrayList<No>();
	private No origem;
	private No Alvo;
	
		
	public Double getTamanhoDoLado() {
		return tamanhoDoLado;
	}



	private void setTamanhoDoLado(Integer d) {
		this.tamanhoDoLado = d;
	}



	public No getOrigem() {
		return origem;
	}



	private void setOrigem(No origem) {
		this.origem = origem;
	}



	public No getAlvo() {
		return Alvo;
	}



	private void setAlvo(No alvo) {
		Alvo = alvo;
	}



	public Labirinto(Boolean tamanho) {
		
		Integer numeroDeQuadrados;
		
		if (tamanho) {
			numeroDeQuadrados = 10;
			
		} else {
			numeroDeQuadrados = 100;
		}
		
		this.setTamanhoDoLado( 500 / numeroDeQuadrados);
		this.setAlvo(new No(numeroDeQuadrados, 1));
		this.setOrigem(new No( 1, numeroDeQuadrados - 1));
			
	}
	
	
	public ArrayList<No> getArredores(No noAtual) {
		
		return 
	}
	

}
