/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.UIUtilities.*;

/**
 *
 * @author ausias
 */
public class Idiomas {

    public static Idiomas idioma;

    public Idiomas() {
    }
    String[] idiomaSel;
    public static final String[] LISTA_FRASES = 
/*0*/       {"",
        
/*2*/       "", "", "","", "", //Simulacio
        
/*3*/       "","", // Resultat
            "", "","","",
            "", 
        
/*4*/       "", "", // Main
        
/*5*/       "", //Buscar
            "",
            "",
        
/*6*/       "", "", "", // Menu/simulacion
            "", "",
        
/*7*/       "", // Menu
            "",
            "",
            "",
            ""};
        
    public static Idiomas SelectorIdioma() {
        if (idioma == null) {
            idioma = new Idiomas();
        }
        String idiomaElegido = Selector();
        SacarFrases(idiomaElegido);
        idioma.idiomaSel= LISTA_FRASES;
        
        return idioma;
    }
    
    public static void SacarFrases(String nom) {
        // Creamos el enlace con el fichero en el disco
        BufferedReader buf = AbrirFicheroLectura(nom, true);

        String linea = LeerLinea(buf);
        int pos=0;
        while (linea != null) {
            LISTA_FRASES[pos]= linea;
            linea = LeerLinea(buf);
            pos++;
        }
        CerrarFichero(buf);
    }
    public static void CerrarFichero(BufferedReader br) {
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Idiomas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String LeerLinea(BufferedReader br) {
        String linea = null;

        try {
            linea = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Idiomas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linea;
    }
        /**
     * 
     * @return Devuelve el idioma que se usara
     */
    public static String Selector(){
        int elegido;
        String eleccion;
        System.out.println("Elige un idioma:");
        elegido = Menu("Catala","Castella");
        if(elegido==1){
            eleccion="./catala.txt";
        }else{
            eleccion="./castella.txt";
        }
        return eleccion;
    }
}
