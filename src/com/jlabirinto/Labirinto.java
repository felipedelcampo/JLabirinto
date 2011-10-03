package com.jlabirinto;

import java.util.ArrayList;

public class Labirinto {

	private Double tamanhoDoLado;
	private Boolean[][] labirintoPrincipal;
	private No origem;
	private No Alvo;

	public Double getTamanhoDoLado() {
		return tamanhoDoLado;
	}

	private void setTamanhoDoLado(Double d) {
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

	public Labirinto(Integer tamanho) {

		Integer numeroDeQuadrados;

		switch (tamanho) {
		case 1:
			numeroDeQuadrados = 9;
			break;
		case 2:
			numeroDeQuadrados = 49;
			break;
		default:
			numeroDeQuadrados = 9;
			break;
		}

		this.setTamanhoDoLado(500.00 / numeroDeQuadrados);
		this.setAlvo(new No(numeroDeQuadrados, 1));
		this.setOrigem(new No(1, numeroDeQuadrados - 1));

	}

	public ArrayList<No> getArredoresTrue(No noAtual) {

		Integer posicaoX = noAtual.getPosicaoX();
		Integer posicaoY = noAtual.getPosicaoY();
		ArrayList<No> arredores = new ArrayList<No>();
		if (labirintoPrincipal[posicaoX + 1][posicaoY] == true) {
			arredores.add(new No(posicaoX + 1, posicaoY));
		}
		if (labirintoPrincipal[posicaoX - 1][posicaoY] == true) {
			arredores.add(new No(posicaoX - 1, posicaoY));
		}
		if (labirintoPrincipal[posicaoX][posicaoY + 1] == true) {
			arredores.add(new No(posicaoX, posicaoY + 1));
		}
		if (labirintoPrincipal[posicaoX][posicaoY - 1] == true) {
			arredores.add(new No(posicaoX, posicaoY - 1));
		}
		return arredores;

	}

}
