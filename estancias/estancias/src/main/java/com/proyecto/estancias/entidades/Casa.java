
package com.proyecto.estancias.entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Casa {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid2")
    private String id;
    
    private String Calle;
    private int numero;
    private String codPostal;
    private String ciudad;
    private String pais;
    private Date fechaDesde;
    private Date fechaHasta;
    private int minDias;
    private int maxDias;
    private double precio;
    private String tipoVivienda;
  /**
    Falta encapsular foto
    
    */
    
// private Foto foto; 

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the Calle
     */
    public String getCalle() {
        return Calle;
    }

    /**
     * @param Calle the Calle to set
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the codPostal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * @param codPostal the codPostal to set
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the fechaDesde
     */
    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     * @param fechaDesde the fechaDesde to set
     */
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * @return the fecgaHasta
     */
    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     * @param fecgaHasta the fecgaHasta to set
     */
    public void setFechaHasta(Date fecgaHasta) {
        this.fechaHasta = fecgaHasta;
    }

    /**
     * @return the minDias
     */
    public int getMinDias() {
        return minDias;
    }

    /**
     * @param minDias the minDias to set
     */
    public void setMinDias(int minDias) {
        this.minDias = minDias;
    }

    /**
     * @return the maxDias
     */
    public int getMaxDias() {
        return maxDias;
    }

    /**
     * @param maxDias the maxDias to set
     */
    public void setMaxDias(int maxDias) {
        this.maxDias = maxDias;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the tipoVivienda
     */
    public String getTipoVivienda() {
        return tipoVivienda;
    }

    /**
     * @param tipoVivienda the tipoVivienda to set
     */
    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }
    
    
    
}
