/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author techlogistic2
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByIdStock", query = "SELECT s FROM Stock s WHERE s.idStock = :idStock")
    , @NamedQuery(name = "Stock.findByCantidadStock", query = "SELECT s FROM Stock s WHERE s.cantidadStock = :cantidadStock")
    , @NamedQuery(name = "Stock.findByDescripcionStock", query = "SELECT s FROM Stock s WHERE s.descripcionStock = :descripcionStock")
    , @NamedQuery(name = "Stock.findByEstado", query = "SELECT s FROM Stock s WHERE s.estado = :estado")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "id_stock")
    private Integer idStock;
    @Column(name = "cantidad_stock")
    private String cantidadStock;
    @Column(name = "descripcion_stock")
    private String descripcionStock;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "productos_codigo_producto", referencedColumnName = "codigo_producto")
    @ManyToOne(optional = false)
    private Productos productosCodigoProducto;

    public Stock() {
    }

    public Stock(Integer idStock) {
        this.idStock = idStock;
    }

    public Integer getIdStock() {
        return idStock;
    }

    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public String getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(String cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getDescripcionStock() {
        return descripcionStock;
    }

    public void setDescripcionStock(String descripcionStock) {
        this.descripcionStock = descripcionStock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Productos getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(Productos productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStock != null ? idStock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Stock[ idStock=" + idStock + " ]";
    }
    
}
