package nl.hu.ict.dp.nscasus;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
	
	@SuppressWarnings("unchecked")
	public List<Reiziger> findAll() {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Query qry = em.createQuery("from Reiziger");
	    List<Reiziger> rzg = qry.getResultList();
        
	    return rzg;
	}
	
	public Reiziger save(Reiziger reiziger) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        em.getTransaction().begin();
        em.persist(reiziger);
        em.getTransaction().commit();
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reiziger r_db = em.find(Reiziger.class, reiziger.getReizigerid());
		
        em.getTransaction().begin();
        r_db.setAchternaam(reiziger.getAchternaam());
        r_db.setVoorletters(reiziger.getVoorletters());
        r_db.setTussenvoegsel(reiziger.getTussenvoegsel());
        r_db.setGbdatum(reiziger.getGbdatum());
        r_db.setKaarten(reiziger.getKaarten());
        em.getTransaction().commit();
		return reiziger;
	}
	
	public Boolean delete(Reiziger reiziger) {
		EntityManager em = null;
		try {
			em = super.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reiziger r_db = em.find(Reiziger.class, reiziger.getReizigerid());
		em.getTransaction().begin();
		em.remove(r_db);
		em.getTransaction().commit();
		return true;
	}
}
