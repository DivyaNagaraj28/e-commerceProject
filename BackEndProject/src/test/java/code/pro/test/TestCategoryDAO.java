package code.pro.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.pro.dao.CategoryDAO;
import code.pro.model.Category;

public class TestCategoryDAO {

	static CategoryDAO  categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("code.pro");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category = new Category();
		category.setCategoryName("chair");
		category.setCategoryDescrip("Rolling chair");
		
		assertTrue("Problem in adding the Category",categoryDAO.add(category));
		
	}
    
	
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(117);
		category.setCategoryName("Pencils");
		category.setCategoryDescrip("Apsara");
		
		assertTrue("Problem in updating the Category",categoryDAO.update(category));
		
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category =categoryDAO.getCategory(49);
		
		assertTrue("Problem in updating the Category",categoryDAO.delete(category));
		
	}
	
	@Test
	public void listCategoriesTest()
	{ 
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Problem in listing the Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println(category);
		}
		
		
	}
	
	
	
}
