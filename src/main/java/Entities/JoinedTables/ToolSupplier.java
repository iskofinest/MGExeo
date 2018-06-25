
package Entities.JoinedTables;

import Entities.Item.Tool;
import Entities.Supplier;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tool_supplier")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.tools",
        joinColumns = @JoinColumn(name = "tool_id")),
    @AssociationOverride(name = "primaryKey.suppliers",
        joinColumns = @JoinColumn(name = "supplier_id")) })
public class ToolSupplier implements Serializable {
    
    private ToolSupplierId primaryKey = new ToolSupplierId();
    
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="id")
//    private int id;
//
//    @OneToMany(mappedBy = "primaryKey.tools",
//            cascade = CascadeType.ALL)
//    private Set<Tool> tools = new HashSet<>(0);
//    
//    @Column(name="price")    
//    private BigDecimal price;
//    
//    @OneToMany(mappedBy = "primaryKey.suppliers",
//            cascade = CascadeType.ALL)
//    private Set<Supplier> suppliers = new HashSet<Supplier>(0);
    
}
