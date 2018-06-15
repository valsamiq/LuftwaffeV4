/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
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
 * @author dawm
 */
@Entity
@Table(name = "Tripulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tripulacion.findAll", query = "SELECT t FROM Tripulacion t"),
    @NamedQuery(name = "Tripulacion.findById", query = "SELECT t FROM Tripulacion t WHERE t.id = :id")})
public class Tripulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idMision", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mision idMision;
    @JoinColumn(name = "idPersonal", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personal idPersonal;

    public Tripulacion() {
    }

    public Tripulacion(Mision idMision, Personal idPersonal) {
        this.idMision = idMision;
        this.idPersonal = idPersonal;
    }

    public Tripulacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mision getIdMision() {
        return idMision;
    }

    public void setIdMision(Mision idMision) {
        this.idMision = idMision;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
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
        if (!(object instanceof Tripulacion)) {
            return false;
        }
        Tripulacion other = (Tripulacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Tripulacion[ id=" + id + " ]";
    }
    
}
