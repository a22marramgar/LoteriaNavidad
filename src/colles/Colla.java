/**
 *
 */
package colles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import loteria.Comprobacio;
import loteria.LoteriaNavidad;
import static loteria.LoteriaNavidad.idioma;
import static utils.UIUtilities.*;

/**
 * @author Mario
 *
 */
public class Colla implements Serializable{

    private String _nomColla;
    private int _anyJugat;
    private int _nombreMembres;
    private double _importTotal;
    public ArrayList<Membre> _lista;

    /**
     * Constructor de Colla
     * @param nomColla String
     * @param anyJugat int
     */
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
    /**
     * Elimina un membre de la lista de membres
     *
     * @param nommembre
     * @param numeroJugat
     * @return true si s'ha afegit, false si està repetit
     */
    public boolean borrarMembre(String nommembre, String numeroJugat) {
        boolean afegit = false;
        for (int i = 0; i < this._lista.size(); i++) {
            if(this._lista.get(i).getNom().equals(nommembre) && 
                this._lista.get(i).getNumero().equals(numeroJugat)){
                this._importTotal -= this._lista.get(i).getImport();
                this._lista.remove(this._lista.get(i));
                this._nombreMembres -= 1;                
            afegit = true;
            }
        }
        return afegit;
    }
    /**
     * Modifica un membre de la lista de membres
     *
     * @param nomMembre String
     * @param numeroJugat String
     * @param importMembre double
     * @return true si s'ha afegit, false si està repetit
     */
    public boolean ModImporteMembre(String nomMembre, String numeroJugat, double importMembre){
        boolean afegit = false;
        for (int i = 0; i < this._lista.size(); i++) {
            Membre miembro = this._lista.get(i);
            if(miembro.getNom().equals(nomMembre) && 
                miembro.getNumero().equals(numeroJugat)){
                this._importTotal -= miembro.getImport();
                miembro.ModificarImport(importMembre);
                this._lista.set(i, miembro);
                this._importTotal += importMembre;
                afegit = true;
            }
        }
        return afegit;
    }
      
    /**
     * Comprova que no hagi un membre a la llista amb el mateix nom i numero de
     * loteria
     * @param nouMembre Membre a comprovar
     * @return true si esta repetit, false si no
     */
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
    
    /**
     * Mostra la informacio de la Colla
     */
    public void mostrar(){
        System.out.println(idioma.frase("collanom")+this._nomColla);
        System.out.println(idioma.frase("collaany")+this._anyJugat);
        System.out.println(idioma.frase("colladiners")+this._importTotal);
        System.out.println(idioma.frase("collapremi")+calcularPremioTotal());
        System.out.println();
        System.out.println(idioma.frase("collamembres")+this._nombreMembres);
        mostrarTablaMembres();
    }

    /**
     * Fa el calcul de la suma del total dels premis guanyats a la colla
     * @return 
     */
    private double calcularPremioTotal() {
        double premioTotal = 0;
        Comprobacio com = new Comprobacio (LoteriaNavidad.sim.GetPremios());
        for(Membre m : this._lista){
            premioTotal += com.Comprobar(m.getNumero(), 200);
        }
        return premioTotal;
    }

    /**
     * Mostra la taula de Membres de la Colla
     */
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

    /**
     * 
     * @return nom de la colla 
     */
    public String getNom() {
        return this._nomColla;
    }

    /**
     * 
     * @return any jugat de la colla
     */
    public int getAnyo() {
        return this._anyJugat;
    }
}
