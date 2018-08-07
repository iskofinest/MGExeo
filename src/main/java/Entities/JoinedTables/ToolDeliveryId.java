
package Entities.JoinedTables;

import Entities.TransactionIn;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ToolDeliveryId implements Serializable {
    
    private TransactionIn transactionIn;
    private ToolSupplier toolSupplier;

    @ManyToOne(cascade = CascadeType.ALL)
    public TransactionIn getTransactionIn() {
        return transactionIn;
    }

    public void setTransactionIn(TransactionIn transactionIn) {
        this.transactionIn = transactionIn;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public ToolSupplier getToolSupplier() {
        return toolSupplier;
    }

    public void setToolSupplier(ToolSupplier toolSupplier) {
        this.toolSupplier = toolSupplier;
    }
    
}
