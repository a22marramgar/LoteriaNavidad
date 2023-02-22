/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loteria;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static loteria.Idiomas.idioma;
import static loteria.Simulacion.PRIMERPREMIO;

/**
 *
 * @author Samuel
 */
public class ArchivosBinarios {

    public static final int TOTALPREMIOS = 1807;

    /**
     * @param Lista
     */
    public static void GrabarPremiosBinario(ArrayList<Premio> Lista, int any) {
        ObjectOutputStream oos = AbrirFicheroEscrituraBinario("./simulaciones/loteria" + any + ".bin", true, false);

        for (Premio p : Lista) {
            try {
                oos.writeObject(p);
            } catch (IOException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            } catch (IOException ex) {
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

    public static ArrayList<Premio> CargarLista(int any) {
        ArrayList<Premio> lista = new ArrayList();
        File fitxer;
        fitxer = new File("./simulaciones/loteria" + any + ".bin");

        if (!fitxer.exists()) {
            Simulacion sim = new Simulacion();
            sim.IniciarSimulacion();
            lista = sim.GetPremios();
            GrabarPremiosBinario(lista, any);

        } else {
            ObjectInputStream ois = AbrirFicheroLecturaBinario("./simulaciones/loteria" + any + ".bin", true);
            for (int i = 0; i != TOTALPREMIOS; i++) {
                try {
                    Premio p = (Premio) ois.readObject();
                    lista.add(p);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            CerrarFicheroBinarioInput(ois);
        }
        return lista;
    }

}
