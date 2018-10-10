package co.com.soundMusic.Seguridad.Permisos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IPermisosDao {

    List<Permisos> obtenerPermisos() throws SQLException;

    public Permisos obtenerPermiso(int idPermisos) throws SQLException;

    public void crearPermiso(Permisos permisos) throws SQLException;

    public void actualizarPermiso(Permisos permisos) throws SQLException;

    public void eliminarPermiso(int idPermiso) throws SQLException;
}
