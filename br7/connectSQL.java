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
	private static ArrayList<String> result;
	private static final String SEARCHCOLNAMES = "Serial, Make, Model, Bldg, Room, Last, First, EDIPI";
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	private static String sqlSearchall = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos);";
	private static String sqlAssetSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos) WHERE a.DSerNum LIKE ?;";
	private static String sqlUserSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos) WHERE u.LName LIKE ?;";
	private static String sqlBldgSearch = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos) WHERE a.BldNum LIKE ?;";
	private static String sqlAdvSearchall = "SELECT a.DSerNum,a.Make,a.Model,s.WinName,s.Class,a.PurchaseDate,"
			+ "a.WarrantyEndDate,a.BldNum,a.RmNum,u.EDIPI,u.LName,u.FName,u.Para,u.Ln,su.SName,su.Desc "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos) LEFT JOIN storage s on a.DSerNum = s.DSerNum LEFT JOIN mtoe mt on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(mt.Para,mt.Ln,mt.Pos) LEFT JOIN support su on mt.SNum = su.SNum;";

	
	
	
	
	
	
	public static ArrayList<String> searchSQL(int buttonState, String userData) {
		result =new ArrayList<String>();
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			switch (buttonState) {
			case 1: searchForAsset(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, SEARCHCOLNAMES);
				con.close();
				return result;
			case 2: searchForUser(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, SEARCHCOLNAMES);
				con.close();
				return result;
			case 3: searchForBldg(userData, con);
				if (result.isEmpty()) result.add(noResultMsg);
				else result.add(0, SEARCHCOLNAMES);
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
	
	public static ArrayList<String> advSearchSQL(String searchBy, String userData) {
		result =new ArrayList<String>();		
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			blankAdvSearch(con);
			return result;
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
	
	private static void blankAdvSearch(Connection con) throws SQLException {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sqlAdvSearchall);
		while(rs.next()) {
			row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
			+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
			+", "+rs.getString(7)+", "+rs.getString(8)+", "+rs.getString(9)
			+", "+rs.getString(10)+", "+rs.getString(11)+", "+rs.getString(12)
			+", "+rs.getString(13)+", "+rs.getString(14)+", "+rs.getString(15);
			result.add(row);
			}
		stmt.close();
		rs.close();
	}

}