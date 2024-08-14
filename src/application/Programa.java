package application;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.PartidaXadrez;

public class Programa {

	public static void main(String[] args) {
		

		PartidaXadrez partida = new PartidaXadrez();
		UI.printTabuleiro(partida.getPecas());// ui(user interface)é a classe e toda linha é uma função
		
		
	}

}
