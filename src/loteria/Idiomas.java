/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public static final ArrayList<String> LISTA_FRASES = new ArrayList<>();

    public static ArrayList<String> SelectorIdioma() {
        if (idioma == null) {
            idioma = new Idiomas();
        }
        final File archivosIdiomas = new File("./lang");
        ArrayList<String> posibilidades = ArchivosEnCarpeta(archivosIdiomas);
        String idiomaElegido = Selector(posibilidades);
        SacarFrases(idiomaElegido);
        return LISTA_FRASES;
    }

    public static void SacarFrases(String nom) {
        // Creamos el enlace con el fichero en el disco
        BufferedReader buf = AbrirFicheroLectura(nom, true);

        String linea = LeerLinea(buf);
        int pos = 0;
        while (linea != null) {
            LISTA_FRASES.add(linea);
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
     * @param listaDeIdiomas
     * @return Devuelve el idioma que se usara
     */
    public static String Selector(ArrayList<String> listaDeIdiomas) {
        int elegido;
        String eleccion;
        elegido = MenuAL(listaDeIdiomas);
        eleccion = "./lang/"+listaDeIdiomas.get(elegido-1);
        return eleccion;
    }

    public static ArrayList ArchivosEnCarpeta(final File carpeta) {
        ArrayList<String> listaidiomas=new ArrayList<>();
        for (final File archivos : carpeta.listFiles()) {
            if (archivos.isDirectory()) {
                ArchivosEnCarpeta(archivos);
            } else {
                //if(archivos.getName()!=null){ 
                    listaidiomas.add(archivos.getName());
                //}
            }
        }
        return listaidiomas;
    }
    public static String FRASE(int indice){
        String frase= LISTA_FRASES.get(indice);
        return frase;
    }
}
