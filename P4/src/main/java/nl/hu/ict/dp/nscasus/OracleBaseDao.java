package nl.hu.ict.dp.nscasus;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OracleBaseDao {
	
	static String orclcfg = "nl.hu.ict.jpa.oracle";
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(orclcfg);
	
	protected EntityManager getConnection() throws SQLException {
        try {

            EntityManager em = entityManagerFactory.createEntityManager();
            return em;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
}
