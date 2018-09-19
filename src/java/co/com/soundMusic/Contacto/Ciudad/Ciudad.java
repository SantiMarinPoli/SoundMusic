package co.com.soundMusic.Contacto.Ciudad;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Ciudad {
    private int idCiudad;
    private String nombre;
    private int idPais;

    public Ciudad(int idCiudad, String nombre, int idPais) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.idPais = idPais;
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

    public void setPais(int idPais) {
        this.idPais = idPais;
    }
}
