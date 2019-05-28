// AJ Sijpenhof(1745798)

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
	public List<Product> getProductenVanOVChipkaart(int kaartnummmer) throws SQLException;
}
