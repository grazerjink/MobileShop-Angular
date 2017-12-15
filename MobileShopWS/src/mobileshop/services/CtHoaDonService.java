package mobileshop.services;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobileshop.entities.CtHoaDon;
import mobileshop.entities.HoaDon;
import mobileshop.entities.SanPham;

@Component
@Transactional
public class CtHoaDonService {

	@Autowired
	SessionFactory factory;
	
	public void insert(CtHoaDon ctHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(ctHoaDon);
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
	
	public void update(CtHoaDon ctHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(ctHoaDon);
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
	
	public void delete(CtHoaDon ctHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(ctHoaDon);
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
	
	public void refresh(CtHoaDon ctHoaDon) {
		Session session = factory.getCurrentSession();
		session.refresh(ctHoaDon);
	}
	
	public CtHoaDon get(Integer id) {
		Session session = factory.getCurrentSession();
		CtHoaDon ctHoaDon = (CtHoaDon)session.get(CtHoaDon.class,id);
		return ctHoaDon;
	}
	
	public List<CtHoaDon> list() {
		String hql = "FROM CtHoaDon";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<CtHoaDon> list = query.list();
		return list;
	}

	public void purchase(HoaDon hd, Collection<SanPham> sanPhams) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			for(SanPham sp : sanPhams) {
				CtHoaDon ct = new CtHoaDon();
				ct.setHoaDon(hd);
				ct.setGiaBan(sp.getGiaBan());
				ct.setSoLuong(sp.getSoLuong());
				ct.setThanhTien(sp.getGiaBan()*sp.getSoLuong());
				ct.setSanPham(sp);
				session.save(ct);
			}
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException("Process errors");
		}
		
	}
	
}
