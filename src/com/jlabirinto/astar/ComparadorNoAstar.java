/**
 * @author felipe
 * Classe ordenador par o nó A*
 */

package com.jlabirinto.astar;

import java.util.Comparator;

public class ComparadorNoAstar implements Comparator<NoAStar> {

	public int compare(NoAStar no1, NoAStar no2) {
		return no1.getCustoF() < no2.getCustoF() ? -1 : (no1.getCustoF() > no2.getCustoF() ? +1 : 0);
	}

}
