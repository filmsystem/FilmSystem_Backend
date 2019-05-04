package shu.ces.filmsystem.DAO;

import shu.ces.filmsystem.Model.Administrator;
import java.sql.*;

import DAO.BaseDAO;


public class AdministratorDAO {
	PreparedStatement pstmt;

	public boolean insertAdministrator(String username, String password, String img) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("insert into administrator (username, password, img) values(?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAdministrator(int id) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("delete from administrator where id=?");
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

	public Administrator checkAdministrator(String username, String password) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from administrator where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Administrator c = new Administrator();
				c.setId(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setImg(rs.getString(4));
				return c;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getAdministratorName(int id) {
		String username = null;
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select username from administrator where id=?");
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

	public boolean updateAdministrator(int id, String username, String password, String img) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"update customer set username=?,password=?,img=?,gender=?,phonenum=?,city=? where id=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, img);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
