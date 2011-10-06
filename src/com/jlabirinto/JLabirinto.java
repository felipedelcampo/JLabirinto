package com.jlabirinto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jlabirinto.astar.AStar;
import com.jlabirinto.astar.ListaAberta;
import com.jlabirinto.astar.NoAStar;

public class JLabirinto {

	/**
	 * @param args
	 */

	private Labirinto labirinto = new Labirinto(1);
	private Boolean[][] labirintoDesenho = this.labirinto
			.getLabirintoPrincipal();
	private AStar astar = new AStar(labirinto);
	private ArrayList<NoAStar> listaAberta;
	private ArrayList<NoAStar> listaFechada;

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PainelDeDesenho painel = new PainelDeDesenho();

		frame.getContentPane().add(painel);
		frame.setSize(
				labirinto.getNumeroDeQuadrados() * labirinto.getTamanhoDoLado(),
				labirinto.getNumeroDeQuadrados() * labirinto.getTamanhoDoLado());
		frame.setVisible(true);

		while (this.astar.proximoPasso(labirinto)) {

			this.listaAberta = this.astar.getListaAberta();
			this.listaFechada = this.astar.getListaFechada();
			painel.repaint();
//			try {
//				Thread.sleep(50);
//			} catch (Exception ex) {
//			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JLabirinto gui = new JLabirinto();
		gui.go();

	}

	class PainelDeDesenho extends JPanel {

		public void paintComponent(Graphics g) {
			// metodos de desenho
			Integer lado = labirinto.getTamanhoDoLado();
			for (int i = 0; i < labirinto.getNumeroDeQuadrados(); i++) {
				for (int j = 0; j < labirinto.getNumeroDeQuadrados(); j++) {
					if (labirintoDesenho[i][j] == true) {
						g.setColor(Color.white);
					} else
						g.setColor(Color.black);
					g.fillRect(i * lado, j * lado, lado, lado);
				}
			}
			g.setColor(Color.blue);
			for (NoAStar noLista : listaAberta) {
				
				g.fillRect(noLista.getPosicaoX() * lado, noLista.getPosicaoY() * lado, lado, lado);
				
			}
			g.setColor(Color.red);
			for (NoAStar noLista : listaFechada){
				
				g.fillRect(noLista.getPosicaoX() * lado, noLista.getPosicaoY() * lado, lado, lado);
				
			}
		}
	}

}
