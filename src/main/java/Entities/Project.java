
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "projects")
public class Project implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", length=10, nullable=false)
    private int id;
    
    @Column(name="project_code", nullable=false)
    private String projectCode;
    
    @Column(name="project_name", nullable=false)
    private String projectName;
    
    @Column(name="transaction_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    
    @Column(name="spent_amount")
    private BigDecimal spentAmount;
    
    @Column(name="total_budget", nullable=false)
    private BigDecimal totalBudget;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="transactions")
    private Set<Transactions> transactions = new HashSet<>();
    
    public Project(){}

    public Project(String projectCode, String projectName, Date transactionDate, BigDecimal spentAmount, BigDecimal totalBudget) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.transactionDate = transactionDate;
        this.spentAmount = spentAmount;
        this.totalBudget = totalBudget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

//    @Override
//    public String toString() {
//        String transactionList = "{";
//        Transactions transactions[] = (Transactions[])getTransactions().toArray();
//        for(Transactions transaction : transactions) transactionList += transaction.getTransactionCode() + ", ";
//        transactionList += "}\n";
//        return "Project{" + "id=" + id + ", projectCode=" + projectCode + ", projectName=" + projectName + ", transactionDate=" + transactionDate + ", spentAmount=" + spentAmount + ", totalBudget=" + totalBudget + ", \n\ttransactions=" + transactionList + '}';
//    }
    
    
    
}
