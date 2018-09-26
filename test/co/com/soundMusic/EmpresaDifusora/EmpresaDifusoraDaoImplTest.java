package co.com.soundMusic.EmpresaDifusora;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresaDifusoraDaoImplTest {
    
    public EmpresaDifusoraDaoImplTest() {
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
     * Test of obtenerEmpresasDifusoras method, of class EmpresaDifusoraDaoImpl.
     */
    @Test
    public void testObtenerEmpresasDifusoras() throws Exception {
        System.out.println("obtenerEmpresasDifusoras");
        EmpresaDifusoraDaoImpl instance = null;
        List<EmpresaDifusora> expResult = null;
        List<EmpresaDifusora> result = instance.obtenerEmpresasDifusoras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerEmpresaDifusora method, of class EmpresaDifusoraDaoImpl.
     */
    @Test
    public void testObtenerEmpresaDifusora() throws Exception {
        System.out.println("obtenerEmpresaDifusora");
        int idEmpresaDifusora = 0;
        EmpresaDifusoraDaoImpl instance = null;
        EmpresaDifusora expResult = null;
        EmpresaDifusora result = instance.obtenerEmpresaDifusora(idEmpresaDifusora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearEmpresaDifusora method, of class EmpresaDifusoraDaoImpl.
     */
    @Test
    public void testCrearEmpresaDifusora() throws Exception {
        System.out.println("crearEmpresaDifusora");
        EmpresaDifusora empresaDifusora = null;
        EmpresaDifusoraDaoImpl instance = null;
        instance.crearEmpresaDifusora(empresaDifusora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEmpresaDifusora method, of class EmpresaDifusoraDaoImpl.
     */
    @Test
    public void testEliminarEmpresaDifusora() throws Exception {
        System.out.println("eliminarEmpresaDifusora");
        String status = "";
        int idEmpresaDifusora = 0;
        EmpresaDifusoraDaoImpl instance = null;
        instance.eliminarEmpresaDifusora(status, idEmpresaDifusora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEmpresaDifusora method, of class EmpresaDifusoraDaoImpl.
     */
    @Test
    public void testActualizarEmpresaDifusora() throws Exception {
        System.out.println("actualizarEmpresaDifusora");
        EmpresaDifusora empresaDifusora = null;
        EmpresaDifusoraDaoImpl instance = null;
        instance.actualizarEmpresaDifusora(empresaDifusora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
