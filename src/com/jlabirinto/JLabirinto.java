package com.jlabirinto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jlabirinto.astar.*;

public class JLabirinto {

	/**
	 * @param args
	 */
	
	private Labirinto labirinto = new Labirinto(1);
	private AStar astar = new AStar(labirinto);
	
	class Janela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		while (astar.proximoPasso(labirinto)) {
			
			ListaAberta listaAberta = astar.getListaAberta();
			ArrayList<NoAStar> listaFechada = astar.getListaFechada();
		}

	}

}
