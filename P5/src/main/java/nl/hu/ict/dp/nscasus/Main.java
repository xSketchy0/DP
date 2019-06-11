package nl.hu.ict.dp.nscasus;

public class Main {

    public static void main(String[] args) {
        // get the Hibernate - JPA entityManager
   
       
        ReizigerOracleDaoImpl rodi = new ReizigerOracleDaoImpl();
        OVChipkaartOracleDaoImpl oodi = new OVChipkaartOracleDaoImpl();
        
        
        /* Eerste reiziger */
        System.out.println("creating r1\n");
        Reiziger r1 = new Reiziger();
        r1.setAchternaam("Huizen");
        r1.setVoorletters("H");
        rodi.save(r1);
        
        System.out.println("print alle reizigers:");
        /* print alle reizigers */
        for (Reiziger r : rodi.findAll()) {
        	System.out.println(r);
        }
        
        System.out.println("\nupdate r1\n");
        /* Updaten eerste reiziger */
        r1.setVoorletters("S");
        rodi.update(r1);
        
        System.out.println("print alle reizigers:");
        /* print alle reizigers */
        for (Reiziger r : rodi.findAll()) {
        	System.out.println(r);
        }
        
        System.out.println("\nmaken r2\n");
        /* maken tweede reiziger */
        Reiziger r2 = new Reiziger();
        r2.setAchternaam("Water");
        r2.setTussenvoegsel("ter");
        rodi.save(r2);
        
        System.out.println("print alle reizigers:");
        /* print alle reizigers */
        for (Reiziger r : rodi.findAll()) {
        	System.out.println(r);
        }
        
        System.out.println("\nverwijderen r2\n");
        /* verwijderen tweede reiziger */
        rodi.delete(r2);
        
        System.out.println("print alle reizigers:");
        /* print alle reizigers */
        for (Reiziger r : rodi.findAll()) {
        	System.out.println(r);
        }
        
        System.out.println("\nmaken ov1");
        /* maken eerste ov van r1 */
        OVChipkaart kaart = new OVChipkaart();
        kaart.setKaartopdruk("mijn eerste kaart");
        kaart.setReiziger(r1);
        oodi.save(kaart);
        
        System.out.println("\nmaken ov2\n");
        /* maken tweede ov van r1 */
        OVChipkaart kaart2 = new OVChipkaart();
        kaart2.setKaartopdruk("mijn tweede kaart");
        kaart2.setReiziger(r1);
        oodi.save(kaart2);
        
        System.out.println("print alle ov's:");
        /* print alle kaarten */
        for (OVChipkaart o : oodi.findAll()) {
        	System.out.println(o);
        }
        
        
        System.out.println("\nophalen kaart met nummer: " + kaart2.getKaartnr());
        /* vind de kaart mbv het nummer */
        System.out.println(oodi.findByKaartnummer(kaart2.getKaartnr()));
        
        System.out.println("\nupdaten ov2\n");
        /* update de tweede kaart */
        kaart2.setKaartopdruk("updated tweede kaart");
        oodi.update(kaart2);
        
        System.out.println("print alle ov's:");
        /* print alle kaarten */
        for (OVChipkaart o : oodi.findAll()) {
        	System.out.println(o);
        }
        
        System.out.println("\nverwijder ov2\n");
        /* verwijder kaart2 */
        oodi.delete(kaart2);
        
        System.out.println("print alle ov's:");
        /* print alle kaarten */
        for (OVChipkaart o : oodi.findAll()) {
        	System.out.println(o);
        }
        
        System.out.println("-- einde --");
    }
}
