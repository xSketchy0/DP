package nl.hu.ict.dp.nscasus;

public class Main {

    public static void main(String[] args) {
        // get the Hibernate - JPA entityManager
   

        ReizigerOracleDaoImpl rodi = new ReizigerOracleDaoImpl();
        OVChipkaartOracleDaoImpl oodi = new OVChipkaartOracleDaoImpl();
        
        Reiziger r2 = new Reiziger();
        r2.setAchternaam("Sijpenhof");
        rodi.save(r2);
        
        r2.setVoorletters("oi");
        rodi.update(r2);
        
        Reiziger r1 = new Reiziger();
        r1.setTussenvoegsel("van");
        rodi.save(r1);
        
        rodi.delete(r1);
        
        OVChipkaart kaart = new OVChipkaart();
        kaart.setKaartopdruk("mijn eerste kaart");
        kaart.setReiziger(r2);
        
        oodi.save(kaart);
        
        OVChipkaart kaart2 = new OVChipkaart();
        kaart.setKaartopdruk("mijn tweede kaart");
        kaart.setReiziger(r2);
        
        oodi.save(kaart2);
        
        System.out.println(oodi.findByKaartnummer(kaart2.getKaartnr()).get(0));
        
        kaart2.setKaartopdruk("updated tweede kaart");
        oodi.update(kaart2);
        
        for (OVChipkaart o : oodi.findAll()) {
        	System.out.println(o);
        }
        
        oodi.delete(kaart2);
        for (OVChipkaart o : oodi.findAll()) {
        	System.out.println(o);
        }
        
        for (Reiziger r : rodi.findAll()) {
        	System.out.println(r);
        }
        
        System.out.println("-- einde --");
    }
}
