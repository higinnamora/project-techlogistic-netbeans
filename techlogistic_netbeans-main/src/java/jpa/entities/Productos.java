/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author techlogistic2
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByCodigoProducto", query = "SELECT p FROM Productos p WHERE p.codigoProducto = :codigoProducto")
    , @NamedQuery(name = "Productos.findByMaterial", query = "SELECT p FROM Productos p WHERE p.material = :material")
    , @NamedQuery(name = "Productos.findByModelo", query = "SELECT p FROM Productos p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Productos.findByTalla", query = "SELECT p FROM Productos p WHERE p.talla = :talla")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_producto")
    private Integer codigoProducto;
    @Column(name = "material")
    private String material;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "precio")
    private String precio;
    @Column(name = "talla")
    private String talla;
    @JoinTable(name = "materia_prima_has_productos", joinColumns = {
        @JoinColumn(name = "productos_codigo_producto", referencedColumnName = "codigo_producto")}, inverseJoinColumns = {
        @JoinColumn(name = "materia_prima_id_materia_prima", referencedColumnName = "id_materia_prima")})
    @ManyToMany
    private Collection<MateriaPrima> materiaPrimaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosCodigoProducto")
    private Collection<DetalleordenVenta> detalleordenVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosCodigoProducto")
    private Collection<Stock> stockCollection;

    public Productos() {
    }

    public Productos(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @XmlTransient
    public Collection<MateriaPrima> getMateriaPrimaCollection() {
        return materiaPrimaCollection;
    }

    public void setMateriaPrimaCollection(Collection<MateriaPrima> materiaPrimaCollection) {
        this.materiaPrimaCollection = materiaPrimaCollection;
    }

    @XmlTransient
    public Collection<DetalleordenVenta> getDetalleordenVentaCollection() {
        return detalleordenVentaCollection;
    }

    public void setDetalleordenVentaCollection(Collection<DetalleordenVenta> detalleordenVentaCollection) {
        this.detalleordenVentaCollection = detalleordenVentaCollection;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Productos[ codigoProducto=" + codigoProducto + " ]";
    }
    
}
