package shu.ces.filmsystem.DAO;

import java.sql.*;
import java.util.ArrayList;

import shu.ces.filmsystem.DAO.BaseDAO;
import shu.ces.filmsystem.Model.Film;
import shu.ces.filmsystem.Model.Cinema;

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

	public ArrayList<Cinema> searchForList() {
		ArrayList<Cinema> al = new ArrayList<Cinema>();
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Cinema cinema = new Cinema();
				cinema.setId(rs.getInt(1));
				cinema.setUsername(rs.getString(2));
				cinema.setPassword(rs.getString(3));
				cinema.setImg(rs.getString(4));
				cinema.setCity(rs.getString(5));
				cinema.setAddress(rs.getString(6));
				al.add(cinema);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
			return searchForList();
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
