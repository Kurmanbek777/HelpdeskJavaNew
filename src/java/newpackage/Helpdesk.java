/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "helpdesk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Helpdesk.findAll", query = "SELECT h FROM Helpdesk h")
    , @NamedQuery(name = "Helpdesk.findByTicketID", query = "SELECT h FROM Helpdesk h WHERE h.ticketID = :ticketID")
    , @NamedQuery(name = "Helpdesk.findByFName", query = "SELECT h FROM Helpdesk h WHERE h.fName = :fName")
    , @NamedQuery(name = "Helpdesk.findByLName", query = "SELECT h FROM Helpdesk h WHERE h.lName = :lName")
    , @NamedQuery(name = "Helpdesk.findByEmail", query = "SELECT h FROM Helpdesk h WHERE h.email = :email")
    , @NamedQuery(name = "Helpdesk.findBySeverityID", query = "SELECT h FROM Helpdesk h WHERE h.severityID = :severityID")
    , @NamedQuery(name = "Helpdesk.findByStatusID", query = "SELECT h FROM Helpdesk h WHERE h.statusID = :statusID")
    , @NamedQuery(name = "Helpdesk.findByDepartmentID", query = "SELECT h FROM Helpdesk h WHERE h.departmentID = :departmentID")
    , @NamedQuery(name = "Helpdesk.findByEmployeeID", query = "SELECT h FROM Helpdesk h WHERE h.employeeID = :employeeID")
    , @NamedQuery(name = "Helpdesk.findByComments", query = "SELECT h FROM Helpdesk h WHERE h.comments = :comments")})
public class Helpdesk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TicketID")
    private Integer ticketID;
    @Column(name = "FName")
    private String fName;
    @Column(name = "LName")
    private String lName;
    @Column(name = "Email")
    private String email;
    @Column(name = "SeverityID")
    private Integer severityID;
    @Basic(optional = false)
    @Column(name = "StatusID")
    private int statusID;
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private int departmentID;
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Column(name = "Comments")
    private String comments;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "helpdesk")
    private Severity severity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "helpdesk")
    private Department department;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "helpdesk")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "helpdesk")
    private Status status;

    public Helpdesk() {
    }

    public Helpdesk(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Helpdesk(Integer ticketID, int statusID, int departmentID) {
        this.ticketID = ticketID;
        this.statusID = statusID;
        this.departmentID = departmentID;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSeverityID() {
        return severityID;
    }

    public void setSeverityID(Integer severityID) {
        this.severityID = severityID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketID != null ? ticketID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Helpdesk)) {
            return false;
        }
        Helpdesk other = (Helpdesk) object;
        if ((this.ticketID == null && other.ticketID != null) || (this.ticketID != null && !this.ticketID.equals(other.ticketID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Helpdesk[ ticketID=" + ticketID + " ]";
    }
    
}
