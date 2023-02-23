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
    private int _anyJugat;
    private ArrayList<Membre> _lista;

    public Colla(String nomColla, int anyJugat) {
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
        if (!comprobarRepetido(nouMembre)) {
            this._lista.add(nouMembre);
            this._nombreMembres += 1;
            this._importTotal += importMembre;
            afegit = true;
        }

        return afegit;
    }
    
    private boolean comprobarRepetido(Membre nouMembre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void mostrar(){
        System.out.println("Colla: "+this._nomColla);
        System.out.println("Any: "+this._anyJugat);
        System.out.println("Diners: "+this._importTotal);
        System.out.println("Premi: "+calcularPremioTotal());
        System.out.println();
        System.out.println("MEMBRES");
        mostrarTablaMembres();
    }

    private double calcularPremioTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarTablaMembres() {
        System.out.println("+------------------+--------+--------+-----------+");
        System.out.println("|       NOM        | NUMERO | DINERS |   PREMI   |");
        System.out.println("+------------------+--------+--------+-----------+");
        Comprobacio com = new Comprobacio(ArchivosBinarios.CargarLista(this._anyJugat));
        for (Membre membre : this._lista) {
            System.out.print("| "+String.format("%-17s", membre.getNom())
            +"|  "+membre.getNumero()+" | "+String.format("%6s", membre.getImport())
            +" | "+String.format("%9s",com.Comprobar(membre.getNumero(), 200))+" |");
        }
        System.out.println("+------------------+--------+--------+-----------+");
    }
}
