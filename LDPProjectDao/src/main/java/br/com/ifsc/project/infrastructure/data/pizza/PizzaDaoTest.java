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
public class PizzaDaoTest {

    public static void main(String[] args) throws SQLException {
        Pizza p1 = new Pizza("Pizza de mussarela");
        Pizza p2 = new Pizza("Teste");
        IPizzaDao dao = new PizzaDao();

        //CREATE
        p1 = dao.create(p1);
        p2 = dao.create(p2);

        //RETRIVE
        List<Pizza> pizzas = dao.retrieve();
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.toString());
        }

        //RETRIVE BY ID
        p1 = dao.retrieveBy(p1.getId());
        System.out.println(p1.toString());

        //UPDATE
        p2.setNome("TesteAtualizado");
        dao.update(p2);

        //RETRIVE UPDATED
        pizzas = dao.retrieve();
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.toString());
        }

        //DELETE
        dao.delete(p2);

        //RETRIVE DELETED
        pizzas = dao.retrieve();
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.toString());
        }

    }
}
