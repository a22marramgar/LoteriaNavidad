/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils;

import colles.Colla;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import loteria.Simulacion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ausias
 */
public class ArchivosBinariosTest {
    public Simulacion sim = new Simulacion(512);
    public Colla colla = new Colla("lacolla",sim.getAnyo());
     
    public ArchivosBinariosTest() {
    sim.IniciarSimulacion();  
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Prueba para comprobar que el numero se grabe correctamente
     */
    @Test
    public void testGrabarPremiosBinario() {
        System.out.println("GrabarPremiosBinario");        
        ArchivosBinarios.GrabarPremiosBinario(sim);
        Simulacion simpruebas = ArchivosBinarios.CargarSimulacion(512);
        String result = sim.GetPremios().get(3).getNumero();
        String expresult = simpruebas.GetPremios().get(3).getNumero();
        assertEquals(expresult, result);        
        
    }
    
     /**
     * Prueba para comprobar que el premio se grabe correctamente
     */
    @Test
    public void testGrabarPremiosBinario2() {
        System.out.println("GrabarPremiosBinario2");        
        ArchivosBinarios.GrabarPremiosBinario(sim);
        Simulacion simpruebas = ArchivosBinarios.CargarSimulacion(512);
        int result = sim.GetPremios().get(804).getPremio();
        int expresult = simpruebas.GetPremios().get(804).getPremio();
        assertEquals(expresult, result);        
        
    }    
    

    /**
     * Prueba 2 para comprobar que grabe bien las collas, comprueba cuando el nombre 
     * de la colla es igual a la esperada
     */
    @Test
    public void testGrabarColla() {
        System.out.println("GrabarColla");
        ArchivosBinarios.GrabarColla(colla);
        Colla colla2 = ArchivosBinarios.CargarColla("lacolla",sim.getAnyo());
        String result = colla.getNom();
        String expresult = colla2.getNom();
        assertEquals(expresult, result);  
    }
    
    /**
     * Prueba 2 para comprobar que grabe bien las collas, comprueba cuando el nombre 
     * de la colla no es igual a la esperada
     */
    @Test
    public void testGrabarColla2() {
        System.out.println("GrabarColla2");
        ArchivosBinarios.GrabarColla(colla);        
        Colla colla2 = ArchivosBinarios.CargarColla("otracolla",sim.getAnyo());
        String result = colla.getNom();
        String expresult = colla2.getNom();
        assertNotSame(expresult, result);  
    } 


    /**
     * Prueba para comprobar si se inicia una simulacion vacia
     */
    @Test
    public void testCargarSimulacion() {
        System.out.println("CargarSimulacion");                  
        Simulacion sim1 =  ArchivosBinarios.CargarSimulacion(422);
        boolean result = sim1.estaIniciada();
        boolean expResult = false;        
        assertEquals(expResult, result);
       
    }
    
     /**
     * Prueba para comprobar cuando se inicia una simulacion correctamente
     */
    @Test
    public void testCargarSimulacion2() {
        System.out.println("CargarSimulacion2");                  
        sim = ArchivosBinarios.CargarSimulacion(512);
        boolean result = sim.estaIniciada();
        boolean expResult = true;        
        assertEquals(expResult, result);
       
    }

    /**
     * Prueba para comprobar que carge bien las collas, comprueba cuando el nombre 
     * de la colla es igual a la esperada
     */
    @Test
    public void testCargarColla() {
        System.out.println("CargarColla");                  
        Colla colla2 = ArchivosBinarios.CargarColla("lacolla",sim.getAnyo());
        String result = colla.getNom();
        String expresult = colla2.getNom();
        assertEquals(expresult, result);
    }
    
     /**
     * Prueba para comprobar que carge bien las collas, comprueba cuando el nombre 
     * de la colla no es igual a la esperada
     */
    @Test
    public void testCargarColla2() {
        System.out.println("CargarColla2");                  
        Colla colla2 = ArchivosBinarios.CargarColla("novacolla",sim.getAnyo());
        String result = colla.getNom();
        String expresult = colla2.getNom();
        assertNotSame(expresult, result);
    }    
    

}
