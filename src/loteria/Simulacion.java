package loteria;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class Simulacion {
	public boolean IniciarSimulacion() {
            return false;
	}
	public Premio[] GetPremios() {
            Random ran = new Random();
	    ArrayList<String> pozo = new ArrayList<String>();
            pozo.add("4.000.000");//1 - un premio
            pozo.add("1.200.000");//2 - un premio
            pozo.add("500.000");//3 - un premio
            pozo.add("200.000");//4 - dos premios
            pozo.add("60.000");//5 - ocho premios
            pozo.add("1.000");//6 - 1794 premios
            pozo.add("0"); //sin premios 
            int contador4 = 2;
            int contador5 = 8;
            int contador6 = 1794;
            int valor = ran.nextInt(8);
            switch (valor) {
                case 3:
                    contador4--;
                    break;
                case 4:
                    contador5--;
                    break;
                case 5:
                    contador6--;
                    break;
                default:
                    break;
            }
            ArrayList<Integer> numeros = new ArrayList<Integer>();
            for (int i=1; i<99999; i++) {
                numeros.add(i);
            }
            Collections.shuffle(numeros);
            if(valor<=2){
                pozo.remove(valor);
            }
            else if(contador4==0){
                pozo.remove(valor);
            }
            else if(contador5==0){
                pozo.remove(valor);
            }
            else if(contador6==0){
                pozo.remove(valor);
            }
            return ;
	}

}
