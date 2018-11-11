import java.sql.*;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class connectSQL {
	private static String url = "jdbc:mysql://192.168.32.130:3306/br7";
	private static String username = "mf56";
	private static String password = "narrate^lips";
	private static String row;
	private static String sqlAssetSearch = "select * from asset where DSerNum = ?;";
	private static ArrayList<String> result=new ArrayList<String>();
	
	public static String connectToSQL() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			connection.close();
			return "Database connected!";
		} catch (SQLException e) {
			return "Cannot connect the database!";
		}
	}
	
	public static ArrayList<String> searchForAsset(String sernum) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			if (sernum.isEmpty()) {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from asset");
				while(rs.next()) {
					row = rs.getString(1)+",  "+rs.getString(2)+",  "+rs.getString(3)+",  "+rs.getString(4)+",  "+rs.getString(5)+",  "+rs.getString(6)+",  "+rs.getString(7);
					result.add(row);
				}
				stmt.close();
				rs.close();
			}
			else {
				PreparedStatement pstmt = con.prepareStatement(sqlAssetSearch);
				pstmt.setString(1, sernum);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7);
					result.add(row);
				}
				pstmt.close();
				rs.close();
			}
			con.close();
			return result;
		} catch (SQLException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			row = sw.toString();
			result.add(row);
			return result;
		}

	}

}