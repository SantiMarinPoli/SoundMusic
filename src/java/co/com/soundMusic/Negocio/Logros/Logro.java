package co.com.soundMusic.Negocio.Logros;

import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Logro {

    private int idLogro;
    private String nombreLogro;
    private String criterio;
    private float cantidadCriterio;
    private Date fechaCreacion;
    private Date fechaFinal;
    private String status;
    private float premio;

    public Logro() {
    }

    public Logro(int idLogro, String nombreLogro, String criterio, float cantidadCriterio, Date fechaCreacion, Date fechaFinal, String status, float premio) {
        this.idLogro = idLogro;
        this.nombreLogro = nombreLogro;
        this.criterio = criterio;
        this.cantidadCriterio = cantidadCriterio;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinal = fechaFinal;
        this.status = status;
        this.premio = premio;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public String getNombreLogro() {
        return nombreLogro;
    }

    public void setNombreLogro(String nombreLogro) {
        this.nombreLogro = nombreLogro;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public float getCantidadCriterio() {
        return cantidadCriterio;
    }

    public void setCantidadCriterio(float cantidadCriterio) {
        this.cantidadCriterio = cantidadCriterio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPremio() {
        return premio;
    }

    public void setPremio(float premio) {
        this.premio = premio;
    }

}
