package pe.integrador.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "estado_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProveedor.findAll", query = "SELECT e FROM EstadoProveedor e")
    , @NamedQuery(name = "EstadoProveedor.findByIdestado", query = "SELECT e FROM EstadoProveedor e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "EstadoProveedor.findByCnomestado", query = "SELECT e FROM EstadoProveedor e WHERE e.cnomestado = :cnomestado")
    , @NamedQuery(name = "EstadoProveedor.findByDfecreg", query = "SELECT e FROM EstadoProveedor e WHERE e.dfecreg = :dfecreg")
    , @NamedQuery(name = "EstadoProveedor.findByBactivo", query = "SELECT e FROM EstadoProveedor e WHERE e.bactivo = :bactivo")
    , @NamedQuery(name = "EstadoProveedor.findByNorden", query = "SELECT e FROM EstadoProveedor e WHERE e.norden = :norden")})
public class EstadoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado")
    private Integer idestado;
    @Column(name = "cnomestado")
    private String cnomestado;
    @Column(name = "dfecreg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfecreg;
    @Column(name = "bactivo")
    private Boolean bactivo;
    @Column(name = "norden")
    private Integer norden;
    @OneToMany(mappedBy = "idestado")
    private Collection<Proveedor> proveedorCollection;

    public EstadoProveedor() {
    }

    public EstadoProveedor(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getCnomestado() {
        return cnomestado;
    }

    public void setCnomestado(String cnomestado) {
        this.cnomestado = cnomestado;
    }

    public Date getDfecreg() {
        return dfecreg;
    }

    public void setDfecreg(Date dfecreg) {
        this.dfecreg = dfecreg;
    }

    public Boolean getBactivo() {
        return bactivo;
    }

    public void setBactivo(Boolean bactivo) {
        this.bactivo = bactivo;
    }

    public Integer getNorden() {
        return norden;
    }

    public void setNorden(Integer norden) {
        this.norden = norden;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProveedor)) {
            return false;
        }
        EstadoProveedor other = (EstadoProveedor) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cnomestado;
    }
    
}
