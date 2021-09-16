package com.DAO;

import java.sql.*;

import java.util.*;
import com.Bean.RS_Database;
import com.Configuration.DB_Connect;
import com.Controller.Resturant_Management;

import java.util.regex.*;

public class ResturantdaoImplements implements ResturantDao {

	public RS_Database getResturantName() {

		Connection connection = null;
		try {
			Resturant_Management rds = new Resturant_Management();
			Scanner sc = new Scanner(System.in);
			connection = DB_Connect.getConnect();
			Statement stmt = connection.createStatement();
			System.out.println("Enter the choice : ");
			System.out.println("1.Search by Name \t" + "2.Search by Location \t" + "3.Search by Opening and Closing time");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the name: ");
				String name1 = sc.next();
				String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
				String regex1 = "^[a-zA-Z]*$";
				Pattern p = Pattern.compile(regex);
				Pattern p1 = Pattern.compile(regex1);
				if (name1 == null) {
					System.out.println("Didn't Enter the Name: ");
				}
				Matcher m = p.matcher(name1);
				Matcher m1 = p1.matcher(name1);
				if (m.matches() == false && m1.matches() == false) {
					System.out.println("Invalid Name...");
					rds.run();
				}
				ResultSet rs = stmt.executeQuery("SELECT * FROM rs_database WHERE name='" + name1 + "'");
				rs.next();

				System.out.println(rs.getInt("Id") + "\t");
				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getString("Optime") + "\t");
				System.out.println(rs.getString("Cltime") + "\t");
				System.out.println(rs.getString("address") + "\t");
				System.out.println(rs.getInt("Phone_no"));
				System.out.println(rs.getString("Cusine"));
				break;
			case 2:
				System.out.println("Enter the Address: ");
				String address = sc.next();
				ResultSet rs1 = stmt.executeQuery("SELECT * FROM rs_database WHERE address='" + address + "'");
				rs1.next();

				System.out.println(rs1.getInt("Id") + "\t");
				System.out.println(rs1.getString("name") + "\t");
				System.out.println(rs1.getString("Optime") + "\t");
				System.out.println(rs1.getString("Cltime") + "\t");
				System.out.println(rs1.getString("address") + "\t");
				System.out.println(rs1.getInt("Phone_no"));
				System.out.println(rs1.getString("Cusine"));
				break;
			case 3:
				System.out.println("Enter the Opening and Closing time: ");
				String optime = sc.next();
				String cltime = sc.next();
				ResultSet rs2 = stmt.executeQuery(
						"SELECT * FROM rs_database WHERE Optime='" + optime + "'" + "AND Cltime='" + cltime + "'");
				while (rs2.next()) {

					System.out.println(rs2.getInt("Id") + "\t");
					System.out.println(rs2.getString("name") + "\t");
					System.out.println(rs2.getString("Optime") + "\t");
					System.out.println(rs2.getString("Cltime") + "\t");
					System.out.println(rs2.getString("address") + "\t");
					System.out.println(rs2.getInt("Phone_no"));
					System.out.println(rs2.getString("Cusine"));

				}
				break;
			}
			sc.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
		return null;
	}

	@SuppressWarnings("unlikely-arg-type")
	public void insert() {
	
		Connection connection = null;
		PreparedStatement ps = null;
		Resturant_Management rds = new Resturant_Management();
		try {
			Scanner sc = new Scanner(System.in);
			RS_Database rd = new RS_Database();
			String queryString = "INSERT INTO RS_Database(name,address,Optime,Cltime,Phone_no,Cusine) VALUES(?,?,?,?,?,?)";
			connection = DB_Connect.getConnect();
			ps = connection.prepareStatement(queryString);

			System.out.println("Enter the Name: ");
			String name = sc.next();
			String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
			String regex1 = "^[a-zA-Z]*$";
			Pattern p = Pattern.compile(regex);
			Pattern p1 = Pattern.compile(regex1);
			if (name == null) {
				System.out.println("Didn't Enter the Name: ");
			}
			Matcher m = p.matcher(name);
			Matcher m1 = p1.matcher(name);
			if (m.matches() == false && m1.matches() == false) {
				System.out.println("Invalid Name...");
				rds.run();
			}
			rd.setName(name);
			ps.setString(1, rd.getName());

			System.out.println("Enter the Address:");
			String address = sc.next();
			rd.setAddress(address);
			ps.setString(2, rd.getAddress());

			System.out.println("Enter the Opening time of Resturant: ");
			String Optime = sc.next();
			String regex4 = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[:])[A-Za-z0-9:]+$";
			Pattern p4 = Pattern.compile(regex4);
			if (Optime == null) {
				System.out.println("Didn't Enter the Opening time: ");
			}
			Matcher m4 = p4.matcher(Optime);
			if (m4.matches() == false) {
				System.out.println("Invalid opening time format...");
				rds.run();
			}
			rd.setOptime(Optime);
			ps.setString(3, rd.getOptime());

			System.out.println("Enter the Closing time of Resturant: ");
			String Cltime = sc.next();
			String regex9 = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[:])[A-Za-z0-9:]+$";
			Pattern p9 = Pattern.compile(regex9);
			if (Cltime == null) {
				System.out.println("Didn't Enter the Closing time ");
			}
			Matcher m9 = p9.matcher(Cltime);
			if (m9.matches() == false) {
				System.out.println("Invalid closing time format...");
				rds.run();
			}
			rd.setCltime(Cltime);
			ps.setString(4, rd.getCltime());

			System.out.println("Enter the Phone no to the Resturant: ");
			int Phone_no = sc.nextInt();
			String phoneno = String.valueOf(Phone_no);
			String regex13 = "^([0-9]*)$";
			Pattern p13 = Pattern.compile(regex13);
			if (phoneno == null) {
				System.out.println("Didn't Enter a proper time: ");
			}
			Matcher m13 = p13.matcher(phoneno);
			if (m13.matches() == false) {
				System.out.println("Invalid Phone number...");
				rds.run();
			}
			rd.setPhone_no(Phone_no);
			ps.setInt(5, rd.getPhone_no());

			System.out.println("Enter the Cusine of the Resturant: ");
			String Cusine = sc.next();
			ArrayList<String> firstList = new ArrayList<String>();
			ArrayList<String> secondList = new ArrayList<String>();
			firstList.add("Indian");
			firstList.add("Itaian");
			firstList.add("Chinese");
			firstList.add("American");
			firstList.add("Mexican");
			secondList.add(Cusine);
			if (!firstList.contains(secondList)) 
			{
				System.out.println("Invalid Name...");
				rds.run();
			}

			rd.setCusine(Cusine);
			ps.setString(6, rd.getCusine());

			ps.executeUpdate();
			sc.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void UpdateResturantDetails() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Resturant_Management rds = new Resturant_Management();
			Scanner sc = new Scanner(System.in);
			RS_Database rd = new RS_Database();
			connection = DB_Connect.getConnect();
			System.out.println("Enter the Choice: ");
			System.out.println("1.Update Time: \n" + "2.Update Address: \n" + "3.Update Name: \n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				String queryString = "UPDATE rs_database SET Optime=?,Cltime=? WHERE name =?;";
				ps = connection.prepareStatement(queryString);
				System.out.println("Enter the name of the resturant which you want to update: ");
				String nm = sc.next();
				String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
				String regex1 = "^[a-zA-Z]*$";
				Pattern p = Pattern.compile(regex);
				Pattern p1 = Pattern.compile(regex1);
				if (nm == null) {
					System.out.println("Didn't Enter the Name: ");
				}
				Matcher m = p.matcher(nm);
				Matcher m1 = p1.matcher(nm);
				if (m.matches() == false && m1.matches() == false) {
					System.out.println("Invalid Name...");
					rds.run();
				}
				ps.setString(3, nm);
				System.out.println("Enter the time to Update: ");
				String optime = sc.next();
				String cltime = sc.next();
				rd.setOptime(optime);
				rd.setCltime(cltime);
				ps.setString(1, optime);
				ps.setString(2, cltime);
				int rs = ps.executeUpdate();
				System.out.println(rs + "Updated");
				break;
			case 2:
				String queryString1 = "UPDATE rs_database set address=? WHERE name =?;";
				ps = connection.prepareStatement(queryString1);
				System.out.println("Enter the name of the resturant which you want to update: ");
				String nm1 = sc.next();
				ps.setString(2, nm1);
				System.out.println("Enter the Address to Update: ");
				String ad = sc.next();
				ps.setString(1, ad);
				ps.executeUpdate();
				break;
			case 3:
				String queryString2 = "UPDATE rs_database set name=? WHERE Id =?;";
				ps = connection.prepareStatement(queryString2);
				System.out.println("Enter the id of the resturant which you want to update: ");
				int id = sc.nextInt();
				ps.setInt(2, id);
				System.out.println("Enter t3he Name to Update: ");
				String nm2 = sc.next();
				ps.setString(1, nm2);
				 ps.executeUpdate();
				break;
			default:
				break;
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void deleteResturantDetails() {

		Connection connection = null;
		try {

			Scanner sc = new Scanner(System.in);
			connection = DB_Connect.getConnect();
			Statement stmt = connection.createStatement();
			Resturant_Management rds = new Resturant_Management();
			System.out.println("Enter the name: ");
			String name2 = sc.next();
			String regex11 = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";
			String regex12 = "^[a-zA-Z]*$";
			Pattern p11 = Pattern.compile(regex11);
			Pattern p12 = Pattern.compile(regex12);
			Matcher m11 = p11.matcher(name2);
			Matcher m12 = p12.matcher(name2);
			if (m11.matches() == false && m12.matches() == false) {
				System.out.println("Invalid Name...");
				rds.run();
			}
			stmt.executeUpdate("DELETE FROM rs_database WHERE name='" + name2 + "'");
			System.out.println("DELETE FROM rs_database WHERE name='" + name2 + "'");
			sc.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
			
		}

	}

	public static boolean Deactivate() {
		return false;
	}

	public void DisplayNoOfRetsurants() {
		Connection connection = null;
		
		try {
			connection = DB_Connect.getConnect();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM rs_database");
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + "\t");
				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getString("Optime") + "\t");
				System.out.println(rs.getString("Cltime") + "\t");
				System.out.println(rs.getString("address") + "\t");
				System.out.println(rs.getInt("Phone_no"));
				System.out.println(rs.getString("Cusine"));
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();}
			} catch (SQLException e) {
				e.printStackTrace();}
		}
	}

	public void sort() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Choice: ");
		System.out.println(
				"1.Sort by Name: \n" + "2.Sort by Opening time and Closing time: \n" + "3.Sort by Address: \n");
		int choice = sc.nextInt();

		try {
			Connection connection = DB_Connect.getConnect();

			Statement stmt = connection.createStatement();

			switch (choice) {
			case 1:
				ResultSet rs = stmt.executeQuery("SELECT * FROM rs_database ORDER BY name");
				while (rs.next()) {
					System.out.println("**************************");
					System.out.println(rs.getString("name") + "\t");
					System.out.println(rs.getInt("Id") + "\t");

					System.out.println(rs.getString("Optime") + "\t");
					System.out.println(rs.getString("Cltime") + "\t");
					System.out.println(rs.getString("address") + "\t");
					System.out.println(rs.getInt("Phone_no"));
					System.out.println(rs.getString("Cusine"));
					System.out.println("****************************");
				}
				break;
			case 2:
				ResultSet rs1 = stmt.executeQuery("SELECT * FROM rs_database ORDER BY Optime && Cltime ");
				while (rs1.next()) {
					System.out.println("***************************");
					System.out.println(rs1.getString("Optime") + "\t");
					System.out.println(rs1.getString("Cltime") + "\t");
					System.out.println(rs1.getInt("Id") + "\t");
					System.out.println(rs1.getString("name") + "\t");
					System.out.println(rs1.getString("address") + "\t");
					System.out.println(rs1.getInt("Phone_no"));
					System.out.println(rs1.getString("Cusine"));
					System.out.println("****************************");
				}
				break;
			case 3:
				ResultSet rs2 = stmt.executeQuery("SELECT * FROM rs_database ORDER BY address ");
				while (rs2.next()) {
					System.out.println("***************************");
					System.out.println(rs2.getString("address") + "\t");
					System.out.println(rs2.getInt("Id") + "\t");
					System.out.println(rs2.getString("name") + "\t");
					System.out.println(rs2.getString("Optime") + "\t");
					System.out.println(rs2.getString("Cltime") + "\t");					
					System.out.println(rs2.getInt("Phone_no"));
					System.out.println(rs2.getString("Cusine"));
					System.out.println("****************************");
				}
				break;

			}
			sc.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

}
