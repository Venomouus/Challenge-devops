package br.com.fiap.tein8.model;

import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String descricao;
    private String email;
    private String senha;
    private Calendar compra;
    private double valorCompra;
    private String statusCompra;
    
    public Empresa() {
    }
    
    public Empresa(String nome, String cnpj, String descricao, String email, String senha, Calendar compra,
            double valorCompra, String statusCompra) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.email = email;
        this.senha = senha;
        this.compra = compra;
        this.valorCompra = valorCompra;
        this.statusCompra = statusCompra;
    }

    public Empresa(Long id, String nome, String cnpj, String descricao, String email, String senha, Calendar compra,double valorCompra, String statusCompra) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.email = email;
        this.senha = senha;
        this.compra = compra;
        this.valorCompra = valorCompra;
        this.statusCompra = statusCompra;
    }

    
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Calendar getCompra() {
        return compra;
    }
    public void setCompra(Calendar compra) {
        this.compra = compra;
    }
    public double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public String getStatusCompra() {
        return statusCompra;
    }
    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }
    
    @Override
    public String toString() {
        return "Empresa [cnpj=" + cnpj + ", compra=" + compra + ", descricao=" + descricao + ", email=" + email
                + ", id=" + id + ", nome=" + nome + ", senha=" + senha + ", statusCompra=" + statusCompra
                + ", valorCompra=" + valorCompra + "]";
    }
    
    
}
