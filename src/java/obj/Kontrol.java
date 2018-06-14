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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dawm
 */
@Entity
@Table(name = "kontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kontrol.findAll", query = "SELECT k FROM Kontrol k"),
    @NamedQuery(name = "Kontrol.findById", query = "SELECT k FROM Kontrol k WHERE k.id = :id"),
    @NamedQuery(name = "Kontrol.findByUsername", query = "SELECT k FROM Kontrol k WHERE k.username = :username"),
    @NamedQuery(name = "Kontrol.findByPassword", query = "SELECT k FROM Kontrol k WHERE k.password = :password"),
    @NamedQuery(name = "Kontrol.findByRank", query = "SELECT k FROM Kontrol k WHERE k.rank = :rank")})
public class Kontrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rank")
    private String rank;

    public Kontrol() {
    }

    public Kontrol(Integer id) {
        this.id = id;
    }

    public Kontrol(Integer id, String username, String password, String rank) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
        if (!(object instanceof Kontrol)) {
            return false;
        }
        Kontrol other = (Kontrol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Kontrol[ id=" + id + " ]";
    }
    
}
