/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loteria;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class ArchivosBinarios {

    public static final String LOTERIA = "./loteria.bin";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static void GrabarPremiosBinario() {
        DataOutputStream dos = AbrirFicheroEscrituraBinario(LOTERIA, true, true);
        Premio p = this_lista;
        try {
            dos.writeUTF(p.numero);
            dos.writeInt(p.premio);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        CerrarFicheroBinarioOutput(dos);
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

    public static DataOutputStream AbrirFicheroEscrituraBinario(String nomFichero, boolean crear, boolean blnAnyadir) {
        DataOutputStream dos = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileOutputStream writer;
            try {
                writer = new FileOutputStream(f, blnAnyadir);
                // PrintWriter para poder escribir más comodamente
                dos = new DataOutputStream(writer);
            } catch (IOException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dos;
    }

    public static void CerrarFicheroBinarioOutput(DataOutputStream dos) {

        try {
            dos.flush();
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DataInputStream AbrirFicheroLecturaBinario(String nomFichero, boolean crear) {
        DataInputStream dis = null;
        File f = AbrirFichero(nomFichero, crear);

        if (f != null) {
            // Declarar el writer para poder escribir en el fichero¡
            FileInputStream reader;
            try {
                reader = new FileInputStream(f);
                // PrintWriter para poder escribir más comodamente
                dis = new DataInputStream(reader);
            } catch (IOException ex) {
                Logger.getLogger(ArchivosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return dis;
    }
}
