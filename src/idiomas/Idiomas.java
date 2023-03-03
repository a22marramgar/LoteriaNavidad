/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idiomas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;

/**
 * 
 * @author ausias
 */
public class Idiomas {

    private Properties _prop;
    /**
     * Constructor de Idiomas
     * @param IdiomaElegido Idioma que se cargara en el Properties
     */
    public Idiomas(String IdiomaElegido){
        this._prop=new Properties();
        this._prop=CargarIdiomas(IdiomaElegido);
    } 
    /**
     * Carga el archivo con el idioma seleccionado en el Properties
     * @param archivo Archivo a cargar
     * @return 
     */
    private Properties CargarIdiomas(String archivo) {        
        try {
            FileInputStream archivoPropiedades = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(archivoPropiedades, StandardCharsets.UTF_8);
            this._prop.load(isr);
        } catch (IOException ex) {
            // manejo de excepciones
        }
        return this._prop;
    }
    /**
     * Para leer los archivos que existen en un carpeta
     * @param carpeta Donde buscaremos los archivos
     * @return Devuelve un ArrayList con los posibles idiomas a escoger
     */
    public static ArrayList<String> ArchivosEnCarpeta(final File carpeta) {
        ArrayList<String> listaidiomas = new ArrayList<>();
        for (final File archivos : carpeta.listFiles()) {
            if (archivos.isDirectory()) {
                ArchivosEnCarpeta(archivos);
            } else {
                listaidiomas.add(archivos.getName().substring(0, archivos.getName().length()-4));
            }
        }
        return listaidiomas;
    }
    /**
     * Busca la frase correspondiente a la clave que le proporcionamos
     * @param clave con la que buscaremos la frase
     * @return La frase
     */
    public String frase(String clave) {
        String frase = this._prop.getProperty(clave);
        return frase;
    }
}
