
package Entities.JoinedTables;

import Entities.Tool;
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
@Table(name = "tool_stock")
public class ToolStock {
    
    int id;
    int quantity;
    BigDecimal totalAmount;
    
    Tool tool;

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
    @JoinColumn(name = "tool_id")
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
    
    public void addQuantity(Tool tool, int quantity, BigDecimal unitPrice) {
        setQuantity(getQuantity() + quantity);
        setTotalAmount(getTotalAmount().add(unitPrice.multiply(BigDecimal.valueOf(Double.parseDouble(String.valueOf(unitPrice))))));
    }
    
}
