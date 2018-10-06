package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ICostoActividadDao {    
    CostoActividad obtenerCostoActividad (int idCostoActividad) throws SQLException;
    void crearCostoActividad(CostoActividad costoActividad) throws SQLException;    
    void actualizarCostoActividad (CostoActividad costoActividad) throws SQLException;
    int getUltimoIdCostoActividad() throws SQLException;
}
