package co.com.soundMusic.EmpresaDifusora.TipoCosto;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class TipoEmpresaDifusora {

    private int idTipoActividad;
    private String tipoActividad;
    private String descripcion;

    public TipoEmpresaDifusora() {
    }

    public TipoEmpresaDifusora(int idTipoActividad, String tipoActividad, String descripcion) {
        this.idTipoActividad = idTipoActividad;
        this.tipoActividad = tipoActividad;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoEmpresaDifusora{" + "idTipoActividad=" + idTipoActividad
                + ", tipoActividad=" + tipoActividad
                + ", descripcion=" + descripcion + '}';
    }

}
