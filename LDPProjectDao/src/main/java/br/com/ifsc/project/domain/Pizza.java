/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.domain;

/**
 *
 * @author Lucas
 */
public class Pizza {

    private int id;
    private String nome;

    public Pizza(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pizza(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", nome=" + nome + '}';
    }

}
