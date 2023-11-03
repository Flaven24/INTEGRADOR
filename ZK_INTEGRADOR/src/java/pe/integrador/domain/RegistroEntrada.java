package pe.integrador.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "registro_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroEntrada.findAll", query = "SELECT r FROM RegistroEntrada r")
    , @NamedQuery(name = "RegistroEntrada.findByIdregentrada", query = "SELECT r FROM RegistroEntrada r WHERE r.idregentrada = :idregentrada")
    , @NamedQuery(name = "RegistroEntrada.findByDfecemi", query = "SELECT r FROM RegistroEntrada r WHERE r.dfecemi = :dfecemi")
    , @NamedQuery(name = "RegistroEntrada.findByDfecven", query = "SELECT r FROM RegistroEntrada r WHERE r.dfecven = :dfecven")
    , @NamedQuery(name = "RegistroEntrada.findByNplazo", query = "SELECT r FROM RegistroEntrada r WHERE r.nplazo = :nplazo")
    , @NamedQuery(name = "RegistroEntrada.findByNsubtotal", query = "SELECT r FROM RegistroEntrada r WHERE r.nsubtotal = :nsubtotal")
    , @NamedQuery(name = "RegistroEntrada.findByNigv", query = "SELECT r FROM RegistroEntrada r WHERE r.nigv = :nigv")
    , @NamedQuery(name = "RegistroEntrada.findByNimporte", query = "SELECT r FROM RegistroEntrada r WHERE r.nimporte = :nimporte")
    , @NamedQuery(name = "RegistroEntrada.findByDfecreg", query = "SELECT r FROM RegistroEntrada r WHERE r.dfecreg = :dfecreg")})
public class RegistroEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregentrada")
    private Integer idregentrada;
    @Column(name = "dfecemi")
    @Temporal(TemporalType.DATE)
    private Date dfecemi;
    @Column(name = "dfecven")
    @Temporal(TemporalType.DATE)
    private Date dfecven;
    @Column(name = "nplazo")
    private Integer nplazo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nsubtotal")
    private BigDecimal nsubtotal;
    @Column(name = "nigv")
    private BigDecimal nigv;
    @Column(name = "nimporte")
    private BigDecimal nimporte;
    @Column(name = "dfecreg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfecreg;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne
    private Proveedor idproveedor;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public RegistroEntrada() {
    }

    public RegistroEntrada(Integer idregentrada) {
        this.idregentrada = idregentrada;
    }

    public Integer getIdregentrada() {
        return idregentrada;
    }

    public void setIdregentrada(Integer idregentrada) {
        this.idregentrada = idregentrada;
    }

    public Date getDfecemi() {
        return dfecemi;
    }

    public void setDfecemi(Date dfecemi) {
        this.dfecemi = dfecemi;
    }

    public Date getDfecven() {
        return dfecven;
    }

    public void setDfecven(Date dfecven) {
        this.dfecven = dfecven;
    }

    public Integer getNplazo() {
        return nplazo;
    }

    public void setNplazo(Integer nplazo) {
        this.nplazo = nplazo;
    }

    public BigDecimal getNsubtotal() {
        return nsubtotal;
    }

    public void setNsubtotal(BigDecimal nsubtotal) {
        this.nsubtotal = nsubtotal;
    }

    public BigDecimal getNigv() {
        return nigv;
    }

    public void setNigv(BigDecimal nigv) {
        this.nigv = nigv;
    }

    public BigDecimal getNimporte() {
        return nimporte;
    }

    public void setNimporte(BigDecimal nimporte) {
        this.nimporte = nimporte;
    }

    public Date getDfecreg() {
        return dfecreg;
    }

    public void setDfecreg(Date dfecreg) {
        this.dfecreg = dfecreg;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregentrada != null ? idregentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroEntrada)) {
            return false;
        }
        RegistroEntrada other = (RegistroEntrada) object;
        if ((this.idregentrada == null && other.idregentrada != null) || (this.idregentrada != null && !this.idregentrada.equals(other.idregentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.integrador.domain.RegistroEntrada[ idregentrada=" + idregentrada + " ]";
    }
    
}
