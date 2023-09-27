package com.example.model;

import java.math.BigDecimal;

public class Livro { 
    private Integer id;
    private String titulo;
    private String genero;
    private Integer ano;
    private BigDecimal valor;
    private Autor autor;
    
    public Livro(String titulo, String genero, Integer ano, BigDecimal valor, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.valor = valor;
        this.autor = autor;
    }

    public Livro(Integer id, String titulo, String genero, Integer ano, BigDecimal valor, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.valor = valor;
        this.autor = autor;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", genero=" + genero + ", ano=" + ano + ", valor=" + valor + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Livro titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Livro genero(String genero) {
        this.genero = genero;
        return this;
    }

    public Livro ano(Integer ano) {
        this.ano = ano;
        return this;
    }

    public Livro valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
}
