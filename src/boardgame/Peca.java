package boardgame;

public class Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; //a peça vai começar nula, pq ela nao foi jogada ainda
	}
	
	protected Tabuleiro getTabuleiro() { // ele é de uso interno de tabuleiro
		return tabuleiro;
		
	}
	
	
	
}
