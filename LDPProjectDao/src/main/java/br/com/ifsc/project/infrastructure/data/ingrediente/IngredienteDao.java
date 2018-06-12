/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure.data.ingrediente;

import br.com.ifsc.project.domain.ingrediente.Ingrediente;
import br.com.ifsc.project.infrastructure.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class IngredienteDao implements IIngredienteDao {

    @Override
    public Ingrediente create(Ingrediente ingrediente) throws SQLException {
        String sql = "INSERT INTO ingrediente(nome) VALUES(?);";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, ingrediente.getNome());
        pstmt.execute();

        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            ingrediente.setId(rs.getInt(1));
        }

        ConnectionDB.commit();
        return ingrediente;
    }

    @Override
    public List<Ingrediente> retrieve() throws SQLException {
        String sql = "SELECT * FROM ingrediente";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Ingrediente> ingredientes = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            Ingrediente p = new Ingrediente(id, nome);
            ingredientes.add(p);
        }
        rs.close();
        ConnectionDB.commit();

        return ingredientes;
    }

    @Override
    public Ingrediente retrieveBy(int id) throws SQLException {
        String sql = "SELECT * FROM ingrediente WHERE id = ?";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        pstmt.setInt(1, id);
        pstmt.execute();
        Ingrediente ingrediente = null;
        if (rs.next()) {
            ingrediente = new Ingrediente(
                    rs.getInt(1),
                    rs.getString(2));
        }
        ConnectionDB.commit();
        return ingrediente;
    }

    @Override
    public Ingrediente update(Ingrediente ingrediente) throws SQLException {
        String sql = "UPDATE ingrediente SET nome = ? WHERE id = ?;";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, ingrediente.getNome());
        pstmt.setInt(2, ingrediente.getId());
        pstmt.execute();

        ResultSet rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            ingrediente.setId(rs.getInt(1));
        }

        ConnectionDB.commit();
        return ingrediente;
    }

    @Override
    public void delete(Ingrediente ingrediente) throws SQLException {
        String sql = "DELETE FROM ingrediente WHERE id = ?;";
        PreparedStatement pstmt = ConnectionDB.getConnection().prepareStatement(sql);
        pstmt.setInt(1, ingrediente.getId());
        pstmt.execute();
        ConnectionDB.commit();
    }

}
