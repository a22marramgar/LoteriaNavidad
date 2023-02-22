/**
 *
 */
package loteria;

import java.util.ArrayList;

/**
 * @author ausias
 *
 */
public class Colla {

    private String _nomColla;
    private int _nombreMembres;
    private double _importTotal;
    private String _anyJugat;
    private ArrayList<Membre> _lista;

    public Colla(String nomColla, String anyJugat) {
        this._nomColla = nomColla;
        this._anyJugat = anyJugat;
        this._nombreMembres = 0;
        this._importTotal = 0;
    }

    /**
     * Afegeix un membre a la lista de membres si no existeix el membre amb el
     * numero jugat a la llista de membres
     *
     * @param nomMembre String
     * @param numeroJugat String
     * @param importMembre double
     * @return true si s'ha afegit, false si està repetit
     */
    public boolean afegirMembre(String nomMembre, String numeroJugat, double importMembre) {
        boolean afegit = false;
        Membre nouMembre = new Membre(nomMembre, numeroJugat, importMembre);
        if (!ComprobarRepetido(nouMembre)) {
            this._lista.add(nouMembre);
            afegit = true;
        }

        return afegit;
    }
    
    private boolean ComprobarRepetido(Membre nouMembre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
