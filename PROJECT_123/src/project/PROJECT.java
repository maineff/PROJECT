/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Controller.Dbutils;
import View.HomePage;

/**
 *
 * @author maine
 */


/**************************NORMALEMENT INUTILE SUREMENT A SUPP********************/
public class PROJECT {

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        //LIGNE DE CODE POUR CREER ET INITIALISER LES TABLES DE NOTRE BASE DE DONNEES (POUR LE CORRECTEUR)
//        Dbutils I = new Dbutils();
//        I.initDB();
        new HomePage().setVisible(true);
    }
    
}
