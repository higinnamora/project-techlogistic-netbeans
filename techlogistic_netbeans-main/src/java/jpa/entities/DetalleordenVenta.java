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
@Table(name = "detalleorden_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleordenVenta.findAll", query = "SELECT d FROM DetalleordenVenta d")
    , @NamedQuery(name = "DetalleordenVenta.findByIdDetalleordenVenta", query = "SELECT d FROM DetalleordenVenta d WHERE d.idDetalleordenVenta = :idDetalleordenVenta")
    , @NamedQuery(name = "DetalleordenVenta.findByCantidadProductos", query = "SELECT d FROM DetalleordenVenta d WHERE d.cantidadProductos = :cantidadProductos")
    , @NamedQuery(name = "DetalleordenVenta.findByDescuento", query = "SELECT d FROM DetalleordenVenta d WHERE d.descuento = :descuento")
    , @NamedQuery(name = "DetalleordenVenta.findByMedioPago", query = "SELECT d FROM DetalleordenVenta d WHERE d.medioPago = :medioPago")
    , @NamedQuery(name = "DetalleordenVenta.findByObservacion", query = "SELECT d FROM DetalleordenVenta d WHERE d.observacion = :observacion")
    , @NamedQuery(name = "DetalleordenVenta.findBySubTotal", query = "SELECT d FROM DetalleordenVenta d WHERE d.subTotal = :subTotal")
    , @NamedQuery(name = "DetalleordenVenta.findByTotal", query = "SELECT d FROM DetalleordenVenta d WHERE d.total = :total")})
public class DetalleordenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detalleorden_venta")
    private Integer idDetalleordenVenta;
    @Column(name = "cantidad_productos")
    private Integer cantidadProductos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Float descuento;
    @Column(name = "medio_pago")
    private String medioPago;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "sub_total")
    private Float subTotal;
    @Column(name = "total")
    private Float total;
    @JoinColumn(name = "Orden_venta_id_orden_venta", referencedColumnName = "id_orden_venta")
    @ManyToOne(optional = false)
    private OrdenVenta ordenventaidordenventa;
    @JoinColumn(name = "productos_codigo_producto", referencedColumnName = "codigo_producto")
    @ManyToOne(optional = false)
    private Productos productosCodigoProducto;

    public DetalleordenVenta() {
    }

    public DetalleordenVenta(Integer idDetalleordenVenta) {
        this.idDetalleordenVenta = idDetalleordenVenta;
    }

    public Integer getIdDetalleordenVenta() {
        return idDetalleordenVenta;
    }

    public void setIdDetalleordenVenta(Integer idDetalleordenVenta) {
        this.idDetalleordenVenta = idDetalleordenVenta;
    }

    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public OrdenVenta getOrdenventaidordenventa() {
        return ordenventaidordenventa;
    }

    public void setOrdenventaidordenventa(OrdenVenta ordenventaidordenventa) {
        this.ordenventaidordenventa = ordenventaidordenventa;
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
        hash += (idDetalleordenVenta != null ? idDetalleordenVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleordenVenta)) {
            return false;
        }
        DetalleordenVenta other = (DetalleordenVenta) object;
        if ((this.idDetalleordenVenta == null && other.idDetalleordenVenta != null) || (this.idDetalleordenVenta != null && !this.idDetalleordenVenta.equals(other.idDetalleordenVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DetalleordenVenta[ idDetalleordenVenta=" + idDetalleordenVenta + " ]";
    }
    
}
