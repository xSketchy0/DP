// AJ Sijpenhof(1745798)

import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<>();

    public List<Reiziger> findAll() throws SQLException {
		Statement stmt = OracleBaseDao.conn.createStatement();
		String queryText = "SELECT * FROM reiziger";
		ResultSet rs = stmt.executeQuery(queryText);

		while (rs.next()) {
			int id = rs.getInt("reizigerid");
			String naam = rs.getString("voorletters") + " " + rs.getString("tussenvoegsel") + " " + rs.getString("achternaam");
			Date gbdatum = rs.getDate("gebortedatum");
			this.reizigers.add(new Reiziger(naam, gbdatum, id));
		}
		stmt.close();
		return this.reizigers;
	}

	public Reiziger findById(int reizigerid) throws SQLException {
		String qry = "SELECT * from reiziger WHERE reizigerid = ?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, reizigerid);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("reizigerid");
			String naam = rs.getString("voorletters") + " " + rs.getString("tussenvoegsel") + " " + rs.getString("achternaam");
			Date gbdatum = rs.getDate("gebortedatum");
			return new Reiziger(naam, gbdatum, id);
		}
		return null;
	}

	public List<Reiziger> findByGBdatum(String dt) throws SQLException, ParseException {
		List<Reiziger> found_reizigers = new ArrayList<Reiziger>();

		String qry = "SELECT * FROM reiziger WHERE gebortedatum = ?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);

		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		java.util.Date ud = df.parse(dt);
		pstmt.setDate(1, new java.sql.Date(ud.getTime()));

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("reizigerid");
			String naam = rs.getString("voorletters") + " " + rs.getString("tussenvoegsel") + " " + rs.getString("achternaam");
			Date gbdatum = rs.getDate("gebortedatum");
			found_reizigers.add(new Reiziger(naam, gbdatum, id));
		}
		pstmt.close();
		return found_reizigers;
	}

	public Reiziger save(Reiziger reiziger) throws SQLException {

		Statement stmt = OracleBaseDao.conn.createStatement();
		String qry0 = "SELECT * FROM reiziger ORDER BY reizigerid Desc";
		ResultSet rs = stmt.executeQuery(qry0);
		rs.next();
		int reizigerid = rs.getInt("reizigerid") + 1;

		String qry = "INSERT INTO reiziger VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);

		pstmt.setInt(1, reizigerid);

		String[] parts = reiziger.getNaam().split(" ");
		pstmt.setString(2, parts[0]);
		pstmt.setString(3, parts[1]);
		pstmt.setString(4, parts[2]);

		pstmt.setDate(5, new java.sql.Date(reiziger.getGBdatum().getTime()));
		pstmt.executeQuery();

		pstmt.close();

		reiziger.setReizigerid(reizigerid);
		return(reiziger);
	}

	public Reiziger update(Reiziger reiziger) throws SQLException {
		String qry1 = "UPDATE reiziger SET voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?";
		PreparedStatement pstmt1 = OracleBaseDao.conn.prepareStatement(qry1);

		String[] parts = reiziger.getNaam().split(" ");
		pstmt1.setString(1, parts[0]);
		pstmt1.setString(2, parts[1]);
		pstmt1.setString(3, parts[2]);
		pstmt1.setDate(4, new java.sql.Date(reiziger.getGBdatum().getTime()));
		pstmt1.setInt(5, reiziger.getReizigerid());

		pstmt1.executeQuery();

		pstmt1.close();
		return reiziger;
	}

	public Boolean delete(Reiziger reiziger) throws SQLException {
		String qry = "DELETE FROM reiziger WHERE reizigerid=?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, reiziger.getReizigerid());
		pstmt.executeQuery();
		pstmt.close();
		return true;
	}
}
