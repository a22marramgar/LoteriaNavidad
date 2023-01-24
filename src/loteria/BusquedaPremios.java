package loteria;

import java.util.ArrayList;

public class BusquedaPremios {

	public static String Comprobar(int numero, ArrayList<Premio> Premiados, double importe) {
    	int suma = ComprobarPremio(numero, Premiados);
    	suma += ComprobarAproximaciones(int numero, ArrayList<Premio> Premiados);
    	suma += ComprobarCentenas(int numero, ArrayList<Premio> Premiados);
    	suma += ComprobarDosUltimas(int numero, ArrayList<Premio> Premiados);
    	CalcularTotal(int suma, double importe);
        return null;
    }

	private static int ComprobarPremio(int numero, ArrayList<Premio> Premiados) {

	}

	private static int ComprobarAproximaciones(int numero, ArrayList<Premio> Premiados) {

	}

	private static int ComprobarCentenas(int numero, ArrayList<Premio> Premiados) {

	}

	private static int ComprobarDosUltimas(int numero, ArrayList<Premio> Premiados) {

	}

	private static double CalcularTotal(int suma, double importe) {

	}
}
