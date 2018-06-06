/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure.data;

import br.com.ifsc.project.domain.Pizza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class PizzaDao implements IPizzaDao {

    @Override
    public Pizza create(Pizza pizza) throws SQLException {
        String sql = "INSERT INTO pizza(nome) VALUES(?);";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        pstmt.setString(1, pizza.getNome());
        pstmt.execute();

        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            pizza.setId(rs.getInt(1));
        }

        ConnectionDB.commit();
        return pizza;
    }

    @Override
    public List<Pizza> retrieve() throws SQLException {
        String sql = "SELECT * FROM pizza";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Pizza> pizzas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            Pizza p = new Pizza(id, nome);
            pizzas.add(p);
        }
        rs.close();
        ConnectionDB.commit();

        return pizzas;
    }

    @Override
    public Pizza update(Pizza pizza) throws SQLException {
        String sql = "UPDATE pizza SET nome = ? WHERE id = ?;";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        pstmt.setString(1, pizza.getNome());
        pstmt.setInt(2, pizza.getId());
        pstmt.execute(sql);

        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            pizza.setId(rs.getInt(1));
        }

        ConnectionDB.commit();
        return pizza;
    }

    @Override
    public void delete(Pizza pizza) throws SQLException {
        String sql = "DELETE FROM pizza WHERE id = ?;";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        pstmt.setInt(1, pizza.getId());
        pstmt.execute(sql);
        ConnectionDB.commit();
    }

}
