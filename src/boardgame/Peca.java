package boardgame;

public abstract class  Peca {
	
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; //a peça vai começar nula, pq ela nao foi jogada ainda
	}
	
	protected Tabuleiro getTabuleiro() { // ele é de uso interno de tabuleiro
		return tabuleiro;
		
	}
	
	public abstract boolean[][] movimentosPossiveis();
		
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] matriz = movimentosPossiveis();
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				if(matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
