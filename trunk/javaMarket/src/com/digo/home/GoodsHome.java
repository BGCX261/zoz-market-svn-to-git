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
import com.digo.pojo.Goods;

/**
 * Home object for domain model class Goods.
 * 
 * @see com.digo.pojo.Goods
 * @author Hibernate Tools
 */
public class GoodsHome extends BaseDao {

	public boolean persist(Goods transientInstance) {

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

	public boolean attachDirty(Goods instance) {

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

	public boolean attachClean(Goods instance) {

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

	public boolean delete(Goods persistentInstance) {

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

	public Goods merge(Goods detachedInstance) {

		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Goods result = (Goods) session.merge(detachedInstance);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Goods();
		}
	}

	public Goods findById(String id) {

		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Goods goods = (Goods) session.get("com.digo.pojo.Goods", id);
			if (goods == null) {
				goods = new Goods();
			}
			tx.commit();
			return goods;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Goods();
		}
	}

	public List<Goods> findByExample(Goods goods) {

		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Goods> results = session.createCriteria("com.digo.pojo.Goods")
					.add(Example.create(goods)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Goods>();
		}
	}

	/**
	 * 根据商品大类别，分页查询
	 * @param kind 大类别
	 * @param pageSize 商品数量
	 * @param page 页号，从1开始
	 * @return
	 */
	public List<Goods> findByBigKindAndPage(String kind, int pageSize, int page) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Goods where goodsType like '" + kind + "%'";
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<Goods> results = (List<Goods>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Goods>();
		}
	}
	
	/**
	 * 根据商品名称，模糊分页查询
	 * @param value 相关字
	 * @param pageSize 商品数量
	 * @param page 页号，从1开始
	 * @return
	 */
	public List<Goods> findByKeyWords(String value, int pageSize, int page) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Goods where goodsName like '%" + value + "%'";
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<Goods> results = (List<Goods>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Goods>();
		}
	}
	
	public List<Goods> refreshgoods(){
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Goods";
			Query query = session.createQuery(hql);
			List<Goods> results = (List<Goods>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Goods>();
		}
	}
}
