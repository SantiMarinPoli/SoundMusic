package co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa;

import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IArtistaEmpresaDao {

    List<ArtistaEmpresa> obtenerTodoArtistaEmpresa();

    List<ArtistaEmpresa> obtenerNumeroDeArtistas(int idEmpresaDifusora);

    List<String> obtenerEmpresas(int idArtista);

    ArtistaEmpresa obtenerArtistaEmpresa(int idArtistaEmpresa);

    void crearArtistaEmpresa(ArtistaEmpresa artistaEmpresa);

    void actualizarArtistaEmpresa(ArtistaEmpresa artistaEmpresa);
}
