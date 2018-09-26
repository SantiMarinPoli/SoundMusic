package co.com.soundMusic.Artista;

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
public class ArtistaDaoImplTest {
    
    public ArtistaDaoImplTest() {
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
     * Test of obtenerArtistas method, of class ArtistaDaoImpl.
     */
    @Test
    public void testObtenerArtistas() throws Exception {
        System.out.println("obtenerArtistas");
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        List<Artista> expResult = null;
        List<Artista> result = instance.obtenerArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerArtista method, of class ArtistaDaoImpl.
     */
    @Test
    public void testObtenerArtista() throws Exception {
        System.out.println("obtenerArtista");
        int idArtista = 0;
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        Artista expResult = null;
        Artista result = instance.obtenerArtista(idArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearArtista method, of class ArtistaDaoImpl.
     */
    @Test
    public void testCrearArtista() throws Exception {
        System.out.println("crearArtista");
        Artista artista = null;
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        instance.crearArtista(artista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarArtista method, of class ArtistaDaoImpl.
     */
    @Test
    public void testEliminarArtista() throws Exception {
        System.out.println("eliminarArtista");
        String status = "";
        int idArtista = 0;
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        instance.eliminarArtista(status, idArtista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarArtista method, of class ArtistaDaoImpl.
     */
    @Test
    public void testActualizarArtista() throws Exception {
        System.out.println("actualizarArtista");
        Artista artista = null;
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        instance.actualizarArtista(artista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
