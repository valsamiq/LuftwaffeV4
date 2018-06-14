/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dawm
 */
@Entity
@Table(name = "nave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nave.findAll", query = "SELECT n FROM Nave n"),
    @NamedQuery(name = "Nave.findById", query = "SELECT n FROM Nave n WHERE n.id = :id"),
    @NamedQuery(name = "Nave.findByFabricante", query = "SELECT n FROM Nave n WHERE n.fabricante = :fabricante"),
    @NamedQuery(name = "Nave.findByModelo", query = "SELECT n FROM Nave n WHERE n.modelo = :modelo"),
    @NamedQuery(name = "Nave.findByTipo", query = "SELECT n FROM Nave n WHERE n.tipo = :tipo")})
public class Nave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNave")
    private Collection<Mision> misionCollection;

    public Nave() {
    }

    public Nave(Integer id) {
        this.id = id;
    }

    public Nave(String fabricante, String modelo, String tipo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipo = tipo;
    }
    
    public Nave(Integer id, String fabricante, String modelo, String tipo) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Mision> getMisionCollection() {
        return misionCollection;
    }

    public void setMisionCollection(Collection<Mision> misionCollection) {
        this.misionCollection = misionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nave)) {
            return false;
        }
        Nave other = (Nave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Nave[ id=" + id + " ]";
    }
    
}
