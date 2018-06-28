
package Entities.JoinedTables;

import Entities.Material;
import Entities.Supplier;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class MaterialSupplierId implements Serializable {
    
    private Material material;
    private Supplier supplier;
 
    @ManyToOne(cascade = CascadeType.ALL)
    public Material getMaterial() {
        return material;
    }
 
    public void setMaterial(Material material) {
        this.material = material;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    public Supplier getSupplier() {
        return supplier;
    }
 
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
}
