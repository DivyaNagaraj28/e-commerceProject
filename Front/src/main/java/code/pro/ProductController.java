package code.pro;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import code.pro.dao.CategoryDAO;
import code.pro.dao.ProductDAO;
import code.pro.dao.SupplierDAO;
import code.pro.model.Category;
import code.pro.model.Product;
import code.pro.model.Supplier;
@Controller
public class ProductController
{

	@Autowired
	ProductDAO productDAO;


	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value="/Productform")
	public String listProduct(Model m)
	{   
		List<Product> listproduct=productDAO.listProducts();
		m.addAttribute("listproduct", listproduct);


		m.addAttribute("productmodel", new Product());
		m.addAttribute("listcate",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("listsupp",this.getSupplierList(supplierDAO.listSuppliers()));
		return "NewProduct";
	}

	@RequestMapping(value="/newproduct",method=RequestMethod.POST) 
	public String newProductData(@ModelAttribute("productmodel")Product product,@RequestParam("productImage")MultipartFile productImage,Model m)
	{   
		System.out.println(product.getPrice());
		productDAO.addProduct(product);


		String path="D:\\Divya\\workspaceEclipse1\\Front\\src\\main\\webapp\\resources\\images\\";

		path=path+String.valueOf(product.getProductId())+".jpg";

		File image = new File(path);

		if(!productImage.isEmpty())
		{
			try
			{
				byte[] buffer=productImage.getBytes();
				FileOutputStream fos= new FileOutputStream(image);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);
				bos.close();

			}

			catch(Exception e)
			{
				m.addAttribute("Failed","Failed to upload image"+" "+e);
			}
		}

		else
		{
			m.addAttribute("Failed","Failed to upload image");
		}
		Product newproductform = new Product();
		m.addAttribute("productmodel", newproductform);

		List<Product> listproduct=productDAO.listProducts();
		m.addAttribute("listproduct", listproduct);
		m.addAttribute("listcate",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("listsupp",this.getSupplierList(supplierDAO.listSuppliers()));



		return "NewProduct";
	}


	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateCategoryData(@ModelAttribute("productmodelupdate")Product product,Model m)
	{

		productDAO.addProduct(product);

		Product newproductform = new Product();
		m.addAttribute("productmodelupdate", newproductform);

		List<Product> listproduct=productDAO.listProducts();
		m.addAttribute("listproduct", listproduct);
		m.addAttribute("listcate",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("listsupp",this.getSupplierList(supplierDAO.listSuppliers()));

		return "NewProduct";
	}

	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProductData(@PathVariable("productId")int productId,Model m)
	{
		Product product= productDAO.getProduct(productId);
		productDAO.deleteProduct(product);


		Product newproductform = new Product();
		m.addAttribute("productmodel", newproductform);

		List<Product> listproduct=productDAO.listProducts();
		m.addAttribute("listproduct", listproduct);

		m.addAttribute("listcate",this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("listsupp",this.getSupplierList(supplierDAO.listSuppliers()));

		return "NewProduct";
	}
	@RequestMapping(value="/Productview")
	public String viewProduct(Model m)
	{   
		List<Product> listproduct=productDAO.listProducts();
		m.addAttribute("listproduct", listproduct);
		return "ProductView";
	}


	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listcategory)
	{
		LinkedHashMap<Integer,String> listcate = new LinkedHashMap<>();

		for(Category category:listcategory)
		{
			listcate.put(category.getCategoryId(),category.getCategoryName());
		}
		return listcate;

	}
	public LinkedHashMap<Integer,String> getSupplierList(List<Supplier> listproduct)
	{
		LinkedHashMap<Integer,String> listsupp = new LinkedHashMap<>();

		for(Supplier supplier:listproduct)
		{

			listsupp.put(supplier.getSupplierId(),supplier.getSupplierName());
		}
		return listsupp;

	}

}





