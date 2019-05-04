package DAO;

import Model.Film;
import java.sql.*;
import java.util.ArrayList;

import DAO.BaseDAO;

public class FilmDAO {
	PreparedStatement pstmt;

	public boolean insertFilm(String name, String img, float star, String directors, String casts, int year,
			String countries, String type, String summary) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"insert into film (name, img, star, directors, casts, year, countries, type, summary) values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, img);
			pstmt.setFloat(3, star);
			pstmt.setString(4, directors);
			pstmt.setString(5, casts);
			pstmt.setInt(6, year);
			pstmt.setString(7, countries);
			pstmt.setString(8, type);
			pstmt.setString(9, summary);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteFilm(int id) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("delete from film where id=?");
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

	public Film checkFilmByName(String name) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			name = "%" + name + "%";
			pstmt = ct.prepareStatement("select * from film where name=?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Film checkFilmByDirectors(String d) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			d = "%" + d + "%";
			pstmt = ct.prepareStatement("select * from film where directors=?");
			pstmt.setString(1, d);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Film checkFilmByCasts(String c) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			c = "%" + c + "%";
			pstmt = ct.prepareStatement("select * from film where casts=?");
			pstmt.setString(1, c);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Film checkFilmByYear(int y) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from film where year=?");
			pstmt.setInt(1, y);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Film checkFilmByCountries(String c) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from film where Countries=?");
			c="%"+c+"%";
			pstmt.setString(1, c);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Film checkFilmByType(String t) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from film where type=?");
			t="%"+t+"%";
			pstmt.setString(1, t);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				return f;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Film> listAllFilm() {
		ArrayList<Film> al = new ArrayList<Film>();
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement("select * from Film");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Film f = new Film();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setImg(rs.getString(3));
				f.setStar(rs.getFloat(4));
				f.setDirectors(rs.getString(5));
				f.setCasts(rs.getString(6));
				f.setYear(rs.getInt(7));
				f.setCountries(rs.getString(8));
				f.setType(rs.getString(9));
				f.setSummary(rs.getString(10));
				al.add(f);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateFilm(int id, String name, String img, float star, String directors, String casts, int year,
			String countries, String type, String summary) {
		try {
			BaseDAO BD = new BaseDAO();
			Connection ct = BD.getConnection();
			pstmt = ct.prepareStatement(
					"update customer set name=?,img=?,star=?,directors=?,casts=?,year=?,countries=?,type=?,summary=? where id=?");
			pstmt.setString(1, name);
			pstmt.setString(2, img);
			pstmt.setFloat(3, star);
			pstmt.setString(4, directors);
			pstmt.setString(5, casts);
			pstmt.setInt(6, year);
			pstmt.setString(7, countries);
			pstmt.setString(8, type);
			pstmt.setString(9, summary);
			pstmt.setInt(10, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
