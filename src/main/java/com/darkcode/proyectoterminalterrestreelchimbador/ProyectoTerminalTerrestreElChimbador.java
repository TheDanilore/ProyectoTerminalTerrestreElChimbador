/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.darkcode.proyectoterminalterrestreelchimbador;

import DAO.DAOException;
import Vista.LoginUser;
import java.sql.SQLException;

/**
 *
 * @author Danilore
 */
public class ProyectoTerminalTerrestreElChimbador {

    public static void main(String[] args) throws DAOException, SQLException {
        LoginUser login = new LoginUser();
        
        login.setVisible(true);
    }
}
