import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll();

    List<Reiziger> findByGBdatum(String dt);

    Reiziger save(Reiziger reiziger);

    Reiziger update(Reiziger reiziger);

    boolean delete(Reiziger reiziger);
//    public void closeConnection();
}
