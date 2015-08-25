package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.digo.base.BaseDao;
import com.digo.pojo.Orders;
import com.digo.pojo.User;

/**
 * Home object for domain model class Orders.
 * @see com.digo.pojo.Orders
 * @author Hibernate Tools
 */
public class OrdersHome extends BaseDao{

	public boolean persist(Orders transientInstance) {
		
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

	public boolean attachDirty(Orders instance) {
		
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

	public boolean attachClean(Orders instance) {
		
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

	public boolean delete(Orders persistentInstance) {
		
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

	public Orders merge(Orders detachedInstance) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Orders result = (Orders) session.merge(
					detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Orders();
		}
	}

	public Orders findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Orders instance = (Orders) session.get(
					"com.digo.pojo.Orders", id);
			tx.commit();
			if (instance == null) {
			instance = new Orders();
			} 
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Orders();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Orders> findByExample(Orders instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Orders> results = session
					.createCriteria("com.digo.pojo.Orders")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
	
	public List<Orders> findByProperty(String pro, String name) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Orders where " + pro + " = '" + name + "'";
			Query query = session.createQuery(hql);

			List<Orders> results = (List<Orders>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
	
	public List<Orders> findAll(){
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Orders";
			Query query = session.createQuery(hql);

			List<Orders> results = (List<Orders>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
}
