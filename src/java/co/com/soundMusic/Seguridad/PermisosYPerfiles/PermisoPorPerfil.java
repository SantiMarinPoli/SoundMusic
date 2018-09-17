package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import co.com.soundMusic.Seguridad.Permisos.Permisos;
import co.com.soundMusic.Seguridad.Perfiles.Perfil;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class PermisoPorPerfil {

    private int idPermisoPorPerfil;
    private Permisos permisos;
    private Perfil perfil;

    public PermisoPorPerfil() {
    }

    public PermisoPorPerfil(int idPermisoPorPerfil, Permisos permisos, Perfil perfil) {
        this.idPermisoPorPerfil = idPermisoPorPerfil;
        this.permisos = permisos;
        this.perfil = perfil;
    }

    public int getIdPermisoPorPerfil() {
        return idPermisoPorPerfil;
    }

    public void setIdPermisoPorPerfil(int idPermisoPorPerfil) {
        this.idPermisoPorPerfil = idPermisoPorPerfil;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
