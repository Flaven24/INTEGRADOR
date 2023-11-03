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
@Table(name = "registro_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroSalida.findAll", query = "SELECT r FROM RegistroSalida r")
    , @NamedQuery(name = "RegistroSalida.findByIdregsalida", query = "SELECT r FROM RegistroSalida r WHERE r.idregsalida = :idregsalida")
    , @NamedQuery(name = "RegistroSalida.findByDfecha", query = "SELECT r FROM RegistroSalida r WHERE r.dfecha = :dfecha")
    , @NamedQuery(name = "RegistroSalida.findByNsubtotal", query = "SELECT r FROM RegistroSalida r WHERE r.nsubtotal = :nsubtotal")
    , @NamedQuery(name = "RegistroSalida.findByNigv", query = "SELECT r FROM RegistroSalida r WHERE r.nigv = :nigv")
    , @NamedQuery(name = "RegistroSalida.findByNimporte", query = "SELECT r FROM RegistroSalida r WHERE r.nimporte = :nimporte")
    , @NamedQuery(name = "RegistroSalida.findByDfecreg", query = "SELECT r FROM RegistroSalida r WHERE r.dfecreg = :dfecreg")})
public class RegistroSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregsalida")
    private Integer idregsalida;
    @Column(name = "dfecha")
    @Temporal(TemporalType.DATE)
    private Date dfecha;
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
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public RegistroSalida() {
    }

    public RegistroSalida(Integer idregsalida) {
        this.idregsalida = idregsalida;
    }

    public Integer getIdregsalida() {
        return idregsalida;
    }

    public void setIdregsalida(Integer idregsalida) {
        this.idregsalida = idregsalida;
    }

    public Date getDfecha() {
        return dfecha;
    }

    public void setDfecha(Date dfecha) {
        this.dfecha = dfecha;
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

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
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
        hash += (idregsalida != null ? idregsalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroSalida)) {
            return false;
        }
        RegistroSalida other = (RegistroSalida) object;
        if ((this.idregsalida == null && other.idregsalida != null) || (this.idregsalida != null && !this.idregsalida.equals(other.idregsalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.integrador.domain.RegistroSalida[ idregsalida=" + idregsalida + " ]";
    }
    
}
