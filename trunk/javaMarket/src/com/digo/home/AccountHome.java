package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.digo.base.BaseDao;
import com.digo.pojo.Account;

/**
 * Home object for domain model class Account.
 * @see com.digo.pojo.Account
 * @author Hibernate Tools
 */
public class AccountHome extends BaseDao{

	public void persist(Account account) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(account);
			tx.commit();
		
		} catch (RuntimeException re) {
		
			throw re;
		}
	}

	public void attachDirty(Account account) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(account);
			tx.commit();
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Account account) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.lock(account, LockMode.NONE);
			tx.commit();
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void delete(Account account) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.delete(account);
			tx.commit();
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public Account merge(Account account) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Account result = (Account) session
					.merge(account);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}





	/***********************************************
	 * description   : 
	 * @return       : Account
	 * @param        : @param id
	 * @param        : @return
	 * @modified     : chen ,  2012-12-8  下午02:45:09
	 * @see          : 
	 **********************************************/
	public Account findById(String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Account account = (Account) session
					.get("com.digo.pojo.Account", id);
			tx.commit();
			if (account == null) {
				account = new Account();
			} else {
				
			}
			return account;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	/** ********************************************
	 * method name   : findByExample 
	 * description   : 
	 * @return       : List<?>
	 * @param        : @param account
	 * @param        : @return
	 * modified      : chen ,  2012-12-8  下午02:20:49
	 * @see          : 
	 * ********************************************/
	public List<?> findByExample(Account account) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<?> results = getSessionFactory().getCurrentSession()
					.createCriteria("com.digo.pojo.Account")
					.add(Example.create(account)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}
