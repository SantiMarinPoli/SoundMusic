package co.com.soundMusic.Login.Usuario;

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
public class UsuarioDaoImplTest {
    
    public UsuarioDaoImplTest() {
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
     * Test of obtenerUsuarios method, of class UsuarioDaoImpl.
     */
    @Test
    public void testObtenerUsuarios() throws Exception {
        System.out.println("obtenerUsuarios");
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.obtenerUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerUsuario method, of class UsuarioDaoImpl.
     */
    @Test
    public void testObtenerUsuario() throws Exception {
        System.out.println("obtenerUsuario");
        int idUsuario = 0;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuario(idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearUsuario method, of class UsuarioDaoImpl.
     */
    @Test
    public void testCrearUsuario() throws Exception {
        System.out.println("crearUsuario");
        Usuario usuario = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.crearUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarUsuario method, of class UsuarioDaoImpl.
     */
    @Test
    public void testEliminarUsuario() throws Exception {
        System.out.println("eliminarUsuario");
        String status = "";
        int idUsuario = 0;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.eliminarUsuario(status, idUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarUsuario method, of class UsuarioDaoImpl.
     */
    @Test
    public void testActualizarUsuario() throws Exception {
        System.out.println("actualizarUsuario");
        Usuario usuario = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.actualizarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
