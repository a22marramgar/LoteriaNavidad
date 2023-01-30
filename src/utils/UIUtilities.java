package utils;

import java.util.Scanner;

/**
 * Clase que sirve para pedir correctamente valores int, float, double, String
 * 
 * @author Mario
 *
 */
public class UIUtilities {
	private static Scanner input = new Scanner(System.in);

	/**
	 * Utilitza l'escaner per assegurar que hem introduit un valor enter
	 * 
	 * @return valor int
	 */
	public static int llegirInt() {
		int resultat = 1;
		boolean valid = false;
		do {
			valid = input.hasNextInt();
			if (valid) {
				resultat = input.nextInt();
				input.nextLine();
			} else if (input.hasNext()) {
				input.nextLine();
				System.out.println("Valor incorrecte");
			}
		} while (!valid);
		return resultat;
	}

	/**
	 * Pide un valor de tipo Float
	 * 
	 * @param f Texto que se muestra por pantalla para pedir un float
	 * @return Devuelve un valor float
	 */
	public static float llegirFloat(String f) {
		float numero = 0;
		boolean valido = false;
		while (!valido) {
			System.out.print(f);
			try {
				numero = input.nextFloat();
				input.nextLine();
				valido = true;
			} catch (Exception e) {
				input = new Scanner(System.in);
				System.err.println("Error: " + e);
				System.out.println("Vuelve a intentarlo");
			}
		}

		return numero;
	}

	/**
	 * Pide un valor de tipo Double
	 * 
	 * @param f Texto que se muestra por pantalla para pedir un double
	 * @return Devuelve un valor double
	 */
	public static double llegirDouble(String f) {
		double numero = 0;
		boolean valido = false;
		while (!valido) {
			System.out.print(f);
			try {
				numero = input.nextDouble();
				input.nextLine();
				valido = true;
			} catch (Exception e) {
				input = new Scanner(System.in);
				System.err.println("Error: " + e);
				System.out.println("Vuelve a intentarlo");
			}
		}

		return numero;
	}

	public static String llegirString(String f) {
		String texto = null;
		boolean valido = false;
		while (!valido) {
			System.out.print(f);
			try {
				texto = input.nextLine();
				valido = true;
			} catch (Exception e) {
				input = new Scanner(System.in);
				System.err.println("Error: " + e);
				System.out.println("Vuelve a intentarlo");
			}
		}

		return texto;
	}

	/**
	 * Agafa un int entre un rang de valors
	 * 
	 * @param max int més gran
	 * @param min int més petit
	 * @return int que es trobi en el rang especificat
	 */
	public static int escollirOpcio(int min, int max) {
		int opcio = 0;
		boolean valid = false;
		do {
			opcio = llegirInt();
			if (opcio <= max && opcio >= min) {
				valid = true;
			} else {
				System.out.println("Opcio incorrecta");
			}
		} while (!valid);
		return opcio;
	}

	public static void clearScreen() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.flush();
	}
}