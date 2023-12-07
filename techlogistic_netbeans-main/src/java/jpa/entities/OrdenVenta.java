/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author techlogistic2
 */
@Entity
@Table(name = "orden_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenVenta.findAll", query = "SELECT o FROM OrdenVenta o")
    , @NamedQuery(name = "OrdenVenta.findByIdOrdenVenta", query = "SELECT o FROM OrdenVenta o WHERE o.idOrdenVenta = :idOrdenVenta")
    , @NamedQuery(name = "OrdenVenta.findByFechaVenta", query = "SELECT o FROM OrdenVenta o WHERE o.fechaVenta = :fechaVenta")})
public class OrdenVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_orden_venta")
    private Integer idOrdenVenta;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenventaidordenventa")
    private Collection<DetalleordenVenta> detalleordenVentaCollection;
    @JoinColumn(name = "personas_id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Personas personasIdPersona;

    public OrdenVenta() {
    }

    public OrdenVenta(Integer idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public Integer getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(Integer idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @XmlTransient
    public Collection<DetalleordenVenta> getDetalleordenVentaCollection() {
        return detalleordenVentaCollection;
    }

    public void setDetalleordenVentaCollection(Collection<DetalleordenVenta> detalleordenVentaCollection) {
        this.detalleordenVentaCollection = detalleordenVentaCollection;
    }

    public Personas getPersonasIdPersona() {
        return personasIdPersona;
    }

    public void setPersonasIdPersona(Personas personasIdPersona) {
        this.personasIdPersona = personasIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenVenta != null ? idOrdenVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenVenta)) {
            return false;
        }
        OrdenVenta other = (OrdenVenta) object;
        if ((this.idOrdenVenta == null && other.idOrdenVenta != null) || (this.idOrdenVenta != null && !this.idOrdenVenta.equals(other.idOrdenVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.OrdenVenta[ idOrdenVenta=" + idOrdenVenta + " ]";
    }
    
}
