package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;
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
import com.digo.pojo.Records;
import com.digo.pojo.User;

/**
 * Home object for domain model class Records.
 * @see com.digo.pojo.Records
 * @author Hibernate Tools
 */
public class RecordsHome extends BaseDao{

	public boolean persist(Records transientInstance) {
		
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

	public boolean attachDirty(Records instance) {
	
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

	public boolean attachClean(Records instance) {
	
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

	public boolean delete(Records persistentInstance) {
		
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

	public Records merge(Records detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Records result = (Records) session
					.merge(detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Records();
		}
	}

	public Records findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Records instance = (Records) session
					.get("com.digo.pojo.Records", id);
			tx.commit();
			if (instance == null) {
				instance = new Records();
			}
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Records();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Records> findByExample(Records instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Records> results = session
					.createCriteria("com.digo.pojo.Records")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Records>();
		}
	}
	
	public Records findByProperty(String pro, String name) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Records where " + pro + " = '" + name + "'";
			Query query = session.createQuery(hql);

			List<Records> results = (List<Records>)query.list();
			tx.commit();
			return results.isEmpty()?null:results.get(0);
		} catch (RuntimeException re) {
			re.printStackTrace();
			return null;
		}
	}
}
