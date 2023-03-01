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
    
    private Comprobacio comprobarTest;
    
    public ComprobacioTest() {
        Premio primero = new Premio("12347",4000000);
        Premio segundo = new Premio("78901",1200000);
        Premio tercero = new Premio("54321", 500000);
        Premio cuarto1 = new Premio("65432", 200000);
        Premio cuarto2 = new Premio("98765", 200000);
        Premio quinto = new Premio("76543", 60000);
        Premio pedrea = new Premio("67890", 1000);
        ArrayList<Premio> pruebas = new ArrayList<>();
        pruebas.add(primero);
        pruebas.add(segundo);
        pruebas.add(tercero);
        pruebas.add(cuarto1);
        pruebas.add(cuarto2);
        pruebas.add(quinto);
        pruebas.add(pedrea);
        comprobarTest = new Comprobacio(pruebas);
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
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void test1rPremio() {
        
        System.out.println("test1rPremio");
        double expResult = 4000000.0;
        double result = comprobarTest.Comprobar("12347",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void test2nPremio() {
        
        System.out.println("test2nPremio");
        double expResult = 1200000.0;
        double result = comprobarTest.Comprobar("78901",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void test3rPremio() {
        
        System.out.println("test3rPremio");
        double expResult = 500000.0;
        double result = comprobarTest.Comprobar("54321",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void testCuartos() {
        
        System.out.println("testCuartos");
        double expResult = 200000.0;
        double result = comprobarTest.Comprobar("65432",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void testQuintos() {
        
        System.out.println("testQuintos");
        double expResult = 60000.0;
        double result = comprobarTest.Comprobar("76543",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void testPedrea() {
        
        System.out.println("testPedrea");
        double expResult = 1000.0;
        double result = comprobarTest.Comprobar("67890",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void testAproximacionYCentena1rPremi() {
        
        System.out.println("testAproximacionYCentena1rPremi");
        double expResult = 21000.0;
        double result = comprobarTest.Comprobar("12346",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void test2UltimasAproximacionYUltima1rPremi() {
        
        System.out.println("test2UltimasYAproximacion1rPremi");
        double expResult = 1200.0;
        double result = comprobarTest.Comprobar("30947",200);
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test of Comprobar method, of class Comprobacio.
     */
    @Test
    public void testSinPremio() {
        
        System.out.println("testSinPremio");
        double expResult = 0.0;
        double result = comprobarTest.Comprobar("30919",200);
        assertEquals(expResult, result, 0);
    }
}
