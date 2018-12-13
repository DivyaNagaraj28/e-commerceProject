package code.pro;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import code.pro.dao.CategoryDAO;
import code.pro.model.Category;
@Controller
public class CategoryController
{

	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping(value="/Categoryform")
	public String listCategory(Model m)
	{   
		List<Category> listcategory=categoryDAO.listCategories();
		m.addAttribute("listcategory", listcategory);
		return "NewCategory";
	}

	@RequestMapping(value="/newCategory",method=RequestMethod.POST)
	public String newCategoryData(@RequestParam("categoryName")String Name,@RequestParam("categoryDesc")String Description,Model m)
	{
		Category category = new Category();
		category.setCategoryName(Name);
		category.setCategoryDescrip(Description);

		categoryDAO.add(category);
		List<Category> listcategory=categoryDAO.listCategories();
		m.addAttribute("listcategory", listcategory);


		return "NewCategory";
	}


	@RequestMapping(value="editCategory/updateCategory",method=RequestMethod.POST)
	public String updateCategoryData(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String Name,@RequestParam("categoryDesc")String Description,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(Name);
		category.setCategoryDescrip(Description);

		categoryDAO.update(category);
		List<Category> listcategory=categoryDAO.listCategories();
		m.addAttribute("listcategory", listcategory);

		return "NewCategory";
	}

	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategoryData(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);

                 m.addAttribute("show",category);
		

		return "UpdateCategory";
	}

	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String updateCategoryData(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.delete(category);


		List<Category> listcategory=categoryDAO.listCategories();
		m.addAttribute("listcategory", listcategory);

		return "NewCategory";
	}
}





