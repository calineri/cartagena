package com.br.senac.ppdm.cartagena;

import java.util.ArrayList;
import java.util.HashMap;

public class Status {
	
	private Long idJogadorDaVez;
	private int numeroDaJogada;
	private String erro;
	
	private HashMap<Long,ArrayList<CasaTabuleiro>> tabuleiro = new HashMap<>();

	public Long getIdJogadorDaVez() {
		return idJogadorDaVez;
	}

	public void setIdJogadorDaVez(Long idJogadorDaVez) {
		this.idJogadorDaVez = idJogadorDaVez;
	}

	public int getNumeroDaJogada() {
		return numeroDaJogada;
	}

	public void setNumeroDaJogada(int numeroDaJogada) {
		this.numeroDaJogada = numeroDaJogada;
	}

	public HashMap<Long, ArrayList<CasaTabuleiro>> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(HashMap<Long, ArrayList<CasaTabuleiro>> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
	

}
