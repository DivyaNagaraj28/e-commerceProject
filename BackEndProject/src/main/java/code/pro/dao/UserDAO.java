package code.pro.dao;

import code.pro.model.UserDetails;

public interface UserDAO {
	
	public boolean registerUser(UserDetails userDetails);
	public boolean updateUser(UserDetails userDetails);
	public UserDetails getUser(String username);

}
