package nl.hu.ict.dp.nscasus;
import java.util.List;

public interface ReizigerDao {
	public List<Reiziger> findAll();
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public Boolean delete(Reiziger reiziger);
}
