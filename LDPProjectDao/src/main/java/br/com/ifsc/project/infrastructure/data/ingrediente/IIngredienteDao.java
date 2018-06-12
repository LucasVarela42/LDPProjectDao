/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure.data.ingrediente;

import br.com.ifsc.project.domain.ingrediente.Ingrediente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lucas
 */
public interface IIngredienteDao {

    public Ingrediente create(Ingrediente ingrediente) throws SQLException;

    public List<Ingrediente> retrieve() throws SQLException;

    public Ingrediente retrieveBy(int id) throws SQLException;

    public Ingrediente update(Ingrediente ingrediente) throws SQLException;

    public void delete(Ingrediente ingrediente) throws SQLException;
}
