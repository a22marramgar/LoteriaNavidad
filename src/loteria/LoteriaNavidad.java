package loteria;

import java.util.Scanner;
import static utils.Utils.*;

public class LoteriaNavidad {
 static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opcio = 0;
        boolean creado = false;
        
        while (opcio != 3) {
            System.out.println("Que vols fer? Escull una opcio");
            System.out.println("1.Inicia simulacio");
            System.out.println("2.Buscar el premi");
            System.out.println("3.Sortir");
            opcio = comprobarEnter();

            switch (opcio)  {

                case 1:
                    creado = Simulacion.IniciarSimulacion();
                    if (creado = true) {
                        System.out.println("Simulacion creada");
                    } else {
                        System.out.println("No se ha podido crear la simulacion");
                    }
                    break;

                case 2:
                    
                    if (creado = true) {
                        System.out.println("Introdueix el numero a comprobar");
                        int numero=scan.nextInt();
                        System.out.println(busquedapremios.comprobar(numero,Simulacion.getPremios));
                    } else {
                        System.out.println("Porfavor, inicia una nueva simulacion");
                    }

                    break;

            }
        }
        System.out.println("Adeu, fins un altre");

    }
}