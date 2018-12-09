package code.pro.test;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.pro.dao.SupplierDAO;


import code.pro.model.Supplier;


public class TestSupplierDAO {


    static SupplierDAO  supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("code.pro");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
    
	@Test
	public void registerSupplierTest()
	{
    	Supplier supplier = new Supplier();
    	supplier.setSupplierId(2);
    	supplier.setSupplierName("mark");
    	supplier.setSupplierAddress("chennai");
    	
    	
	    assertTrue("Problem in adding the Supplier",supplierDAO.registerSupplier(supplier));
		
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
	    Supplier supplier = supplierDAO.getSupplier(1);
	    supplier.setSupplierAddress("mumbai");
		
		assertTrue("Problem in updating the supplier",supplierDAO.updateSupplier(supplier));
		
	}
	@Test
	public void listCategoriesTest()
	{ 
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertTrue("Problem in listing the Suppliers",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println(supplier);
		}
		
		
	}
	
	
	}

	
  
		



