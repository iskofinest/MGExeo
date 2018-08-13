
package Entities;

import Entities.JoinedTables.BorrowTool;
import Entities.JoinedTables.ToolStock;
import Entities.JoinedTables.ToolSupplier;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tools")
public class Tool implements Serializable {
    
    private int id;
    
    private String code;
    private String description;
    private String unit;
    private String brand;
    private String size;
    private String color;
    
    private Set<ToolSupplier> toolSuppliers;
    private Set<BorrowTool> borrowTools;
    ToolStock toolStock;

    public Tool() {}

    public Tool(String code, String description, String unit, String brand, String size, String color) {
        this.code = code;
        this.description = description;
        this.unit = unit;
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tool_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @OneToMany(mappedBy = "toolSupplierId.tool",
            cascade = CascadeType.ALL)
    public Set<ToolSupplier> getToolSuppliers() {
        return toolSuppliers;
    }

    public void setToolSuppliers(Set<ToolSupplier> toolSuppliers) {
        this.toolSuppliers = toolSuppliers;
    }

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    public Set<BorrowTool> getBorrowTools() {
        return borrowTools;
    }

    public void setBorrowTools(Set<BorrowTool> borrowTools) {
        this.borrowTools = borrowTools;
    }
    
    public void addBorrowTool(BorrowTool borrowTool) {
        this.borrowTools.add(borrowTool);
    }

    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    public ToolStock getToolStock() {
        return toolStock;
    }

    public void setToolStock(ToolStock toolStock) {
        this.toolStock = toolStock;
    }

    @Override
    public String toString() {
        return "Tool{" + "id=" + id + ", code=" + code + ", description=" + description + ", unit=" + unit + ", brand=" + brand + ", size=" + size + ", color=" + color + '}';
    }
    
}
