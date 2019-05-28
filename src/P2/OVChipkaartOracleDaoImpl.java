// AJ Sijpenhof(1745798)

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//fill list OVChipkaart
public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {
	public List<OVChipkaart> findAll() throws SQLException {
		List<OVChipkaart> ovchipkaarten = new ArrayList<OVChipkaart>();
		 
		Statement stmt = OracleBaseDao.conn.createStatement();
		String queryText = "SELECT * FROM OV_CHIPKAART";
		ResultSet rs = stmt.executeQuery(queryText);
		
		while (rs.next()) {   
			int kaartnummer = rs.getInt("kaartnummer");
			Date geldigtot = rs.getDate("geldigtot");
			int klasse = rs.getInt("klasse");
			float saldo = rs.getInt("saldo");
			int reizigerid = rs.getInt("reizigerid");
			
			ovchipkaarten.add(new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid));
		}
		
		stmt.close();
		return ovchipkaarten; 
	}
	
	public List<OVChipkaart> findByKaartnummer(int kaartnummer) throws SQLException {
		List<OVChipkaart> ovchipkaarten = new ArrayList<OVChipkaart>();
		 
		String qry = "SELECT * FROM OV_CHIPKAART WHERE kaartnummer = ?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, kaartnummer);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Date geldigtot = rs.getDate("geldigtot");
			int klasse = rs.getInt("klasse");
			float saldo = rs.getInt("saldo");
			int reizigerid = rs.getInt("reizigerid");
			
			ovchipkaarten.add(new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid));
		}
		
		pstmt.close();
		return ovchipkaarten; 
	}
	
	public Reiziger getReiziger(OVChipkaart ovchipkaart) throws SQLException {
		ReizigerOracleDaoImpl rodi = new ReizigerOracleDaoImpl();
		return rodi.findById(ovchipkaart.getReizigerId());
	}
	
	public OVChipkaart save(OVChipkaart ovchipkaart) throws SQLException {

		String qry = "INSERT INTO ov_chipkaart VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		System.out.println("kaartnummer: " + Integer.toString(ovchipkaart.getKaartNummer()) + "klasse: " + Integer.toString(ovchipkaart.getKlasse()) + "saldo" + Double.toString(ovchipkaart.getSaldo()) +"ID: "+ Integer.toString(ovchipkaart.getReizigerId()));
		pstmt.setInt(1, ovchipkaart.getKaartNummer());
		pstmt.setDate(2, new java.sql.Date(ovchipkaart.getGeldidgTot().getTime()));
		pstmt.setInt(3, ovchipkaart.getKlasse());
		pstmt.setDouble(4, ovchipkaart.getSaldo());
		pstmt.setInt(5, ovchipkaart.getReizigerId());
		
		pstmt.executeQuery();
		
		pstmt.close();
		return(ovchipkaart);
	}
	
	public OVChipkaart update(OVChipkaart ovchipkaart) throws SQLException {
		String qry1 = "UPDATE OV_CHIPKAART SET geldigtot = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry1);

		pstmt.setDate(1, new java.sql.Date(ovchipkaart.getGeldidgTot().getTime()));
		pstmt.setInt(2, ovchipkaart.getKlasse());
		pstmt.setDouble(3, ovchipkaart.getSaldo());
		pstmt.setInt(4, ovchipkaart.getReizigerId());
		pstmt.setInt(5, ovchipkaart.getKaartNummer());
		pstmt.executeQuery();
		pstmt.close();
		
		return ovchipkaart;
	}
	
	public Boolean delete(OVChipkaart ovchipkaart) throws SQLException {
		String qry = "DELETE FROM OV_CHIPKAART WHERE kaartnummer=?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
        
		pstmt.setInt(1, ovchipkaart.getKaartNummer());
		
		pstmt.executeQuery();
		pstmt.close();
		return true;
	}
}
