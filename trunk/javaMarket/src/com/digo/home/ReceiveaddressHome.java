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
import com.digo.pojo.Receiveaddress;
import com.digo.pojo.User;

/**
 * Home object for domain model class Receiveaddress.
 * @see com.digo.pojo.Receiveaddress
 * @author Hibernate Tools
 */
public class ReceiveaddressHome extends BaseDao{

	public boolean persist(Receiveaddress transientInstance) {
		
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

	public boolean attachDirty(Receiveaddress instance) {
		
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

	public boolean attachClean(Receiveaddress instance) {
		
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

	public boolean delete(Receiveaddress persistentInstance) {
		
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

	public Receiveaddress merge(Receiveaddress detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Receiveaddress result = (Receiveaddress)session.merge(detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Receiveaddress();
		}
	}

	public Receiveaddress findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Receiveaddress instance = (Receiveaddress) session
					.get("com.digo.pojo.Receiveaddress", id);
			tx.commit();
			if (instance == null) {
			instance = new Receiveaddress();	
			}
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Receiveaddress();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Receiveaddress> findByExample(Receiveaddress instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Receiveaddress> results =session
					.createCriteria("com.digo.pojo.Receiveaddress")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Receiveaddress>();
		}
	}
	
	public List<Receiveaddress> findListByProperty(String pro, String name) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Receiveaddress where " + pro + " = '" + name + "'";
			Query query = session.createQuery(hql);

			List<Receiveaddress> results = (List<Receiveaddress>)query.list();
			tx.commit();
			return results.isEmpty()?null:results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
}
