package mobileshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobileshop.entities.HoaDon;

@Component
@Transactional
public class HoaDonService {

	@Autowired
	SessionFactory factory;
	
	public void insert(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(hoaDon);
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
	
	public void update(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(hoaDon);
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
	
	public void delete(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hoaDon);
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
	
	public void refresh(HoaDon hoaDon) {
		Session session = factory.getCurrentSession();
		session.refresh(hoaDon);
	}
	
	public HoaDon get(Integer id) {
		Session session = factory.getCurrentSession();
		HoaDon hoaDon = (HoaDon)session.get(HoaDon.class,id);
		return hoaDon;
	}
	
	public List<HoaDon> list() {
		String hql = "FROM HoaDon";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<HoaDon> list = query.list();
		return list;
	}
	
}
