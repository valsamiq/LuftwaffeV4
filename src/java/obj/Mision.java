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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Mision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mision.findAll", query = "SELECT m FROM Mision m"),
    @NamedQuery(name = "Mision.findById", query = "SELECT m FROM Mision m WHERE m.id = :id"),
    @NamedQuery(name = "Mision.findByNombre", query = "SELECT m FROM Mision m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mision.findByClasificacion", query = "SELECT m FROM Mision m WHERE m.clasificacion = :clasificacion"),
    @NamedQuery(name = "Mision.findByTipo", query = "SELECT m FROM Mision m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Mision.findByZona", query = "SELECT m FROM Mision m WHERE m.zona = :zona")})
public class Mision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clasificacion")
    private int clasificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zona")
    private String zona;
    @JoinColumn(name = "idNave", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nave idNave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMision")
    private Collection<Tripulacion> tripulacionCollection;

    public Mision() {
    }

    public Mision(Integer id) {
        this.id = id;
    }

    public Mision(String nombre, int clasificacion, String tipo, String zona, Nave idNave) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
        this.zona = zona;
        this.idNave = idNave;
    }
    
    public Mision(Integer id, String nombre, int clasificacion, String tipo, String zona) {
        this.id = id;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
        this.zona = zona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Nave getIdNave() {
        return idNave;
    }

    public void setIdNave(Nave idNave) {
        this.idNave = idNave;
    }

    @XmlTransient
    public Collection<Tripulacion> getTripulacionCollection() {
        return tripulacionCollection;
    }

    public void setTripulacionCollection(Collection<Tripulacion> tripulacionCollection) {
        this.tripulacionCollection = tripulacionCollection;
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
        if (!(object instanceof Mision)) {
            return false;
        }
        Mision other = (Mision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Mision[ id=" + id + " ]";
    }
    
}
