/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HomePage;

/**
 *
 * @author maine
 */
public class Main {
    
    public static void main(String[] args) {
        //LIGNE DE CODE POUR CREER ET INITIALISER LES TABLES DE NOTRE BASE DE DONNEES (POUR LE CORRECTEUR)
        //Dbutils I = new Dbutils();
        //I.initDB();
        new HomePage().setVisible(true);
    }
}
