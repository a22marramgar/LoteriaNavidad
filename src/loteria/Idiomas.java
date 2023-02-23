/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.UIUtilities.*;
import java.util.Properties;

/**
 *
 * @author ausias
 */
public class Idiomas {

    public static Idiomas idioma;
    public static Properties PROPIEDADES = new Properties();

    public static Properties SelectorIdioma() {
        if (idioma == null) {
            idioma = new Idiomas();
        }
        final File archivosIdiomas = new File("./lang");
        ArrayList<String> posibilidades = ArchivosEnCarpeta(archivosIdiomas);
        String idiomaElegido = Selector(posibilidades);
        Properties prop = CargarIdiomas(idiomaElegido);
        return prop;
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
        eleccion = "./lang/" + listaDeIdiomas.get(elegido - 1)+".txt";
        return eleccion;
    }

    public static Properties CargarIdiomas(String archivo) {
        
        try (FileInputStream archivoPropiedades = new FileInputStream(archivo)) {
            PROPIEDADES.load(archivoPropiedades);
        } catch (IOException ex) {
            // manejo de excepciones
        }
        return PROPIEDADES;
    }

    public static ArrayList ArchivosEnCarpeta(final File carpeta) {
        ArrayList<String> listaidiomas = new ArrayList<>();
        for (final File archivos : carpeta.listFiles()) {
            if (archivos.isDirectory()) {
                ArchivosEnCarpeta(archivos);
            } else {
                //if(archivos.getName()!=null){ 
                listaidiomas.add(archivos.getName().substring(0, archivos.getName().length()-4));
                //}
            }
        }
        return listaidiomas;
    }

    public static String FRASE(String clave) {
        String frase = PROPIEDADES.getProperty(clave);
        return frase;
    }
}
