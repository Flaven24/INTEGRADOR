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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdproveedor", query = "SELECT p FROM Proveedor p WHERE p.idproveedor = :idproveedor")
    , @NamedQuery(name = "Proveedor.findByCnombre", query = "SELECT p FROM Proveedor p WHERE p.cnombre LIKE :cnombre")
    , @NamedQuery(name = "Proveedor.findByCrazon", query = "SELECT p FROM Proveedor p WHERE p.crazon = :crazon")
    , @NamedQuery(name = "Proveedor.findByCruc", query = "SELECT p FROM Proveedor p WHERE p.cruc = :cruc")
    , @NamedQuery(name = "Proveedor.findByDfecreg", query = "SELECT p FROM Proveedor p WHERE p.dfecreg = :dfecreg")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproveedor")
    private Integer idproveedor;
    @Column(name = "cnombre")
    private String cnombre;
    @Column(name = "crazon")
    private String crazon;
    @Column(name = "cruc")
    private String cruc;
    @Column(name = "dfecreg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfecreg;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne
    private EstadoProveedor idestado;

    public Proveedor() {
    }

    public Proveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCrazon() {
        return crazon;
    }

    public void setCrazon(String crazon) {
        this.crazon = crazon;
    }

    public String getCruc() {
        return cruc;
    }

    public void setCruc(String cruc) {
        this.cruc = cruc;
    }

    public Date getDfecreg() {
        return dfecreg;
    }

    public void setDfecreg(Date dfecreg) {
        this.dfecreg = dfecreg;
    }

    public EstadoProveedor getIdestado() {
        return idestado;
    }

    public void setIdestado(EstadoProveedor idestado) {
        this.idestado = idestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.integrador.domain.Proveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
