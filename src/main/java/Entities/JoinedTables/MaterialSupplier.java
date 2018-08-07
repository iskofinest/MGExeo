
package Entities.JoinedTables;

import Entities.Material;
import Entities.Supplier;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "material_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "materialSupplierId.material",
        joinColumns = @JoinColumn(name = "material_id")),
    @AssociationOverride(name = "materialSupplierId.supplier",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class MaterialSupplier implements Serializable {
    
    MaterialSupplierId materialSupplierId = new MaterialSupplierId();
    
    private String currency;
    private BigDecimal price;
    
    private Set<MaterialDelivery> materialDeliveries = new HashSet<>();

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "materialDeliveryId.materialSupplier",
            cascade = CascadeType.ALL)
    public Set<MaterialDelivery> getMaterialDeliveries() {
        return materialDeliveries;
    }

    public void setMaterialDeliveries(Set<MaterialDelivery> materialDeliveries) {
        this.materialDeliveries = materialDeliveries;
    }
    
    public void addMaterialDeliveries(MaterialDelivery materialDelivery) {
        this.materialDeliveries.add(materialDelivery);
    }
    
}
