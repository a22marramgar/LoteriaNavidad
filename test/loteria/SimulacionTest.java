/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package loteria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static loteria.Simulacion.*;
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
public class SimulacionTest {
    
    public SimulacionTest() {
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
    }
    
    /**
     * Test of IniciarSimulacion method, of class Simulacion.
     */
    @Test
    public void testSimulacionNumerosRepetidos() {
        System.out.println("SimulacionNumerosRepetidos");
        Simulacion sim = new Simulacion();
        sim.IniciarSimulacion();
        Set<String> numeros_repetidos = new HashSet<>();
        for (Premio p : sim.GetPremios()) {
            if(numeros_repetidos.add(p.getNumero()) == false){
                fail("Numero "+p.getNumero()+" repetido");
            }
        }
    }
}
