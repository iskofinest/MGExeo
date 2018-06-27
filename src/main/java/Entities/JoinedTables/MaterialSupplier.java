
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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.supplier",
        joinColumns = @JoinColumn(name = "supplier_id")),
@AssociationOverride(name = "primaryKey.material",
        joinColumns = @JoinColumn(name = "material_id")) })
public class MaterialSupplier implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "material_supplier_id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @EmbeddedId
    private MaterialSupplierId primaryKey = new MaterialSupplierId();
    
//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Supplier.class)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier")
    private Supplier supplier;
    
//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Material.class)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material")
    private Material material;
    
    @Column(name="price")    
    private BigDecimal price;

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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    
    
}
