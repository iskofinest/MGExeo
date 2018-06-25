
package Entities.JoinedTables;

import Entities.Item.Tool;
import Entities.Supplier;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ToolSupplierId implements Serializable {
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Tool tool;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
    
}
