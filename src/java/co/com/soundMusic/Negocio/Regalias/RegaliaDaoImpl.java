package co.com.soundMusic.Negocio.Regalias;

import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividadDaoImpl;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresaDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class RegaliaDaoImpl implements IRegaliaDao {

    private Connection conexion;
    private ArtistaEmpresaDaoImpl artistaEmpresaDao;
    private CostoActividadDaoImpl costoDao;

    public RegaliaDaoImpl() {
        conexion = DBUtil.getConexion();
        artistaEmpresaDao= new ArtistaEmpresaDaoImpl();
        costoDao=new CostoActividadDaoImpl();        
    }

    @Override
    public List<Regalia> obtenerRegalias() throws SQLException {
        List<Regalia> listaRegalias = new ArrayList<>();
        
        Statement stmt = conexion.createStatement();
        
        String sql="";
        
        ResultSet rs=stmt.executeQuery(sql);
        
        while (rs.next()){
            ///cod
                        
        }
        stmt.close();
        return listaRegalias;
    }

    @Override
    public Regalia obtenerRegalia(int idRegalia) throws SQLException {
        String sql="";
        
        PreparedStatement ps=conexion.prepareStatement(sql);
        ps.setInt(1, idRegalia);
        ResultSet rs= ps.executeQuery();
        
        while (rs.next()) {
            
            
        }
        return null;
    }

    @Override
    public void crearERegalia(Regalia regalia) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarRegalia(int idRegalia) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarRegalia(Regalia regalia) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
