package loteria;

import idiomas.Idiomas;
import utils.ArchivosBinarios;
import colles.Colla;
import java.io.File;
import java.util.ArrayList;
import static utils.UIUtilities.*;

/**
 * Portara el menu principal, on s'executaran les altres clases, funcions i
 * procediments
 *
 * @author ausias
 */
public class LoteriaNavidad {
    final static File ARCHIVOSIDIOMAS = new File("./lang");
    public static Idiomas idioma;
    public static Simulacion sim;
    public static void main(String[] args) {
        idioma = new Idiomas(Selector(Idiomas.ArchivosEnCarpeta(ARCHIVOSIDIOMAS)));
        
        sim = new Simulacion();
        NuevaSimulacion();
        int opcio = 0;

        while (opcio != 5) {
            opcio = Menu(idioma.frase("iniciar"),
                    idioma.frase("buscar"),
                    idioma.frase("verlista"),idioma.frase("gestioncolla"),
                    idioma.frase("salir"));

            switch (opcio) {
                case 1:
                    NuevaSimulacion();
                    break;
                case 2:
                    Buscar();
                    break;
                case 3:
                    VeureLlista();
                    break;
                case 4:
                    GestiondeCollas();
                    break;
            }
        }
        System.out.println(idioma.frase("adios"));

    }

    /**
     * Veure la llista de tots els numeros amb premi, menys les pedreas
     *
     * @param creado Variable que indica si hi ha una simulacio creada
     * @param sim Objecte Simulacion
     */
    private static void VeureLlista() {

        sim.Mostrar();
    }

    /**
     * Buscar el premi corresponent a un numero
     *
     */
    public static void Buscar() {
        Comprobacio comprobar_numero = new Comprobacio(sim.GetPremios());
        System.out.println(idioma.frase("introducenum"));
        int numero1 = escollirOpcio(0, 99999, idioma.frase("introducenum"));
        String num = String.format("%05d", numero1);
        System.out.println(idioma.frase("introduceprecio"));
        int precio = llegirInt();
        System.out.println(comprobar_numero.Resultat(num, precio));

    }
    /**
     * Abre una la simulacion según el año que quieras o la crea si no existe
     */
    public static void NuevaSimulacion() {

        System.out.println(idioma.frase("anyocons"));
        int any = llegirInt();
        sim = ArchivosBinarios.CargarSimulacion(any);
        if(!sim.estaIniciada()){
            sim.IniciarSimulacion();
            ArchivosBinarios.GrabarPremiosBinario(sim);
        }
        System.out.println(idioma.frase("loteriade") + any +" " +idioma.frase("iniciada"));
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
    
    /**
     * Para gestionar grupos, añadarilos y mostrarlos
     */
    public static void GestiondeCollas(){
        String nomcolla = llegirString(idioma.frase("nomcolla"));
        Colla colla = ArchivosBinarios.CargarColla(nomcolla,sim.getAnyo());
        
        int opcion=0;
        while (opcion < 5) {
            opcion=Menu(idioma.frase("anyadirmiembro"),
      idioma.frase("eliminarmiembro"),idioma.frase("modimportemiembro"),
      idioma.frase("mostrarcolla"), idioma.frase("eliminarcolla"),
      idioma.frase("salir"));
        switch(opcion){
            case 1:
                pedirNuevoMiembro(colla);
                break;
            case 2:
                EliminarMiembro(colla);
                break;
            case 3:
                ModImporte(colla);
                break;            
            case 4:
                colla.mostrar();
                break;
            case 5:
                ArchivosBinarios.BorrarFichero("./colles/"+ nomcolla + sim.getAnyo() + ".bin");
                break;
            case 6:
                ArchivosBinarios.GrabarColla(colla);
                break;
        }
        
        }
        
    }
    /**
     * Procedimiento para pedir datos de nuevo miembro
     * @param colla el obnjeto colla
     */
    private static void pedirNuevoMiembro(Colla colla) {
        String nombre = llegirString(idioma.frase("nommiembro"));
        while (nombre.length()> 16){
            System.out.println(idioma.frase("nombrelargo"));
            nombre = llegirString(idioma.frase("nommiembro"));
        }       
        
        System.out.print(idioma.frase("numeromiembro"));
        int num = escollirOpcio(0, 99999, idioma.frase("numeromiembro"));
        String nummiembros = String.format("%05d", num);
        double importe;
        System.out.println(idioma.frase("entre5y60"));
        System.out.print(idioma.frase("importemiembro"));
        do{
            
            importe=escollirOpcio(5, 60, idioma.frase("entre5y60"));
        }while(importe%5!=0);
        
        colla.afegirMembre(nombre, nummiembros, importe);
    }
    /**
     * Funcion para eliminar un miembro
     * @param colla A eliminar
     */
    private static void EliminarMiembro(Colla colla) {
        String nombre = llegirString(idioma.frase("nommiembro"));
        System.out.print(idioma.frase("numeromiembro"));
        int num = escollirOpcio(0, 99999, idioma.frase("numeromiembro"));
        String nummiembros = String.format("%05d", num);
        colla.borrarMembre(nombre, nummiembros);
    }
    
    /**
     * Funcion para modificar el importe de un miembro
     * @param colla A modificar
     */
    private static void ModImporte(Colla colla) {
        
        double importe;        
        String nombre = llegirString(idioma.frase("nommiembro"));
        System.out.print(idioma.frase("numeromiembro"));
        int num = escollirOpcio(0, 99999, idioma.frase("numeromiembro"));
        String nummiembros = String.format("%05d", num);
        System.out.println(idioma.frase("entre5y60"));
        System.out.println(idioma.frase("importemiembro"));
        do{
            
            importe=escollirOpcio(1, 60, idioma.frase("entre5y60"));
        }while(importe%5!=0);   
        colla.ModImporteMembre(nombre, nummiembros, importe);
    }
    
}
