
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
    @AssociationOverride(name = "materialSupplierId.material",
        joinColumns = @JoinColumn(name = "material_id")),
    @AssociationOverride(name = "materialSupplierId.supplier",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class MaterialSupplier {
    
    MaterialSupplierId materialSupplierId = new MaterialSupplierId();
    
    private BigDecimal price;

    @EmbeddedId
    public MaterialSupplierId getMaterialSupplierId() {
        return materialSupplierId;
    }

    public void setMaterialSupplierId(MaterialSupplierId materialSupplierId) {
        this.materialSupplierId = materialSupplierId;
    }

    @Transient
    public Material getMaterial() {
        return getMaterialSupplierId().getMaterial();
    }

    public void setMaterial(Material material) {
        getMaterialSupplierId().setMaterial(material);
    }

    @Transient
    public Supplier getSupplier() {
        return getMaterialSupplierId().getSupplier();
    }

    public void setSupplier(Supplier supplier) {
        getMaterialSupplierId().setSupplier(supplier);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
