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
        int expresult = simpruebas.GetPremios().get(804).getPremio();;
        assertEquals(expresult, result);        
        
    }
    
    

    /**
     * Test of GrabarColla method, of class ArchivosBinarios.
     */
    @Test
    public void testGrabarColla() {
        System.out.println("GrabarColla");       
        ArchivosBinarios.GrabarPremiosBinario(sim);
        Simulacion simpruebas = ArchivosBinarios.CargarSimulacion(512);
        int result = sim.GetPremios().get(804).getPremio();
        int expresult = simpruebas.GetPremios().get(804).getPremio();;
        assertEquals(expresult, result);  
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
        System.out.println("CargarSimulacion");                  
        sim = ArchivosBinarios.CargarSimulacion(512);
        boolean result = sim.estaIniciada();
        boolean expResult = true;        
        assertEquals(expResult, result);
       
    }

    /**
     * Test of CargarColla method, of class ArchivosBinarios.
     */
    @Test
    public void testCargarColla() {
        System.out.println("CargarColla");
        String nomcolla = "";
        int any = 0;
        Colla expResult = null;
        Colla result = ArchivosBinarios.CargarColla(nomcolla, any);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
