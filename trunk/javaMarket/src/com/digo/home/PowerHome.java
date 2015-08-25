package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.digo.base.BaseDao;
import com.digo.pojo.Power;

/**
 * Home object for domain model class Power.
 * @see com.digo.pojo.Power
 * @author Hibernate Tools
 */
public class PowerHome extends BaseDao{

	public boolean persist(Power transientInstance) {
	
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

	public boolean attachDirty(Power instance) {
		
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

	public boolean attachClean(Power instance) {
		
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

	public boolean delete(Power persistentInstance) {
		
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

	public Power merge(Power detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Power result = (Power) session.merge(
					detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Power();
		}
	}

	public Power findById(String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Power instance = (Power) session.get(
					"com.digo.pojo.Power", id);
			tx.commit();
			if (instance == null) {
				instance = new Power();
			}
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Power();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Power> findByExample(Power instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Power> results =session
					.createCriteria("com.digo.pojo.Power")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Power>();
		}
	}
}
