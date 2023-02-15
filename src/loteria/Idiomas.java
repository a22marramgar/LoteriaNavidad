/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;

/**
 *
 * @author ausias
 */
public class Idiomas {

    public static Idiomas idioma;

    public Idiomas() {
    }
    String[][] idiomaSel;
    public static final String[][][] LISTA_FRASES = {
        {{"premi"},
        
        {"Primer", "Segon", "Tercer","Quarts", "Cinquens"}, //Simulacio
        
        {"Felicitats, has guanyat ","Aquest premi es reparteix entre", // Resultat
        "APROXIMACIO", "CENTENA","ULTIMES 2 XIFRES","REINTEGRAMENT",
        "Ho sentim, aquest numero no te cap premi."}, 
        
        {"Adeu, fins un altre moment", "Si us plau, inicia una nova simulacio"}, // Main
        
        {"Introdueix el numero a comprobar", //Buscar
        "Introdueix el preu que has pagat",
        "Si us plau, inicia una nova simulacio"},
        
        {"Ja existeix una simulacio, crear una nova?", "Si", "No", // Menu/simulacion
        "Iniciant simulacio...", "Finalitzat."},
        
        {"Opcions", // Menu
        "Inicia simulacio",
        "Buscar el premi",
        "Veure llista de premis",
        "Sortir"}},
        
        {{"premio"},
        
        {"Primero", "Segundo", "Tercero","Cuartos", "Quintos"}, //Simulacio
        
        {"Felicidades, has ganado ","Este premio se reparte entre entre", // Resultat
        "APROXIMACION", "CENTENA","ULTIMAS 2 CIFRAS","REINTEGRO",
        "Lo sentimos, este numero no tiene ningun premio."}, 
        
        {"Adios, hasta otra", "Por favor inicia una nueva simulacion"}, // Main
        
        {"Introduce el numero a comprobar", //Buscar
        "Introduce el precio que has pagado",
        "Por favor inicia una nueva simulacion"},
        
        {"Ya existe una simulacion, crear una nueva?", "Si", "No", // Menu/simulacion
        "Iniciando simulacion...", "Finalizado."},
        
        {"Opciones", // Menu
        "Iniciar simulacion",
        "Buscar el premio",
        "Ver lista de premios",
        "Salir"}}
    
    };  
    public static Idiomas SelectorIdioma(int eleccion) {
        if (idioma == null) {
            idioma = new Idiomas();
        }
        idioma.idiomaSel= LISTA_FRASES[eleccion];
        
        return idioma;
    }
}