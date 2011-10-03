package com.jlabirinto.astar;

import java.util.ArrayList;
import java.util.Collections;

import com.jlabirinto.No;

public class ListaAberta {

	private ArrayList<NoAStar> listaAberta = new ArrayList<NoAStar>();

	public void setOrigem(No origem) {

		listaAberta.add((NoAStar) origem);

	}

	public NoAStar pegaMenorCustoF() {

		NoAStar noAstarMenorCustoF = listaAberta.get(0);
		listaAberta.remove(0);
		return noAstarMenorCustoF;
	}

	public void adicionaListaAberta(NoAStar novoNoAstar) {

		listaAberta.add(novoNoAstar);
		Collections.sort(listaAberta, new ComparadorNoAstar());

	}

}
