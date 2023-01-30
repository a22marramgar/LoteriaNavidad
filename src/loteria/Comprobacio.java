package loteria;

import java.util.ArrayList;

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

    public Comprobacio(String numero, ArrayList<Premio> Premiados, double importe) {
        this._numero = numero;
        this._lista = Premiados;
        this._importe = importe;
        this._total = Comprobar();

    }

    private double Comprobar() {
        int suma = ComprobarPremio();
        suma += ComprobarAproximaciones();
        suma += ComprobarCentenas();
        suma += ComprobarUltimas();
        double total = CalcularTotal(suma);

        return total;
    }

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

    private int ComprobarAproximaciones() {
        int premio = 0;
        premio += Aprox1rPremi();
        premio += Aprox2nPremi();
        premio += Aprox3rPremi();
        return premio;

    }

    private int Aprox1rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(this._numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_PRIMER_PREMI;
                    this._aproximacion = true;
                }

            }
        }
        return premio;

    }

    private int Aprox2nPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.SEGUNDOPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(this._numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_SEGON_PREMI;
                    this._aproximacion = true;
                }
            }
        }
        return premio;

    }

    private int Aprox3rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.TERCERPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(this._numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_TERCER_PREMI;
                    this._aproximacion = true;
                }
            }
        }
        return premio;

    }

    private int ComprobarCentenas() {
        int premio = 0;
        premio += Centenas1rPremi();
        premio += Centenas2nPremi();
        premio += Centenas3rPremi();
        premio += Centenas4rtPremi();
        return premio;

    }

    private int Centenas1rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !this._numero.equals(p.getNumero())) {
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

    private int Centenas2nPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.SEGUNDOPREMIO && !this._numero.equals(p.getNumero())) {
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

    private int Centenas3rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.TERCERPREMIO && !this._numero.equals(p.getNumero())) {
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

    private int Centenas4rtPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.CUARTOS && !this._numero.equals(p.getNumero())) {
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

    private int ComprobarUltimas() {
        int premio = 0;
        premio += Last2Cifras1rPremi();
        premio += Last2Cifras2nPremi();
        premio += Last2Cifras3rPremi();
        premio += UltimaCifra1rPremi();
        return premio;

    }

    private int Last2Cifras1rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !this._numero.equals(p.getNumero())) {
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

    private int Last2Cifras2nPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.SEGUNDOPREMIO && !this._numero.equals(p.getNumero())) {
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

    private int Last2Cifras3rPremi() {
        int premio = 0;
        for (Premio p : this._lista) {
            if (p.getPremio() == Simulacion.TERCERPREMIO && !this._numero.equals(p.getNumero())) {
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

    private double CalcularTotal(int suma) {
        double total = suma * (_importe / 200);
        return total;

    }

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
