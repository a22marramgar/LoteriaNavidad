package loteria;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Simulacion {
    private ArrayList<Premio> _Lista;
    public final int PRIMERPREMIO = 4000000;
    public final int SEGUNDOPREMIO =1200000;
    public final int TERCERPREMIO=500000;
    public final int CUARTOS=200000;
    public final int QUINTOS=60000;
    public final int PEDREAS=1000;

    public boolean IniciarSimulacion() {
        Random ran = new Random();

                                
        System.out.println("Iniciando simulación...");
        ArrayList<Integer> pozo = new ArrayList<>();//Lista con los premios
        pozo.add(PRIMERPREMIO);//1 - un premio
        pozo.add(SEGUNDOPREMIO);//2 - un premio
        pozo.add(TERCERPREMIO);//3 - un premio
        pozo.add(CUARTOS);//4 - dos premios
        pozo.add(QUINTOS);//5 - ocho premios
        pozo.add(PEDREAS);//6 - 1794 premios

        ArrayList<String> numeros = new ArrayList<>();//Lista con los numeros
        for (int i = 0; i <= 99999; i++) {
            numeros.add(Integer.toString(i));
        }
        Collections.shuffle(numeros);//Se mezclan los numeros
        int contador4 = 2;//cantidad de premios - cuartos
        int contador5 = 8;//cantidad de premios - quintos
        int contador6 = 1794;//cantidad de premios - pedreas
        this._Lista = new ArrayList<>();
        int recorredor = 0;
        boolean corte4 = false;
        boolean corte5 = false;
        boolean corte6 = false;
        //boolean corte7 = false;
        while (pozo.size() >= 1) {
            int valor = ran.nextInt(pozo.size());
            Premio Prem = new Premio( numeros.get(recorredor),pozo.get(valor));
            this._Lista.add(Prem);
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
        System.out.println("Finalizado.");
        return true;
    }

    public ArrayList<Premio> GetPremios() {
        
        return this._Lista;
    }

}
