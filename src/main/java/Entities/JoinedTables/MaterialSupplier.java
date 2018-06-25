
package Entities.JoinedTables;

import Entities.Item.Material;
import Entities.Supplier;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.material",
        joinColumns = @JoinColumn(name = "material_id")),
    @AssociationOverride(name = "primaryKey.supplier",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class MaterialSupplier implements Serializable{
    
    @EmbeddedId
    private MaterialSupplierId primaryKey = new MaterialSupplierId();
    
    @Column(name="price")    
    private BigDecimal price;
    
    @OneToMany(mappedBy = "this.primaryKey.supplier",
            cascade = CascadeType.ALL)
    private Set<Supplier> suppliers = new HashSet<Supplier>(0);
    
    @OneToMany(mappedBy = "this.primaryKey.material",
            cascade = CascadeType.ALL)
    private Set<Material> materials = new HashSet<>(0);

    public MaterialSupplier() {}

    public MaterialSupplierId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(MaterialSupplierId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
    
}
