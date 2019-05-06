package shu.ces.filmsystem.DAO;

import java.sql.*;
import java.util.ArrayList;

import DAO.BaseDAO;
import shu.ces.filmsystem.Model.Customer;

public class CustomerDAO {
	PreparedStatement pstmt;

	public boolean insertCustomer(String username, String password, String img, String gender, String phonenum,
			String city) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"insert into customer (username, password, level, gender, phonenum, city) values(?,?,?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.setString(4, gender);
			pstmt.setString(5, phonenum);
			pstmt.setString(6, city);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCustomer(int id) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("delete from customer where id=?");
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Customer checkCustomer(String username, String password) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from customer where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setImg(rs.getString(4));
				c.setGender(rs.getString(5));
				c.setPhoneNum(rs.getString(6));
				c.setCity(rs.getString(7));
				return c;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCustomerName(int id) {
		String username = null;
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select username from customer where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				username = rs.getString(1);
			}
			return username;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Customer> listAllCustomer() {
		ArrayList<Customer> al = new ArrayList<Customer>();
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from customer");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setImg(rs.getString(4));
				c.setGender(rs.getString(5));
				c.setPhoneNum(rs.getString(6));
				c.setCity(rs.getString(7));
				al.add(c);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateCustomer(int id, String username, String password, String img, String gender, String phonenum,
			String city) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"update customer set username=?,password=?,img=?,gender=?,phonenum=?,city=? where id=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.setString(4, gender);
			pstmt.setString(5, phonenum);
			pstmt.setString(6, city);
			pstmt.setInt(7, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
