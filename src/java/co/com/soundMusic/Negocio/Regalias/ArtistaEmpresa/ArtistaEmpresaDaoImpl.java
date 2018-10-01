package co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaEmpresaDaoImpl implements IArtistaEmpresaDao {

    private Connection conexion;

    public ArtistaEmpresaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<ArtistaEmpresa> obtenerTodoArtistaEmpresa() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArtistaEmpresa obtenerArtistaEmpresa(int idArtistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearArtistaEmpresa(ArtistaEmpresa artistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarArtistaEmpresa(int idArtistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarArtistaEmpresa(ArtistaEmpresa artistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
