package co.com.soundMusic.EmpresaDifusora;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IEmpresaDifusoraDao {
    List<EmpresaDifusora> obtenerEmpresasDifusoras () throws SQLException;
    EmpresaDifusora obtenerEmpresaDifusora (int idEmpresaDifusora) throws SQLException;
    void crearEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException;
    void eliminarEmpresaDifusora (String status, int idEmpresaDifusora) throws SQLException;
    void actualizarEmpresaDifusora (EmpresaDifusora empresaDifusora) throws SQLException;
}
