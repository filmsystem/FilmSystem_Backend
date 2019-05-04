package DAO;

import Model.Cinema;
import java.sql.*;
import java.util.ArrayList;

import DAO.BaseDAO;

public class CinemaDAO {
	PreparedStatement pstmt;

	public boolean insertCinema(String username, String password, String img, String city, String address) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"insert into cinema (username, password, img, city, address) values(?,?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.setString(4, city);
			pstmt.setString(5, address);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCinema(int id) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("delete from cinema where id=?");
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

	public Cinema checkCinema(String username, String password) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from cinema where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Cinema c = new Cinema();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setImg(rs.getString(4));
				c.setCity(rs.getString(5));
				c.setAddress(rs.getString(6));
				return c;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCinemaName(int id) {
		String username = null;
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select username from cinema where id=?");
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

	public ArrayList<Cinema> listAllCinema() {
		ArrayList<Cinema> al = new ArrayList<Cinema>();
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from cinema");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Cinema c = new Cinema();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setImg(rs.getString(4));
				c.setCity(rs.getString(5));
				c.setAddress(rs.getString(6));
				al.add(c);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateCinema(int id, String username, String password, String img, String city, String address) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"update cinema set username=?,password=?,img=?,city=?,address=? where id=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.setString(4, city);
			pstmt.setString(5, address);
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
