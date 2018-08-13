
package Entities;

import Entities.JoinedTables.MaterialDelivery;
import Entities.JoinedTables.ToolDelivery;
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
@Table(name="transaction_in")
public class TransactionIn {
    
    private int id;
    private String transactionCode;
    private Date transactionInDate;
    private String deliveryReceiptNo;
    private String purchaseOrderNo;
    private BigDecimal vat;
    private BigDecimal netAmount;
    private BigDecimal totalAmount;
    String remarks;
    
    
    private Supplier supplier;
    private Project project;
    private Set<MaterialDelivery> materialDeliveries = new HashSet<>();
    private Set<ToolDelivery> toolDeliveries = new HashSet<>();
    
    private User createdBy;
    private Date createdAt;
    private User updatedBy;
    private Date updatedAt;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="transaction_in_id")    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="transaction_code")
    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    @Column(name="transaction_date")
    @Temporal(TemporalType.DATE)
    public Date getTransactionInDate() {
        return transactionInDate;
    }

    public void setTransactionInDate(Date transactionInDate) {
        this.transactionInDate = transactionInDate;
    }

    @Column(name="DR_no")
    public String getDeliveryReceiptNo() {
        return deliveryReceiptNo;
    }

    public void setDeliveryReceiptNo(String deliveryReceiptNo) {
        this.deliveryReceiptNo = deliveryReceiptNo;
    }

    @Column(name="PO_no")
    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    @Column(name="vat")
    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    @Column(name="net_amount")
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    @Column(name="total_amount")
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name="remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by")
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="created_at")
    @Temporal(TemporalType.DATE)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by")
    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name="updated_at")
    @Temporal(TemporalType.DATE)
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @OneToMany(mappedBy = "materialDeliveryId.transactionIn",
            cascade = CascadeType.ALL)
    public Set<MaterialDelivery> getMaterialDeliveries() {
        return materialDeliveries;
    }

    public void setMaterialDeliveries(Set<MaterialDelivery> materialDeliveries) {
        this.materialDeliveries = materialDeliveries;
    }
    
    public void addMaterialDeliveries(MaterialDelivery materialDelivery) {
        this.materialDeliveries.add(materialDelivery);
    }

    @OneToMany(mappedBy = "toolDeliveryId.transactionIn",
            cascade = CascadeType.ALL)
    public Set<ToolDelivery> getToolDeliveries() {
        return toolDeliveries;
    }

    public void setToolDeliveries(Set<ToolDelivery> toolDeliveries) {
        this.toolDeliveries = toolDeliveries;
    }
    
    public void addToolDelivery(ToolDelivery toolDelivery) {
        this.toolDeliveries.add(toolDelivery);
    }

    @Override
    public String toString() {
        return "TransactionIn{" + "id=" + id + ", transactionCode=" + transactionCode + ", transactionInDate=" + transactionInDate + ", deliveryReceiptNo=" + deliveryReceiptNo + ", purchaseOrderNo=" + purchaseOrderNo + ", vat=" + vat + ", netAmount=" + netAmount + ", totalAmount=" + totalAmount + ", remarks=" + remarks + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
}
