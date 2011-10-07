package com.jlabirinto;

import java.util.ArrayList;

import com.jlabirinto.dfs.DFS;

public class Labirinto {

	private Integer tamanhoDoLado;
	private Integer numeroDeQuadrados;
	private Boolean[][] labirintoPrincipal;
	private No origem;
	private No Alvo;

	public Integer getTamanhoDoLado() {
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

	public Integer getNumeroDeQuadrados() {
		return numeroDeQuadrados;
	}

	public Boolean[][] getLabirintoPrincipal() {
		return labirintoPrincipal;
	}

	public Labirinto(Integer tamanho) {

		switch (tamanho) {
		case 1:
			this.numeroDeQuadrados = 69;
			break;
		case 2:
			this.numeroDeQuadrados = 99;
			break;
		default:
			this.numeroDeQuadrados = 29;
			break;
		}

		this.setTamanhoDoLado(500 / this.numeroDeQuadrados);
		this.setAlvo(new No(this.numeroDeQuadrados - 1,
				this.numeroDeQuadrados - (this.numeroDeQuadrados/2)));
		this.setOrigem(new No(1, this.numeroDeQuadrados/2));
		Integer j = this.numeroDeQuadrados;
		Integer i = this.numeroDeQuadrados;
		this.labirintoPrincipal = new Boolean[i][j];
		for (i = 0; i < this.numeroDeQuadrados; i++) {
			for (j = 0; j < this.numeroDeQuadrados; j++) {
				
				this.labirintoPrincipal[i][j] = false;

			}
		}
		this.labirintoPrincipal[1][this.numeroDeQuadrados/2] = true;
		this.labirintoPrincipal[this.numeroDeQuadrados - 1][this.numeroDeQuadrados - (this.numeroDeQuadrados/2)] = true;
		this.labirintoPrincipal[this.numeroDeQuadrados - 2][this.numeroDeQuadrados - (this.numeroDeQuadrados/2)] = true;
		DFS dfs = new DFS(this);
		this.labirintoPrincipal = dfs.getLabirintoDFS();
		this.labirintoPrincipal[0][this.numeroDeQuadrados/2] = true;

	}

	public ArrayList<No> getArredores(No noAtual, Boolean tipo, Integer offset) {

		Integer posicaoX = noAtual.getPosicaoX();
		Integer posicaoY = noAtual.getPosicaoY();
		ArrayList<No> arredores = new ArrayList<No>();
		if ((posicaoX + 1 + offset) < this.numeroDeQuadrados) {
			if (labirintoPrincipal[posicaoX + 1 + offset][posicaoY] == tipo) {
				arredores.add(new No(posicaoX + 1 + offset, posicaoY));
			}
		}
		if ((posicaoX - 1 - offset) > 0) {
			if (labirintoPrincipal[posicaoX - 1 - offset][posicaoY] == tipo) {
				arredores.add(new No(posicaoX - 1 - offset, posicaoY));
			}
		}
		if ((posicaoY + 1 + offset) < this.numeroDeQuadrados) {
			if (labirintoPrincipal[posicaoX][posicaoY + 1 + offset] == tipo) {
				arredores.add(new No(posicaoX, posicaoY + 1 + offset));
			}
		}
		if ((posicaoY - 1 - offset) > 0) {
			if (labirintoPrincipal[posicaoX][posicaoY - 1 - offset] == tipo) {
				arredores.add(new No(posicaoX, posicaoY - 1 - offset));
			}
		}

		return arredores;

	}
}
