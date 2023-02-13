package loteria;

import java.util.ArrayList;

/**
 * Comproba el premis de cada numero
 * @author ausias
 */
public class Comprobacio {

    static final int APROX_PRIMER_PREMI = 20000;
    static final int APROX_SEGON_PREMI = 12500;
    static final int APROX_TERCER_PREMI = 9600;
    static final int PREMI_CENTENAS = 1000;
    static final int PREMI_2CIFRAS_ULTIMAS = 1000;
    static final int PREMI_ULTIMA_CIFRA = 200;

    private String _numero;
    private ArrayList<Premio> _lista;
    private double _importe;
    private double _total;
    private boolean _premio;
    private boolean _aproximacion;
    private boolean _centenas;
    private boolean _ultimas;
    private boolean _reintegro;

    /**
     * Constructor de Comprobacio
     *
     * @param numero numero a comprobar
     * @param Premiados llista de Premio
     * @param importe Diners gastats en el numero
     */
    public Comprobacio(String numero, ArrayList<Premio> Premiados, double importe) {
        this._numero = numero;
        this._lista = Premiados;
        this._importe = importe;
        this._total = Comprobar();

    }

    /**
     * Demana la comprobacio del total de diners del numero amb l'import aportat
     *
     * @return double diners totals assignat a la comprobacio
     */
    private double Comprobar() {
        int suma = ComprobarPremio();
        suma += ComprobarAproximaciones();
        suma += ComprobarCentenas();
        suma += ComprobarUltimas();
        double total = CalcularTotal(suma);

        return total;
    }

    /**
     * Demana la comprobacio del premi assignat al numero
     *
     * @return int valor del premi assignat
     */
    private int ComprobarPremio() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getNumero().equals(_numero)) {
                premio = p.getPremio();
                this._premio = true;
            }
        }
        return premio;
    }

    /**
     * Demana la comprobacio de les aproximacions
     *
     * @return int valor de les aproximacions del numero
     */
    private int ComprobarAproximaciones() {
        int premio = 0;
        premio += Aproximacion(Simulacion.PRIMERPREMIO, APROX_PRIMER_PREMI);
        premio += Aproximacion(Simulacion.SEGUNDOPREMIO, APROX_SEGON_PREMI);
        premio += Aproximacion(Simulacion.TERCERPREMIO, APROX_TERCER_PREMI);
        return premio;

    }

    /**
     * Demana l'aproximacio d'un premi, si el numero no es igual al premi
     *
     * @return int valor de la primera aproxmacio
     */
    private int Aproximacion(int valorPremio, int valorAproximacion) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(this._numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = valorAproximacion;
                    this._aproximacion = true;
                }
            }
        }
        return premio;

    }

    /**
     * Demana la comprobacio de les centenes
     *
     * @return int valor de les centenes
     */
    private int ComprobarCentenas() {
        int premio = 0;
        premio += Centenas(Simulacion.PRIMERPREMIO);
        premio += Centenas(Simulacion.SEGUNDOPREMIO);
        premio += Centenas(Simulacion.TERCERPREMIO);
        premio += Centenas(Simulacion.CUARTOS);
        return premio;

    }

    /**
     * Demana la centena d'un premi, si el numero no es igual al premi
     *
     * @return int valor de la primera centena
     */
    private int Centenas(int valorPremio) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio && !this._numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = this._numero.substring(0, 3);
                if (centenar_premi.equals(centenar_numero)) {
                    premio = PREMI_CENTENAS;
                    this._centenas = true;
                }
            }
        }
        return premio;
    }

    /**
     * Demana la comprobacio de les ultimes xifres
     *
     * @return int valor de les ultimes xifres
     */
    private int ComprobarUltimas() {
        int premio = 0;
        premio += Last2Cifras(Simulacion.PRIMERPREMIO);
        premio += Last2Cifras(Simulacion.SEGUNDOPREMIO);
        premio += Last2Cifras(Simulacion.TERCERPREMIO);
        premio += UltimaCifra1rPremi();
        return premio;

    }

    /**
     * Demana el premi de les 2 ultimes xifres d'un premi, si no es igual
     * al premi
     *
     * @return int valor del premi de les 2 ultimes xifres del primer premi
     */
    private int Last2Cifras(int valorPremio) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio && !this._numero.equals(p.getNumero())) {
                String ultimas_2_cifras_premi = p.getNumero().substring(3, 5);
                String ultimas_2_cifras_numero = this._numero.substring(3, 5);
                if (ultimas_2_cifras_premi.equals(ultimas_2_cifras_numero)) {
                    premio = PREMI_2CIFRAS_ULTIMAS;
                    this._ultimas = true;
                }
            }
        }
        return premio;
    }

    /**
     * Demana el premi de l'ultima xifra del primer premi, si no es igual al
     * premi
     *
     * @return int valor del premi de l'ultima xifra del primer premi
     */
    private int UltimaCifra1rPremi() {

        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !this._numero.equals(p.getNumero())) {
                char ultima_cifra_premi = p.getNumero().charAt(4);
                char ultima_cifra_numero = this._numero.charAt(4);
                if (ultima_cifra_premi == ultima_cifra_numero) {
                    premio = PREMI_ULTIMA_CIFRA;
                    this._reintegro = true;
                }
            }
        }
        return premio;
    }

    /**
     * Calcula el valor final del premi segons l'import aportat
     *
     * @param suma valor acumulat del premi
     * @return double valor acumulat del premi segons l'import (200 euros
     * equival a un 100% del premi)
     */
    private double CalcularTotal(int suma) {
        double total = suma * (_importe / 200);
        return total;

    }
    
    /**
     * Demana l'importe aportat a la comprobacio del premi
     * @return double importe
     */
    public double getImporte(){
        return this._importe;
    }
    
    /**
     * Demana el preu total de la comprobacio
     * @return double total
     */
    public double getTotal(){
        return this._total;
    }
    
    /**
     * Demana el numero que realitza la comprobacio
     * @return String numero
     */
    public String getNumero(){
        return this._numero;
    }

    /**
     * Crea un missatge personalitzat anunciat el premi assignat a aquesta
     * comprobacio
     *
     * @return String missatge
     */
    public String Resultat() {
        String missatge;
        if (this._total != 0) {
            missatge = "Felicitats, has guanyat " + this._total + "€!\nAquest premi es reparteix entre: ";
            if (this._premio) {
                missatge += "PREMI";
            }
            if (this._aproximacion) {
                if (this._premio) {
                    missatge += ", ";
                }
                missatge += "APROXIMACIO";
            }
            if (this._centenas) {
                if (this._premio || this._aproximacion) {
                    missatge += ", ";
                }
                missatge += "CENTENA";
            }
            if (this._ultimas) {
                if (this._premio || this._aproximacion || this._centenas) {
                    missatge += ", ";
                }
                missatge += "ULTIMES 2 XIFRES";
            }
            if (this._reintegro) {
                if (this._premio || this._aproximacion || this._centenas || this._ultimas) {
                    missatge += ", ";
                }
                missatge += "REINTEGRAMENT";
            }
        } else {
            missatge = "Ho sentim, aquest numero no te cap premi.";
        }
        return missatge;
    }
}
