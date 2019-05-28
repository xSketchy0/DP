// AJ Sijpenhof(1745798)

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
		ReizigerOracleDaoImpl ajs = new ReizigerOracleDaoImpl();
		try {
			ajs.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\nalle reizigers:");
		for (Reiziger r : ajs.findAll()) {
			System.out.println(r);
		}



		System.out.println("\ncreating reiziger Test");
		Reiziger r1 = new Reiziger("Test van Jongen", new Date(System.currentTimeMillis()));
		System.out.println(r1);
		ajs.save(r1);

		System.out.println("\ngetting reiziger " + r1.getReizigerid());
		Reiziger r2 = ajs.findById(r1.getReizigerid());
		System.out.println(r2);



		//verbinding met ovkaart
		OVChipkaartOracleDaoImpl oobd = new OVChipkaartOracleDaoImpl();
		oobd.getConnection();



		System.out.println("\nalle ovchipkaarten");
		for (OVChipkaart r : oobd.findAll()) {
			System.out.println(r.getKaartNummer());
		}

		System.out.println("\ncreating ovchipkaart");
		OVChipkaart ov = new OVChipkaart(11299, new Date(System.currentTimeMillis()), 1, 20, 5);

		System.out.println("\ncreating ovchipkaart2");
		OVChipkaart ov2 = new OVChipkaart(11230, new Date(System.currentTimeMillis()), 2, 20, 5);

		System.out.println("\nediting ovchipkaart");
		ov.setSaldo(50.5);

		System.out.println("\ngetting reiziger");
		Reiziger reiziger = oobd.getReiziger(ov);
		Reiziger reiziger2 = oobd.getReiziger(ov2);
		System.out.println(reiziger + "           " + reiziger2);

		System.out.println("\nalle ovchipkaarten");
		for (OVChipkaart r : oobd.findAll()) {
			System.out.println(r.getKaartNummer());
		}
		oobd.save(ov2);
		System.out.println("\nalle ovchipkaarten");
		for (OVChipkaart r : oobd.findAll()) {
			System.out.println(r.getKaartNummer());
		}
    }
}
