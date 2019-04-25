import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        // Dit roep ik aan om de reizigers in op te slaan
        ReizigerOracleDaoImpl obj = new ReizigerOracleDaoImpl();

        // Reizigers aanmaken
        Reiziger r1 = new Reiziger("AJ", Date.valueOf("1998-09-29"));
        Reiziger r2 = new Reiziger("Clover", Date.valueOf("2000-09-15"));
        Reiziger r3 = new Reiziger("Dad", Date.valueOf("1970-09-15"));
        Reiziger r4 = new Reiziger("Mom", Date.valueOf("1970-09-15"));

        // Hier worden reizigers opgeslagen in de List<Reiziger> van obj
        obj.save(r1);
        obj.save(r2);
        obj.save(r3);
        obj.save(r4);

        System.out.println("Alle reizigers:");
        // For loop om de opgeslagen reizigers te laten zien
        for (Reiziger r : obj.findAll()) {
            System.out.println(r.getNaam() + " " + r.getGBdatum());
        }

        System.out.println();
        // For loop om de reizigers te laten zien gefilterd op geboortedatum
        System.out.println("Reizigers gefilterd op geboortedatum:");
        for (Reiziger r : obj.findByGBdatum("1970-09-15")) {
            System.out.println(r.getNaam() + " " + r.getGBdatum());
        }

        // Reizigers worden hier geupdatet
        obj.update(r1).setNaam("AJ(Update)");
        obj.update(r1).setGBdatum(Date.valueOf("1998-12-29"));

        System.out.println();
        System.out.println("Reizigers na het updaten:");
        // For loop om te laten zien dat de reizigers zijn geupdatet
        for (Reiziger r : obj.findAll()) {
            System.out.println(r.getNaam() + " " + r.getGBdatum());
        }

        // Verwijderen van de 3e reiziger
        obj.delete(r3);

        System.out.println();
        System.out.println("Reizigers na het verwijderen:");
        // For loop om te laten zien dat r3 is verwijderd
        for (Reiziger r : obj.findAll()) {
            System.out.println(r.getNaam() + " " + r.getGBdatum());
        }
    }
}
