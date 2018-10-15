package co.com.soundMusic.Negocio.Regalias;
 import java.sql.SQLException;
import java.util.List;
 /**
 *
 * @author Santiago Medina Pelaez
 */
public interface IRegaliaDao {
     List<Regalia> obtenerRegalias() throws SQLException;
     Regalia obtenerRegalia(int idRegalia) throws SQLException;
     void crearERegalia(Regalia regalia) throws SQLException;
     void actualizarRegalia(Regalia regalia) throws SQLException;
}