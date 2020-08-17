package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;
import utility.HibernateConnectionManager;

public class UserDao {
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	//private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public int signUp(User user) {
		System.out.println("check dopost 3");

		 Session session = this.sessionFactory.openSession();
			System.out.println("check dopost 4");

	     Transaction transaction = session.beginTransaction();  
	            if(session.save(user)!=null)
	        	{
	        		System.out.println("check dopost 5");

	        		 transaction.commit();
	        		 session.close();

	        		 return 1;
	        	}
	        	else {
	        		 return 0;  
	        	}
	}

}
