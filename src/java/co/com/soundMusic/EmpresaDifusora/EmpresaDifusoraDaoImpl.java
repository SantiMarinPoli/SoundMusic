package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusora;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresaDifusoraDaoImpl implements IEmpresaDifusoraDao {

    //Conexion a la base de datos
    private final Connection conexion;

    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_EMPRESAS;
    private static final String SELECT_EMPRESA_POOR_ID;
    private static final String INSERT_EMPRESA;
    private static final String UPDATE_STATUS;
    private static final String UPDATE_EMPRSA;
    private static final String SELECT_ULTIMO_ID;

    public EmpresaDifusoraDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public List<EmpresaDifusora> obtenerEmpresasDifusoras() {
        List<EmpresaDifusora> listaEmpresasDifusora = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_EMPRESAS);

            while (rs.next()) {
                EmpresaDifusora empresaDifusora = new EmpresaDifusora();
                Contacto contacto = new Contacto();
                TipoEmpresaDifusora tipoActividad = new TipoEmpresaDifusora();
                CostoActividad costoOperacion = new CostoActividad();
                Pais pais = new Pais();
                Ciudad ciudad = new Ciudad();
                //Crear Pais
                pais.setIdPais(rs.getInt("PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                //Crear Ciudad
                ciudad.setIdCiudad(rs.getInt("CIUDAD"));
                ciudad.setNombre(rs.getString("NOMBRE_CIUDAD"));
                ciudad.setPais(pais);
                //Crear Contacto
                contacto.setIdContacto(rs.getInt("CONTACTO"));
                contacto.setCelular(rs.getString("CELULAR"));
                contacto.setTelefono(rs.getString("TELEFONO"));
                contacto.setDireccion(rs.getString("DIRECCION"));
                contacto.setBarrio(rs.getString("BARRIO"));
                contacto.setEmail(rs.getString("EMAIL"));
                contacto.setCiudad(ciudad);
                //Crear Tipo Empres Difusora
                tipoActividad.setIdTipoActividad(rs.getInt("TIPO_ACTIVIDAD"));
                tipoActividad.setTipoActividad(rs.getString("NOMBRE_ACTIVIDAD"));
                //Crear CostoActividad
                costoOperacion.setIdCostoActividad(rs.getInt("COSTO"));
                costoOperacion.setCostoPorOperacion(rs.getFloat("COSTO_OPERACION"));
                costoOperacion.setFechaCreacion(rs.getDate("COSTO_CREACION"));
                costoOperacion.setFechaUsoFinal(rs.getDate("COSTO_FECHA_FINAL"));

                empresaDifusora.setIdEmpresaDifusora(rs.getInt("ID_EMPRESA_DIFUSORA"));
                empresaDifusora.setNombre(rs.getString("NOMBRE"));
                empresaDifusora.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                empresaDifusora.setFechaTerminacion(rs.getDate("FECHA_TERMINACION"));
                empresaDifusora.setStatus(rs.getString("STATUS"));
                empresaDifusora.setRutaImagen(rs.getString("RUTA_IMAGEN"));
                empresaDifusora.setContacto(contacto);
                empresaDifusora.setCostoOperacion(costoOperacion);
                empresaDifusora.setTipoActividad(tipoActividad);

                listaEmpresasDifusora.add(empresaDifusora);
            }

        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(stmt);
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaEmpresasDifusora;
    }

    @Override
    public EmpresaDifusora obtenerEmpresaDifusora(int idEmpresaDifusora) {
        EmpresaDifusora empresaDifusora = new EmpresaDifusora();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_EMPRESA_POOR_ID);
            ps.setInt(1, idEmpresaDifusora);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contacto contacto = new Contacto();
                TipoEmpresaDifusora tipoActividad = new TipoEmpresaDifusora();
                CostoActividad costoOperacion = new CostoActividad();
                Pais pais = new Pais();
                Ciudad ciudad = new Ciudad();
                //Crear Pais
                pais.setIdPais(rs.getInt("PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                //Crear Ciudad
                ciudad.setIdCiudad(rs.getInt("CIUDAD"));
                ciudad.setNombre(rs.getString("NOMBRE_CIUDAD"));
                ciudad.setPais(pais);
                //Crear Contacto
                contacto.setIdContacto(rs.getInt("CONTACTO"));
                contacto.setCelular(rs.getString("CELULAR"));
                contacto.setTelefono(rs.getString("TELEFONO"));
                contacto.setDireccion(rs.getString("DIRECCION"));
                contacto.setBarrio(rs.getString("BARRIO"));
                contacto.setEmail(rs.getString("EMAIL"));
                contacto.setCiudad(ciudad);
                //Crear Tipo Empres Difusora
                tipoActividad.setIdTipoActividad(rs.getInt("TIPO_ACTIVIDAD"));
                tipoActividad.setTipoActividad(rs.getString("NOMBRE_ACTIVIDAD"));
                //Crear CostoActividad
                costoOperacion.setIdCostoActividad(rs.getInt("COSTO"));
                costoOperacion.setCostoPorOperacion(rs.getFloat("COSTO_OPERACION"));
                costoOperacion.setFechaCreacion(rs.getDate("COSTO_CREACION"));
                costoOperacion.setFechaUsoFinal(rs.getDate("COSTO_FECHA_FINAL"));

                empresaDifusora.setIdEmpresaDifusora(idEmpresaDifusora);
                empresaDifusora.setNombre(rs.getString("NOMBRE"));
                empresaDifusora.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                empresaDifusora.setFechaTerminacion(rs.getDate("FECHA_TERMINACION"));
                empresaDifusora.setStatus(rs.getString("STATUS"));
                empresaDifusora.setRutaImagen(rs.getString("RUTA_IMAGEN"));
                empresaDifusora.setContacto(contacto);
                empresaDifusora.setCostoOperacion(costoOperacion);
                empresaDifusora.setTipoActividad(tipoActividad);

                return empresaDifusora;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empresaDifusora;
    }

    @Override
    public void crearEmpresaDifusora(EmpresaDifusora empresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_EMPRESA);

            ps.setString(1, empresaDifusora.getNombre());
            ps.setDate(2, empresaDifusora.getFechaCreacion());
            ps.setDate(3, empresaDifusora.getFechaTerminacion());
            ps.setString(4, empresaDifusora.getStatus());
            ps.setString(5, empresaDifusora.getRutaImagen());
            ps.setInt(6, empresaDifusora.getIdTipoActividad());
            ps.setInt(7, empresaDifusora.getIdContacto());
            ps.setInt(8, empresaDifusora.getIdCostoOperacion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminarEmpresaDifusora(String status, int idEmpresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
            ps.setString(1, status);
            ps.setInt(2, idEmpresaDifusora);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actualizarEmpresaDifusora(EmpresaDifusora empresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_EMPRSA);

            ps.setString(1, empresaDifusora.getNombre());
            ps.setDate(2, empresaDifusora.getFechaTerminacion());
            ps.setString(3, empresaDifusora.getStatus());
            ps.setString(4, empresaDifusora.getRutaImagen());
            ps.setInt(5, empresaDifusora.getIdTipoActividad());
            ps.setInt(6, empresaDifusora.getIdContacto());
            ps.setInt(7, empresaDifusora.getIdCostoOperacion());
            ps.setInt(8, empresaDifusora.getIdEmpresaDifusora());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getUltimoIdEmpresaDifusora() {
        int idEmpresaDifusora = -1;
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                idEmpresaDifusora = rs.getInt("CURRVAL");
                return idEmpresaDifusora;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(EmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idEmpresaDifusora;
    }

    static {
        SELECT_EMPRESAS = "SELECT EMDI.ID_EMPRESA_DIFUSORA,EMDI.NOMBRE,EMDI.FECHA_CREACION, \n"
                + "EMDI.FECHA_TERMINACION,EMDI.STATUS,EMDI.RUTA_IMAGEN, \n"
                + "EMDI.ID_TIPO_ACTIVIDAD AS TIPO_ACTIVIDAD, EMDI.ID_CONTACTO AS CONTACTO, \n"
                + "EMDI.ID_COSTO_ACTIVIDAD AS COSTO,CONT.CELULAR AS CELULAR, \n"
                + "CONT.TELEFONO AS TELEFONO,CONT.DIRECCION AS DIRECCION, \n"
                + "CONT.BARRIO AS BARRIO, CONT.EMAIL AS EMAIL, \n"
                + "CIU.ID_CIUDAD AS CIUDAD,CIU.NOMBRE AS NOMBRE_CIUDAD,\n"
                + "PA.ID_PAIS AS PAIS, PA.NOMBRE AS NOMBRE_PAIS,TIPACT.NOMBRE AS NOMBRE_ACTIVIDAD,\n"
                + "COSACT.COSTO_POR_OPERACION AS COSTO_OPERACION,COSACT.FECHA_CREACION AS COSTO_CREACION,\n"
                + "COSACT.FECHA_USO_FINAL AS COSTO_FECHA_FINAL \n"
                + "FROM EMPRESA_DIFUSORA EMDI INNER JOIN CONTACTO CONT \n"
                + "ON EMDI.ID_CONTACTO = CONT.ID_CONTACTO \n"
                + "INNER JOIN CIUDAD CIU \n"
                + "ON CONT.ID_CIUDAD = CIU.ID_CIUDAD \n"
                + "INNER JOIN PAIS PA \n"
                + "ON CIU.ID_PAIS = PA.ID_PAIS \n"
                + "INNER JOIN TIPO_ACTIVIDAD TIPACT \n"
                + "ON EMDI.ID_TIPO_ACTIVIDAD = TIPACT.ID_TIPO_ACTIVIDAD \n"
                + "INNER JOIN COSTO_ACTIVITIDAD COSACT \n"
                + "ON EMDI.ID_COSTO_ACTIVIDAD = COSACT.ID_COSTO_ACTIVIDAD \n"
                + "ORDER BY ID_EMPRESA_DIFUSORA";

        SELECT_EMPRESA_POOR_ID = "SELECT EMDI.NOMBRE,EMDI.FECHA_CREACION, \n"
                + "EMDI.FECHA_TERMINACION,EMDI.STATUS,EMDI.RUTA_IMAGEN, \n"
                + "EMDI.ID_TIPO_ACTIVIDAD AS TIPO_ACTIVIDAD, EMDI.ID_CONTACTO AS CONTACTO, \n"
                + "EMDI.ID_COSTO_ACTIVIDAD AS COSTO,CONT.CELULAR AS CELULAR, \n"
                + "CONT.TELEFONO AS TELEFONO,CONT.DIRECCION AS DIRECCION, \n"
                + "CONT.BARRIO AS BARRIO, CONT.EMAIL AS EMAIL, \n"
                + "CIU.ID_CIUDAD AS CIUDAD,CIU.NOMBRE AS NOMBRE_CIUDAD,\n"
                + "PA.ID_PAIS AS PAIS, PA.NOMBRE AS NOMBRE_PAIS,TIPACT.NOMBRE AS NOMBRE_ACTIVIDAD,\n"
                + "COSACT.COSTO_POR_OPERACION AS COSTO_OPERACION,COSACT.FECHA_CREACION AS COSTO_CREACION,\n"
                + "COSACT.FECHA_USO_FINAL AS COSTO_FECHA_FINAL \n"
                + "FROM EMPRESA_DIFUSORA EMDI INNER JOIN CONTACTO CONT \n"
                + "ON EMDI.ID_CONTACTO = CONT.ID_CONTACTO \n"
                + "INNER JOIN CIUDAD CIU \n"
                + "ON CONT.ID_CIUDAD = CIU.ID_CIUDAD \n"
                + "INNER JOIN PAIS PA \n"
                + "ON CIU.ID_PAIS = PA.ID_PAIS \n"
                + "INNER JOIN TIPO_ACTIVIDAD TIPACT \n"
                + "ON EMDI.ID_TIPO_ACTIVIDAD = TIPACT.ID_TIPO_ACTIVIDAD \n"
                + "INNER JOIN COSTO_ACTIVITIDAD COSACT \n"
                + "ON EMDI.ID_COSTO_ACTIVIDAD = COSACT.ID_COSTO_ACTIVIDAD \n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        INSERT_EMPRESA = "INSERT INTO EMPRESA_DIFUSORA (NOMBRE,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "RUTA_IMAGEN, ID_TIPO_ACTIVIDAD, ID_CONTACTO, ID_COSTO_ACTIVIDAD)\n"
                + "VALUES (?,?,?,?,?,?,?,?)";

        UPDATE_STATUS = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET STATUS=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        UPDATE_EMPRSA = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET NOMBRE=?,FECHA_TERMINACION=?,STATUS=?,RUTA_IMAGEN=?,\n"
                + "ID_TIPO_ACTIVIDAD=?, ID_CONTACTO=?, ID_COSTO_ACTIVIDAD=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        SELECT_ULTIMO_ID = "SELECT EMPRESA_DIFUSORA_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}
