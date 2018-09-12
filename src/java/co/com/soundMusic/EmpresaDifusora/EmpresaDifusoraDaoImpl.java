package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividadDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusoraDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresaDifusoraDaoImpl implements IEmpresaDifusoraDao{
     private Connection conexion;
    private ContactoDaoImpl contacto;
    private CostoActividadDaoImpl costoOperacion;
    private TipoEmpresaDifusoraDaoImpl tipoActividad;

    private EmpresaDifusoraDaoImpl(){
        conexion = DBUtil.getConexion();
        contacto=new ContactoDaoImpl();
        costoOperacion=new CostoActividadDaoImpl();
        tipoActividad=new TipoEmpresaDifusoraDaoImpl();
    }

    @Override
    public List<EmpresaDifusora> obtenerEmpresasDifusoras() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpresaDifusora obtenerEmpresaDifusora(int idEmpresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEmpresaDifusora(String status, int idEmpresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
