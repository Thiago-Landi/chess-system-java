package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.PartidaXadrez;
import chess.PecaXadrez;
import chess.PosicaoXadrez;
import chess.XadrezException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		List<PecaXadrez> capturada = new ArrayList<>();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printPartida(partida, capturada);// ui(user interface)é a classe e toda linha é uma função
				System.out.println();
				System.out.print("Source: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(scan);
				
				boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.printTabuleiro(partida.getPecas(), movimentosPossiveis);
				
				System.out.println();
				System.out.print("Target: ");
				PosicaoXadrez alvo = UI.lerPosicaoXadrez(scan);
				
				PecaXadrez capturarPeca =  partida.executarMovimentoXadrez(origem, alvo);
				
				if(capturarPeca != null) {
					capturada.add(capturarPeca);
				}
			}
			catch(XadrezException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
		}
		
	}

}
