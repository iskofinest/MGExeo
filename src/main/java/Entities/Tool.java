
package Entities;

import Entities.Item.Item;
import Entities.JoinedTables.BorrowTool;
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
import javax.persistence.Table;

@Entity
@Table(name = "tools")
public class Tool extends Item implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tool_id")
    private int id;
    
    @Column(name="brand")
    private String brand;
    
    @Column(name="size")
    private String size;
    
    @Column(name="color")
    private String color;
    
    @OneToMany(mappedBy = "primaryKey.tools",
            cascade = CascadeType.ALL)
    private Set<BorrowTool> borrowTools;
    
    @OneToMany(mappedBy = "primaryKey.tools",
            cascade = CascadeType.ALL)
    private Set<ToolSupplier> toolSuppliers;

    public Tool() {}

    public Tool(String brand, String size, String color, Set<BorrowTool> borrowTools) {
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.borrowTools = borrowTools;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<BorrowTool> getBorrowTools() {
        return borrowTools;
    }

    public void setBorrowTools(Set<BorrowTool> borrowTools) {
        this.borrowTools = borrowTools;
    }

    public Set<ToolSupplier> getToolSuppliers() {
        return toolSuppliers;
    }

    public void setToolSuppliers(Set<ToolSupplier> toolSuppliers) {
        this.toolSuppliers = toolSuppliers;
    }
    
    public void addToolSupplier(ToolSupplier toolSupplier) {
        this.toolSuppliers.add(toolSupplier);
    }
    
    public void addBorrowTool(BorrowTool borrowTool) {
        this.borrowTools.add(borrowTool);
    }
    
}
