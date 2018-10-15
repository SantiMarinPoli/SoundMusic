package co.com.soundMusic.EmpresaDifusora.TipoCosto;

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
public class TipoEmpresaDifusoraDaoImpl implements ITipoEmpresaDifusoraDao {

//Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_TIPOS_EMPRESAS;
    private static final String SELECT_TIPO_EMPRESA_POR_ID;
    private static final String INSERT_TIPO_EMPRESA;
    private static final String UPDATE_TIPO_EMPRESA;
    
    public TipoEmpresaDifusoraDaoImpl() {
        conexion = DBUtil.getConexion();
    }
    
    @Override
    public List<TipoEmpresaDifusora> obtenerTipoEmpresaDifusora() throws SQLException {
        List<TipoEmpresaDifusora> lstTipoEmpresa = new ArrayList<>();
        
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_TIPOS_EMPRESAS);
        
        while (rs.next()) {
            int idTipoEmpresaDifusora = rs.getInt("ID_TIPO_ACTIVIDAD");
            String tipoActividad = rs.getString("NOMBRE");
            
            TipoEmpresaDifusora tipoEmpresa = new TipoEmpresaDifusora(idTipoEmpresaDifusora, tipoActividad);
            
            lstTipoEmpresa.add(tipoEmpresa);
        }
        
        stmt.close();
        return lstTipoEmpresa;
    }
    
    @Override
    public TipoEmpresaDifusora obtenerTipoEmpresaDifusora(int idTipoEmpresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_TIPO_EMPRESA_POR_ID);
        
        ps.setInt(1, idTipoEmpresaDifusora);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tipoActividad = rs.getString("NOMBRE");
            
            TipoEmpresaDifusora tipoEmpresa = new TipoEmpresaDifusora(idTipoEmpresaDifusora, tipoActividad);
            
            return tipoEmpresa;
        }
        return null;
    }
    
    @Override
    public void crearArtista(TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_TIPO_EMPRESA);
        ps.setString(1, tipoEmpresaDifusora.getTipoActividad());
        ps.executeUpdate();
    }
    
    @Override
    public void actualizarTipoEmpresaDifusora(TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_TIPO_EMPRESA);
        ps.setString(1, tipoEmpresaDifusora.getTipoActividad());
        ps.setInt(2, tipoEmpresaDifusora.getIdTipoActividad());
        ps.executeUpdate();
    }
    
    static {
        SELECT_TIPOS_EMPRESAS = "SELECT ID_TIPO_ACTIVIDAD, NOMRE \n"
                + "FROM TIPO_ACTIVIDAD \n"
                + "ORDER BY ID_TIPO_ACTIVIDAD";
        
        SELECT_TIPO_EMPRESA_POR_ID = "SELECT NOMRE \n"
                + "FROM TIPO_ACTIVIDAD \n"
                + "WHERE ID_TIPO_ACTIVIDAD=?";
        
        INSERT_TIPO_EMPRESA = "INSERT INTO TIPO_ACTIVIDAD (NOMBRE)\n"
                + "VALUES(?)";
        
        UPDATE_TIPO_EMPRESA = "UPDATE TIPO_ACTIVIDAD\n"
                + "SET NOMBRE=? \n"
                + "WHERE ID_TIPO_ACTIVIDAD=?";
    }
}
