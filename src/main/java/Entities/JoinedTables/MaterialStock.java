
package Entities.JoinedTables;

import Entities.Material;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material_stock")
public class MaterialStock {
    
    int id;
    int quantity;
    BigDecimal totalAmount;
    
    Material material;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="stock_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @OneToOne
    @JoinColumn(name = "material_id")
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void addQuantity(Material material, int quantity, BigDecimal unitPrice) {
        setQuantity(getQuantity() + quantity);
        setTotalAmount(getTotalAmount().add(unitPrice.multiply(BigDecimal.valueOf(Double.parseDouble(String.valueOf(unitPrice))))));
    }
    
}
