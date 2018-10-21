package co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.Contacto.Pais.Pais;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Ciudad {
    
    private int idCiudad;
    private String nombre;
    private Pais pais;
    private int idPais;
    
    public Ciudad(int idCiudad, String nombre, int idPais) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idPais = idPais;
    }
    
    public Ciudad(int idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }
    
    public int getIdCiudad() {
        return idCiudad;
    }
    
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdPais() {
        return idPais;
    }
    
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    public Pais getPais() {
        return pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public void obtenerPais() {
        PaisDaoImpl daoPais = new PaisDaoImpl();
        try {
            this.setPais(daoPais.obtenerPais(this.idPais));
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
