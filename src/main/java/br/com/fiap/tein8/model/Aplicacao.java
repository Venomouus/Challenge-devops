package br.com.fiap.tein8.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "TB_APLICACAO")
public class Aplicacao {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_empresa;
    private String nome;
    private int botoes;
    private int entrada_dados;
    private int links;

    public Aplicacao() {
    }

    public Aplicacao(Long id_empresa, String nome, int botoes, int entrada_dados, int links) {
        this.id_empresa = id_empresa;
        this.nome = nome;
        this.botoes = botoes;
        this.entrada_dados = entrada_dados;
        this.links = links;
    }

    
    public Aplicacao(Long id, Long id_empresa, String nome, int botoes, int entrada_dados, int links) {
        this.id = id;
        this.id_empresa = id_empresa;
        this.nome = nome;
        this.botoes = botoes;
        this.entrada_dados = entrada_dados;
        this.links = links;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId_empresa() {
        return id_empresa;
    }
    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getBotoes() {
        return botoes;
    }
    public void setBotoes(int botoes) {
        this.botoes = botoes;
    }
    public int getEntrada_dados() {
        return entrada_dados;
    }
    public void setEntrada_dados(int entrada_dados) {
        this.entrada_dados = entrada_dados;
    }
    public int getLinks() {
        return links;
    }
    public void setLinks(int links) {
        this.links = links;
    }
    @Override
    public String toString() {
        return "Aplicacao [botoes=" + botoes + ", entrada_dados=" + entrada_dados + ", id=" + id + ", id_empresa="
                + id_empresa + ", links=" + links + ", nome=" + nome + "]";
    }

    
}
