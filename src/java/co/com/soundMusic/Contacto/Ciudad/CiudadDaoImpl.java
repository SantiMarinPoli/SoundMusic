package java.co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.utilidades.DBUtil;

import java.co.com.soundMusic.Contacto.Pais.PaisDaoImp;
import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CiudadDaoImpl {
    private Connection conexion;
    private PaisDaoImp pais;

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
        pais = new PaisDaoImp();
    }

    @Override
    public List<Ciudad> obtenerCiudades() throws SQLException{

    }

    @Override
    public Contacto obtenerCiudad(int idCiudad) throws SQLException{

    }

    @Override
    public void crearCiudad(Ciudad ciudad) throws SQLException{

    }

    @Override
    public void actualizarCiudad (Ciudad ciudad) throws SQLException{

    }
}