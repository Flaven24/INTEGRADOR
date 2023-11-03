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
@Table(name = "estado_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCliente.findAll", query = "SELECT e FROM EstadoCliente e")
    , @NamedQuery(name = "EstadoCliente.findByIdestado", query = "SELECT e FROM EstadoCliente e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "EstadoCliente.findByCnomestado", query = "SELECT e FROM EstadoCliente e WHERE e.cnomestado = :cnomestado")
    , @NamedQuery(name = "EstadoCliente.findByDfecreg", query = "SELECT e FROM EstadoCliente e WHERE e.dfecreg = :dfecreg")
    , @NamedQuery(name = "EstadoCliente.findByBactivo", query = "SELECT e FROM EstadoCliente e WHERE e.bactivo = :bactivo")
    , @NamedQuery(name = "EstadoCliente.findByNorden", query = "SELECT e FROM EstadoCliente e WHERE e.norden = :norden")})
public class EstadoCliente implements Serializable {

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

    public EstadoCliente() {
    }

    public EstadoCliente(Integer idestado) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCliente)) {
            return false;
        }
        EstadoCliente other = (EstadoCliente) object;
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
