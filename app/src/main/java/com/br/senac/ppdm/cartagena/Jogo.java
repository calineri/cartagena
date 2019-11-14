package com.br.senac.ppdm.cartagena;

import java.util.Date;

public class Jogo {
	
	private Long id;
	private String nome;
	private String senha;
	private String erro;
	
	
	/**
	 * Status da partida (A)berta, (J)Em Andamento e (E)ncerrada - O id (identificador da partida) - A data de cria��o - O nome da partida.
	 */
	private String status;
	
	/*/**
	 * Status da rodada (J) Promovendo - (S) setup de personagens - (V) vota��o
	 */
	//private String statusRodado;*/
	
	private String data;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	/**
	 * Obtem status do jogo
	 * @return Status da partida (A)berta, (J)Em Andamento e (E)ncerrada - O id (identificador da partida) - A data de cria��o - O nome da partida.
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}



	
	
	

}
