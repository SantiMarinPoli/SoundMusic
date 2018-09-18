package co.com.soundMusic.Contacto.Ciudad;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ICiudadDao{
    List<Ciudad> obtenerCiudades() throws SQLException;
    Ciudad obtenerCiudad(int idCiudad) throws SQLException;
    void crearCiudad(Ciudad ciudad) throws SQLException;    
    void actualizarCiudad (Ciudad ciudad) throws SQLException;
}