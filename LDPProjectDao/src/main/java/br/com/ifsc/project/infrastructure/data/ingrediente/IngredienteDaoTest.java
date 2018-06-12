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
public class IngredienteDaoTest {

    public static void main(String[] args) throws SQLException {
        Ingrediente i1 = new Ingrediente("Queijo mussarela");
        Ingrediente i2 = new Ingrediente("Molho de tomate");
        Ingrediente i3 = new Ingrediente("Tomate em rodela");
        Ingrediente i4 = new Ingrediente("Orégano");
        Ingrediente i5 = new Ingrediente("Teste");
        IIngredienteDao dao = new IngredienteDao();

        //CREATE
        dao.create(i1);
        dao.create(i2);
        dao.create(i3);
        dao.create(i4);
        i5 = dao.create(i5);

        //RETRIVE
        List<Ingrediente> ingredientes = dao.retrieve();
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente.toString());
        }
        
        //RETRIVE BY ID
        i5 = dao.retrieveBy(i5.getId());
        System.out.println(i5.toString());

        //UPDATE
        i5.setNome("TesteAtualizado");
        dao.update(i5);

        //RETRIVE UPDATED
        ingredientes = dao.retrieve();
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente.toString());
        }

        //DELETE
        dao.delete(i5);

        //RETRIVE DELETED
        ingredientes = dao.retrieve();
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente.toString());
        }

    }
}
