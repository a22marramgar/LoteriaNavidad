/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package loteria;

import java.util.ArrayList;
import static loteria.Simulacion.*;
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
public class SimulacionTest {
    
    public SimulacionTest() {
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
     * Test of IniciarSimulacion method, of class Simulacion.
     */
    @Test
    public void testIniciarSimulacion() {
        System.out.println("IniciarSimulacion");
        Simulacion instance = new Simulacion();
        int[] premios = {PRIMERPREMIO,SEGUNDOPREMIO,TERCERPREMIO,CUARTOS,QUINTOS,PEDREAS};
        boolean expResult = true;
        for (int j=0;j<premios.length;j++){
            for (int k=j+1;k<premios.length;k++){
                if (k!=j && premios[k] == premios[j]){
                  expResult=false;
                }
            }
        }
        boolean result = instance.IniciarSimulacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
