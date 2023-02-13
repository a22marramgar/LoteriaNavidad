/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loteria;

import java.util.ArrayList;
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
public class ComprobacioTest {
    
    public ComprobacioTest() {
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
     * Test of getImporte method, of class Comprobacio.
     */
    @Test
    public void testGetImporte() {
        String numero = "014721";
        double importe = 20;        
        ArrayList <Premio> pruebas = new ArrayList<>();
        Comprobacio comprobar_importe= new Comprobacio(numero, pruebas, importe);
        assertEquals(comprobar_importe.getImporte(), importe, 0);
        
    }

    /**
     * Test of getTotal method, of class Comprobacio.
     */
    @Test
    public void test1rPremio() {
        Premio primero = new Premio("12347",4000000);
        Premio segundo = new Premio("78901",1200000);
        Premio tercero = new Premio("54321", 500000);
        Premio cuarto1 = new Premio("65432", 200000);
        Premio cuarto2 = new Premio("98765", 200000);
        Premio quinto = new Premio("76543", 60000);
        Premio pedrea = new Premio("12345", 1000);
        ArrayList<Premio> pruebas = new ArrayList<>();
        pruebas.add(primero);
        pruebas.add(segundo);
        pruebas.add(tercero);
        pruebas.add(cuarto1);
        pruebas.add(cuarto2);
        pruebas.add(quinto);
        pruebas.add(pedrea);
        System.out.println("getTotal");
        Comprobacio comprobar = new Comprobacio("12347", pruebas, 200);
        double expResult = 4000000.0;
        double result = comprobar.getTotal();
        assertEquals(expResult, result, 0);
    }
    
}
