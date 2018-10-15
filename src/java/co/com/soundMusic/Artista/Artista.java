package co.com.soundMusic.Artista;

import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresaDaoImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Artista {

    private int idArtista;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreArtistico;
    private String genero;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String status;
    private String rutaImagen;
    private int idContacto;

    public Artista(int idArtista, String[] datosArtista, Date[] fechasArtista, int idContacto) {
        this.idArtista = idArtista;
        this.primerNombre = datosArtista[0];
        this.segundoNombre = datosArtista[1];
        this.primerApellido = datosArtista[2];
        this.segundoApellido = datosArtista[3];
        this.nombreArtistico = datosArtista[4];
        this.genero = datosArtista[5];
        this.fechaNacimiento = fechasArtista[0];
        this.fechaCreacion = fechasArtista[1];
        this.status = datosArtista[6];
        this.rutaImagen = datosArtista[7];
        this.idContacto = idContacto;
    }

    public Artista() {
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idArtista;
        hash = 47 * hash + Objects.hashCode(this.nombreArtistico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artista other = (Artista) obj;
        if (this.idArtista != other.idArtista) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        return true;
    }

    public List<String> getNumeroEmpresas() {
        List<String> nombreEmpresas = new ArrayList<>();
        ArtistaEmpresaDaoImpl daoArtistaEmpresa = new ArtistaEmpresaDaoImpl();
        List<EmpresaDifusora> lstEmpresas = new ArrayList<>();
        try {
            lstEmpresas = daoArtistaEmpresa.obtenerEmpresas(idArtista);

        } catch (SQLException ex) {
            Logger.getLogger(Artista.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (EmpresaDifusora empDif : lstEmpresas) {
            nombreEmpresas.add(empDif.getNombre());
        }
        return nombreEmpresas;
    }
}
