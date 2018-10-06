package co.com.soundMusic.Login.Usuario;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
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
public class UsuarioDaoImplTest {

    UsuarioDaoImpl daoUsuario;
    Usuario usuarioPruebaAct;
    List<Usuario> pruebaLstUsuario;

    public UsuarioDaoImplTest() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        daoUsuario = new UsuarioDaoImpl();

        usuarioPruebaAct = new Usuario(1, "MELAY", null, "PALACIO", "FEONNEGRA", Date.valueOf("2018-05-05"),
                "A", "F", 1, 1, 1);
    }

    /**
     * Test of obtenerUsuarios method, of class UsuarioDaoImpl.
     *
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.sql.SQLException
     */
    @Test
    public void testObtenerUsuarios() throws InvocationTargetException,SQLException {
        System.out.println("obtenerUsuarios");
        List<Usuario> resultadoActual = daoUsuario.obtenerUsuarios();
        assertFalse(resultadoActual.isEmpty());
    }

    /**
     * Test of obtenerUsuario method, of class UsuarioDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testObtenerUsuario() throws Exception {
        System.out.println("obtenerUsuario");
        int idUsuario = 1;
        Usuario usuarioPrueba = new Usuario(1, "SANTIAGO", null, "MEDINA", "PELAEZ", Date.valueOf("2018-05-05"),
                "A", "M", 1, 1, 1);
        Usuario resultadoActual = daoUsuario.obtenerUsuario(idUsuario);
        assertEquals(usuarioPrueba, resultadoActual);
    }

    /**
     * Test of crearUsuario method, of class UsuarioDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testCrearUsuario() throws Exception {
        /*System.out.println("crearUsuario");
        daoUsuario.crearUsuario(usuarioPrueba);
        int idUsuarioPrueba = daoUsuario.getUltimoIdUsuario();
        Usuario usuarioEsperado = usuarioPrueba;
        usuarioEsperado.setIdUsuario(idUsuarioPrueba);
        Usuario usuarioActual = daoUsuario.obtenerUsuario(idUsuarioPrueba);

        assertEquals(usuarioEsperado, usuarioActual);*/
    }

    /**
     * Test of eliminarUsuario method, of class UsuarioDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testEliminarUsuario() throws Exception {
        /*System.out.println("eliminarUsuario");
        String status = "I";
        int idUsuario = 1;
        Usuario usuarioPruebaElim = usuarioPrueba;
        usuarioPruebaElim.setStatus("I");
        daoUsuario.eliminarUsuario(status, idUsuario);
        Usuario resultadoActual = daoUsuario.obtenerUsuario(idUsuario);

        assertEquals(usuarioPruebaElim, resultadoActual);*/
    }

    /**
     * Test of actualizarUsuario method, of class UsuarioDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    @Ignore
    public void testActualizarUsuario() throws Exception {
        /* System.out.println("actualizarUsuario");

        daoUsuario.actualizarUsuario(usuarioPruebaAct);
        Usuario resultadoActual = daoUsuario.obtenerUsuario(1);

        assertEquals(usuarioPruebaAct, resultadoActual);*/
    }

}
