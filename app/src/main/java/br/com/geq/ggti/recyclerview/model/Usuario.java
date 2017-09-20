package br.com.geq.ggti.recyclerview.model;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class Usuario {

    private String matricula;
    private String nome;
    private String n_chamado;

    public Usuario(){}

    public Usuario(String matricula, String nome, String n_chamado){
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.n_chamado = n_chamado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getN_chamado() {
        return n_chamado;
    }

    public void setN_chamado(String n_chamado) {
        this.n_chamado = n_chamado;
    }
}
