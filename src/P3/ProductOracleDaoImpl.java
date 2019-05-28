// AJ Sijpenhof(1745798)

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {

	public ArrayList<Product> getProducten(String qry) throws SQLException {
		ArrayList<Product> producten = new ArrayList<Product>();

		Statement stmt = OracleBaseDao.conn.createStatement();
		ResultSet rs = stmt.executeQuery(qry);

		while (rs.next()) {
			int productNummer = rs.getInt("productNummer");
			String productNaam = rs.getString("productNaam");
			String beschrijving = rs.getString("beschrijving");
			double prijs = rs.getDouble("prijs");
			producten.add(new Product(productNummer, productNaam, beschrijving, prijs));
		}

		return producten;
	}

	public ArrayList<Product> getAllProducten() throws SQLException {
		return getProducten("SELECT * FROM product");
	}

	public Product getProductByNummer(int nummer) throws SQLException {
		ArrayList<Product> producten = getProducten("SELECT * FROM product WHERE productnummer='" + nummer + "'");
		if (producten.size() > 0) {
			return producten.get(0);
		} else {
			return null;
		}
	}

	public ArrayList<Product> getProductenVanOVChipkaart(int kaartnummer) throws SQLException {
		ArrayList<Product> producten = new ArrayList<Product>();

		String qry = "SELECT * FROM OV_CHIPKAART_PRODUCT, PRODUCT WHERE OV_CHIPKAART_PRODUCT.kaartNummer = ? AND OV_CHIPKAART_PRODUCT.productNummer=PRODUCT.productNummer";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, kaartnummer);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int productNummer = rs.getInt("productNummer");
			String productNaam = rs.getString("productNaam");
			String beschrijving = rs.getString("beschrijving");
			double prijs = rs.getDouble("prijs");
			producten.add(new Product(productNummer, productNaam, beschrijving, prijs));
		}

		pstmt.close();
		return producten;
	}

	public Product save(Product p) throws SQLException {
		String qry = "INSERT INTO product VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);

		pstmt.setInt(1, p.getProductNummer());
		pstmt.setString(2, p.getProductNaam());
		pstmt.setString(3, p.getBeschrijving());
		pstmt.setDouble(4, p.getPrijs());

		pstmt.executeQuery();

		pstmt.close();
		return p;
	}

	public Product update(Product p) throws SQLException {
		String qry = "UPDATE product SET productnaam=?, beschrijving=?, prijs=? WHERE productnummer=?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);

		pstmt.setString(1, p.getProductNaam());
		pstmt.setString(2, p.getBeschrijving());
		pstmt.setDouble(3, p.getPrijs());
		pstmt.setInt(4, p.getProductNummer());

		pstmt.executeQuery();

		pstmt.close();
		return p;
	}

	public void delete(Product p) throws SQLException {
		String qry0 = "DELETE FROM OV_CHIPKAART_PRODUCT WHERE productnummer=?";
		PreparedStatement pstmt0 = OracleBaseDao.conn.prepareStatement(qry0);
		pstmt0.setInt(1, p.getProductNummer());
		pstmt0.executeQuery();
		pstmt0.close();

		String qry = "DELETE FROM PRODUCT WHERE productnummer=?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);

		pstmt.setInt(1, p.getProductNummer());

		pstmt.executeQuery();
		pstmt.close();
	}

	public void voegProductToeAanKaart(int productNummer, int kaartNummer) throws SQLException {

		Statement stmt = OracleBaseDao.conn.createStatement();
		String qry0 = "select * from (select * from OV_CHIPKAART_PRODUCT order by ovproductid desc) where rownum = 1";
		ResultSet rs = stmt.executeQuery(qry0);
		rs.next();
		int ovproductid = rs.getInt("ovproductid") + 1;

		String qry = "INSERT INTO OV_CHIPKAART_PRODUCT values (?, ?, ?, 'actief', sysdate)";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, ovproductid);
		pstmt.setInt(2, kaartNummer);
		pstmt.setInt(3, productNummer);

		pstmt.executeQuery();
		pstmt.close();
	}

	public void deleteProductVanKaart(int productNummer, int kaartNummer) throws SQLException {
		String qry = "DELETE FROM OV_CHIPKAART_PRODUCT WHERE productnummer=? AND kaartnummer=?";
		PreparedStatement pstmt = OracleBaseDao.conn.prepareStatement(qry);
		pstmt.setInt(1, productNummer);
		pstmt.setInt(2, kaartNummer);
		pstmt.executeQuery();
	}

	// public void deleteProductvanKaart
}
