/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "severity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Severity.findAll", query = "SELECT s FROM Severity s")
    , @NamedQuery(name = "Severity.findById", query = "SELECT s FROM Severity s WHERE s.id = :id")
    , @NamedQuery(name = "Severity.findBySeverity", query = "SELECT s FROM Severity s WHERE s.severity = :severity")})
public class Severity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Severity")
    private String severity;
    @JoinColumn(name = "ID", referencedColumnName = "SeverityID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Helpdesk helpdesk;

    public Severity() {
    }

    public Severity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Helpdesk getHelpdesk() {
        return helpdesk;
    }

    public void setHelpdesk(Helpdesk helpdesk) {
        this.helpdesk = helpdesk;
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
        if (!(object instanceof Severity)) {
            return false;
        }
        Severity other = (Severity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Severity[ id=" + id + " ]";
    }
    
}
