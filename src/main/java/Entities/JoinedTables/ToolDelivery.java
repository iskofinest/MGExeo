
package Entities.JoinedTables;

import Entities.TransactionIn;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JOptionPane;


@Entity
@Table(name = "tool_delivery")
@AssociationOverrides({
    @AssociationOverride(name = "toolDeliveryId.transactionIn",
        joinColumns = @JoinColumn(name = "transaction_in_id")),
    @AssociationOverride(name = "toolDeliveryId.toolSupplier.toolSupplierId.tool.id",
        joinColumns = @JoinColumn(name = "tool_id")),
    @AssociationOverride(name = "toolDeliveryId.toolSupplier.toolSupplierId.supplier.id",
        joinColumns = @JoinColumn(name = "supplier_id")) 
})
public class ToolDelivery implements Serializable {
    
    ToolDeliveryId toolDeliveryId = new ToolDeliveryId();
    
    private int quantity;
    private BigDecimal unitCost;
    private BigDecimal totalAmount;

    @EmbeddedId
    public ToolDeliveryId getToolDeliveryId() {
        return toolDeliveryId;
    }

    public void setToolDeliveryId(ToolDeliveryId toolDeliveryId) {
        this.toolDeliveryId = toolDeliveryId;
    }
    
    @Transient
    public TransactionIn getTransactionIn() {
        return getToolDeliveryId().getTransactionIn();
    }
    
    public void setTransactionIn(TransactionIn transactionIn) {
        getToolDeliveryId().setTransactionIn(transactionIn);
    }
    
    @Transient
    public ToolSupplier getToolSupplier() {
        return getToolDeliveryId().getToolSupplier();
    }
    
    public void setToolSupplier(ToolSupplier toolSupplier) {
        getToolDeliveryId().setToolSupplier(toolSupplier);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}
