package br7;
import java.sql.*;
import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ConnectSQL {
	private static final String SERVDATFILE = "servdat.br7";
	private static String url;
	private static String username;
	private static String password;	
	private static final String NORESULTSMSG = "No results found";
	private static final String UNABLETOSEARCHMSG = "Oops... unable to complete this search. Please select a button.";
	private static String row;
	private static ArrayList<String> result;
	private static final String SEARCHCOLNAMES = "Serial, Make, Model, Bldg, Room, Last, First, EDIPI";	
	private static final String SQLSEARCHTXT = "SELECT a.DSerNum,a.Make,a.Model,a.BldNum,a.RmNum,u.LName,u.FName,u.EDIPI "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos)";
	private static final String SQLASSETSEARCHTXT = " WHERE a.DSerNum LIKE ?;";
	private static final String SQLUSERSEARCHTXT = " WHERE u.LName LIKE ?;";
	private static final String SQLBLDGSEARCHTXT = " WHERE a.BldNum LIKE ?;";
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	private static final String SQLADVSERTXT = "SELECT a.DSerNum,a.Make,a.Model,s.WinName,s.Class,a.PurchaseDate,"
			+ "a.WarrantyEndDate,a.BldNum,a.RmNum,u.EDIPI,u.LName,u.FName,u.Para,u.Ln,su.SName,su.Desc "
			+ "FROM asset a LEFT JOIN mtoe_asset m on a.DSerNum = m.DSerNum LEFT JOIN user u on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(u.Para,u.Ln,u.Pos) LEFT JOIN storage s on a.DSerNum = s.DSerNum LEFT JOIN mtoe mt on CONCAT(m.Para,m.Ln,m.Pos)"
			+ " = CONCAT(mt.Para,mt.Ln,mt.Pos) LEFT JOIN support su on mt.SNum = su.SNum";
	private static final String SQLSERADVSERTXT = " WHERE a.DSerNum LIKE ?;";
	private static final String SQLMKADVSERTXT = " WHERE a.Make LIKE ?;";
	private static final String SQLMDLADVSERTXT = " WHERE a.Model LIKE ?;";
	private static final String SQLWINADVSERTXT = " WHERE s.WinName LIKE ?;";
	private static final String SQLCLSADVSERTXT = " WHERE s.Class LIKE ?;";
	private static final String SQLPURADVSERTXT = " WHERE a.PurchaseDate LIKE ?;";
	private static final String SQLWARADVSERTXT = " WHERE a.WarrantyEndDate LIKE ?;";
	private static final String SQLBLDADVSERTXT = " WHERE a.BldNum LIKE ?;";
	private static final String SQLRMADVSERTXT = " WHERE a.RmNum LIKE ?;";
	private static final String SQLEDIADVSERTXT = " WHERE u.EDIPI LIKE ?;";
	private static final String SQLLSTADVSERTXT = " WHERE u.LName LIKE ?;";
	private static final String SQLFSTADVSERTXT = " WHERE u.FName LIKE ?;";
	private static final String SQLPARADVSERTXT = " WHERE u.Para LIKE ?;";
	private static final String SQLLNADVSERTXT = " WHERE u.Ln LIKE ?;";
	private static final String SQLSPTADVSERTXT = " WHERE su.SName LIKE ?;";
	private static final String SQLDESADVSERTXT = " WHERE su.Desc LIKE ?;";
	
	private static void readServerData() {
		if (url == null) {
			url = "jdbc:mysql://";
			username = "";
			password = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader (SERVDATFILE));
				url += br.readLine();
				username = br.readLine();
				password = br.readLine();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static ArrayList<String> searchSQL(int buttonState, String userData) {
		result =new ArrayList<String>();
		String search = SQLSEARCHTXT;
		readServerData();
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement pstmt;
			if (!userData.isEmpty()) {
				switch (buttonState) {
				case 0: search += SQLASSETSEARCHTXT;
					break;
				case 1: search += SQLUSERSEARCHTXT;
					break;
				case 2: search += SQLBLDGSEARCHTXT;
					break;
				default: result.add(UNABLETOSEARCHMSG);
					return result;
				}
				pstmt=con.prepareStatement(search);
				pstmt.setString(1, "%" + userData + "%");
			} else {
				search += ";";
				pstmt=con.prepareStatement(search);
			}		
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				row = rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)
				+", "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)
				+", "+rs.getString(7)+", "+rs.getString(8);
				result.add(row);
				}
			pstmt.close();
			rs.close();
			con.close();
			if (result.isEmpty()) result.add(NORESULTSMSG);
			else result.add(0, SEARCHCOLNAMES);
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
	
	public static ArrayList<String> advSearchSQL(int buttonState, String userData) {
		result =new ArrayList<String>();
		String search = SQLADVSERTXT;
		readServerData();
		try (Connection con = DriverManager.getConnection(url, username, password)) {
			PreparedStatement pstmt;
			if (!userData.isEmpty()) {
				switch (buttonState) {
				case 0: search += SQLSERADVSERTXT;
					break;
				case 1: search += SQLMKADVSERTXT;
					break;
				case 2: search += SQLMDLADVSERTXT;
					break;
				case 3: search += SQLWINADVSERTXT;
					break;
				case 4: search += SQLCLSADVSERTXT;
					break;
				case 5: search += SQLPURADVSERTXT;
					break;
				case 6: search += SQLWARADVSERTXT;
					break;
				case 7: search += SQLBLDADVSERTXT;
					break;
				case 8: search += SQLRMADVSERTXT;
					break;
				case 9: search += SQLEDIADVSERTXT;
					break;
				case 10: search += SQLLSTADVSERTXT;
					break;
				case 11: search += SQLFSTADVSERTXT;
					break;
				case 12: search += SQLPARADVSERTXT;
					break;
				case 13: search += SQLLNADVSERTXT;
					break;
				case 14: search += SQLSPTADVSERTXT;
					break;
				case 15: search += SQLDESADVSERTXT;
					break;
				default: result.add(UNABLETOSEARCHMSG);
					return result;
				}
				pstmt=con.prepareStatement(search);
				pstmt.setString(1, "%" + userData + "%");
			} else {
				search += ";";
				pstmt=con.prepareStatement(search);
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				row = "";
				if (ColumnSelection.getSerNumState()) row += rs.getString(1)+", ";
				if (ColumnSelection.getMakeState()) row += rs.getString(2)+", ";
				if (ColumnSelection.getModelState()) row += rs.getString(3)+", ";
				if (ColumnSelection.getWinNameState()) row += rs.getString(4)+", ";
				if (ColumnSelection.getClassState()) row += rs.getString(5)+", ";
				if (ColumnSelection.getPurchaseState()) row += rs.getString(6)+", ";
				if (ColumnSelection.getWarrantyState()) row += rs.getString(7)+", ";
				if (ColumnSelection.getBldgState()) row += rs.getString(8)+", ";
				if (ColumnSelection.getRmState()) row += rs.getString(9)+", ";
				if (ColumnSelection.getEDIPIState()) row += rs.getString(10)+", ";
				if (ColumnSelection.getLastState()) row += rs.getString(11)+", ";
				if (ColumnSelection.getFirstState()) row += rs.getString(12)+", ";
				if (ColumnSelection.getParaState()) row += rs.getString(13)+", ";
				if (ColumnSelection.getLnState()) row += rs.getString(14)+", ";
				if (ColumnSelection.getSptState()) row += rs.getString(15)+", ";
				if (ColumnSelection.getSptDecState()) row += rs.getString(16)+", ";
				if (row.length() > 0) row = row.substring(0, row.length()-2);
				result.add(row);
			}
			pstmt.close();
			rs.close();
			con.close();	
			if (result.isEmpty()) result.add(NORESULTSMSG);
			else {
				row = "";
				if (ColumnSelection.getSerNumState()) row += row = COMBOOPT[0]+", ";
				if (ColumnSelection.getMakeState()) row += COMBOOPT[1]+", ";
				if (ColumnSelection.getModelState()) row += COMBOOPT[2]+", ";
				if (ColumnSelection.getWinNameState()) row += COMBOOPT[3]+", ";
				if (ColumnSelection.getClassState()) row += COMBOOPT[4]+", ";
				if (ColumnSelection.getPurchaseState()) row += COMBOOPT[5]+", ";
				if (ColumnSelection.getWarrantyState()) row += COMBOOPT[6]+", ";
				if (ColumnSelection.getBldgState()) row += COMBOOPT[7]+", ";
				if (ColumnSelection.getRmState()) row += COMBOOPT[8]+", ";
				if (ColumnSelection.getEDIPIState()) row += COMBOOPT[9]+", ";
				if (ColumnSelection.getLastState()) row += COMBOOPT[10]+", ";
				if (ColumnSelection.getFirstState()) row += COMBOOPT[11]+", ";
				if (ColumnSelection.getParaState()) row += COMBOOPT[12]+", ";
				if (ColumnSelection.getLnState()) row += COMBOOPT[13]+", ";
				if (ColumnSelection.getSptState()) row += COMBOOPT[14]+", ";
				if (ColumnSelection.getSptDecState()) row += COMBOOPT[15]+", ";
				if (row.length() > 0) row = row.substring(0, row.length()-2);
				result.add(0, row);
			}

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

}