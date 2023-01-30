package loteria;

import java.util.Scanner;
import static utils.UIUtilities.*;

public class LoteriaNavidad {

    static Scanner scan = new Scanner(System.in);
    static final String ANSI_GREEN=("\u001B[32m");
    static final String ANSI_RESET=("\u001B[0m");
    static final String ANSI_RED=("\u001B[31m");
    
    public static void main(String[] args) {
        Simulacion sim = new Simulacion();
        int opcio = 0;
        boolean creado = false;

        while (opcio != 4) {
            opcio = Menu();

            switch (opcio) {
                case 1:
                    creado = Simulacion(creado, sim);
                    break;
                case 2:
                    Buscar(creado, sim);
                    break;      
                case 3:
                    VeureLlista(creado, sim);
            }
        }
        System.out.println("Adeu, fins un altre moment");

    }

    private static void VeureLlista(boolean creado, Simulacion sim) {
        if (creado) {
            sim.Mostrar();
        } else {
            System.out.println("Si us plau, inicia una nova simulacio");
        }
    }

    private static void Buscar(boolean creado, Simulacion sim) {
        if (creado) {
            System.out.println("Introdueix el numero a comprobar");
            int numero1 = escollirOpcio(0,99999);
            String num = String.format("%05d", numero1);
            System.out.println("Introdueix el preu que has pagat");
            int precio = llegirInt();
            Comprobacio comprobar_numero = new Comprobacio(num, sim.GetPremios(), precio);
            System.out.println(comprobar_numero.Resultat());
            
        } else {
            System.out.println("Si us plau, inicia una nova simulacio");
        }
    }

    private static boolean Simulacion(boolean creado, Simulacion sim) {
        if (creado) {
            System.out.println("Ja existeix una simulacio, crear una nova?");
            System.out.println("1.Si");
            System.out.println("2.No");
            if(escollirOpcio(1,2)==1){
                creado = sim.IniciarSimulacion();
            }
        } else {
            creado = sim.IniciarSimulacion();
        }
        return creado;
    }

    private static int Menu() {
        int opcio;
        System.out.println("Que vols fer? Escull una opcio");
        System.out.println("1.Inicia simulacio");
        System.out.println("2.Buscar el premi");
        System.out.println("3.Veure llista de premis");
        System.out.println("4.Sortir");
        opcio = escollirOpcio(1,4);
        return opcio;
    }
}
