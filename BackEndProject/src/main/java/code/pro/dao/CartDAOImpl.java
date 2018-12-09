package code.pro.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import code.pro.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {


	@Autowired
	SessionFactory sessionFactory;

	public boolean addToCart(Cart cart) {

		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}

	}

	public boolean removeFromCart(Cart cart) {

		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}

	}

	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}
	}

	public List<Cart> listCartItems(String username) {
		
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		List<Cart> listCart=query.list();
		session.close();
		
		return listCart;
	}

	public Cart getCart(int cartId) {
		
		Session session = sessionFactory.openSession();
		Cart cart = session.get(Cart.class,cartId);
		session.close();
		return cart;
	}


}
