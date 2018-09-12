package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ITipoEmpresaDifusoraDao {
    List<TipoEmpresaDifusora> obtenerTipoEmpresaDifusora() throws SQLException;
    TipoEmpresaDifusora obtenerTipoEmpresaDifusora(int idTipoEmpresaDifusora) throws SQLException;
    void crearArtista (TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException;
    void eliminarTipoEmpresaDifusora (String status) throws SQLException;
    void actualizarTipoEmpresaDifusora (TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException;
}
