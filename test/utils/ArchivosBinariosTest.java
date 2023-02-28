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
     * Test of GrabarPremiosBinario method, of class ArchivosBinarios.
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
     * Test of GrabarPremiosBinario method, of class ArchivosBinarios.
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
        Simulacion sim = new Simulacion(512);
        sim.IniciarSimulacion();
        ArchivosBinarios.GrabarPremiosBinario(sim);
        Simulacion simpruebas = ArchivosBinarios.CargarSimulacion(512);
        int result = sim.GetPremios().get(804).getPremio();
        int expresult = simpruebas.GetPremios().get(804).getPremio();;
        assertEquals(expresult, result);  
    }

    /**
     * Test of AbrirFichero method, of class ArchivosBinarios.
     */
    @Test
    public void testAbrirFichero() {
        System.out.println("AbrirFichero");
        String nomFichero = "";
        boolean crear = false;
        File expResult = null;
        File result = ArchivosBinarios.AbrirFichero(nomFichero, crear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbrirFicheroEscrituraBinario method, of class ArchivosBinarios.
     */
    @Test
    public void testAbrirFicheroEscrituraBinario() {
        System.out.println("AbrirFicheroEscrituraBinario");
        String nomFichero = "";
        boolean crear = false;
        boolean blnAnyadir = false;
        ObjectOutputStream expResult = null;
        ObjectOutputStream result = ArchivosBinarios.AbrirFicheroEscrituraBinario(nomFichero, crear, blnAnyadir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CerrarFicheroBinarioOutput method, of class ArchivosBinarios.
     */
    @Test
    public void testCerrarFicheroBinarioOutput() {
        System.out.println("CerrarFicheroBinarioOutput");
        ObjectOutputStream oos = null;
        ArchivosBinarios.CerrarFicheroBinarioOutput(oos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbrirFicheroLecturaBinario method, of class ArchivosBinarios.
     */
    @Test
    public void testAbrirFicheroLecturaBinario() {
        System.out.println("AbrirFicheroLecturaBinario");
        String nomFichero = "";
        boolean crear = false;
        ObjectInputStream expResult = null;
        ObjectInputStream result = ArchivosBinarios.AbrirFicheroLecturaBinario(nomFichero, crear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CerrarFicheroBinarioInput method, of class ArchivosBinarios.
     */
    @Test
    public void testCerrarFicheroBinarioInput() {
        System.out.println("CerrarFicheroBinarioInput");
        ObjectInputStream ois = null;
        ArchivosBinarios.CerrarFicheroBinarioInput(ois);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CargarSimulacion method, of class ArchivosBinarios.
     */
    @Test
    public void testCargarSimulacion() {
        System.out.println("CargarSimulacion");
        int any = 0;
        Simulacion expResult = null;
        Simulacion result = ArchivosBinarios.CargarSimulacion(any);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
