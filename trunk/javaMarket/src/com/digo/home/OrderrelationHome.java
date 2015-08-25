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
import com.digo.pojo.Orderrelation;
import com.digo.pojo.Orders;

/**
 * Home object for domain model class Orderrelation.
 * @see com.digo.pojo.Orderrelation
 * @author 
 */
public class OrderrelationHome extends BaseDao{

	public boolean persist(Orderrelation transientInstance) {
		
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

	public boolean attachDirty(Orderrelation instance) {
		
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

	public boolean attachClean(Orderrelation instance) {
		
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

	public boolean delete(Orderrelation persistentInstance) {
		
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

	public Orderrelation merge(Orderrelation detachedInstance) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Orderrelation result = (Orderrelation) session.merge(detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Orderrelation();
		}
	}

	public Orderrelation findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Orderrelation instance = (Orderrelation)session.get("com.digo.pojo.Orderrelation", id);
			tx.commit();
			if (instance == null) {
				instance = new Orderrelation();
			} 
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Orderrelation();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Orderrelation> findByExample(Orderrelation instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Orderrelation> results = session
					.createCriteria("com.digo.pojo.Orderrelation")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Orderrelation>();
		}
	}
	
	public List<Orderrelation> findByProperty(String pro, String name) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Orderrelation where " + pro + " = '" + name + "'";
			Query query = session.createQuery(hql);

			List<Orderrelation> results = (List<Orderrelation>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
}
