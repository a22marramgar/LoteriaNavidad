package loteria;

import java.util.ArrayList;

public class BusquedaPremios {

    static final int APROX_PRIMER_PREMI = 20000;
    static final int APROX_SEGON_PREMI = 12500;
    static final int APROX_TERCER_PREMI = 9600;
    static final int PREMI_CENTENAS = 1000;
    static final int PREMI_2CIFRAS_ULTIMAS = 1000;
    static final int PREMI_ULTIMA_CIFRA = 200;

    public static String Comprobar(String numero, ArrayList<Premio> Premiados, double importe) {
        int suma = ComprobarPremio(numero, Premiados);
        suma += ComprobarAproximaciones(numero, Premiados);
        suma += ComprobarCentenas(numero, Premiados);
        suma += ComprobarUltimas(numero, Premiados);
        double total = CalcularTotal(suma, importe);

        return Double.toString(total);
    }

    public static int ComprobarPremio(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getNumero().equals(numero)) {
                premio = p.getPremio();
            }
        }
        return premio;
    }

    public static int ComprobarAproximaciones(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        premio += Aprox1rPremi(numero, Premiados);
        premio += Aprox2nPremi(numero, Premiados);
        premio += Aprox3rPremi(numero, Premiados);
        return 0;

    }

    public static int Aprox1rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_PRIMER_PREMI;
                }

            }
        }
        return premio;

    }

    public static int Aprox2nPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.SEGUNDOPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_SEGON_PREMI;
                }
            }
        }
        return premio;

    }

    public static int Aprox3rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.TERCERPREMIO) {
                int numeropremi = Integer.parseInt(p.getNumero());
                int numero_a_probar = Integer.parseInt(numero);
                if (numeropremi == numero_a_probar + 1 || numeropremi == numero_a_probar - 1) {
                    premio = APROX_TERCER_PREMI;
                }
            }
        }
        return premio;

    }

    public static int ComprobarCentenas(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        premio += Centenas1rPremi(numero, Premiados);
        premio += Centenas2nPremi(numero, Premiados);
        premio += Centenas3rPremi(numero, Premiados);
        premio += Centenas4rtPremi(numero, Premiados);
        return premio;

    }

    public static int Centenas1rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = numero.substring(0, 3);
                if (centenar_premi.equals(centenar_numero)) {
                    premio = PREMI_CENTENAS;
                }
            }
        }
        return premio;
    }

    public static int Centenas2nPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = numero.substring(0, 3);
                if (centenar_premi.equals(centenar_numero)) {
                    premio = PREMI_CENTENAS;
                }
            }
        }
        return premio;
    }

    public static int Centenas3rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = numero.substring(0, 3);
                if (centenar_premi.equals(centenar_numero)) {
                    premio = PREMI_CENTENAS;
                }
            }
        }
        return premio;
    }

    public static int Centenas4rtPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                String centenar_premi = p.getNumero().substring(0, 3);
                String centenar_numero = numero.substring(0, 3);
                if (centenar_premi.equals(centenar_numero)) {
                    premio = PREMI_CENTENAS;
                }
            }
        }
        return premio;
    }

    public static int ComprobarUltimas(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        premio += Last2Cifras1rPremi(numero, Premiados);
        premio += Last2Cifras2nPremi(numero, Premiados);
        premio += Last2Cifras3rPremi(numero, Premiados);
        premio += UltimaCifra1rPremi(numero, Premiados);
        return premio;

    }

    public static int Last2Cifras1rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                String ultimas_2_cifras_premi = p.getNumero().substring(3, 5);
                String ultimas_2_cifras_numero = numero.substring(3, 5);
                if (ultimas_2_cifras_premi.equals(ultimas_2_cifras_numero)) {
                    premio = PREMI_2CIFRAS_ULTIMAS;
                }
            }
        }
        return premio;
    }

    public static int Last2Cifras2nPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.SEGUNDOPREMIO && !numero.equals(p.getNumero())) {
                String ultimas_2_cifras_premi = p.getNumero().substring(3, 5);
                String ultimas_2_cifras_numero = numero.substring(3, 5);
                if (ultimas_2_cifras_premi.equals(ultimas_2_cifras_numero)) {
                    premio = PREMI_2CIFRAS_ULTIMAS;
                }
            }
        }
        return premio;
    }

    public static int Last2Cifras3rPremi(String numero, ArrayList<Premio> Premiados) {
        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.TERCERPREMIO && !numero.equals(p.getNumero())) {
                String ultimas_2_cifras_premi = p.getNumero().substring(3, 5);
                String ultimas_2_cifras_numero = numero.substring(3, 5);
                if (ultimas_2_cifras_premi.equals(ultimas_2_cifras_numero)) {
                    premio = PREMI_2CIFRAS_ULTIMAS;
                }
            }
        }
        return premio;
    }

    public static int UltimaCifra1rPremi(String numero, ArrayList<Premio> Premiados) {

        int premio = 0;
        for (Premio p : Premiados) {
            if (p.getPremio() == Simulacion.PRIMERPREMIO && !numero.equals(p.getNumero())) {
                char ultima_cifra_premi = p.getNumero().charAt(4);
                char ultima_cifra_numero = numero.charAt(4);
                if (ultima_cifra_premi == ultima_cifra_numero) {
                    premio = PREMI_ULTIMA_CIFRA;
                }
            }
        }
        return premio;
    }

    public static double CalcularTotal(int suma, double importe) {
        double total = suma * (importe / 200);
        return total;

    }
}
