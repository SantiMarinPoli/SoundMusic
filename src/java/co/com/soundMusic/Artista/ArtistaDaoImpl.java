package co.com.soundMusic.Artista;

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
 * @author sanme
 */
public class ArtistaDaoImpl implements IArtistaDao {

    private Connection conexion;

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Artista> obtenerArtistas() throws SQLException {
        List<Artista> listaArtistas = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "";

        ResultSet rs = stmt.executeQuery(sql);

        // Se avanza el cursor de a una fila 
        // Cuando se alcalza el fin del cursor, la funcion retorna false
        while (rs.next()) {
            //Codigo para guardar los datos de las filas en 
            //modelo artistas y agregar a la arraylist
        }

        stmt.close();
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(0, idArtista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            //Codigo para guardar los datos de la consulta en
            //un objeto artista

        }
        Artista artista = new Artista();
        return artista;
    }

    @Override
    public void crearArtista(Artista artista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        //Codigo para guardar cada parametro de artista en el
        // ps: ps.setString(1, artista.getidArtista());
        ps.executeUpdate();
    }

    @Override
    public void eliminarArtista(int idArtista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ps.executeUpdate();
    }

    @Override
    public void actualizarArtista(Artista artista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        //Codigo para guardar cada parametro de artista en el
        // ps: ps.setString(1, artista.getidArtista());
        ps.executeUpdate();
    }
}
