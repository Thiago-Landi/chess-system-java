package chess;

import boardgame.Peca;
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
	
	public PecaXadrez executarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoAlvo) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao alvo = posicaoAlvo.posicionar();
		validarPosicaoOrigem(origem);
		Peca capturarPeca = fazerMovimento(origem, alvo);
		return (PecaXadrez)capturarPeca;
	}
	
	private Peca fazerMovimento(Posicao origem, Posicao alvo) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca capturarPeca = tabuleiro.removerPeca(alvo);
		tabuleiro.LugarDaPeca(p, alvo);
		return capturarPeca;
	}
	
	public void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.possuiAPeca(posicao)) {
			throw new XadrezException("Não há peça na posição de origem");
		}
		if(!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel());
			throw new XadrezException("Não existe movimento possivel para a peça escolhida");
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
