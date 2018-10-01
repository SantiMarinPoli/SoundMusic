package co.com.soundMusic.Negocio.Logros.LogroArtista;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Meidna Peláez
 */
public class LogroArtistaDaoImpl implements ILogroArtistaDao {

    private Connection conexion;

    public LogroArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<LogroArtista> obtenerLogroArtista() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogroArtista obtenerLogroArtista(int idLogroArtista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearLogroArtista(LogroArtista logroArtista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarLogroArtista(int idLogroArtista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarLogroArtista(LogroArtista logroArtista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
