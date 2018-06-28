
package Entities.JoinedTables;

import Entities.Supplier;
import Entities.Tool;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tool_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "toolSupplierId.tools",
        joinColumns = @JoinColumn(name = "tool_id")),
    @AssociationOverride(name = "toolSupplierId.suppliers",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class ToolSupplier  {
    
    private ToolSupplierId toolSupplierId = new ToolSupplierId();
    private BigDecimal price;

    @EmbeddedId
    public ToolSupplierId getToolSupplierId() {
        return toolSupplierId;
    }

    public void setToolSupplierId(ToolSupplierId toolSupplierId) {
        this.toolSupplierId = toolSupplierId;
    }
    
    @Transient
    public Tool getTool() {
        return getToolSupplierId().getTool();
    }
    
    public void setTool(Tool tool) {
        getToolSupplierId().setTool(tool);
    }
    
    @Transient
    public Supplier getSupplier() {
        return getToolSupplierId().getSupplier();
    }
    
    public void setSupplier(Supplier supplier) {
        getToolSupplierId().setSupplier(supplier);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
    
}
