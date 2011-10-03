package com.jlabirinto;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.jlabirinto.astar.*;

public class JLabirinto {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Labirinto labirinto = new Labirinto(1);
		AStar astar = new AStar(labirinto);
		while (astar.proximoPasso(labirinto)) {
			
			ListaAberta listaAberta = astar.getListaAberta();
			ArrayList<NoAStar> listaFechada = astar.getListaFechada();

	}

}
