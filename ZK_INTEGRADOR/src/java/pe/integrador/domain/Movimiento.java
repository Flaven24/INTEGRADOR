package pe.integrador.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findByIdmovimiento", query = "SELECT m FROM Movimiento m WHERE m.idmovimiento = :idmovimiento")
    , @NamedQuery(name = "Movimiento.findByNcantidad", query = "SELECT m FROM Movimiento m WHERE m.ncantidad = :ncantidad")
    , @NamedQuery(name = "Movimiento.findByNcosuni", query = "SELECT m FROM Movimiento m WHERE m.ncosuni = :ncosuni")
    , @NamedQuery(name = "Movimiento.findByNvaluni", query = "SELECT m FROM Movimiento m WHERE m.nvaluni = :nvaluni")
    , @NamedQuery(name = "Movimiento.findByNsubtotal", query = "SELECT m FROM Movimiento m WHERE m.nsubtotal = :nsubtotal")
    , @NamedQuery(name = "Movimiento.findByIdregentrada", query = "SELECT m FROM Movimiento m WHERE m.idregentrada = :idregentrada")
    , @NamedQuery(name = "Movimiento.findByIdregsalida", query = "SELECT m FROM Movimiento m WHERE m.idregsalida = :idregsalida")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimiento")
    private Integer idmovimiento;
    @Column(name = "ncantidad")
    private Integer ncantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ncosuni")
    private BigDecimal ncosuni;
    @Column(name = "nvaluni")
    private BigDecimal nvaluni;
    @Column(name = "nsubtotal")
    private BigDecimal nsubtotal;
    @Column(name = "idregentrada")
    private Integer idregentrada;
    @Column(name = "idregsalida")
    private Integer idregsalida;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Producto idproducto;

    public Movimiento() {
    }

    public Movimiento(Integer idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public Integer getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(Integer idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public Integer getNcantidad() {
        return ncantidad;
    }

    public void setNcantidad(Integer ncantidad) {
        this.ncantidad = ncantidad;
    }

    public BigDecimal getNcosuni() {
        return ncosuni;
    }

    public void setNcosuni(BigDecimal ncosuni) {
        this.ncosuni = ncosuni;
    }

    public BigDecimal getNvaluni() {
        return nvaluni;
    }

    public void setNvaluni(BigDecimal nvaluni) {
        this.nvaluni = nvaluni;
    }

    public BigDecimal getNsubtotal() {
        return nsubtotal;
    }

    public void setNsubtotal(BigDecimal nsubtotal) {
        this.nsubtotal = nsubtotal;
    }

    public Integer getIdregentrada() {
        return idregentrada;
    }

    public void setIdregentrada(Integer idregentrada) {
        this.idregentrada = idregentrada;
    }

    public Integer getIdregsalida() {
        return idregsalida;
    }

    public void setIdregsalida(Integer idregsalida) {
        this.idregsalida = idregsalida;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimiento != null ? idmovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idmovimiento == null && other.idmovimiento != null) || (this.idmovimiento != null && !this.idmovimiento.equals(other.idmovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.integrador.domain.Movimiento[ idmovimiento=" + idmovimiento + " ]";
    }
    
}
