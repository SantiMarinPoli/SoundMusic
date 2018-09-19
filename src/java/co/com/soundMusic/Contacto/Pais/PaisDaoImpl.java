package co.com.soundMusic.Contacto.Pais;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class PaisDaoImpl implements IPaisDao {

    private Connection conexion;

    public PaisDaoImpl() {
        conexion = DBUtil.getConexion();
    }
}
