/**
 * @author felipe
 * Classe ordenador par o nó A*
 */

package com.jlabirinto.astar;

import java.util.Comparator;

public class ComparadorNoAstar implements Comparator<NoAStar> {

	// Seta o custo F como comparação para os NoAstar
	public int compare(NoAStar no1, NoAStar no2) {
		return no1.getCustoF() < no2.getCustoF() ? -1 : (no1.getCustoF() > no2.getCustoF() ? +1 : 0);
	}

}
