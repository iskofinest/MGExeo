
package Entities.JoinedTables;

import Entities.Tool;
import Entities.TransactionOut;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="borrow_tools")
public class BorrowTool {
    
    private int id;
    private int quantity;
    private Tool tool;
    private BigDecimal totalAmount;
    private Date borrowDate;
    private Date returnDate;
    

    public BorrowTool() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="borrow_id")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tool_id")
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name="borrow_date")
    @Temporal(TemporalType.DATE)
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Column(name="return_date")
    @Temporal(TemporalType.DATE)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
