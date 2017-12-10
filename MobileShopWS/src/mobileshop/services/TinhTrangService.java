package mobileshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobileshop.entities.TinhTrang;

@Component
@Transactional
public class TinhTrangService {

	@Autowired
	SessionFactory factory;
	
	public void insert(TinhTrang tinhTrang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(tinhTrang);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void update(TinhTrang tinhTrang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(tinhTrang);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void delete(TinhTrang tinhTrang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(tinhTrang);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void refresh(TinhTrang tinhTrang) {
		Session session = factory.getCurrentSession();
		session.refresh(tinhTrang);
	}
	
	public TinhTrang get(Integer id) {
		Session session = factory.getCurrentSession();
		TinhTrang tinhTrang = (TinhTrang)session.get(TinhTrang.class,id);
		return tinhTrang;
	}
	
	public List<TinhTrang> list() {
		String hql = "FROM TinhTrang";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<TinhTrang> list = query.list();
		return list;
	}
	
}
