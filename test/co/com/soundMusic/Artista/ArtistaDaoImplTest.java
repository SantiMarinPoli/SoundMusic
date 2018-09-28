package co.com.soundMusic.Artista;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaDaoImplTest {

    ArtistaDaoImpl daoArtista;
    Artista Artistaprueba;

    public ArtistaDaoImplTest() {
    }

    @Before
    public void setUp() {
        daoArtista = new ArtistaDaoImpl();
        String[] datosArtista = {"SANTIAGO", null, "MEDINA", "PELAEZ", "MC DINA", "M", "A"};
        Date[] fechasArtista = {Date.valueOf("1992-06-01"), null};
        Artistaprueba = new Artista(1, datosArtista, fechasArtista);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerArtistas method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testObtenerArtistas() throws Exception {
        System.out.println("obtenerArtistas");
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();
        List<Artista> resultadoEsperado = null;

        List<Artista> resultadoActual = daoArtista.obtenerArtistas();

        assertFalse(resultadoActual.isEmpty());
        //assertEquals(expResult, result);
    }

    /**
     * Test of obtenerArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testObtenerArtista() throws Exception {
        System.out.println("obtenerArtista");
        int idArtista = 1;

        Artista resultadoActual = daoArtista.obtenerArtista(idArtista);

        assertEquals(Artistaprueba.getIdArtista(), resultadoActual.getIdArtista());
        assertEquals(Artistaprueba.getPrimerNombre(), resultadoActual.getPrimerNombre());
        assertEquals(Artistaprueba.getSegundoNombre(), resultadoActual.getSegundoNombre());
        assertEquals(Artistaprueba.getPrimerApellido(), resultadoActual.getPrimerApellido());
        assertEquals(Artistaprueba.getSegundoApellido(), resultadoActual.getSegundoApellido());
        assertEquals(Artistaprueba.getNombreArtistico(), resultadoActual.getNombreArtistico());
        assertEquals(Artistaprueba.getGenero(), resultadoActual.getGenero());
        assertEquals(Artistaprueba.getFechaNacimiento(), resultadoActual.getFechaNacimiento());
        assertTrue("Dates aren't close enough to each other!",
                Math.abs(Artistaprueba.getFechaNacimiento().getTime() - resultadoActual.getFechaNacimiento().getTime()) < 1000);
    }

    /**
     * Test of crearArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
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
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
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
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testActualizarArtista() throws Exception {
        System.out.println("actualizarArtista");
        Artista artista = null;
        ArtistaDaoImpl instance = new ArtistaDaoImpl();
        instance.actualizarArtista(artista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
