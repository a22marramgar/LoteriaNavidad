/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package colles;

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
public class CollaTest {
    public Colla colla = new Colla("lacolla",512);
    
    public CollaTest() {
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
     * Prueba para comprobar que añade miembro a las collas correctamente
     */
    @Test
    public void testAfegirMembre() {
        System.out.println("afegirMembre");
        String nomMembre = "Juan";
        String numeroJugat = "00001";
        double importMembre = 20.0;       
        boolean result = colla.afegirMembre(nomMembre, numeroJugat, importMembre);
        boolean expResult = true;
        assertEquals(expResult, result);       
    }
    
    /**
     * Prueba para ver si cuando añade el miembro a la colla, comprueba correctamente
     * que no este repetido
     */
    @Test
    public void testAfegirMembre2() {
        System.out.println("afegirMembre2");
        String nomMembre = "Juan";
        String numeroJugat = "00001";
        double importMembre = 20.0;
        String nomMembre2 = "Juan";
        String numeroJugat2 = "00001";
        double importMembre2 = 20.0;
        boolean miembro1 = colla.afegirMembre(nomMembre, numeroJugat, importMembre);
        boolean result = colla.afegirMembre(nomMembre2, numeroJugat2, importMembre2);
        boolean expResult = false;
        assertEquals(expResult, result);      
    }
 
  
}
