package loteria;

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
    final static File archivosIdiomas = new File("./lang");
    public static Idiomas idioma;
    public static Simulacion sim;
    public static void main(String[] args) {
        idioma = new Idiomas(Selector(Idiomas.ArchivosEnCarpeta(archivosIdiomas)));
        
        sim = new Simulacion();
        NuevaSimulacion();
        int opcio = 0;
        boolean creado = false;

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
     * @param creado Variable que indica si hi ha una simulacio creada
     * @param sim Objecte Simulacion
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

    public static void NuevaSimulacion() {

        System.out.println(idioma.frase("anyocons"));
        int any = llegirInt();
        sim.NuevaLista(ArchivosBinarios.CargarLista(any));
        System.out.println(idioma.frase("loteriade") + any +" " +idioma.frase("iniciada"));
        sim.setAnyo(any);
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
    public static void GestiondeCollas(){
        String nomcolla = llegirString(idioma.frase("nomcolla"));
        Colla colla = new Colla(nomcolla,sim.getAnyo());
        
        int opcion=0;
        while (opcion != 3) {
            opcion=Menu("anyadirmiembro","mostrarcolla");
        switch(opcion){
            case 1:
                String nombre = llegirString(idioma.frase("nommiembro"));
                int num=llegirInt(idioma.frase("numeromiembro"));
                String nummiembros = String.format("%05d", num);
                double importe=llegirDouble(idioma.frase("importemiembro"));
                colla.afegirMembre(nombre, nummiembros, importe);
                break;
            case 2:
                colla.mostrar();
                break;
        }
        
        }
        
    }
    

}
