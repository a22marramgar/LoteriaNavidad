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
     * 
     * @param sim
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
     * 
     * @param colla 
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

    public static void CerrarFicheroBinarioOutput(ObjectOutputStream oos) {

        try {
            oos.flush();
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public static void CerrarFicheroBinarioInput(ObjectInputStream ois) {
        try {
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Buscar fichero
    //Si existe, cargar simulacion de fichero
    //Si no existe, crear sim vacia
    //devolver sim
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
