package loteria;

import java.util.ArrayList;

public class BusquedaPremios {

	public static String Comprobar(int numero, ArrayList<Premio> Premiados, double importe) {
		int suma = ComprobarPremio(numero, Premiados);
		suma += ComprobarAproximaciones(numero, Premiados);
		suma += ComprobarCentenas(numero, Premiados);
		suma += ComprobarUltimas(numero, Premiados);
		double total = CalcularTotal(suma, importe);
		return null;
	}

	public static int ComprobarPremio(int numero, ArrayList<Premio> Premiados) {
		int premio = 0;
		for (Premio p : Premiados) {
			if (p.getNumero() == numero) {
				premio = p.getPremio();
			}
		}
		return premio;
	}

	public static int ComprobarAproximaciones(int numero, ArrayList<Premio> Premiados) {

		return 0;

	}

	public static int ComprobarCentenas(int numero, ArrayList<Premio> Premiados) {

		return 0;

	}

	public static int ComprobarUltimas(Integer numero, ArrayList<Premio> Premiados) {

		return 0;

	}

	public static double CalcularTotal(int suma, double importe) {

		return 0;

	}
}
