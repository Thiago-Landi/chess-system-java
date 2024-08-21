package boardgame;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar o tabuleiro: o tabuleiro tem que ter pelo menos uma linha e uma coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	
	public int getColunas() {
		return colunas;
	}

		
	public Peca peca(int linha, int coluna) {
		if(!posicaoExistent(linha, coluna)) {// o ! siginifica não
			throw new TabuleiroException("Não ha essa posição no tabuleiro");
		}
		
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!posicaoExistent(posicao)) {// o ! siginifica não
			throw new TabuleiroException("Não ha essa posição no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void LugarDaPeca(Peca peca, Posicao posicao) {
		if(possuiAPeca(posicao)) {
			throw new TabuleiroException("Já existe peça na posição "+ posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	
	public Peca removerPeca(Posicao posicao) {
		if(!posicaoExistent(posicao)) {
			throw new TabuleiroException("Não ha essa posição no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}
		
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return  aux;
	}
	
	
	private boolean posicaoExistent(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas; // linhas e colunas sao a da classe tabuleiro e o sem o S vai ser dado na hora
	}
	
	public boolean posicaoExistent(Posicao posicao) {
		return posicaoExistent(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean possuiAPeca(Posicao posicao) {
		if(!posicaoExistent(posicao)) {// o ! siginifica não
			throw new TabuleiroException("Não ha essa posição no tabuleiro");
		}
		
		return peca(posicao) != null;// o peca(posicao)é o metodo que esta no tabuleiro na linha 35
	}
	
	
}
