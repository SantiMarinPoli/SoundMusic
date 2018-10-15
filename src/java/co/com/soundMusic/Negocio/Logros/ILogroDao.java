package co.com.soundMusic.Negocio.Logros;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ILogroDao {

    List<Logro> obtenerLogros() throws SQLException;

    Logro obtenerLogro(int idLogro) throws SQLException;

    void crearLogro(Logro logro) throws SQLException;

    void eliminarLogro(Logro logro) throws SQLException;

    void actualizarLogro(Logro logro) throws SQLException;

}
