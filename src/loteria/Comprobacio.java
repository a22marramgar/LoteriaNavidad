package loteria;

import java.util.ArrayList;
import java.util.List;
import static idiomas.Idiomas.*;
import static loteria.LoteriaNavidad.idioma;

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

    private final ArrayList<Premio> _lista;
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
    public Comprobacio(ArrayList<Premio> Premiados) {
        this._lista = Premiados;

    }

    /**
     * Demana la comprobacio del total de diners del numero amb l'import aportat
     *
     * @param numero
     * @param importe
     * @return double diners totals assignat a la comprobacio
     */
    public double Comprobar(String numero, double importe) {
        this._premio = false;
        this._aproximacion = false;
        this._centenas = false;
        this._ultimas = false;
        this._reintegro = false;
        int suma = ComprobarPremio(numero);
        suma += ComprobarAproximaciones(numero);
        suma += ComprobarCentenas(numero);
        suma += ComprobarUltimas(numero);
        double total = CalcularTotal(suma, importe);

        return total;
    }

    /**
     * Demana la comprobacio del premi assignat al numero
     * @param numero
     * @return int valor del premi assignat
     */
    private int ComprobarPremio(String numero) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getNumero().equals(numero)) {
                premio = p.getPremio();
                this._premio = true;
            }
        }
        return premio;
    }

    /**
     * Demana la comprobacio de les aproximacions
     * 
     * @param numero
     * @return int valor de les aproximacions del numero
     */
    private int ComprobarAproximaciones(String numero) {
        int premio = 0;
        premio += Aproximacion(Simulacion.PRIMERPREMIO, APROX_PRIMER_PREMI, numero);
        premio += Aproximacion(Simulacion.SEGUNDOPREMIO, APROX_SEGON_PREMI, numero);
        premio += Aproximacion(Simulacion.TERCERPREMIO, APROX_TERCER_PREMI, numero);
        return premio;

    }

    /**
     * Demana l'aproximacio d'un premi, si el numero no es igual al premi
     *
     * @param valorPremio
     * @param valorAproximacion
     * @param numero
     * @return int valor de la primera aproxmacio
     */
    private int Aproximacion(int valorPremio, int valorAproximacion, String numero) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(numero);
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
     * @param numero
     * @return int valor de les centenes
     */
    private int ComprobarCentenas(String numero) {
        int premio = 0;
        premio += Centenas(Simulacion.PRIMERPREMIO, numero);
        premio += Centenas(Simulacion.SEGUNDOPREMIO, numero);
        premio += Centenas(Simulacion.TERCERPREMIO, numero);
        premio += Centenas(Simulacion.CUARTOS, numero);
        return premio;

    }

    /**
     * Demana la centena d'un premi, si el numero no es igual al premi
     *
     * @param valorPremio
     * @param numero
     * @return int valor de la primera centena
     */
    private int Centenas(int valorPremio, String numero) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio && !numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = numero.substring(0, 3);
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
     * @param numero
     * @return int valor de les ultimes xifres
     */
    private int ComprobarUltimas(String numero) {
        int premio = 0;
        premio += Last2Cifras(Simulacion.PRIMERPREMIO, numero);
        premio += Last2Cifras(Simulacion.SEGUNDOPREMIO, numero);
        premio += Last2Cifras(Simulacion.TERCERPREMIO, numero);
        premio += UltimaCifra1rPremi(numero);
        return premio;

    }

    /**
     * Demana el premi de les 2 ultimes xifres d'un premi, si no es igual
     * al premi
     *
     * @param valorPremio
     * @param numero
     * @return int valor del premi de les 2 ultimes xifres del primer premi
     */
    private int Last2Cifras(int valorPremio, String numero) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == valorPremio && !numero.equals(p.getNumero())) {
                String ultimas_2_cifras_premi = p.getNumero().substring(3, 5);
                String ultimas_2_cifras_numero = numero.substring(3, 5);
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
     * @param numero
     * @return int valor del premi de l'ultima xifra del primer premi
     */
    private int UltimaCifra1rPremi(String numero) {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                char ultima_cifra_premi = p.getNumero().charAt(4);
                char ultima_cifra_numero = numero.charAt(4);
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
     * @param importe
     * @return double valor acumulat del premi segons l'import (200 euros
     * equival a un 100% del premi)
     */
    private double CalcularTotal(int suma, double importe) {
        double total = suma * (importe / 200);
        return total;

    }

    /**
     * Crea un missatge personalitzat anunciat el premi assignat a aquesta
     * comprobacio
     * @param numero
     * @param importe
     * @return String missatge
     */
    public String Resultat(String numero, double importe) {
        String missatge;
        double total = Comprobar(numero, importe);
        if (total != 0) {
            List<String> premios = new ArrayList<>();
            if (this._premio) {
                premios.add(idioma.frase("premio").toUpperCase());
            }
            if (this._aproximacion) {
                premios.add(idioma.frase("aprox"));
            }
            if (this._centenas) {
                premios.add(idioma.frase("centena"));
            }
            if (this._ultimas) {
                premios.add(idioma.frase("ultimas2"));
            }
            if (this._reintegro) {
                premios.add(idioma.frase("reintegro"));
            }
            String premiosString = String.join(", ", premios);
            missatge = idioma.frase("felicidades")+" " + total + "€!\n"+idioma.frase("reparticion")+": " + premiosString;
        } else {
            missatge = idioma.frase("losiento");
        }
        return missatge;
    }
}
