package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de utilidades
 *
 * @author Mario
 *
 */
public class UIUtilities {

    private static Scanner input = new Scanner(System.in);

    /**
     * Utilitza l'escaner per assegurar que hem introduit un valor enter
     *
     * @return int
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
     * Demana un valor de tipus Float
     *
     * @param f Text que es mostra per pantalla per a demanar un float
     * @return float
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
     * Demana un valor de tipus double
     *
     * @param f Text que es mostra per pantalla per a demanar un double
     * @return double
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
    /**
     * Demana un valor de tipus int
     *
     * @param f Text que es mostra per pantalla per a demanar un int
     * @return int
     */
    public static int llegirInt(String f) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(f);
            try {
                numero = input.nextInt();
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
     * Demana un valor de tipus String
     *
     * @param f Text que es mostra per pantalla per a demanar un String
     * @return String
     */
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
     * @param mensaje Mensaje que se mostrara cuando el numero no cumpla las condiciones
     * @return int que es trobi en el rang especificat
     */
    public static int escollirOpcio(int min, int max, String mensaje) {
        int opcio = 0;
        boolean valid = false;
        do {
            opcio = llegirInt();
            if (opcio <= max && opcio >= min) {
                valid = true;
            } else {
                System.out.println(mensaje);
            }
        } while (!valid);
        return opcio;
    }

    /**
     * Buida la consola afegint salts de linia
     */
    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }
    public static File AbrirFichero(String nomFichero, boolean crear) {
        File result = null;

        result = new File(nomFichero);

        if (!result.exists()) {
            if (crear) {
                try {
                    result.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(UIUtilities.class.getName()).log(Level.SEVERE, null, ex);
                    result = null;
                }
            } else {
                result = null;
            }
        }

        return result;
    }
    public static BufferedReader AbrirFicheroLectura(String nomFichero, boolean crear) {
        BufferedReader br = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el reader para poder leer el fichero¡
            FileReader reader;
            try {
                reader = new FileReader(f);
                // Buffered reader para poder leer más comodamente
                br = new BufferedReader(reader);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UIUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return br;
    }
    public static void CerrarFichero(PrintWriter pw) {
        pw.flush();
        pw.close();
    }
        /**
     * Utilitza el menu
     *
     * @param opciones Las opciones que tendra el menu
     * @return int opcio
     */
    public static int Menu(String ...opciones) {
        int opcio;
        int num=1;
        System.out.println("---------------");
        for(String a:opciones){
            System.out.println(num+". "+a);
            num++;
        }
        opcio = escollirOpcio(1, num,"Invalid");
        return opcio;
    }
    public static int MenuAL(ArrayList<String> datos) {
        int opcio;
        int num=1;
        System.out.println("--------------");
        for (String a : datos) {
            System.out.println(num+". "+a);
            num++;
        }
        opcio = escollirOpcio(1, num,"Invalid");
        return opcio;
    }
    
}
