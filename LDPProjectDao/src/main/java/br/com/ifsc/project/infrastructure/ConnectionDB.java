/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsc.project.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ConnectionDB {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            return connection = connect();
        }
    }

    private static Connection connect() {
        String url, user, pass;

        try {
            //URL MySQL localhost
            url = "jdbc:mysql://localhost:3306/Pizzaria?useTimezone=true&serverTimezone=UTC";

            //URL POSTGRESQL localhost
            //url = "jdbc:postgresql://localhost:5432/Pizzaria?useTimezone=true&serverTimezone=UTC";
            
            //Mudar usuário
            user = "root"; //User postgre = postgres | user mysql = root
            pass = "root"; //Pass postgre = aluno | pass mysql = root/aluno
            
            connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
