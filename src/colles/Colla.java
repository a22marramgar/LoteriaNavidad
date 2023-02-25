/**
 *
 */
package colles;

import java.io.Serializable;
import java.util.ArrayList;
import loteria.Comprobacio;
import loteria.LoteriaNavidad;
import static loteria.LoteriaNavidad.idioma;
import static utils.UIUtilities.*;

/**
 * @author ausias
 *
 */
public class Colla implements Serializable{

    private String _nomColla;
    private int _anyJugat;
    private int _nombreMembres;
    private double _importTotal;
    private ArrayList<Membre> _lista;

    public Colla(String nomColla, int anyJugat) {
        this._nomColla = nomColla;
        this._anyJugat = anyJugat;
        this._nombreMembres = 0;
        this._importTotal = 0;
        this._lista = new ArrayList<>();
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
        if (!comprobarRepetido(nouMembre)) {
            this._lista.add(nouMembre);
            this._nombreMembres += 1;
            this._importTotal += importMembre;
            afegit = true;
        }

        return afegit;
    }
    
    private boolean comprobarRepetido(Membre nouMembre) {
        boolean repetido = false;
        for(Membre m : this._lista){
            if (m.getNom().equals(nouMembre.getNom()) 
                    && m.getNumero().equals(nouMembre.getNumero())){
                repetido = true;
            }
        }
        return repetido;
    }
    
    public void mostrar(){
        System.out.println("Colla: "+this._nomColla);
        System.out.println("Any: "+this._anyJugat);
        System.out.println("Diners: "+this._importTotal);
        System.out.println("Premi: "+calcularPremioTotal());
        System.out.println();
        System.out.println("Membres: "+this._nombreMembres);
        mostrarTablaMembres();
    }

    private double calcularPremioTotal() {
        double premioTotal = 0;
        Comprobacio com = new Comprobacio (LoteriaNavidad.sim.GetPremios());
        for(Membre m : this._lista){
            premioTotal += com.Comprobar(m.getNumero(), 200);
        }
        return premioTotal;
    }

    private void mostrarTablaMembres() {
        System.out.println("+------------------+--------+--------+------------+------------+");
        System.out.println("|"+CentrarTexto(idioma.frase("nomtabla"),18)+"|"
                +CentrarTexto(idioma.frase("numerotabla"),8)+"|"
                +CentrarTexto(idioma.frase("dinerotabla"),8)+"|"
                +CentrarTexto(idioma.frase("premiotabla"),12)+"|"
                +CentrarTexto(idioma.frase("calculotabla"),12)+"|");
        System.out.println("+------------------+--------+--------+------------+------------+");
        Comprobacio com = new Comprobacio(LoteriaNavidad.sim.GetPremios());
        for (Membre m : this._lista) {
            double premio = com.Comprobar(m.getNumero(), 200);
            double premioCalculo = com.Comprobar(m.getNumero(), m.getImport());
            System.out.println("| "+String.format("%-17s", m.getNom())
            +"|  "+m.getNumero()+" | "+String.format("%6s", m.getImport())
            +" | "+String.format("%10s",premio)
            +" | "+String.format("%10s",premioCalculo)+" |");
        }
        System.out.println("+------------------+--------+--------+------------+------------+");
    }

    public String getNom() {
        return this._nomColla;
    }

    public int getAnyo() {
        return this._anyJugat;
    }
}
