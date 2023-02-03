package loteria;

import static utils.UIUtilities.*;

/**
 * Portara el menu principal, on s'executaran les altres clases, funcions i procediments
 * @author ausias
 */

public class LoteriaNavidad {

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

    /**
     * Veure la llista de tots els numeros amb premi, menys les pedreas
     *
     * @param creado Variable que indica si hi ha una simulacio creada
     * @param sim Objecte Simulacion
     */
    private static void VeureLlista(boolean creado, Simulacion sim) {
        if (creado) {
            sim.Mostrar();
        } else {
            System.out.println("Si us plau, inicia una nova simulacio");
        }
    }

    /**
     * Buscar el premi corresponent a un numero
     *
     * @param creado Variable que indica si hi ha una simulacio creada
     * @param sim Objecte Simulacion
     */
    public static void Buscar(boolean creado, Simulacion sim) {
        if (creado) {
            System.out.println("Introdueix el numero a comprobar");
            int numero1 = escollirOpcio(0, 99999);
            String num = String.format("%05d", numero1);
            System.out.println("Introdueix el preu que has pagat");
            int precio = llegirInt();
            Comprobacio comprobar_numero = new Comprobacio(num, sim.GetPremios(), precio);
            System.out.println(comprobar_numero.Resultat());

        } else {
            System.out.println("Si us plau, inicia una nova simulacio");
        }
    }

    /**
     * Crea un objecte Simulacion, preguntant si es vol reescriure l'anterior,
     * si hi ha
     *
     * @param creado Variable que indica si hi ha una simulacio creada
     * @param sim Objecte Simulacion
     * @return boolean creado (hauria de retornar sempre true)
     */
    public static boolean Simulacion(boolean creado, Simulacion sim) {
        if (creado) {
            System.out.println("Ja existeix una simulacio, crear una nova?");
            System.out.println("1.Si");
            System.out.println("2.No");
            if (escollirOpcio(1, 2) == 1) {
                creado = sim.IniciarSimulacion();
            }
        } else {
            creado = sim.IniciarSimulacion();
        }
        return creado;
    }

    /**
     * Utilitza el menu
     *
     * @return int opcio
     */
    public static int Menu() {
        int opcio;
        System.out.println("Que vols fer? Escull una opcio");
        System.out.println("1.Inicia simulacio");
        System.out.println("2.Buscar el premi");
        System.out.println("3.Veure llista de premis");
        System.out.println("4.Sortir");
        opcio = escollirOpcio(1, 4);
        return opcio;
    }
}
