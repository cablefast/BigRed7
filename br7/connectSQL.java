package br7;
import java.sql.*;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class connectSQL {
	private static String url = "jdbc:mysql://192.168.32.130:3306/br7";
	private static String username = "mf56";
	private static String password = "narrate^lips";
	private static String noResultMsg = "No results found";
	private static String unableToSeachMsg = "Unable to complete this search";
	private static String row;
	private static String columnNames = "Serial, Make, Model, Bldg, Room, Last, First, EDIPI";
	private static String sqlSearchall = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos) = CONCAT(u.Para,u.Ln,u.Pos);";
	private static String sqlAssetSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos) = CONCAT(u.Para,u.Ln,u.Pos) WHERE a.DSerNum LIKE ?;";
	private static String sqlUserSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos) = CONCAT(u.Para,u.Ln,u.Pos) WHERE u.LName LIKE ?;";
	private static String sqlBldgSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos) = CONCAT(u.Para,u.Ln,u.Pos) WHERE a.BldNum LIKE ?;";
	private static ArrayList<String> result;
	
	public static ArrayList<String> searchSQL(int buttonState, String userData) {
		result =new ArrayList<String>();
		userData += "%";
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			switch (buttonState) {
			case 1: searchForAsset(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, columnNames);
				con.close();
				return result;
			case 2: searchForUser(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, columnNames);
				con.close();
				return result;
			case 3: searchForBldg(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, columnNames);
				con.close();
				return result;
			default: result.add(unableToSeachMsg);
				return result;
			}
		} 
		catch (SQLException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			result.add(sw.toString());
			return result;
		}
	}
	
	private static void blankSearch(Connection con) throws SQLException {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sqlSearchall);
		while(rs.next()) {
			row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
			+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
			+", "+rs.getString(7)+", "+rs.getString(8);
			result.add(row);
			}
		stmt.close();
		rs.close();
	}
	
	private static void searchForAsset(String sernum, Connection con) throws SQLException {
			if (sernum.isEmpty()) blankSearch(con);
			else {
				PreparedStatement pstmt = con.prepareStatement(sqlAssetSearch);
				pstmt.setString(1, sernum);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
					+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
					+", "+rs.getString(7)+", "+rs.getString(8);
					result.add(row);
				}
				pstmt.close();
				rs.close();
			}
	}
	
	private static void searchForUser(String lname, Connection con) throws SQLException {
			if (lname.isEmpty()) blankSearch(con);
			else {
				PreparedStatement pstmt = con.prepareStatement(sqlUserSearch);
				pstmt.setString(1, lname);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
					+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
					+", "+rs.getString(7)+", "+rs.getString(8);
					result.add(row);
				}
				pstmt.close();
				rs.close();
			}
	}
	
	private static void searchForBldg(String bldg, Connection con) throws SQLException  {
			if (bldg.isEmpty()) blankSearch(con);
			else {
				PreparedStatement pstmt = con.prepareStatement(sqlBldgSearch);
				pstmt.setString(1, bldg);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
					+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
					+", "+rs.getString(7)+", "+rs.getString(8);
					result.add(row);
				}
				pstmt.close();
				rs.close();
			}
	}

}