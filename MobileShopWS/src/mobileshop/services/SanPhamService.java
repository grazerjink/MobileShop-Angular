package mobileshop.services;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
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

	public List<SanPham> listByHangId(Integer hangId) {
		String hql = "FROM SanPham s WHERE s.hang.id = :id ";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("id", hangId);
		List<SanPham> list = query.list();
		return list;
	}
	
	public List<SanPham> listRelated(Integer sanPhamId) {
		SanPham sp = get(sanPhamId);
		List<SanPham> list = listByHangId(sp.getHang().getId());
		return list;
	}

	public List<SanPham> listBanChay() {
		String hql = "FROM SanPham";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(5);
		List<SanPham> list = query.list();
		return list;
	}

	public List<SanPham> listMoiNhat() {
		String hql = "FROM SanPham s ORDER BY s.ngayDang DESC";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(5);
		List<SanPham> list = query.list();
		return list;
	}

	public List<SanPham> filterByName(String name) {
		String hql = "FROM SanPham s WHERE s.ten LIKE :name";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("name", "%"+name+"%");
		List<SanPham> list = query.list();
		return list;
	}
	
}
