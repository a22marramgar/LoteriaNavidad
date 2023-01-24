package loteria;

import java.util.ArrayList;

public class BusquedaPremios {
    
        static final int APROX_PRIMER_PREMI=20000;
        static final int APROX_SEGON_PREMI=12500;
        static final int APROX_TERCER_PREMI=9600;
        
	public static String Comprobar(String numero, ArrayList<Premio> Premiados, double importe) {
		int suma = ComprobarPremio(numero, Premiados);
		suma += ComprobarAproximaciones(numero, Premiados);
		suma += ComprobarCentenas(numero, Premiados);
		suma += ComprobarUltimas(numero, Premiados);
		double total = CalcularTotal(suma, importe);
		return null;
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
            
		return 0;

	}
        public static int Aprox1rPremi(String numero,ArrayList<Premio> Premiados){
                int premio=0;
                for(Premio p : Premiados){
                       if(p.getPremio() == Simulacion.PRIMERPREMIO){
                           int numeropremi = Integer.parseInt(p.getNumero());
                           int numero_a_probar = Integer.parseInt(numero);
                           if(numeropremi == numero_a_probar+1||numeropremi == numero_a_probar-1){
                               premio=APROX_PRIMER_PREMI;
                           }
                           
                       }
                }
                return premio;
                
        }
        public static int Aprox2nPremi(String numero,ArrayList<Premio> Premiados){
                int premio=0;
                for(Premio p : Premiados){
                       if(p.getPremio() == Simulacion.SEGUNDOPREMIO){
                           int numeropremi = Integer.parseInt(p.getNumero());
                           int numero_a_probar = Integer.parseInt(numero);
                           if(numeropremi == numero_a_probar+1||numeropremi == numero_a_probar-1){
                               premio=APROX_SEGON_PREMI;
                           }
                       }
                }
                return premio;
                
        }
        public static int Aprox3rPremi(String numero,ArrayList<Premio> Premiados){
                int premio=0;
                for(Premio p : Premiados){
                       if(p.getPremio() == Simulacion.TERCERPREMIO){
                           int numeropremi = Integer.parseInt(p.getNumero());
                           int numero_a_probar = Integer.parseInt(numero);
                           if(numeropremi == numero_a_probar+1||numeropremi == numero_a_probar-1){
                               premio=APROX_TERCER_PREMI;
                           }
                       }
                }
                return premio;
                
        }

	public static int ComprobarCentenas(String numero, ArrayList<Premio> Premiados) {

		return 0;

	}

	public static int ComprobarUltimas(String numero, ArrayList<Premio> Premiados) {

		return 0;

	}

	public static double CalcularTotal(int suma, double importe) {

		return 0;

	}
}
