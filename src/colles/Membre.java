/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colles;

import java.io.Serializable;

/**
 * Emmagatzemarem a la classe Membre el nom, el numero, i l'import
 * @author Mario
 */
public class Membre implements Serializable{

    private String _nom;
    private String _numero;
    private double _import;
    
    /**
     * Constructor de Membre
     * @param nomMembre String
     * @param numeroJugat String
     * @param importMembre double
     */
    public Membre(String nomMembre, String numeroJugat, double importMembre) {
        this._nom = nomMembre;
        this._numero = numeroJugat;
        this._import = importMembre;
    }

    /**
     * 
     * @return nom del Membre
     */
    public String getNom() {
        return this._nom;
    }

    /**
     * 
     * @return numero
     */
    public String getNumero() {
        return this._numero;
    }

    /**
     * 
     * @return import
     */
    public double getImport() {
        return this._import;
    }
    /**
     * Modificar importe
     * @param importe 
     */
    public void ModificarImport(double importe){
        this._import=importe;
    }
    
}
