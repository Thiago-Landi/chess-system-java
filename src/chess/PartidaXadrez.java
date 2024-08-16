package chess;

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
	
	
	private void novoLugarDaPeca(char coluna, int linha, PecaXadrez peca ) {
		tabuleiro.LugarDaPeca(peca, new PosicaoXadrez(coluna, linha).posicionar() );
	}
	
	private void iniciarConfiguracao() {
		novoLugarDaPeca('c', 1, new Rook(tabuleiro, Cor.WHITE));
		novoLugarDaPeca('c', 2, new Rook(tabuleiro, Cor.WHITE));
		novoLugarDaPeca('d', 2, new Rook(tabuleiro, Cor.WHITE));
		novoLugarDaPeca('e', 2, new Rook(tabuleiro, Cor.WHITE));
		novoLugarDaPeca('e', 1, new Rook(tabuleiro, Cor.WHITE));
		novoLugarDaPeca('d', 1, new King(tabuleiro, Cor.WHITE));

		novoLugarDaPeca('c', 7, new Rook(tabuleiro, Cor.BLACK));
		novoLugarDaPeca('c', 8, new Rook(tabuleiro, Cor.BLACK));
		novoLugarDaPeca('d', 7, new Rook(tabuleiro, Cor.BLACK));
		novoLugarDaPeca('e', 7, new Rook(tabuleiro, Cor.BLACK));
		novoLugarDaPeca('e', 8, new Rook(tabuleiro, Cor.BLACK));
		novoLugarDaPeca('d', 8, new King(tabuleiro, Cor.BLACK));
	}
	
}
