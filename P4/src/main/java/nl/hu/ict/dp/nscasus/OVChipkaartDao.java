package nl.hu.ict.dp.nscasus;
import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDao {
	public List<OVChipkaart> findAll() throws SQLException;
	public List<OVChipkaart> findByKaartnummer(int kaartnummer) throws SQLException;
	public OVChipkaart save(OVChipkaart ovchipkaart) throws SQLException;
	public OVChipkaart update(OVChipkaart ovchipkaart) throws SQLException;
	public Boolean delete(OVChipkaart ovchipkaart) throws SQLException;
}
