// AJ Sijpenhof(1745798)

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
		ProductOracleDaoImpl ajs = new ProductOracleDaoImpl();
		ajs.getConnection();

//		System.out.println("creating product 1");
//		Product p = new Product(7, "Product 1", "Dit is product 1", 20.05);
//		podi.save(p);

		Product p = ajs.getProductByNummer(7);

		System.out.println("\nprinting products");
		for (Product ps : ajs.getAllProducten()) {
			System.out.println(ps);
		}

		System.out.println("\nupdating product 1");
		p.setBeschrijving("Dit is nog steeds product 1");
		ajs.update(p);

		System.out.println("\nprinting products");
		for (Product ps : ajs.getAllProducten()) {
			System.out.println(ps);
		}

		System.out.println("\ndeleting product 1");
		ajs.delete(p);

		System.out.println("\nprinting products");
		for (Product ps : ajs.getAllProducten()) {
			System.out.println(ps);
		}

		ajs.save(p);

		System.out.println("\nadding product to card");
		ajs.voegProductToeAanKaart(p.getProductNummer(), 11226);

		System.out.println("\ngetting producten of card 11226");
		for (Product ps : ajs.getProductenVanOVChipkaart(11226)) {
			System.out.println(ps);
		}

		System.out.println("\ndeleting product from card");
		ajs.deleteProductVanKaart(p.getProductNummer(), 11226);

		System.out.println("\ngetting producten of card 11226");
		for (Product ps : ajs.getProductenVanOVChipkaart(11226)) {
			System.out.println(ps);
		}
    }
}
