/**
 * @author felipe
 * Classe principal onde cria os elementos e anima o labirinto
 */
package com.jlabirinto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jlabirinto.astar.AStar;
import com.jlabirinto.astar.NoAStar;


public class JLabirinto {

	/**
	 * @param args
	 */

	private Labirinto labirinto = new Labirinto(2);
	private Boolean[][] labirintoDesenho = this.labirinto
			.getLabirintoPrincipal();
	private AStar astar = new AStar(labirinto);
	private ArrayList<NoAStar> listaAberta;
	private ArrayList<NoAStar> listaFechada;
	private Integer lado = labirinto.getTamanhoDoLado();
	private Boolean desenhaCaminho = false;

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PainelDeDesenho painel = new PainelDeDesenho();

		frame.getContentPane().add(painel);
		frame.setSize(
				labirinto.getNumeroDeQuadrados() * labirinto.getTamanhoDoLado()
						+ 10,
				labirinto.getNumeroDeQuadrados() * labirinto.getTamanhoDoLado()
						+ 30);
		frame.setVisible(true);

		Boolean continua;

		// Loop que controla o desenvolvimento do A*
		do {

			this.listaAberta = this.astar.getListaAberta();
			this.listaFechada = this.astar.getListaFechada();
			try {
				painel.repaint();
				Thread.sleep(5);
			} catch (Exception ex) {
			}
			continua = this.astar.proximoPasso(labirinto);

		} while (continua);

		//Habilita o desenho do caminho, apenas após se achar o caminho completo
		this.desenhaCaminho = true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JLabirinto gui = new JLabirinto();
		gui.go();

	}

	@SuppressWarnings("serial")
	class PainelDeDesenho extends JPanel {

		public void paintComponent(Graphics g) {
			// Desenha o labirinto
			for (int i = 0; i < labirinto.getNumeroDeQuadrados(); i++) {
				for (int j = 0; j < labirinto.getNumeroDeQuadrados(); j++) {
					if (labirintoDesenho[i][j] == true) {
						g.setColor(Color.white);
					} else
						g.setColor(Color.black);
					g.fillRect(i * lado, j * lado, lado, lado);
				}
			}
			//Desenha a origem e o alvo
			g.setColor(Color.green);
			g.fillRect(0, lado * (labirinto.getNumeroDeQuadrados() / 2),
					lado, lado);
			g.fillRect(lado * (labirinto.getNumeroDeQuadrados()-1), lado
					* (labirinto.getNumeroDeQuadrados() / 2 + 1), lado, lado);
			//Desenha a lista fechada
			g.setColor(Color.red);
			ArrayList<NoAStar> listaFechadaPaint = new ArrayList<NoAStar>(listaFechada);
			Iterator<NoAStar> no = listaFechadaPaint.iterator();
			while(no.hasNext()){

				NoAStar noListaFechada = no.next();
				g.fillRect(noListaFechada.getPosicaoX() * lado, noListaFechada.getPosicaoY()
						* lado, lado, lado);

			}
			//Desenha a lista aberta
			g.setColor(Color.blue);
			for (NoAStar noLista : listaAberta) {

				g.fillRect(noLista.getPosicaoX() * lado, noLista.getPosicaoY()
						* lado, lado, lado);

			}
			//Desenha o caminho quando necessário
			g.setColor(Color.green);
			NoAStar noAtual = listaFechada.get(listaFechada.size() - 1);
			if (desenhaCaminho) {
				while (noAtual != null) {

					g.fillRect(noAtual.getPosicaoX() * lado,
							noAtual.getPosicaoY() * lado, lado, lado);
					noAtual = noAtual.getPai();

				}
			}
		}
	}

}
