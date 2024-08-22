package chess.piece;

import boardgame.Tabuleiro;
import chess.Cor;
import chess.PecaXadrez;

public class Rook extends PecaXadrez {

	public Rook(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	
	@Override
	public String toString() {
		return "R";
	}


	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return matriz;
	}

}
