package chess;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import chess.piece.King;
import chess.piece.Rook;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarConfiguracao();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		return matriz;
	}
	
	public void iniciarConfiguracao() {
		tabuleiro.LugarDaPeca(new Rook(tabuleiro, Cor.WHITE), new Posicao(2, 1));
		tabuleiro.LugarDaPeca(new King(tabuleiro, Cor.BLACK), new Posicao(0, 4));
		tabuleiro.LugarDaPeca(new King(tabuleiro, Cor.WHITE), new Posicao(7, 4));
	}
	
}
