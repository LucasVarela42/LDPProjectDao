/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.domain.pizza;

import br.com.ifsc.project.domain.ingrediente.Ingrediente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Pizza {

    private int id;
    private String nome;
    private List<Ingrediente> ingredientes;

    public Pizza(int id, String nome, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }
    
    public Pizza(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pizza(String nome) {
        this.nome = nome;
    }

    public Pizza() {
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

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", nome=" + nome + ", ingredientes=" +  "}\n";
    }

}
