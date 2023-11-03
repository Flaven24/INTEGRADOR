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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByCnombre", query = "SELECT u FROM Usuario u WHERE u.cnombre LIKE :ccriterio")
    , @NamedQuery(name = "Usuario.findByClogin", query = "SELECT u FROM Usuario u WHERE u.clogin = :clogin")    
    , @NamedQuery(name = "Usuario.findByCloginByCcontrasena", query = "SELECT u FROM Usuario u WHERE u.clogin = :clogin AND u.ccontrasena=:ccontrasena")
    , @NamedQuery(name = "Usuario.findByCcontrasena", query = "SELECT u FROM Usuario u WHERE u.ccontrasena = :ccontrasena")
    , @NamedQuery(name = "Usuario.findByDfecreg", query = "SELECT u FROM Usuario u WHERE u.dfecreg = :dfecreg")
    , @NamedQuery(name = "Usuario.findByBactivo", query = "SELECT u FROM Usuario u WHERE u.bactivo = :bactivo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Column(name = "cnombre")
    private String cnombre;
    @Column(name = "clogin")
    private String clogin;
    @Column(name = "ccontrasena")
    private String ccontrasena;
    @Column(name = "dfecreg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dfecreg;
    @Column(name = "bactivo")
    private Boolean bactivo;
    @OneToMany(mappedBy = "idusuario")
    private Collection<RegistroSalida> registroSalidaCollection;
    @OneToMany(mappedBy = "idusuario")
    private Collection<RegistroEntrada> registroEntradaCollection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getClogin() {
        return clogin;
    }

    public void setClogin(String clogin) {
        this.clogin = clogin;
    }

    public String getCcontrasena() {
        return ccontrasena;
    }

    public void setCcontrasena(String ccontrasena) {
        this.ccontrasena = ccontrasena;
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

    @XmlTransient
    public Collection<RegistroSalida> getRegistroSalidaCollection() {
        return registroSalidaCollection;
    }

    public void setRegistroSalidaCollection(Collection<RegistroSalida> registroSalidaCollection) {
        this.registroSalidaCollection = registroSalidaCollection;
    }

    @XmlTransient
    public Collection<RegistroEntrada> getRegistroEntradaCollection() {
        return registroEntradaCollection;
    }

    public void setRegistroEntradaCollection(Collection<RegistroEntrada> registroEntradaCollection) {
        this.registroEntradaCollection = registroEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.integrador.domain.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
