package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.digo.base.BaseDao;
import com.digo.pojo.Role;
import com.digo.pojo.User;

/**
 * Home object for domain model class Role.
 * @see com.digo.pojo.Role
 * @author Hibernate Tools
 */
public class RoleHome extends BaseDao{

	public boolean persist(Role transientInstance) {
		
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

	public boolean attachDirty(Role instance) {
		
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

	@SuppressWarnings("deprecation")
	public boolean attachClean(Role instance) {
		
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

	public boolean delete(Role persistentInstance) {
		
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

	public Role merge(Role detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Role result = (Role) session.merge(
					detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Role();
		}
	}

	public Role findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Role instance = (Role) session.get(
					"com.digo.pojo.Role", id);
			tx.commit();
			if (instance == null) {
				instance = new Role();
			} 
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Role();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Role> findByExample(Role instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Role> results = session
					.createCriteria("com.digo.pojo.Role")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Role>();
		}
	}
	
	public List<Role> getAllRole(){
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Role";
			Query query = session.createQuery(hql);

			List<Role> results = (List<Role>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
}
