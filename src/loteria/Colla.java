/**
 * 
 */
package loteria;

/**
 * @author ausias
 *
 */
public class Colla {
	private String _nomColla;
	private int _nombreMembres;
	private double _importTotal;
	private String _anyJugat;
	
	public Colla(String nomColla, String anyJugat) {
		this._nomColla = nomColla;
		this._anyJugat = anyJugat;
		this._nombreMembres = 0;
		this._importTotal = 0;
	}
	
	public boolean afegirMembre(String nomMembre, String numeroJugat, double importMembre) {
		boolean afegit = false;
		
		return afegit;
	}
}
