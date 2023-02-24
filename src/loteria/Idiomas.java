/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author ausias
 */
public class Idiomas {

    private Properties _prop;
    public Idiomas(String IdiomaElegido){
        this._prop=new Properties();
        this._prop=CargarIdiomas(IdiomaElegido);
    } 

    private Properties CargarIdiomas(String archivo) {        
        try {
            FileInputStream archivoPropiedades = new FileInputStream(archivo);
            this._prop.load(archivoPropiedades);
        } catch (IOException ex) {
            // manejo de excepciones
        }
        return this._prop;
    }

    public static ArrayList<String> ArchivosEnCarpeta(final File carpeta) {
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

    public String frase(String clave) {
        String frase = this._prop.getProperty(clave);
        return frase;
    }
}
