/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package loteria;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ausias
 */
public class ComprobacioIT {
    
    public ComprobacioIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getImporte method, of class Comprobacio.
     */
    @Test
    public void testGetImporte() {
        String numero = "014721";
        double importe = 20;        
        ArrayList <Premio> pruebas = new ArrayList<>();
        Comprobacio comprobar_importe= new Comprobacio(numero, pruebas, importe);
        assertEquals(comprobar_importe.getImporte(), importe);
        
    }

    
}
