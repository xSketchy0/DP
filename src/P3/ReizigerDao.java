// AJ Sijpenhof(1745798)

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll() throws SQLException;

    List<Reiziger> findByGBdatum(String dt) throws SQLException, ParseException;

    Reiziger save(Reiziger reiziger) throws SQLException;

    Reiziger update(Reiziger reiziger) throws SQLException;

    Boolean delete(Reiziger reiziger) throws SQLException;
//    public void closeConnection();
}
