package co.com.soundMusic.Negocio.Logros.LogroArtista;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Meidna Peláez
 */
public interface ILogroArtistaDao {

    List<LogroArtista> obtenerLogroArtista() throws SQLException;

    LogroArtista obtenerLogroArtista(int idLogroArtista) throws SQLException;

    void crearLogroArtista(LogroArtista logroArtista) throws SQLException;

    void eliminarLogroArtista(int idLogroArtista) throws SQLException;

    void actualizarLogroArtista(LogroArtista logroArtista) throws SQLException;
}
