package co.com.soundMusic.Contacto;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Contacto {

    private int idContacto;
    private String celular;
    private String telefono;
    private String direccion;
    private String barrio;
    private String email;
    private int idCiudad;
    private Ciudad ciudad;

    public Contacto() {
    }

    public Contacto(int idContacto, String[] datosContacto, int idCiudad) {
        this.idContacto = idContacto;
        this.celular = datosContacto[0];
        this.telefono = datosContacto[1];
        this.direccion = datosContacto[2];
        this.barrio = datosContacto[3];
        this.email = datosContacto[4];
        this.idCiudad = idCiudad;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void obtenerCiudad() {
        CiudadDaoImpl daoCiudad = new CiudadDaoImpl(true);
        this.setCiudad(daoCiudad.obtenerCiudad(this.idCiudad));
    }
}
