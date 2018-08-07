
package Entities.JoinedTables;

import Entities.TransactionIn;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MaterialDeliveryId implements Serializable {
    
    private TransactionIn transactionIn;
    private MaterialSupplier materialSupplier;
    
    @ManyToOne(cascade = CascadeType.ALL)
    public TransactionIn getTransactionIn() {
        return transactionIn;
    }

    public void setTransactionIn(TransactionIn transactionIn) {
        this.transactionIn = transactionIn;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public MaterialSupplier getMaterialSupplier() {
        return materialSupplier;
    }

    public void setMaterialSupplier(MaterialSupplier materialSupplier) {
        this.materialSupplier = materialSupplier;
    }
    
}
