/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Llibreria d'utilitats
 *
 * @author author
 * @version version
 *
 */
public class Utils {
// <editor-fold defaultstate="collapsed" desc="Implementació de LlegirInt()">

    private static Scanner scan=null;
    
    /***
     * Funcio per convertir un numero enter en numeros romans
     * @param numero
     * @return 
     */ 
    public static String Roman(int numero) {
       
       /*Fem un bucle perque mostri un missatge d'error cuan el numero no estigui entre 1 i 3999*/
       while(numero <=0 || numero>=4000 ){          
           numero = demanaNumeroEnter("El numero a introduir a de estar entre el 1 i el 3999"); 
       }        
       /*Creem una variable per al numeroRoma*/
       String numeroRoma;
       
       /*Creem arrays String per poder agafar els numero romans segons la seva posicio*/
       String[] millares = {"","M","MM", "MMM"};
       String[] centenas = {"","C","CC","CCC", "CD", "D", "DC", "DCC", "DCCC","CM"};
       String[] decenas = {"","X","XX","XXX", "XL", "L", "LX", "LXX", "LXXX","XC"};
       String[] unidades = {"","I","II","III","IV","V","VI","VII","VIII","IX"}; 
          
       /*Anem agafant els numeros romans de les posicions del arrays */
       numeroRoma=millares[numero/1000]+centenas[(numero/100)%10]+decenas[(numero/10)%10]+unidades[numero%10]; 
        
      /*Retornem el valor del numero convertit a roma*/
        return numeroRoma;
    }
     /**
      * Funcio per demanar comprobar que un numero es enter sense missatge
      * @return 
      */
    public static int comprobarEnter() {
        int result;
        if (scan == null)
            scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Ha de ser un numero enter.Torna a intentar-ho");            
        }
        result = scan.nextInt();
        return result;
    }
    
    /**
     * Funcio per demanar comprobar que un numero es enter
     * @param missatge
     * @return 
     */
    public static int demanaNumeroEnter(String missatge) {
        int result;
        System.out.println(missatge);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("Ha de ser un numero enter.Torna a intentar-ho");
            System.out.println(missatge);
        }
        result = scan.nextInt();
        return result;
    }
    
    /**
     * Funcio per calcular descomptes d'un preu
     * @param preu
     * @param categoria
     * @return 
     */    
     public static float CalcularDescompte(float preu, String categoria) {
       /*Creem constants per als descomptes*/
        final float DESCOMPTEA= 0.05f;
        final float DESCOMPTEB= 0.1f;
        final float DESCOMPTEC1= 0.2f;
        final float DESCOMPTEC2= 0.35f;
        
       /*Creem una variable per al preu final*/ 
        float preufinal = 0;

       /*Utilitzem un switch per a cada cas*/ 
        switch (categoria) {
            case "A":
            case "a":
                preufinal = preu-(preu*DESCOMPTEA);
                break;

            case "B":
            case "b":    
                preufinal = preu-(preu*DESCOMPTEB);
                break;

            case "C":
            case "c":    
              if (preu >= 100){/*Si el preu es igual a 100 o superior un descompte*/
              preufinal = preu-(preu*DESCOMPTEC2);
              }
              else/*sino l'altre descompte*/
              preufinal = preu-(preu*DESCOMPTEC1);
                break;

        }
      /*Retornem el valor del preu final*/
        return preufinal;
    }
    
    /**
     * Funcio per validar categories(Si un string es A.B o C)
     * @param missatge
     * @return 
     */
    public static String CategoriaValida(String missatge) {
        System.out.println(missatge);
        String result = scan.next();
        
        
        while (!(result.equalsIgnoreCase("A")||result.equalsIgnoreCase("B")||result.equalsIgnoreCase("C"))) {
            System.out.println("La categoria es incorrecta, solament pot ser A, B o C");
            System.out.println(missatge);
            result = scan.next();
        }
        
        return result;
    }
    
    /**
     * Procediment per agafar les inicials de cada paraula d'una frase i
     * imprimrles per pantalla en majuscules
     * @param frase 
     */
    public static void Inicials(String frase) {

        /*Creem una variable per anar emmagatzemant les incials de cada paraula*/
        String inicial = "";
        
        /*Creem una array que emmagatzemi cada paraula dividint per els espais*/ 
        String[] divisio = frase.split(" ");              
        
        /*Creem un bucle per agafar cada paraula per separat, i agafar la seva inicial*/
        for (int i = 0; i < divisio.length; i++) {
         frase = divisio[i];   
         inicial += frase.charAt(0);

        }
        /*Demanem que imprimeixi el resultan de les inicials pero en majuscules*/
        System.out.println(inicial.toUpperCase());
    }
    
    /**
     * Procediment per crear un numero aleatori i imprimirlo per pantalla
     * 
     */
    public static void Dau() {
        // Creem una variable random perque vagi fent els numeros aleatoris
        Random aleatori = new Random();

        /*Variable per al numeros aleatoris(fins a quin numero aleatori) i posem el +1
        perque no surti el 0 y surti el 6*/
        int numero = aleatori.nextInt(6)+1;
       
        System.out.println(numero);        

    }
    
    /**
     * Funcio per suma el elements d'una array
     * @param vector
     * @return 
     */
    public static int suma_elements (int[ ] vector) {
     
       /*Creem una variable per anar sumant i emmagatzemant els valors*/        
       int suma_elements = 0;
       
       /*Fem un bucle per que vagi sumant els valors de l'array*/
       for(int i =0; i<vector.length;i++){
           suma_elements +=vector[i];
       }
   
       return suma_elements;
    }
    
    
    /**
     * Funcio per calcular la mitja d'una array de float
     * @param v
     * @return 
     */
    public static float mitja (float[] v) {     
     float suma = 0;
  /*Fem un bucle per que vagi sumant les posicions de l'array*/     
     for(int i =0; i<v.length;i++){
       suma += v[i];
     }
   /*Creem una variable per a fer la mitja i li diem que ens retorni aquest valor*/
     float mitja = suma/v.length;     
     return mitja;             
    }
    
    /**
     * Funcio per saber si tres costats poden formar un triangle (si no es un triangle
     * retornara -1) i si es triangle calcular l'area d'aquest.
     * @param a
     * @param b
     * @param c
     * @return 
     */
    public static double AreaTriangle(float a, float b, float c) {

        /*Creem variable per al semiperimetre*/
        float s = (a + b + c) / 2;
        /*Creem variable per al  calcul de l'area*/
        double calcul_area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double area;
       
        /*Si els costats son el d'un triangle que ens imprimeixi l'area*/
        if ((Math.abs(a - c) < b) && (b < (a + c))) {
            area =calcul_area;
        }
        else/*Si no, que ens digui que no son els costats d'un triangle*/
            area = -1;
        
        return area;
    }
    
    /**
     * Funcio per retornar una data amb format "dd/MM/yyyy"
     * @param data_avui 
     */
    
    public static void Avui(Date data_avui) {
    /* Li diem en quin format voldrem la data d'avui */
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    /* Ens retornara la data d'avui amb el format seleccionat */
    System.out.println(formato.format(data_avui));
  }

    
    /**
     * Funcio per mostrar un error amb lletres vermelles
     * @param missatge 
     */
    public static void mostrarError(String missatge) {
         //Creem un variable per al color de la lletra que volem posar
        String lletra_vermella = "\u001B[31m";
        System.out.println(lletra_vermella+"ERROR: "+(missatge));
    }
    
    /**
     * Funcio per saber els dies que te un mes, comptant amb l'any (si es bisext, etc)
     * @param mes
     * @param any
     * @return 
     */
    
    public static int dies_mes(int mes, int any) {

        int dies = 0;

        /*Fem un switch i depenent del mes que introduim sera un dia o altre*/
        switch (mes) {
            /*Casos de Gener, Març,  Maig,  Juliol,  Agost,  Octubre,  Desembre*/
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dies = 31;
                break;
            /*Casos d'Abril, Juny, Septembre,Novembre*/
            case 4:
            case 6:
            case 9:
            case 11:
                dies = 30;
                break;
            /*Cas de Febrer*/
            case 2:
                /*Si es any bisext tindra 29 dies*/
                if (any % 4 == 0 || (any % 100 != 0 && any % 400 == 0)) {
                    dies = 29;
                } else {/*Si no es any bisext tindra 28 dies*/
                    dies = 28;
                }
                break;
        }

        return dies;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni el dies del mes*/
    }
    
    /**
     * Funcio per saber si un numero es capicua, retornara un boolea
     * @param numero
     * @return 
     */
    public static boolean capicua(int numero) {
        boolean igual = false;
        boolean fi = false;
        /*Convertim int a String per fer una comparacio dels caracters amb charAt*/
        String conversio = String.valueOf(numero);

        /*Fem un bucle per comparar el 1er caracter amb el ultim*/
        for (int j = 0, i = conversio.length() - 1; i > 0 && !fi; j++, i--) {
            /*Si son iguals, convertira el boolea igual a true*/
            if (conversio.charAt(j) == (conversio.charAt(i))) {
                igual = true;
            } else {/*Cuan no siguin iguals, convertira el boolea igual a false*/
                igual = false;
                fi = true;
            }
        }

        return igual;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni el boolea de si es igual o no*/
    }
    
    /**
     * Funcio per imprimir Arrays
     * @param array 
     */
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {/*Aqui diem la condicio que no imprimeixi el 0 de l'array*/
                System.out.print(array[i] + " ");
            }
        }
    }
    
    /**
     * Funcio per calcular la suma de dos numeros
     * @param numero1
     * @param numero2
     * @return 
     */
    
    /*Creem una funcio amb el nom i entre parentesi creem una variable,per fer els calculs a dins*/
    public static float suma(float numero1, float numero2){
    
    float suma = numero1+numero2;       
        
    return suma;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni la suma dels dos numeros*/  
    }
    
    /**
     * Funcio per calcular la resta de dos numeros
     * @param numero1
     * @param numero2
     * @return 
     */
    public static float resta(float numero1, float numero2){
    
    float resta = numero1-numero2;       
        
    return resta;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni la resta dels dos numeros*/  
    }
    
    /**
     * Funcio per calcular la multiplicacio de dos numeros
     * @param numero1
     * @param numero2
     * @return 
     */
    
    public static float multiplicacio(float numero1, float numero2){
    
    float multiplicacio = numero1*numero2;       
        
    return multiplicacio;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni la multiplicacio dels dos numeros*/  
    }
    
    /**
     * Funcio per calcular la divisio de dos numeros
     * @param numero1
     * @param numero2
     * @return 
     */
    
    public static float divisio(float numero1, float numero2){
    
    float divisio = numero1/numero2;       
        
    return divisio;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni la divisio dels dos numeros*/  
    }
    
    /**
     * Funcio per saber si un numero es perfecte o no, retornara un boolea
     * @param numero
     * @return 
     */
    public static boolean perfecte(int numero) {
        boolean igual = false;
        int suma_divisors = 0;//creem variable per fer la suma dels divisors del numero

        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma_divisors += i;
            }
        }

        if (suma_divisors == numero) {
            igual = true;
        }

        return igual;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni la suma dels divisors*/
    }
     
    
    /**
     * Funcio per calcular el volum d'una esfera
     * @param radi
     * @return 
     */
    /*Creem una funcio amb el nom i entre parentesi creem una variable,per fer els calculs a dins*/
    public static double calculVolum(double radi){    
    double volum;
    volum = (4*Math.PI)*Math.pow(radi,3)/3;    
    return volum;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni el calcul del volum*/  
    }
    
    
    /**
     * Funcio per calcular el quadrat d'un numero enter
     * 
     * @param numero
     * @return 
     */
    /*Creem una funcio amb el nom i entre parentesi creem una variable,per fer els calculs a dins*/
    public static int quadrat(int numero){
    int quadrat;//creem variable per fer el calcul quadrat
    quadrat = numero * numero;//definim que fa el calcul
    return quadrat;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni el calcul del quadrat*/  
    }     
  
    
    /**
     * Funcio per saber si el primer valor int es major que el segon valor int
     * @param numero1
     * @param numero2
     * @return 
     */
    /*Creem una funcio amb el nom i entre parentesi creem una variable,per fer els calculs a dins*/
    public static boolean primerMajor(int numero1, int numero2){
    
    boolean esMajor = false;//Creem el boolea per al primer numero major
    
    if (numero1 > numero2){/*Si el 1er numero es major el boolea sera true*/
        esMajor=true;
    }    
    return esMajor;/*definim que es el que ens retornara cuan cridem(en aquest cas
    volem que ens retorni el boolea si es true o si es false*/  
    }
       
    
    public static int LlegirInt() {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan);

        return result;
    }

    public static int LlegirInt(String missatge) {
        int result;

        if (scan == null)
            scan = new Scanner(System.in);
        result = LlegirInt(scan, missatge);
        
        return result;
    }

    public static int LlegirInt(Scanner scan) {
        return LlegirInt(scan, null);
    }
    
    public static int LlegirInt(Scanner scan, String missatge, int valorMin, int valorMax)
    {
        int result =0;
        do {
            result = LlegirInt(scan, missatge);
        } while (result < valorMin || result > valorMax);
        
        return result;
    }

    public static int LlegirInt(Scanner scan, String missatge) {
        boolean dadesCorrectes;
        int result = 0;
        do {
            if (missatge != null) {
                System.out.print(missatge);
            }
            dadesCorrectes = scan.hasNextInt();
            if (dadesCorrectes) {
                result = scan.nextInt();
            } else if (scan.hasNext()) {
                scan.nextLine();
            }
        } while (!dadesCorrectes);

        return result;
    }

// </editor-fold>
}
