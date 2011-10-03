/**
 * @author felipe
 *
 */

package com.jlabirinto.astar;

import java.util.ArrayList;

import com.jlabirinto.Labirinto;
import com.jlabirinto.No;

public class AStar {

	private ArrayList<NoAStar> listaFechada = new ArrayList<NoAStar>();
	private ListaAberta listaAberta = new ListaAberta();

	public AStar(Labirinto labirinto) {

		No origem = labirinto.getOrigem();
		this.listaAberta.setOrigem(origem);
		NoAStar primeiroNo = new NoAStar(origem.getPosicaoX(),
				origem.getPosicaoY(), origem, labirinto.getAlvo(), origem);
		this.listaAberta.adicionaListaAberta(primeiroNo);

	}

	public Boolean proximoPasso(Labirinto labirinto) {

		NoAStar noMenorCustoF = this.listaAberta.pegaMenorCustoF();
		if (noMenorCustoF.mesmaPosicao(labirinto.getAlvo())) {

			return false;

		}
		listaFechada.add(noMenorCustoF);
		ArrayList<No> arredores = new ArrayList<No>();
		No noTemporario = new No(noMenorCustoF.getPosicaoX(),
				noMenorCustoF.getPosicaoY());
		arredores = labirinto.getArredoresTrue(noTemporario);
		if (!arredores.isEmpty()) {
			for (No noLista : arredores) {

				listaAberta.adicionaListaAberta(new NoAStar(noLista
						.getPosicaoX(), noLista.getPosicaoY(), labirinto
						.getOrigem(), labirinto.getAlvo(), noTemporario));

			}
		}
		return true;

	}
	
	public ArrayList<NoAStar> getListaFechada() {
		
		return this.listaFechada;
		
	}
	
	public ListaAberta getListaAberta() {
		
		return this.listaAberta;
		
	}

}
