package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ICostoActividadDao {

    CostoActividad obtenerCostoActividad(int idCostoActividad) throws SQLException;

    void crearCostoActividad(CostoActividad costoActividad) throws SQLException;

    void actualizarCostoActividad(CostoActividad costoActividad) throws SQLException;

    void eliminarCostoActividad(CostoActividad costoActividad) throws SQLException;

    int getUltimoIdCostoActividad() throws SQLException;
}
