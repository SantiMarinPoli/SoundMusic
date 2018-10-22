package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ICostoActividadDao {

    CostoActividad obtenerCostoActividad(int idCostoActividad);

    void crearCostoActividad(CostoActividad costoActividad);

    void actualizarCostoActividad(CostoActividad costoActividad);

    void eliminarCostoActividad(CostoActividad costoActividad);

    int getUltimoIdCostoActividad();
}
