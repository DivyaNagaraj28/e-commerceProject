package code.pro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MappingFile {
	@RequestMapping("/login") 
	public String showlogin()
	{
		return "LoginPage"; 
	}
	@RequestMapping("/main") 
	public String showMain()
	{
		return "MainPage"; 
	}

	@RequestMapping("/displayCategory") 
	public String showCategory()
	{
		return "Display";  
	}

	@RequestMapping("/updateCategory") 
	public String updateCategory()
	{
		return "UpdateCategory"; 
	}

	@RequestMapping("/new") 
	public String newproduct()
	{
		return "NewFile"; 
	}

}
