package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.Pais.Pais;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaDaoImplTest {

    ArtistaDaoImpl daoArtista;
    Artista artistaPrueba, artistaPruebaAct;
    List<Artista> pruebaLstArtista;
    Contacto contacto;
    Ciudad ciudad;
    Pais pais;

    public ArtistaDaoImplTest() {
    }

    @Before
    public void setUp() throws SQLException {
        pais = new Pais(1, "COLOMBIA");
        ciudad = new Ciudad(1, "MEDELLIN", pais);

        String[] datosContacto = {"3164349117", "5836395", "MI CASA", "MI BARRIO", "SANMEDI@45.COM"};
        contacto = new Contacto(1, datosContacto, ciudad);
        daoArtista = new ArtistaDaoImpl();
        String[] datosArtista = {"SANTIAGO", null, "MEDINA", "PELAEZ", "MC DINA", "M", "A"};
        Date[] fechasArtista = {Date.valueOf("1992-06-01"), Date.valueOf(LocalDate.now())};

        artistaPrueba = new Artista(1, datosArtista, fechasArtista, contacto);

        String[] datosArtistaAct = {"MELANY", null, "PALACIOS", "FONNEGRA", "MELY P", "F", "A"};
        Date[] fechasArtistaAct = {Date.valueOf("1992-08-01"), Date.valueOf(LocalDate.now())};
        artistaPruebaAct = new Artista(7, datosArtistaAct, fechasArtistaAct, contacto);
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
        List<Artista> resultadoEsperado = null;
        List<Artista> resultadoActual = daoArtista.obtenerArtistas();
        assertFalse(resultadoActual.isEmpty());
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
        assertEquals(artistaPrueba.getIdArtista(), resultadoActual.getIdArtista());
        assertEquals(artistaPrueba.getPrimerNombre(), resultadoActual.getPrimerNombre());
        assertEquals(artistaPrueba.getSegundoNombre(), resultadoActual.getSegundoNombre());
        assertEquals(artistaPrueba.getPrimerApellido(), resultadoActual.getPrimerApellido());
        assertEquals(artistaPrueba.getSegundoApellido(), resultadoActual.getSegundoApellido());
        assertEquals(artistaPrueba.getNombreArtistico(), resultadoActual.getNombreArtistico());
        assertEquals(artistaPrueba.getGenero(), resultadoActual.getGenero());
        assertEquals(artistaPrueba.getFechaNacimiento(), resultadoActual.getFechaNacimiento());
        assertTrue("Dates aren't close enough to each other!", Math.abs(
                artistaPrueba.getFechaNacimiento().getTime() - resultadoActual.getFechaNacimiento().getTime()) < 1000);
    }

    /**
     * Test of crearArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCrearArtista() throws Exception {
        System.out.println("crearArtista");
        daoArtista.crearArtista(artistaPrueba);
        int idArtistaPrueba = daoArtista.getUltimmoIdArtista();
        Artista artistaEsperado = artistaPrueba;
        artistaEsperado.setIdArtista(idArtistaPrueba);
        Artista artistaActual = daoArtista.obtenerArtista(idArtistaPrueba);

        assertEquals(artistaEsperado, artistaActual);
    }

    /**
     * Test of eliminarArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEliminarArtista() throws Exception {
        System.out.println("eliminarArtista");
        String status = "I";
        int idArtista = 6;
        Artista artistaPruebaElim = artistaPrueba;
        artistaPruebaElim.setStatus("I");
        artistaPruebaElim.setIdArtista(idArtista);
        daoArtista.eliminarArtista(status, idArtista);
        Artista resultadoActual = daoArtista.obtenerArtista(idArtista);

        assertEquals(artistaPruebaElim, resultadoActual);
    }

    /**
     * Test of actualizarArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test    
    public void testActualizarArtista() throws Exception {
        System.out.println("actualizarArtista");

        daoArtista.actualizarArtista(artistaPruebaAct);
        Artista resultadoActual = daoArtista.obtenerArtista(7);

        assertEquals(artistaPruebaAct, resultadoActual);
    }

    /**
     * Test of GetUltimmoIdArtista method, of class ArtistaDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUltimmoIdArtista() throws Exception {
        System.out.println("getUltimmoIdArtista");

        daoArtista.crearArtista(artistaPrueba);
        pruebaLstArtista = daoArtista.obtenerArtistas();
        int resultadoEsperado = pruebaLstArtista.get(pruebaLstArtista.size() - 1).getIdArtista();
        int resultadoActual = daoArtista.getUltimmoIdArtista();

        assertEquals(resultadoEsperado, resultadoActual);
    }
}
