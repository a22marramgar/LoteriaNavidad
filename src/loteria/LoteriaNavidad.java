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
            opcio = Menu(idioma.idiomaSel[24],
        idioma.idiomaSel[25],
        idioma.idiomaSel[26],
        idioma.idiomaSel[27]);

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
        System.out.println(idioma.idiomaSel[13]);

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
            System.out.println(idioma.idiomaSel[14]);
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
            System.out.println(idioma.idiomaSel[15]);
            int numero1 = escollirOpcio(0, 99999,idioma.idiomaSel[15]);
            String num = String.format("%05d", numero1);
            System.out.println(idioma.idiomaSel[16]);
            int precio = llegirInt();
            System.out.println(comprobar_numero.Resultat(num, precio));

        } else {
            System.out.println(idioma.idiomaSel[17]);
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
            System.out.println(idioma.idiomaSel[18]);
            System.out.println("1. "+ idioma.idiomaSel[19]);
            System.out.println("2. "+ idioma.idiomaSel[20]);
            if (escollirOpcio(1, 2,idioma.idiomaSel[18]) == 1) {
                System.out.println(idioma.idiomaSel[21]);
                creado = sim.IniciarSimulacion();
                System.out.println(idioma.idiomaSel[22]);
                
            }
        } else {
            System.out.println(idioma.idiomaSel[21]);
            creado = sim.IniciarSimulacion();
            System.out.println(idioma.idiomaSel[22]);
        }
        return creado;
    }


}
