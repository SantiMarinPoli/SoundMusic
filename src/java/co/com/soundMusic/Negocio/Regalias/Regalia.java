package co.com.soundMusic.Negocio.Regalias;

import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresa;
import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Regalia {

    private int idRegalia;
    private float totalGanado;
    private Date fecha;
    private ArtistaEmpresa artistaEmpresa;
    private CostoActividad costo;

    public Regalia() {
    }

    public Regalia(int idRegalia, float totalGanado, Date fecha, ArtistaEmpresa artistaEmpresa, CostoActividad costo) {
        this.idRegalia = idRegalia;
        this.totalGanado = totalGanado;
        this.fecha = fecha;
        this.artistaEmpresa = artistaEmpresa;
        this.costo = costo;
    }

    public int getIdRegalia() {
        return idRegalia;
    }

    public void setIdRegalia(int idRegalia) {
        this.idRegalia = idRegalia;
    }

    public float getTotalGanado() {
        return totalGanado;
    }

    public void setTotalGanado(float totalGanado) {
        this.totalGanado = totalGanado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArtistaEmpresa getArtistaEmpresa() {
        return artistaEmpresa;
    }

    public void setArtistaEmpresa(ArtistaEmpresa artistaEmpresa) {
        this.artistaEmpresa = artistaEmpresa;
    }

    public CostoActividad getCosto() {
        return costo;
    }

    public void setCosto(CostoActividad costo) {
        this.costo = costo;
    }

}
