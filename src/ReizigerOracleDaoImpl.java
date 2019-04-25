import java.util.*;
import java.sql.Date;

public class ReizigerOracleDaoImpl implements ReizigerDao {
    private List<Reiziger> reizigers = new ArrayList<Reiziger>();

    public List<Reiziger> findAll() {
        return reizigers;
    }

    public List<Reiziger> findByGBdatum(String dt) {
        List<Reiziger> res = new ArrayList<Reiziger>();

        for (Reiziger rz : reizigers) {
            if (rz.getGBdatum().equals(Date.valueOf(dt))) {
                res.add(rz);
            }
        }

        return res;
    }

    public Reiziger save(Reiziger reiziger) {
        reizigers.add(reiziger);
        return reiziger;
    }

    public Reiziger update(Reiziger reiziger) {
        Reiziger res = null;

        for (Reiziger rz : reizigers) {
            if (rz.equals(reiziger)) {
                res = rz;
            }
        }
        return res;
    }

    public boolean delete(Reiziger reiziger) {
        boolean res = false;

        for (Reiziger rz : reizigers) {
            if (rz.equals(reiziger)) {
                reizigers.remove(rz);
                res = true;
            } else {
                res = false;
            }
        }

        return res;
    }
}
