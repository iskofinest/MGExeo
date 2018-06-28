
package Entities;

import Entities.JoinedTables.MaterialSupplier;
import java.util.HashSet;
import java.util.Set;
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
public class Material {

    private int id;
    private String code;
    private String description;
    private String unit;
    private Set<MaterialSupplier> materialSuppliers = new HashSet<>();

    public Material() {
    }

    public Material(String code, String description, String unit) {
        this.code = code;
        this.description = description;
        this.unit = unit;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="material_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Column(name="code")
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

//    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @OneToMany(mappedBy = "primaryKey.material",
            cascade = CascadeType.ALL)
    public Set<MaterialSupplier> getMaterialSuppliers() {
        return materialSuppliers;
    }

    public void setMaterialSuppliers(Set<MaterialSupplier> materialSuppliers) {
        this.materialSuppliers = materialSuppliers;
    }
    
    public void addMaterialSupplier(MaterialSupplier materialSupplier) {
        this.materialSuppliers.add(materialSupplier);
    }
    
}
