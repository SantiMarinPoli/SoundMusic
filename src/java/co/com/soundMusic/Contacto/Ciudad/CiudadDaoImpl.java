package co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CiudadDaoImpl implements ICiudadDao{
    private Connection conexion;
    private PaisDaoImpl pais;

    public CiudadDaoImpl() {
        conexion = DBUtil.getConexion();
        pais = new PaisDaoImpl();
    }

    @Override
    public List<Ciudad> obtenerCiudades() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ciudad obtenerCiudad(int idCiudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCiudad(Ciudad ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}