package com.br.senac.ppdm.cartagena;

public class Autenticacao {

    private long id;
    private String senha;

    public Autenticacao(long idJogador, String senhaJogador){
        this.id = idJogador;
        this.senha = senhaJogador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
