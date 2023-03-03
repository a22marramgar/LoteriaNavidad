/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colles;

import java.util.Comparator;

/**
 *
 * @author ausias
 */
public class MembreComparator implements Comparator<Membre> {

    
    /**
     * Compara miembros para ordenarlos
     * @param m1 Miembro
     * @param m2 Miembro
     * @return 
     */
    @Override
    public int compare(Membre m1, Membre m2) {
        return m1.getNom().compareTo(m2.getNom());
    }
}
