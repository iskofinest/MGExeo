
package Entities.JoinedTables;

import Entities.Item.Item;
import Entities.Tool;
import Entities.Transactions;
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
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="quantity", nullable=false)
    private int quantity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Transactions transaction;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tool_id")
    private Tool tool;
    
    @Column(name="borrow_date")
    @Temporal(TemporalType.DATE)
    private Date borrowDate;
    
    @Column(name="return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    
}
