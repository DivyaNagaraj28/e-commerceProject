package code.pro.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import code.pro.dao.CartDAO;
import code.pro.model.Cart;

public class TestCartDAO {

	static CartDAO  cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("code.pro");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart = new Cart();
		cart.setCartId(2);
		cart.setPrice(166);
		cart.setProductId(25);
		cart.setProductName("Glass Tumblr");
		cart.setQuantity(22);
		cart.setStatus("N");
		cart.setUserName("john");
		
		assertTrue("Problem in adding the Cart",cartDAO.addToCart(cart));
		
	}
    
	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart = cartDAO.getCart(1);
		cart.setProductName("small chair");
	
		assertTrue("Problem in updating the Cart",cartDAO.updateCart(cart));
		
	}
	@Ignore
	@Test
	public void deleteCartTest()
	{
		Cart cart =cartDAO.getCart(2);
		
		assertTrue("Problem in updating the Cart",cartDAO.removeFromCart(cart));
		
	}

	@Test
	public void listCartTest()
	{ 
		List<Cart> listCart=cartDAO.listCartItems("john");
		assertTrue("Problem in listing the Categories",listCart.size()>0);
		
		for(Cart cart:listCart)
		{
			System.out.println(cart);
		}
		
		
	}
	
	
	
}
