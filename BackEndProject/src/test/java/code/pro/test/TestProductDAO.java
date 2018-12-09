package code.pro.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.pro.dao.ProductDAO;
import code.pro.model.Product;

public class TestProductDAO {


    static ProductDAO  productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("code.pro");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
    @Ignore
	@Test
	public void addProductTest()
	{
		Product product = new Product();
		
		product.setProductName("Bags");
		product.setProductDesc("americanTourister");
		product.setSupplierId(23);
		product.setCategoryId(50);
		product.setPrice(7000);
		product.setStock(16);
		assertTrue("Problem in adding the Product",productDAO.addProduct(product));
		
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Product product = productDAO.getProduct(51);

		product.setProductName("shoes");
		product.setProductDesc("Nick");
		product.setSupplierId(24);
		product.setCategoryId(51);
		product.setPrice(3000);
		product.setStock(20);
		
		assertTrue("Problem in updating the Product",productDAO.updateProduct(product));
		
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Product product =productDAO.getProduct(51);
		
		assertTrue("Problem in updating the Product",productDAO.deleteProduct(product));
		
	}
	
	@Test
	public void listCategoriesTest()
	{ 
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in listing the Product",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println(product);
		}
		
		
	}
	
  
	


}
