package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ICostoActividadDao {
    List<CostoActividad> obtenerCostoActividad() throws SQLException;
    CostoActividad obtenerCostoActividad (int idCostoActividad) throws SQLException;
    void crearCostoActividad(CostoActividad costoActividad) throws SQLException;
    void eliminarCostoActividad (String status) throws SQLException;
    void actualizarCostoActividad (CostoActividad costoActividad) throws SQLException;
}
