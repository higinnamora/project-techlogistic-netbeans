/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "materia_prima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaPrima.findAll", query = "SELECT m FROM MateriaPrima m")
    , @NamedQuery(name = "MateriaPrima.findByIdMateriaPrima", query = "SELECT m FROM MateriaPrima m WHERE m.idMateriaPrima = :idMateriaPrima")
    , @NamedQuery(name = "MateriaPrima.findByCantidadMateria", query = "SELECT m FROM MateriaPrima m WHERE m.cantidadMateria = :cantidadMateria")
    , @NamedQuery(name = "MateriaPrima.findByColorMateria", query = "SELECT m FROM MateriaPrima m WHERE m.colorMateria = :colorMateria")
    , @NamedQuery(name = "MateriaPrima.findByPeso", query = "SELECT m FROM MateriaPrima m WHERE m.peso = :peso")
    , @NamedQuery(name = "MateriaPrima.findByPrecio", query = "SELECT m FROM MateriaPrima m WHERE m.precio = :precio")
    , @NamedQuery(name = "MateriaPrima.findByTextura", query = "SELECT m FROM MateriaPrima m WHERE m.textura = :textura")})
public class MateriaPrima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_materia_prima")
    private Integer idMateriaPrima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_materia")
    private Float cantidadMateria;
    @Column(name = "color_materia")
    private String colorMateria;
    @Column(name = "peso")
    private Float peso;
    @Column(name = "precio")
    private Float precio;
    @Column(name = "textura")
    private String textura;
    @ManyToMany(mappedBy = "materiaPrimaCollection")
    private Collection<Productos> productosCollection;
    @JoinColumn(name = "pedido_id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne
    private Pedido pedidoIdPedido;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Integer getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(Integer idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public Float getCantidadMateria() {
        return cantidadMateria;
    }

    public void setCantidadMateria(Float cantidadMateria) {
        this.cantidadMateria = cantidadMateria;
    }

    public String getColorMateria() {
        return colorMateria;
    }

    public void setColorMateria(String colorMateria) {
        this.colorMateria = colorMateria;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    public Pedido getPedidoIdPedido() {
        return pedidoIdPedido;
    }

    public void setPedidoIdPedido(Pedido pedidoIdPedido) {
        this.pedidoIdPedido = pedidoIdPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriaPrima != null ? idMateriaPrima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPrima)) {
            return false;
        }
        MateriaPrima other = (MateriaPrima) object;
        if ((this.idMateriaPrima == null && other.idMateriaPrima != null) || (this.idMateriaPrima != null && !this.idMateriaPrima.equals(other.idMateriaPrima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MateriaPrima[ idMateriaPrima=" + idMateriaPrima + " ]";
    }
    
}
