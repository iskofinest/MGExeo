
package Entities.JoinedTables;

import Entities.Item.Material;
import Entities.Supplier;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MaterialSupplierId implements Serializable {
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Material material;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
}
