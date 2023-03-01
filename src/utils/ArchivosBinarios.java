/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utils;

import colles.Colla;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import loteria.Simulacion;

/**
 *
 * @author Samuel
 */
public class ArchivosBinarios {

    public static final int TOTALPREMIOS = 1807;

    /**
     * Procedimiento que graba los premios en un archivo binario
     * @param sim el objeto simulacion
     */
    public static void GrabarPremiosBinario(Simulacion sim) {
        ObjectOutputStream oos = AbrirFicheroEscrituraBinario("./simulaciones/loteria" + sim.getAnyo() + ".bin", true, false);
        try {
            oos.writeObject(sim);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        CerrarFicheroBinarioOutput(oos);
    }
    
    /**
     * Procedimiento que graba las collas en un archivo binario
     * @param colla el objeto colla
     */
    public static void GrabarColla(Colla colla) {
        ObjectOutputStream oos = AbrirFicheroEscrituraBinario("./colles/"+ colla.getNom() + colla.getAnyo() + ".bin", true, false);
        try {
            oos.writeObject(colla);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        CerrarFicheroBinarioOutput(oos);
    }

    /**
     * Funcion que abre un archivo,y si no esta creado,lo crea
     * @param nomFichero Nombre del fichero a abrir
     * @param crear booleano por si se ha de crear el archivo o no
     * @return devuelve el archivo
     */
    public static File AbrirFichero(String nomFichero, boolean crear) {
        File result = null;
        result = new File(nomFichero);

        if (!result.exists()) {
            if (crear) {
                try {
                    result.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
                    result = null;
                }
            } else {
                result = null;
            }
        }
        return result;
    }

    /**
     * Funcion para abrir un archivo binario para escritura
     * @param nomFichero Nombre del fichero a escribir
     * @param crear booleano por si se ha de crear el archivo o no
     * @param blnAnyadir booleano por si se ha de añadir al archivo o no
     * @return el fichero abierto con ObjectOutputStream 
     */
    public static ObjectOutputStream AbrirFicheroEscrituraBinario(String nomFichero, boolean crear, boolean blnAnyadir) {
        ObjectOutputStream oos = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileOutputStream writer;
            try {
                writer = new FileOutputStream(f, blnAnyadir);
                // PrintWriter para poder escribir más comodamente
                oos = new ObjectOutputStream(writer);
            } catch (IOException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return oos;
    }

    /**
     * Procedimiento para cerrar un fichero para escritura
     * @param oos el fichero abierto con ObjectOutputStream
     */
    public static void CerrarFicheroBinarioOutput(ObjectOutputStream oos) {

        try {
            oos.flush();
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion para abrir un archivo binario para lectura
     * @param nomFichero Nombre del fichero a leer
     * @param crear booleano por si se ha de crear el archivo o no     
     * @return el fichero abierto con ObjectInputStream
     */
    public static ObjectInputStream AbrirFicheroLecturaBinario(String nomFichero, boolean crear) {
        ObjectInputStream ois = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileInputStream reader;
            try {
                reader = new FileInputStream(f);
                // PrintWriter para poder escribir más comodamente
                ois = new ObjectInputStream(reader);
            }catch(EOFException ex){
                //Aqui llega si el fichero esta vacio
            }catch (IOException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ois;
    }

    /**
     * Procedimiento para cerrar un fichero para lectura
     * @param ois el fichero abierto con ObjectInputStream
     */
    public static void CerrarFicheroBinarioInput(ObjectInputStream ois) {
        try {
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * Funcion para cargar una simulacion
     * @param any el anyo de la loteria a cargar
     * @return el objeto Simulacion
     */
    public static Simulacion CargarSimulacion(int any) {
        ObjectInputStream ois = AbrirFicheroLecturaBinario("./simulaciones/loteria" + any + ".bin", true);
        Simulacion sim = new Simulacion(any);
        if (ois != null) {
            try {
                sim = (Simulacion) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            CerrarFicheroBinarioInput(ois);
        }
        return sim;
    }

    /**
     * Funcion para cargar una colla
     * @param nomcolla el nom de la colla a cargar
     * @param any el anyo de la loteria a cargar
     * @return el objeto Colla
     */
    public static Colla CargarColla(String nomcolla, int any) {
        ObjectInputStream ois = AbrirFicheroLecturaBinario("./colles/"+ nomcolla + any + ".bin", true);
        Colla colla = new Colla(nomcolla, any);
        if (ois != null) {
            try {
                colla = (Colla) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            CerrarFicheroBinarioInput(ois);
        }
        return colla;
    }

}
