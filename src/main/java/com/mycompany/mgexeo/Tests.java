
package com.mycompany.mgexeo;

import Entities.JoinedTables.MaterialSupplier;
import Entities.JoinedTables.ToolSupplier;
import Entities.Material;
import Entities.MaterialRequest;
import Entities.Project;
import Entities.Supplier;
import Entities.Tool;
import Entities.Transactions;
import Entities.User;
import Services.MaterialService;
import Services.MaterialSupplierService;
import Services.ProjectService;
import Services.RequestService;
import Services.SupplierService;
import Services.ToolService;
import Services.TransactionService;
import Services.UserService;
import java.math.BigDecimal;
import java.util.Date;

public class Tests {
    
    static Material material;
    
    public static void TestItemEntities() {
        Supplier supplier = new Supplier();
        supplier.setCode("1");
        supplier.setName("sample");
        supplier.setAddress("sample");
        supplier.setTelephone("sample");
        supplier.setEmail("sample");
        supplier.setContactPerson("sample");
        supplier.setTinNo("sample");
        supplier.setFaxNo("sample");
        System.out.println("SUPPLIER SAVED: " + SupplierService.saveSupplier(supplier));
        
        material = new Material();
        material.setCode("123");
        material.setDescription("material description");
        material.setUnit("pcs");
        System.out.println("MATERIAL SAVED: " + MaterialService.saveMaterial(material));
        
        Tool tool = new Tool("tool code", "tool description", "tool unit", "tool brand", "tool size", "tool color");
        System.out.println("TOOL SAVED: " + ToolService.saveTool(tool));
        
        User user = new User("admin", 
        "admin",
        "admin",
        "admin",
        "admin",
        "admin",
        "admin");
        System.out.println("USER SAVED: " + UserService.saveUser(user));
        System.out.println("FINISHED");

        Supplier supplier1 = SupplierService.findMaterialById(1);
        Material material1 = MaterialService.findMaterialById(1);
        Tool tool1 = ToolService.findToolById(1);
        
        MaterialSupplier materialSupplier = new MaterialSupplier();
        materialSupplier.setMaterial(material1);
        materialSupplier.setSupplier(supplier1);
        materialSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("500")));
        System.out.println("MATERIAL SUPPLIER SAVED: " + MaterialSupplierService.saveMaterialSupplier(materialSupplier));
        
        ToolSupplier toolSupplier = new ToolSupplier();
        toolSupplier.setTool(tool1);
        toolSupplier.setSupplier(supplier1);
        toolSupplier.setPrice(BigDecimal.valueOf(Double.parseDouble("3000")));
        System.out.println("TOOL SUPPLIER SAVED: " + ToolService.saveToolSupplier(toolSupplier));
        
        System.out.println(supplier1.toString());
        System.out.println(material1.toString());
        System.out.println(materialSupplier.toString());
        
    }
    
    
    static Project project;
    static Transactions transaction;
    
    public static void testProject() {
        project = new Project();
        project.setProjectCode("project code");
        project.setProjectName("project name");
        project.setDateStarted(new Date());
        project.setDateFinished(new Date());
        project.setDateCreated(new Date());
        project.setSpentAmount(BigDecimal.valueOf(Double.parseDouble("12345")));
        project.setTotalBudget(BigDecimal.valueOf(Double.parseDouble("2468")));
        System.out.println("PROJECT SAVED: " + ProjectService.saveProject(project));
    }
    
    public static void testTransaction() {
        transaction = new Transactions("transaction code", new Date(), new Date(), BigDecimal.valueOf(Double.parseDouble("369")));
        transaction.setProject(project);
        System.out.println("TRANSACTION SAVED: " + TransactionService.saveTransaction(transaction));
    }
    
    public static void testRequest() {
        material = new Material();
        material.setCode("123");
        material.setDescription("material description");
        material.setUnit("pcs");
        System.out.println("MATERIAL SAVED: " + MaterialService.saveMaterial(material));
        
        MaterialRequest materialRequest = new MaterialRequest();
        materialRequest.setQuantity(10);
        materialRequest.setTotalAmount(BigDecimal.valueOf(Double.parseDouble("13579")));
        materialRequest.setTransaction(transaction);
        materialRequest.setMaterial(material);
        System.out.println("MATERIAL REQUEST SAVED: " + RequestService.saveRequest(materialRequest));
        
    }
    
}
