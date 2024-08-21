package application;

import java.util.Scanner;

import chess.PartidaXadrez;
import chess.PecaXadrez;
import chess.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		
		while(true) {
			UI.printTabuleiro(partida.getPecas());// ui(user interface)é a classe e toda linha é uma função
			System.out.println();
			System.out.print("Source: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(scan);
			
			System.out.println();
			System.out.print("Target: ");
			PosicaoXadrez alvo = UI.lerPosicaoXadrez(scan);
			
			PecaXadrez capturarPeca =  partida.executarMovimentoXadrez(origem, alvo);
		
		}
		
	}

}
