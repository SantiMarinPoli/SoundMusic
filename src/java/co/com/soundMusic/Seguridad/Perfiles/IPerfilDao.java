package co.com.soundMusic.Seguridad.Perfiles;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IPerfilDao {

    List<Perfil> obtenerPerfiles() throws SQLException;
    Perfil obtenerPerfil(int idPerfil) throws SQLException;
    void crearPerfil(Perfil perfil) throws SQLException;
    void actualizarArtista (Perfil perfil) throws SQLException;
}
