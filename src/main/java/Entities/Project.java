
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "projects")
public class Project implements Serializable {
    
    private int id;
    private String projectCode;
    private String projectName;
    private Date dateStarted;
    private Date dateFinished;
    private Date dateCreated;
    private BigDecimal spentAmount;
    private BigDecimal totalBudget;
    
    private Department department;
    private Set<TransactionIn> transactionIn = new HashSet<>();
    
    public Project(){}

    public Project(String projectCode, String projectName, Date dateStarted, Date dateFinished, Date dateCreated, BigDecimal spentAmount, BigDecimal totalBudget) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
        this.dateCreated = dateCreated;
        this.spentAmount = spentAmount;
        this.totalBudget = totalBudget;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="project_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="project_code")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Column(name="project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name="date_started")
    @Temporal(TemporalType.DATE)
    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    @Column(name="date_finished")
    @Temporal(TemporalType.DATE)
    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    @Column(name="date_created")
    @Temporal(TemporalType.DATE)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name="spent_amount")
    public BigDecimal getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    @Column(name="total_budget")
    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    public Set<TransactionIn> getTransactionIn() {
        return transactionIn;
    }

    public void setTransactionIn(Set<TransactionIn> transactionIn) {
        this.transactionIn = transactionIn;
    }
    
    public void addTransactionIn(TransactionIn transactionIn) {
        this.transactionIn.add(transactionIn);
    }
    
}
