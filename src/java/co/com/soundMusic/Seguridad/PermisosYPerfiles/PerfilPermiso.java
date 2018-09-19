package co.com.soundMusic.Seguridad.PermisosYPerfiles;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class PerfilPermiso {

    private int idPermisoPorPerfil;
    private int idPpermisos;
    private int idPerfil;

    public PerfilPermiso() {
    }

    public PerfilPermiso(int idPermisoPorPerfil, int idPpermisos, int idPerfil) {
        this.idPermisoPorPerfil = idPermisoPorPerfil;
        this.idPpermisos = idPpermisos;
        this.idPerfil = idPerfil;
    }

    public int getIdPermisoPorPerfil() {
        return idPermisoPorPerfil;
    }

    public void setIdPermisoPorPerfil(int idPermisoPorPerfil) {
        this.idPermisoPorPerfil = idPermisoPorPerfil;
    }

    public int getIdPpermisos() {
        return idPpermisos;
    }

    public void setIdPpermisos(int idPpermisos) {
        this.idPpermisos = idPpermisos;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

}
