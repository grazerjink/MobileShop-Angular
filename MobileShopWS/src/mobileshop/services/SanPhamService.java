package mobileshop.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobileshop.entities.SanPham;

@Component
@Transactional
public class SanPhamService {

	@Autowired
	SessionFactory factory;
	
	public void insert(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(sanPham);
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
	
	public void update(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sanPham);
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
	
	public void delete(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(sanPham);
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
	
	public void refresh(SanPham sanPham) {
		Session session = factory.getCurrentSession();
		session.refresh(sanPham);
	}
	
	public SanPham get(Integer id) {
		Session session = factory.getCurrentSession();
		SanPham sanPham = (SanPham)session.get(SanPham.class,id);
		return sanPham;
	}
	
	public List<SanPham> list() {
		String hql = "FROM SanPham";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		return list;
	}

	public List<SanPham> listByCategoryId(Integer categoryId) {
		String hql = "FROM SanPham s WHERE s.category.id = :id ";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("id", categoryId);
		List<SanPham> list = query.list();
		return list;
	}
	
}
