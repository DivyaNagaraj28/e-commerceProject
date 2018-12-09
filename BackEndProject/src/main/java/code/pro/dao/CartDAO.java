package code.pro.dao;

import java.util.List;

import code.pro.model.Cart;

public interface CartDAO {
	
	public boolean addToCart(Cart cart);
	public boolean removeFromCart(Cart cart);
	public boolean updateCart(Cart cart);
    public List<Cart> listCartItems(String username);
	public Cart getCart(int cartId);


}
