
package Entities.Item;

import Entities.JoinedTables.MaterialSupplier;
import Entities.Supplier;
import java.io.Serializable;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materials")
public class Material implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="material_id")
    private int id;
    
    @Column(name="code")
    private String code;
    
    @Column(name="description")
    private String description;
    
    @Column(name="unit")
    private String unit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
//    @OneToMany(mappedBy = "materials",
//            cascade = CascadeType.ALL, targetEntity=MaterialSupplier.class)
//    private HashSet<MaterialSupplier> materialSuppliers = new HashSet<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public HashSet<MaterialSupplier> getMaterialSuppliers() {
//        return materialSuppliers;
//    }
//
//    public void setMaterialSuppliers(HashSet<MaterialSupplier> materialSuppliers) {
//        this.materialSuppliers = materialSuppliers;
//    }
//    
//    public void addMaterialSupplier(MaterialSupplier materialSupplier) {
//        this.materialSuppliers.add(materialSupplier);
//    }
    
}
