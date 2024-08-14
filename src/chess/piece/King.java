package chess.piece;

import boardgame.Tabuleiro;
import chess.Cor;
import chess.PecaXadrez;

public class King extends PecaXadrez{

	public King(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	public String toString() {
		return "K";
	}
	
}
