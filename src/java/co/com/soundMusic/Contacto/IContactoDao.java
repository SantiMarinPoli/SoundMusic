package co.com.soundMusic.Contacto;


/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IContactoDao {

    Contacto obtenerContacto(int idContacto);

    void crearContacto(Contacto contacto);

    void actualizarContacto(Contacto contacto);
}
