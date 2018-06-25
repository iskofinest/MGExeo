
package Entities;

import Entities.JoinedTables.MaterialSupplier;
import java.io.Serializable;
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
@Table(name = "suppliers")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="supplier_id")
    private int id;
    
    @Column(name="code")
    private String code;
    
    @Column(name="name")
    private String name;
    
    @Column(name="address")
    private String address;
    
    @Column(name="telephone")
    private String telephone;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contact_person")
    private String contactPerson;
    
    @Column(name="tin_no")
    private String tinNo;
    
    @Column(name="fax_no")
    private String faxNo;
    
    @OneToMany(mappedBy = "material")
    private Set<MaterialSupplier> materialSuppliers = new HashSet<>();
    
    
//    @OneToMany(mappedBy = "primaryKey.suppliers",
//            cascade = CascadeType.ALL)
//    private Set<ToolSupplier> toolSuppliers = new HashSet<>();

    public Supplier() {
    }
    
    

//    @Override
//    public String toString() {
//        return "Supplier{" + "id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", contactPerson=" + contactPerson + ", tinNo=" + tinNo + ", faxNo=" + faxNo + 
//                "\n\tmaterialSuppliers=" + getMaterialSuppliers().toArray().toString() + ",\n\t toolSuppliers=" + getToolSuppliers().toArray().toString() + "\n}";
//    }

    public Supplier(String code, String name, String address, String telephone, String email, String contactPerson, String tinNo, String faxNo) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.contactPerson = contactPerson;
        this.tinNo = tinNo;
        this.faxNo = faxNo;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

//    public Set<MaterialSupplier> getMaterialSuppliers() {
//        return materialSuppliers;
//    }
//
//    public void setMaterialSuppliers(Set<MaterialSupplier> materialSuppliers) {
//        this.materialSuppliers = materialSuppliers;
//    }

//    public Set<ToolSupplier> getToolSuppliers() {
//        return toolSuppliers;
//    }

//    public void setToolSuppliers(Set<ToolSupplier> toolSuppliers) {
//        this.toolSuppliers = toolSuppliers;
//    }
    
//    public void addToolSupplier(ToolSupplier toolSupplier) {
//        this.toolSuppliers.add(toolSupplier);
//    }
    
//    public void addMaterialSupplier(MaterialSupplier materialSupplier) {
//        this.materialSuppliers.add(materialSupplier);
//    }
    
}
