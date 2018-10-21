package co.com.soundMusic.Negocio.Regalias;

import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividadDaoImpl;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresa;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresaDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class RegaliaDaoImpl implements IRegaliaDao {

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_REGALIAS;
    private static final String SELECT_REGALIA_POR_ID;
    private static final String INSERT_REGALIA;
    private static final String UPDATE_REGALIA;
    
    public RegaliaDaoImpl() {
        conexion = DBUtil.getConexion();
    }
    
    @Override
    public List<Regalia> obtenerRegalias() throws SQLException {
        List<Regalia> listaRegalias = new ArrayList<>();
        
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_REGALIAS);
        
        while (rs.next()) {
            int idRegalia = rs.getInt("ID_REGALIA");
            float totalGanado = rs.getFloat("TOTAL_GANADO");
            Timestamp fecha = rs.getTimestamp("FECHA");
            int idArtistaEmpresa = rs.getInt("ID_ARTISTA_EMPRESA");
            int idCosto = rs.getInt("ID_COSTO");
            
            Regalia regalia = new Regalia(idRegalia, totalGanado, idRegalia, fecha,
                    new ArtistaEmpresa(idArtistaEmpresa), new CostoActividad(idCosto));
            
            regalia.obtenerArtistaEmpresa();
            regalia.obtenerCosto();
            
            listaRegalias.add(regalia);
        }
        stmt.close();
        return listaRegalias;
    }
    
    @Override
    public Regalia obtenerRegalia(int idRegalia) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_REGALIA_POR_ID);
        ps.setInt(1, idRegalia);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            
            float totalGanado = rs.getFloat("TOTAL_GANADO");
            Timestamp fecha = rs.getTimestamp("FECHA");
            int idArtistaEmpresa = rs.getInt("ID_ARTISTA_EMPRESA");
            int idCosto = rs.getInt("ID_COSTO");
            Regalia regalia = new Regalia(idRegalia, totalGanado, idRegalia, fecha,
                    new ArtistaEmpresa(idArtistaEmpresa), new CostoActividad(idCosto));
            
            regalia.obtenerArtistaEmpresa();
            regalia.obtenerCosto();
            
            return regalia;
        }
        return null;
    }
    
    @Override
    public void crearERegalia(Regalia regalia) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_REGALIA);
        ps.setFloat(1, regalia.getTotalGanado());
        ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
        ps.setInt(3, regalia.getArtistaEmpresa().getIdArtistaEmpresa());
        ps.setInt(4, regalia.getCosto().getIdCostoActividad());
        ps.executeUpdate();
    }
    
    @Override
    public void actualizarRegalia(Regalia regalia) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_REGALIA);
        ps.setFloat(1, regalia.getTotalGanado());
        ps.setTimestamp(2, regalia.getFecha());
        ps.setInt(3, regalia.getArtistaEmpresa().getIdArtistaEmpresa());
        ps.setInt(4, regalia.getCosto().getIdCostoActividad());
        ps.setInt(5, regalia.getIdRegalia());
        ps.executeUpdate();
    }
    
    static {
        SELECT_REGALIAS = "SELECT ID_REGALIA, TOTAL_GANADO, FECHA, \n"
                + "ID_ARTISTA_EMPRESA, ID_COSTO"
                + "FROM REGALIA \n"
                + "ORDER BY ID_REGALIA";
        
        SELECT_REGALIA_POR_ID = "SELECT TOTAL_GANADO, FECHA, \n"
                + "ID_ARTISTA_EMPRESA, ID_COSTO \n"
                + "FROM REGALIA \n"
                + "WHERE ID_REGALIA=?";
        
        INSERT_REGALIA = "INSERT INTO REGALIA (TOTAL_GANADO, FECHA, \n"
                + "ID_ARTISTA_EMPRESA, ID_COSTO)\n"
                + "VALUES (?,?,?,?)";
        
        UPDATE_REGALIA = "UPDATE REGALIA \n"
                + "SET TOTAL_GANADO=?, FECHA=?, \n"
                + "ID_ARTISTA_EMPRESA=?, ID_COSTO=? \n"
                + "WHERE ID_REGALIA=?";
    }
}
