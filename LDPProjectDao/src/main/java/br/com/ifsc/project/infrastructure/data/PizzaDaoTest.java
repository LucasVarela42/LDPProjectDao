/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure.data;

import br.com.ifsc.project.domain.Pizza;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class PizzaDaoTest {

    public static void main(String[] args) throws SQLException {
        Pizza p1 = new Pizza("Quatro Queijos");
        Pizza p2 = new Pizza("Bolonhesa");
        IPizzaDao dao = new PizzaDao();
        dao.create(p1);
        dao.create(p2);

        List<Pizza> pizzas = dao.retrieve();
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.toString());
        }
    }
}
