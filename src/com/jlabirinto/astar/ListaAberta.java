/**
 * @author felipe
 * Classe que controla a lista aberta
 */
package com.jlabirinto.astar;

import java.util.ArrayList;
import java.util.Collections;

public class ListaAberta {

	private ArrayList<NoAStar> listaAberta = new ArrayList<NoAStar>();

	// Retorna o menor custo de F entre os nós contidos na lista aberta
	public NoAStar pegaMenorCustoF() {

		NoAStar noAstarMenorCustoF = listaAberta.get(0);
		listaAberta.remove(0);
		return noAstarMenorCustoF;
	}

	public void adicionaListaAberta(NoAStar novoNoAstar) {

		listaAberta.add(novoNoAstar);
		//Após adicionar um nó a lista é ordenada pelo custo F
		Collections.sort(listaAberta, new ComparadorNoAstar());

	}

	public ArrayList<NoAStar> getListaAberta() {

		return this.listaAberta;

	}

}
