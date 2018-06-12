/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure.data.pizza;

import br.com.ifsc.project.domain.pizza.Pizza;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface IPizzaDao {

    public Pizza create(Pizza pizzaIngrediente) throws SQLException;

    public List<Pizza> retrieve() throws SQLException;

    public Pizza retrieveBy(Integer id) throws SQLException;

    public Pizza update(Pizza pizzaIngrediente) throws SQLException;

    public void delete(Pizza pizzaIngrediente) throws SQLException;
}
