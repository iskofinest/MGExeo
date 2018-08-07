
package Entities;

import Entities.JoinedTables.BorrowTool;
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

//@Entity
//@Table(name="transaction_out")
public class TransactionOut {
    
//    private int id;
//    private String transactionCode;
//    private String transactionType;
//    private Date transactionDate;
//    private Date grantedDate;
//    private BigDecimal grandTotal;
//    
//    private Project project;
//    
//    private Set<MaterialRequest> materialRequests = new HashSet<>();
//    private Set<BorrowTool> borrowTools = new HashSet<>();
//    
//    private User requisitioner;
//
//    public TransactionOut() {
//    }
//
//    public TransactionOut(String transactionCode, String transactionType, Date transactionDate, Date grantedDate, BigDecimal grandTotal) {
//        this.transactionCode = transactionCode;
//        this.transactionType = transactionType;
//        this.transactionDate = transactionDate;
//        this.grantedDate = grantedDate;
//        this.grandTotal = grandTotal;
//    }
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="transaction_id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Column(name="transaction_code")
//    public String getTransactionCode() {
//        return transactionCode;
//    }
//
//    public void setTransactionCode(String transactionCode) {
//        this.transactionCode = transactionCode;
//    }
//
//    @Column(name="transaction_type")
//    public String getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(String transactionType) {
//        this.transactionType = transactionType;
//    }
//
//    @Column(name="transaction_date")
//    @Temporal(TemporalType.DATE)
//    public Date getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(Date transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    @Column(name="granted_date")
//    @Temporal(TemporalType.DATE)
//    public Date getGrantedDate() {
//        return grantedDate;
//    }
//
//    public void setGrantedDate(Date grantedDate) {
//        this.grantedDate = grantedDate;
//    }
//
//    @Column(name="grand_total")
//    public BigDecimal getGrandTotal() {
//        return grandTotal;
//    }
//
//    public void setGrandTotal(BigDecimal grandTotal) {
//        this.grandTotal = grandTotal;
//    }
//    
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "project_id")
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
//    public Set<MaterialRequest> getMaterialRequests() {
//        return materialRequests;
//    }
//
//    public void setMaterialRequests(Set<MaterialRequest> materialRequests) {
//        this.materialRequests = materialRequests;
//    }
//    
//    public void addMaterialRequest(MaterialRequest materialRequest) {
//        this.materialRequests.add(materialRequest);
//    }
//
//    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
//    public Set<BorrowTool> getBorrowTools() {
//        return borrowTools;
//    }
//
//    public void setBorrowTools(Set<BorrowTool> borrowTools) {
//        this.borrowTools = borrowTools;
//    }
//    
//    public void addBorrowTool(BorrowTool borrowTool) {
//        this.borrowTools.add(borrowTool);
//    }
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "requisitioner_id")
//    public User getRequisitioner() {
//        return requisitioner;
//    }
//
//    public void setRequisitioner(User requisitioner) {
//        this.requisitioner = requisitioner;
//    }
    
    
}
