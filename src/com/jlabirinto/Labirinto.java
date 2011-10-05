package com.jlabirinto;

import java.util.ArrayList;

import com.jlabirinto.dfs.DFS;

public class Labirinto {

	private Double tamanhoDoLado;
	private Integer numeroDeQuadrados;
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

	public Integer getNumeroDeQuadrados() {
		return numeroDeQuadrados;
	}

	public Boolean[][] getLabirintoPrincipal() {
		return labirintoPrincipal;
	}

	public Labirinto(Integer tamanho) {

		switch (tamanho) {
		case 1:
			this.numeroDeQuadrados = 49;
			break;
		case 2:
			this.numeroDeQuadrados = 99;
			break;
		default:
			this.numeroDeQuadrados = 9;
			break;
		}

		this.setTamanhoDoLado(500.00 / this.numeroDeQuadrados);
		this.setAlvo(new No(this.numeroDeQuadrados - 1,
				this.numeroDeQuadrados - 1));
		this.setOrigem(new No(1, 1));
		Integer j = this.numeroDeQuadrados;
		Integer i = this.numeroDeQuadrados;
		this.labirintoPrincipal = new Boolean[i][j];
		for (i = 0; i < this.numeroDeQuadrados; i++) {
			for (j = 0; j < this.numeroDeQuadrados; j++) {
				if (i == 0 || i == this.numeroDeQuadrados || j == 0
						|| j == this.numeroDeQuadrados) {
					this.labirintoPrincipal[i][j] = false;
				} else {
					this.labirintoPrincipal[i][j] = true;
				}
			}
		}
		DFS dfs = new DFS(this);
		this.labirintoPrincipal = dfs.getLabirintoDFS();

	}

	public ArrayList<No> getArredores(No noAtual, Boolean tipo, Integer offset) {

		Integer posicaoX = noAtual.getPosicaoX();
		Integer posicaoY = noAtual.getPosicaoY();
		ArrayList<No> arredores = new ArrayList<No>();
		if (labirintoPrincipal[posicaoX + 1 + offset][posicaoY] == tipo
				&& (posicaoX + 1 + offset) > 0) {
			arredores.add(new No(posicaoX + 1, posicaoY));
		}
		if (labirintoPrincipal[posicaoX - 1 - offset][posicaoY] == tipo
				&& (posicaoX - 1 - offset) < this.numeroDeQuadrados) {
			arredores.add(new No(posicaoX - 1, posicaoY));
		}
		if (labirintoPrincipal[posicaoX][posicaoY + 1 + offset] == tipo
				&& (posicaoY + 1 + offset) > 0) {
			arredores.add(new No(posicaoX, posicaoY + 1));
		}
		if (labirintoPrincipal[posicaoX][posicaoY - 1 - offset] == tipo
				&& (posicaoY - 1 - offset) < this.numeroDeQuadrados) {
			arredores.add(new No(posicaoX, posicaoY - 1));
		}
		return arredores;

	}
}
