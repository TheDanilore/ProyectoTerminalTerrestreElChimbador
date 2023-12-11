/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.danilore.proyectoterminalterrestreelchimbador;

import DAO.DAOException;
import Vista.login;
import java.sql.SQLException;

/**
 *
 * @author Danilore
 */
public class ProyectoTerminalTerrestreElChimbador {

    public static void main(String[] args) throws DAOException, SQLException {
        login login = new login();
        
        login.setVisible(true);
    }
}
