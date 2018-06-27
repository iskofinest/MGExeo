
package com.mycompany.mgexeo;

import Entities.JoinedTables.MaterialSupplier;
import Entities.Material;
import Entities.Supplier;
import Entities.User;
import Services.MaterialService;
import Services.MaterialSupplierService;
import Services.SupplierService;
import Services.UserService;
import java.math.BigDecimal;

public class MGExeo {
    public static void main(String[] args) {
        System.out.println("STARTED");
        
//        Supplier supplier = new Supplier();
//        supplier.setCode("1");
//        supplier.setName("sample");
//        supplier.setAddress("sample");
//        supplier.setTelephone("sample");
//        supplier.setEmail("sample");
//        supplier.setContactPerson("sample");
//        supplier.setTinNo("sample");
//        supplier.setFaxNo("sample");
//        System.out.println("SUPPLIER SAVED: " + SupplierService.saveSupplier(supplier));
//        
//        Material material = new Material();
//        material.setCode("123");
//        material.setDescription("material description");
//        material.setUnit("pcs");
//        System.out.println("MATERIAL SAVED: " + MaterialService.saveMaterial(material));
        
//        User user = new User("admin", 
//        "admin",
//        "admin",
//        "admin",
//        "admin",
//        "admin",
//        "admin");
//        System.out.println("USER SAVED: " + UserService.saveUser(user));
//        System.out.println("FINISHED");

        Supplier supplier1 = SupplierService.findMaterialById(1);
        Material material1 = MaterialService.findMaterialById(1);
        
        MaterialSupplier materialSupplier = new MaterialSupplier();
        materialSupplier.setMaterial(material1);
        materialSupplier.setSupplier(supplier1);
        materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("500")));
        System.out.println("MATERIAL SUPPLIER SAVED: " + MaterialSupplierService.saveMaterialSupplier(materialSupplier));
        
        
        
        System.out.println(supplier1.toString());
        System.out.println(material1.toString());
        System.out.println(materialSupplier.toString());
        
    }
}
