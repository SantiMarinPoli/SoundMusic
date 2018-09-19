package co.com.soundMusic.Contacto.Pais;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IPaisDao{
    
    List<Pais> obtenerPaises() throws SQLException;
    Pais obtenerPais(int idPais) throws SQLException;
    void crearPais(Pais pais) throws SQLException;
    void actualizarPais(Pais pais) throws SQLException;
}