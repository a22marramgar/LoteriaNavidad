package loteria;

import java.util.Scanner;
import static utils.UtilsBueno.*;
import static utils.Utils.*;

public class LoteriaNavidad {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Simulacion sim = new Simulacion();
        int opcio = 0;
        boolean creado = false;

        while (opcio != 4) {
            System.out.println("Que vols fer? Escull una opcio");
            System.out.println("1.Inicia simulacio");
            System.out.println("2.Buscar el premi");
            System.out.println("3.Veure llista de premis");
            System.out.println("4.Sortir");
            opcio = comprobarEnter();

            switch (opcio) {

                case 1:
                    creado = sim.IniciarSimulacion();
                    if (creado) {
                        System.out.println("Simulacio creada");
                    } else {
                        System.out.println("No s'ha pogut crear la simulacio");
                    }
                    break;

                case 2:

                    if (creado) {
                        System.out.println("Introdueix el numero a comprobar");
                        int numero1 = pedirnum();
                        String num = String.format("%05d", numero1);
                        System.out.println("Introdueix el preu que has pagat");
                        int precio = pedirnum();
                        System.out.println(BusquedaPremios.Comprobar(num, sim.GetPremios(), precio));
                    } else {
                        System.out.println("Si us plau, inicia una nova simulacio");
                    }

                    break;
                case 3:
                    if (creado) {
                        sim.Mostrar();
                    }
                    else{
                        System.out.println("Si us plau, inicia una nova simulacio");
                    }

            }
        }
        System.out.println("Adeu, fins un altre");

    }
}
