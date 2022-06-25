package com.projetopi.expenditurecontrol.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Movement {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false, name = "usuario")
	private String usuario;

    @NotNull
    @Column(nullable = false, name = "descricao")
	private String descricao;
	
	@NotNull
    @Column(nullable = false, name = "valor")
	private double valor;

    @NotNull
    @Column(nullable = false, name = "data")
	private String data;

    @NotNull
    @Column(nullable = false, name = "tipo")
	private String tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}