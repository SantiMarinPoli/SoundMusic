package co.com.soundMusic.EmpresaDifusora.TipoCosto;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class TipoEmpresaDifusora {

    private int idTipoActividad;
    private String tipoActividad;

    public TipoEmpresaDifusora() {
    }

    public TipoEmpresaDifusora(int idTipoActividad, String tipoActividad) {
        this.idTipoActividad = idTipoActividad;
        this.tipoActividad = tipoActividad;
    }

    public int getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setIdTipoActividad(int idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

}
