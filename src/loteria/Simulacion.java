package loteria;

import java.io.Serializable;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import static loteria.LoteriaNavidad.idioma;

/**
 * Creara una simulacio com si fos el sorteig, simulant els bombos on sortiran
 * el numero al atzar
 * @author ausias
 */

public class Simulacion implements Serializable{
    private int _anyo;
    private ArrayList<Premio> _Lista;
    public static final int PRIMERPREMIO = 4000000;
    public static final int SEGUNDOPREMIO = 1200000;
    public static final int TERCERPREMIO = 500000;
    public static final int CUARTOS = 200000;
    public static final int QUINTOS = 60000;
    public static final int PEDREAS = 1000;
    public static final int CANTPREMIOS = 1807;

    public Simulacion(int anyo){
        this._anyo = anyo;
        this._Lista = new ArrayList<>();
    }
    
    public Simulacion(){
        this._Lista = new ArrayList<>();
    }
    /**
     * Inicia una nova simulacio, assignant valors a la llista de Premio
     *
     * @return true
     */
    public boolean IniciarSimulacion() {
        Random ran = new Random();

        
        ArrayList<Integer> pozo = new ArrayList<>();//Lista con los premios
        pozo.add(PRIMERPREMIO);//1 - un premio
        pozo.add(SEGUNDOPREMIO);//2 - un premio
        pozo.add(TERCERPREMIO);//3 - un premio
        pozo.add(CUARTOS);//4 - dos premios
        pozo.add(QUINTOS);//5 - ocho premios
        pozo.add(PEDREAS);//6 - 1794 premios

        ArrayList<String> numeros = new ArrayList<>();//Lista con los numeros
        for (int i = 0; i <= 99999; i++) {
            numeros.add(String.format("%05d", i));
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
        while (pozo.size() >= 1) {
            int valor = ran.nextInt(pozo.size());
            Premio Prem = new Premio(numeros.get(recorredor), pozo.get(valor));
            this._Lista.add(Prem);
            switch (pozo.get(valor)) {
                case CUARTOS:
                    contador4--;
                    break;
                case QUINTOS:
                    contador5--;
                    break;
                case PEDREAS:
                    contador6--;
                    break;
                default:
                    break;
            }

            if (pozo.get(valor) == PRIMERPREMIO || pozo.get(valor) == SEGUNDOPREMIO || pozo.get(valor) == TERCERPREMIO) {
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
        
        return true;
    }

    /**
     * Demana la llista de premis
     *
     * @return ArrayList de Premio _Lista
     */
    public ArrayList<Premio> GetPremios() {

        return this._Lista;
    }

    /**
     * Mostra el primer, segon, tercer, quarts i cinquens premis amb els seus
     * numeros premiats
     */
    public void Mostrar() {

        int contador_cuartos = 2;
        int contador_quintos = 8;

        for (Premio p : this._Lista) {
            if (p.getPremio() == PRIMERPREMIO) {
                System.out.println(idioma.frase("primero")+" (" + p.getPremio() + "???): " + p.getNumero());
            }

        }
        for (Premio p : this._Lista) {
            if (p.getPremio() == SEGUNDOPREMIO) {
                System.out.println(idioma.frase("segundo")+" (" + p.getPremio() + "???): " + p.getNumero());
            }

        }
        for (Premio p : this._Lista) {
            if (p.getPremio() == TERCERPREMIO) {
                System.out.println(idioma.frase("tercero")+" (" + p.getPremio() + "???): " + p.getNumero());
            }

        }
        for (Premio p : this._Lista) {
            if (p.getPremio() == CUARTOS) {
                if (contador_cuartos == 2) {
                    System.out.print(idioma.frase("cuartos")+" (" + p.getPremio() + "???): " + p.getNumero());
                    contador_cuartos--;
                } else {
                    System.out.println(", " + p.getNumero());
                }
            }

        }
        for (Premio p : this._Lista) {
            if (p.getPremio() == QUINTOS) {
                if (contador_quintos == 8) {
                    System.out.print(idioma.frase("quintos")+" (" + p.getPremio() + "???): " + p.getNumero());
                    contador_quintos--;
                } else {
                    System.out.print(", " + p.getNumero());

                }

            }

        }
        System.out.println("");
    }
    
    /**
     * Procedimiento que a??ade una nueva lista a simulacion
     * @param LoteriaAnyo Arraylist de la loteria
     */
    public void NuevaLista(ArrayList<Premio> LoteriaAnyo){
        this._Lista=LoteriaAnyo;
    }
    /**
     * Guarda el a??o que se creo la simulacion
     * @param anyo A??o de la simulacion creada
     */
    public void setAnyo(int anyo){
        this._anyo=anyo;
    }
    /**
     * Sacar el a??o de la simulacion creada
     * @return el a??o
     */
    public int getAnyo(){
        return this._anyo;
    }
    /**
     * Comprobar si la simulacion esta iniciada
     * @return 
     */
    public boolean estaIniciada(){
        return !this._Lista.isEmpty();
    }
}
