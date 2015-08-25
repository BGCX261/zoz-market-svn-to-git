package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.digo.base.BaseDao;
import com.digo.pojo.Goods;
import com.digo.pojo.User;

/**
 * Home object for domain model class User.
 * @see com.digo.pojo.User
 * @author Hibernate Tools
 */
public class UserHome extends BaseDao{
	private Map<String,String> powerMap;
	
	private RoleHome roleHome;
	
	private RolerelationHome rolerelationHome;
	
	public void setRoleHome(RoleHome roleHome) {
		this.roleHome = roleHome;
	}

	public void setRolerelationHome(RolerelationHome rolerelationHome) {
		this.rolerelationHome = rolerelationHome;
	}

	public boolean persist(User transientInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(transientInstance);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean attachDirty(User instance) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(instance);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean attachClean(User instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.lock(instance, LockMode.NONE);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean delete(User persistentInstance) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.delete(persistentInstance);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public User merge(User detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			User result = (User) session.merge(
					detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new User();
		}
	}

	public User findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			User instance = (User) session.get(
					"com.digo.pojo.User", id);
			tx.commit();
			if (instance == null) {
				instance = new User();
			} 
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new User();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExample(User instance) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<User> results = session
					.createCriteria("com.digo.pojo.User")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<User>();
		}
	}
	
	public User findByProperty(String pro, String name) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User where " + pro + " = '" + name + "'";
			Query query = session.createQuery(hql);

			List<User> results = (List<User>)query.list();
			tx.commit();
			return results.isEmpty()?null:results.get(0);
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
	
	public String findPowerByRoleId(String roleId)
	{
		if(powerMap == null)
		{
			this.powerMap = rolerelationHome.findPowerByRoleList(roleHome.getAllRole());
		}
		return powerMap.get(roleId);
	}
	
}
