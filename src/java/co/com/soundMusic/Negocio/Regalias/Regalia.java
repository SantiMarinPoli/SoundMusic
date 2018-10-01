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
    private int numeroOperacio;
    private Date fecha;
    private ArtistaEmpresa artistaEmpresa;
    private CostoActividad costo;

    public Regalia() {
    }

    public Regalia(int idRegalia, float totalGanado, int numeroOperacio, Date fecha, ArtistaEmpresa artistaEmpresa, CostoActividad costo) {
        this.idRegalia = idRegalia;
        this.totalGanado = totalGanado;
        this.numeroOperacio = numeroOperacio;
        this.fecha = fecha;
        this.artistaEmpresa = artistaEmpresa;
        this.costo = costo;
    }

    public Regalia(int idRegalia, float totalGanado, int numeroOperacio, Date fecha) {
        this.idRegalia = idRegalia;
        this.totalGanado = totalGanado;
        this.numeroOperacio = numeroOperacio;
        this.fecha = fecha;
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

    public int getNumeroOperacio() {
        return numeroOperacio;
    }

    public void setNumeroOperacio(int numeroOperacio) {
        this.numeroOperacio = numeroOperacio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idRegalia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Regalia other = (Regalia) obj;
        if (this.idRegalia != other.idRegalia) {
            return false;
        }
        return true;
    }
    
    public float calcularRegalias(){
        float regalias = numeroOperacio*costo.getCostoPorOperacion();               
        return regalias;
    }
}
