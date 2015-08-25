package com.digo.home;

// Generated Dec 4, 2012 11:38:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.digo.pojo.Power;
import com.digo.pojo.Role;
import com.digo.pojo.Rolerelation;
import com.digo.pojo.User;

/**
 * Home object for domain model class Rolerelation.
 * @see com.digo.pojo.Rolerelation
 * @author Hibernate Tools
 */
public class RolerelationHome extends BaseDao{
	
	private PowerHome powerHome;

	public void setPowerHome(PowerHome powerHome) {
		this.powerHome = powerHome;
	}

	public boolean persist(Rolerelation transientInstance) {
		
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

	public boolean attachDirty(Rolerelation instance) {
		
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

	public boolean attachClean(Rolerelation instance) {
		
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

	public boolean delete(Rolerelation persistentInstance) {
		
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

	public Rolerelation merge(Rolerelation detachedInstance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Rolerelation result = (Rolerelation)session.merge(detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Rolerelation();
		}
	}

	public Rolerelation findById(java.lang.String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Rolerelation instance = (Rolerelation) session.get("com.digo.pojo.Rolerelation", id);
			tx.commit();
			if (instance == null) {
				instance = new Rolerelation();
			} 
			return instance;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Rolerelation();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Rolerelation> findByExample(Rolerelation instance) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Rolerelation> results = session
					.createCriteria("com.digo.pojo.Rolerelation")
					.add(Example.create(instance)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Rolerelation>();
		}
	}
	
	public Map<String, String> findPowerByRoleList(List<Role > roleList){
		Iterator<Role> it = roleList.iterator();
		Map<String, String> resultMap = new HashMap<String, String>();
		while(it.hasNext())
		{
			Role ir = it.next();
			try {
				Session session = getSessionFactory().getCurrentSession();
				Transaction tx = session.beginTransaction();
				String hql = "from Rolerelation where role.roleId = '" + ir.getRoleId() + "'";
				Query query = session.createQuery(hql);

				List<Rolerelation> results = (List<Rolerelation>)query.list();
				tx.commit();
				Iterator<Rolerelation> rit = results.iterator();
				String a = "";
				while(rit.hasNext())
				{
					Rolerelation rl = rit.next();
					Power p = powerHome.findById(rl.getPower().getPowerId());
					if(p != null){
						a = a + p.getPowerContent() + "$";
					}
				}
				resultMap.put(ir.getRoleId(), a);
			} catch (RuntimeException re) {
				re.printStackTrace();
				return null;
			}
		}
		return resultMap;
	}
}
