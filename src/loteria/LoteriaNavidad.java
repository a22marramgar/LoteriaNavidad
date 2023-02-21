package loteria;

import static utils.UIUtilities.*;
import static loteria.Idiomas.*;

/**
 * Portara el menu principal, on s'executaran les altres clases, funcions i procediments
 * @author ausias
 */

public class LoteriaNavidad {

    public static void main(String[] args) {
        SelectorIdioma();
        Simulacion sim = new Simulacion();
        int opcio = 0;
        boolean creado = false;

        while (opcio != 4) {
            opcio = Menu(FRASE(24),
        FRASE(25),
        FRASE(26),
        FRASE(27),"Guardar fichero");

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
        System.out.println(FRASE(13));

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
            System.out.println(FRASE(14));
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
            Comprobacio comprobar_numero = new Comprobacio(sim.GetPremios());
            System.out.println(FRASE(15));
            int numero1 = escollirOpcio(0, 99999,FRASE(15));
            String num = String.format("%05d", numero1);
            System.out.println(FRASE(16));
            int precio = llegirInt();
            System.out.println(comprobar_numero.Resultat(num, precio));

        } else {
            System.out.println(FRASE(17));
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
            System.out.println(FRASE(18));
            System.out.println("1. "+ FRASE(19));
            System.out.println("2. "+ FRASE(20));
            if (escollirOpcio(1, 2,FRASE(18)) == 1) {
                System.out.println(FRASE(21));
                creado = sim.IniciarSimulacion();
                System.out.println(FRASE(22));
                
            }
        } else {
            System.out.println(FRASE(21));
            creado = sim.IniciarSimulacion();
            System.out.println(FRASE(22));
        }
        return creado;
    }


}
