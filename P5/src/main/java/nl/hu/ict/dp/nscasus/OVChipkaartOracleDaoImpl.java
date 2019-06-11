package nl.hu.ict.dp.nscasus;
import java.sql.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {
	@SuppressWarnings("unchecked")
	public List<OVChipkaart> findAll() {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Query qry = em.createQuery("from OVChipkaart");
	    List<OVChipkaart> ov = qry.getResultList();
        
	    return ov;
	}
	
	@SuppressWarnings("unchecked")
	public OVChipkaart findByKaartnummer(int kaartnummer) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM OVCHIPKAART WHERE kaartnr=:nr";
		Query query = em.createNativeQuery(sql, OVChipkaart.class);
		query.setParameter("nr", kaartnummer);
		List<OVChipkaart> results = query.getResultList();
		return results.get(0);
	}
	
	
	public OVChipkaart save(OVChipkaart ovchipkaart) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        em.getTransaction().begin();
        em.persist(ovchipkaart);
        em.getTransaction().commit();
		return ovchipkaart;
	}
	
	public OVChipkaart update(OVChipkaart ovchipkaart)  {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OVChipkaart ov_db = em.find(OVChipkaart.class, ovchipkaart.getKaartnr());
		
        em.getTransaction().begin();
        ov_db.setGeldigheid(ovchipkaart.getGeldigheid());
        ov_db.setKaartopdruk(ovchipkaart.getKaartopdruk());
        ov_db.setReiziger(ovchipkaart.getReiziger());
        em.getTransaction().commit();
		return ovchipkaart;
	}
	
	public Boolean delete(OVChipkaart ovchipkaart) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OVChipkaart ov_db = em.find(OVChipkaart.class, ovchipkaart.getKaartnr());
		em.getTransaction().begin();
		em.remove(ov_db);
		em.getTransaction().commit();
		return true;
	}
}
