
package Entities;

import Entities.JoinedTables.BorrowTool;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="transactions")
public class Transactions {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="transaction_code")
    private String transactionCode;
    
    @Column(name="transaction_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="requests")
    private Set<Request> requests = new HashSet<>();
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="transaction")
//    private Set<BorrowTool> borrowTools = new HashSet<>();
    
    @Column(name="transaction_date")
    private BigDecimal grandTotal;

    public Transactions() {
    }

    

//    @Override
//    public String toString() {
//        String requestList = "{";
//        Request[] requests = (Request[])getRequests().toArray();
//        for(Request request : requests) requestList += request.getItem().getDescription()+ ", ";
//        requestList += "}\n";
//        return "Transactions{" + "id=" + id + ", transactionCode=" + transactionCode + ", transactionDate=" + transactionDate + ", requests=" + requestList + ", grandTotal=" + grandTotal + '}';
//    }
    
    
    
}
