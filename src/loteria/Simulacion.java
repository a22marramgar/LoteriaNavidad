package loteria;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Simulacion {

    public boolean IniciarSimulacion() {
        return false;
    }

    public ArrayList<Premio> GetPremios() {
        Random ran = new Random();
        ArrayList<Integer> pozo = new ArrayList<>();//Lista con los premios
        pozo.add(4000000);//1 - un premio
        pozo.add(1200000);//2 - un premio
        pozo.add(500000);//3 - un premio
        pozo.add(200000);//4 - dos premios
        pozo.add(60000);//5 - ocho premios
        pozo.add(1000);//6 - 1794 premios
        pozo.add(0); //sin premios 
        ArrayList<Integer> numeros = new ArrayList<>();//Lista con los numeros
        for (int i = 1; i < 99999 + 1; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros);//Se mezclan los numeros
        int contador4 = 2;//cantidad de premios - cuartos
        int contador5 = 8;//cantidad de premios - quintos
        int contador6 = 1794;//cantidad de premios - pedreas
        ArrayList<Premio> Premiados = new ArrayList<>();
        int recorredor = 0;
        boolean corte4 = false;
        boolean corte5 = false;
        boolean corte6 = false;
        while (pozo.size() >= 1) {
            int valor = ran.nextInt(pozo.size());
            System.out.println(pozo.get(valor));

            Premio Prem = new Premio(pozo.get(valor), numeros.get(recorredor));
            Premiados.add(Prem);
            switch (pozo.get(valor)) {
                case 200000:
                    contador4--;
                    break;
                case 60000:
                    contador5--;
                    break;
                case 1000:
                    contador6--;
                    break;
                default:
                    break;
            }

            if (pozo.get(valor) == 4000000 || pozo.get(valor) == 1200000 || pozo.get(valor) == 500000) {
                pozo.remove(valor);
            } else if (contador4 == 0 && !corte4) {
                pozo.remove(valor);
                corte4 = true;
            } else if (contador5 == 0 && !corte5) {
                pozo.remove(valor);
                corte5 = true;
            } else if (contador6 == 0 && !corte6) {
                pozo.remove(valor);
                corte6 = true;
            }
            recorredor++;

        }
        return Premiados;
    }

}
