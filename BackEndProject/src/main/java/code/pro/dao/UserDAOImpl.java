package code.pro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import code.pro.model.UserDetails;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	public boolean registerUser(UserDetails userDetails) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}
	}
	

	public boolean updateUser(UserDetails userDetails) {
		try
		{
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		}
		catch(Exception e)
		{
			return false;

		}
		
	}

	public UserDetails getUser(String username) {
		Session session = sessionFactory.openSession();
	    UserDetails userDetails=(UserDetails)session.get(UserDetails.class, username);
		session.close();
		return userDetails;
		
	}

}
