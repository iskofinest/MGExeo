
package Entities.JoinedTables;

import Entities.TransactionIn;
import java.math.BigDecimal;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "material_delivery")
@AssociationOverrides({
    @AssociationOverride(name = "materialDeliveryId.transactionIn",
        joinColumns = @JoinColumn(name = "transaction_in_id")),
    @AssociationOverride(name = "materialDeliveryId.materialSupplier.materialSupplierId.material.id",
        joinColumns = @JoinColumn(name = "material_id")),
    @AssociationOverride(name = "materialDeliveryId.materialSupplier.materialSupplierId.supplier.id",
        joinColumns = @JoinColumn(name = "supplier_id"))
})
public class MaterialDelivery {
    
    MaterialDeliveryId materialDeliveryId = new MaterialDeliveryId();
    
    private int quantity;
    private BigDecimal unitCost;
    private BigDecimal totalAmount;
    
    @EmbeddedId
    public MaterialDeliveryId getMaterialDeliveryId() {
        return this.materialDeliveryId;
    }

    public void setMaterialDeliveryId(MaterialDeliveryId materialDeliveryId) {
        this.materialDeliveryId = materialDeliveryId;
    }
    
    @Transient
    public TransactionIn getTransactionIn() {
        return getMaterialDeliveryId().getTransactionIn();
    }
    
    public void setTransactionIn(TransactionIn transactionIn) {
        getMaterialDeliveryId().setTransactionIn(transactionIn);
    }
    
    @Transient
    public MaterialSupplier getMaterialSupplier() {
        return getMaterialDeliveryId().getMaterialSupplier();
    }
    
    public void setMaterialSupplier(MaterialSupplier materialSupplier) {
        getMaterialDeliveryId().setMaterialSupplier(materialSupplier);
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
