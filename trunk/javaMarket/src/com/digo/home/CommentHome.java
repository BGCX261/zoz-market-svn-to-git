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
import com.digo.pojo.Comment;
import com.digo.pojo.Goods;

/**
 * Home object for domain model class Comment.
 * @see com.digo.pojo.Comment
 * @author Hibernate Tools
 */
public class CommentHome extends BaseDao{
	
	public boolean persist(Comment comment) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(comment);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean attachDirty(Comment comment) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(comment);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean attachClean(Comment comment) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.lock(comment, LockMode.NONE);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public boolean delete(Comment comment) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.delete(comment);
			tx.commit();
			return true;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return false;
		}
	}

	public Comment merge(Comment comment) {
	
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Comment result = (Comment) session
					.merge(comment);
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Comment();
		}
	}

	public Comment findById(String id) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Comment comment = (Comment) session
					.get("com.digo.pojo.Comment", id);
			tx.commit();
			if (comment == null) {
				comment = new Comment();
			}
			return comment;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new Comment();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findByExample(Comment comment) {
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<Comment> results = session.createCriteria("com.digo.pojo.Comment").add(Example.create(comment)).list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Comment>();
		}
	}
	
	public List<Comment> findByGoodsId(String id, int pageNum, int pageSize){
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Comment c where c.goods.goodsId = '" + id + "' order by c.commentTime desc";
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<Comment> results = (List<Comment>)query.list();
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			re.printStackTrace();
			return new ArrayList<Comment>();
		}
	}
	
	public int getCountByGoodsId(String id){
		try {
			Session session = getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Comment c where c.goods.goodsId = '" + id + "'";
			Query query = session.createQuery(hql);
			List<Comment> results = (List<Comment>)query.list();
			tx.commit();
			return results.size();
		} catch (RuntimeException re) {
			re.printStackTrace();
			return 0;
		}
	}
}
