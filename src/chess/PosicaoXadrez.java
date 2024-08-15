package chess;

import boardgame.Posicao;

public class PosicaoXadrez {

	private char coluna;
	private int linha;
	
	public PosicaoXadrez(char coluna, int linha) {
		if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro ao instanciar a posição. Valores validos são de a1 a h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	protected Posicao posicionar() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez daPosicao(Posicao posicao) { // metodo para as coordenadas do xadrez esta de acordo com o tabuleiro e nao com a matriz
		return new PosicaoXadrez( (char)('a' - posicao.getColuna()) , 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha; //o "" é colocado pro compliador entender que é uma concatenação
	}
	
}
