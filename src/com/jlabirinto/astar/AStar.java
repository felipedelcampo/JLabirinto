/**
 * @author felipe
 * Classe que controla o desenvolvimento do A*
 */

package com.jlabirinto.astar;

import java.util.ArrayList;

import com.jlabirinto.Labirinto;
import com.jlabirinto.No;

public class AStar {

	private ArrayList<NoAStar> listaFechada = new ArrayList<NoAStar>();
	private ListaAberta listaAberta = new ListaAberta();

	//Contrutor adiciona o nó origem na lista Aberta
	public AStar(Labirinto labirinto) {

		No origem = labirinto.getOrigem();
		NoAStar primeiroNo = new NoAStar(origem.getPosicaoX(),
				origem.getPosicaoY(), origem, labirinto.getAlvo(), null);
		this.listaAberta.adicionaListaAberta(primeiroNo);

	}

	//Iteração que controla o desenvolvimento do A*
	public Boolean proximoPasso(Labirinto labirinto) {

		NoAStar noMenorCustoF = this.listaAberta.pegaMenorCustoF();
		if (noMenorCustoF.mesmaPosicao(labirinto.getAlvo())) {

			return false;

		}
		this.listaFechada.add(noMenorCustoF);
		ArrayList<No> arredores = new ArrayList<No>();
		No noTemporario = new No(noMenorCustoF.getPosicaoX(),
				noMenorCustoF.getPosicaoY());
		arredores = labirinto.getArredores(noTemporario, true, 0);
		if (!arredores.isEmpty()) {
			for (No noLista : arredores) {
				//Verifica se o nó com menor custo F ainda não fi visitado
				if (noMenorCustoF.getPai() == null || noLista.verificaPosicaoRelativa(new No(noMenorCustoF.getPai().getPosicaoX(),
						noMenorCustoF.getPai().getPosicaoY())) != 0) {

					listaAberta.adicionaListaAberta(new NoAStar(noLista
							.getPosicaoX(), noLista.getPosicaoY(), labirinto
							.getOrigem(), labirinto.getAlvo(), noMenorCustoF));

				}
			}
		}
		return true;

	}

	public ArrayList<NoAStar> getListaFechada() {

		return this.listaFechada;

	}

	public ArrayList<NoAStar> getListaAberta() {

		return this.listaAberta.getListaAberta();

	}

}
