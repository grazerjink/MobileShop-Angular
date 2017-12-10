package mobileshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobileshop.entities.HangSanXuat;

@Component
@Transactional
public class HangSanXuatService {

	@Autowired
	SessionFactory factory;
	
	public void insert(HangSanXuat hangSanXuat) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(hangSanXuat);
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
	
	public void update(HangSanXuat hangSanXuat) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(hangSanXuat);
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
	
	public void delete(HangSanXuat hangSanXuat) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hangSanXuat);
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
	
	public void refresh(HangSanXuat hangSanXuat) {
		Session session = factory.getCurrentSession();
		session.refresh(hangSanXuat);
	}
	
	public HangSanXuat get(Integer id) {
		Session session = factory.getCurrentSession();
		HangSanXuat hangSanXuat = (HangSanXuat)session.get(HangSanXuat.class,id);
		return hangSanXuat;
	}
	
	public List<HangSanXuat> list() {
		String hql = "FROM HangSanXuat";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<HangSanXuat> list = query.list();
		return list;
	}
	
}
