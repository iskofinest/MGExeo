
package Entities.JoinedTables;

import Entities.Material;
import Entities.Supplier;
import java.math.BigDecimal;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "material_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.material",
        joinColumns = @JoinColumn(name = "material_id")),
    @AssociationOverride(name = "primaryKey.supplier",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class MaterialSupplier {
    
    MaterialSupplierId primaryKey = new MaterialSupplierId();
    
    private BigDecimal price;

    @EmbeddedId
    public MaterialSupplierId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(MaterialSupplierId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Material getMaterial() {
        return getPrimaryKey().getMaterial();
    }

    public void setMaterial(Material material) {
        getPrimaryKey().setMaterial(material);
    }

    @Transient
    public Supplier getSupplier() {
        return getPrimaryKey().getSupplier();
    }

    public void setSupplier(Supplier supplier) {
        getPrimaryKey().setSupplier(supplier);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
