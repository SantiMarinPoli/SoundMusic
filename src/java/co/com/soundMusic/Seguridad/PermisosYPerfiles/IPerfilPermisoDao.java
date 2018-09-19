package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IPerfilPermisoDao {

    List<PerfilPermiso> obtenePerfilPermisos() throws SQLException;
    List<PerfilPermiso> obtenerPermisosDePerfil (int idPerfil) throws SQLException;

}