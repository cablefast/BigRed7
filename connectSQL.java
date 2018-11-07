import java.sql.*;

public class connectSQL {
	
	
	//public void connectToSQL() {
	public static void main(String args[]){
		String url = "jdbc:mysql://192.168.32.130:3306/br7";
		String username = "mf56";
		String password = "narrate^lips";
		System.out.println("Connecting database...");
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

}