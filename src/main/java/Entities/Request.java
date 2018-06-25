
package Entities;

import Entities.Item.Item;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="quantity", nullable=false)
    private int quantity;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy="request")
    private Item item;

    public Request() {
    }
    
    public Request(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Request{" + "id=" + id + ", quantity=" + quantity + ", item=" + item.getDescription() + '}';
    }
    
    
    
}
