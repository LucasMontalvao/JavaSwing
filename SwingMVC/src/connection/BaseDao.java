package connection;
import java.sql.Connection;

public abstract class BaseDao {
	public Connection getConnection() {
		return DatabaseConnection.getInstance().getConnection();
	}
}
