
package Entities.JoinedTables;

import Entities.Tool;
import Entities.Supplier;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ToolSupplierId implements Serializable {
    
    private Tool tool;
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
    
}
