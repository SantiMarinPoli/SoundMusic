package co.com.soundMusic.Negocio.Regalias;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresa;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author medinas
 */
public class RegaliaTest {

    ArtistaEmpresa artistaEmpresa;
    Artista artista;
    Contacto contacto;
    EmpresaDifusora empresaDifusora;
    CostoActividad costo;

    public RegaliaTest() {
    }

    @Before
    public void setUp() throws SQLException,InvocationTargetException {
        String[] datosArtista = {"SANTIAGO", null, "MEDINA", "PELAEZ", "MC DINA", "M", "A"};
        Date[] fechasArtista = {Date.valueOf("1992-06-01"), Date.valueOf(LocalDate.now())};

        artista = new Artista(1, datosArtista, fechasArtista, 1);

        empresaDifusora = new EmpresaDifusora(1, "YOUTUBE", Date.valueOf("2018-06-01"), null, "A",null ,1, 1, 1);
        artistaEmpresa = new ArtistaEmpresa(1, artista, empresaDifusora);

        costo = new CostoActividad(1, 10, Date.valueOf("2018-08-08"), null);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcularRegalias method, of class Regalia.
     */
    @Test
    public void testCalcularRegalias() {
        System.out.println("calcularRegalias");
        Regalia regaliaPrueba = new Regalia(1, 0.0f, 10, Date.valueOf("2018-08-05"), artistaEmpresa, costo);
        float resultadoEsperado = 100F;
        float resultadoActual = regaliaPrueba.calcularRegalias();
        assertEquals(resultadoEsperado, resultadoActual, 0.0);
    }

}
