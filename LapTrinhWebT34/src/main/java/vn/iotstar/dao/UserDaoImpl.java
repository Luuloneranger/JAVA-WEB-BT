package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBContext;
import vn.iotstar.model.UserModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel get(String username) {
		String sql = "SELECT * FROM [User_2] WHERE username = ? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				System.out.println("DB return: " + user.getUserName() + " / " + user.getPassWord());
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "Insert Into [User_2](id,username,fullname,password) Values (?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User_2] where username = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public UserModel findbyUandF(String username, String fullname) {
		String query = "Select * From [User_2] where username = ? and fullname = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, fullname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				return user;
			}

		} catch (Exception ex) {
		}
		return null;
	}

	@Override
	public void edit(UserModel user) {
		String query = "UPDATE [User_2] SET password = ?, fullname = ?  WHERE username = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, user.getPassWord());
			ps.setString(2, user.getFullName());
			ps.setString(3, user.getUserName());

			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}



	@Override
	public List<UserModel> getall() {
		List<UserModel> Userr = new ArrayList<UserModel>();
		String sql = "SELECT * FROM Category";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel element = new UserModel();
				element.setUserName(rs.getString("username"));
				element.setFullName(rs.getString("fullname"));
				element.setPassWord(rs.getString("password"));
				
				Userr.add(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Userr;

	}

	@Override
	public List<UserModel> search(String keyword) {
		
		return null;
	}

	@Override
	public void delete( String username) {
		String query = "Delete from [User_2] where username = ? and id = ?";

		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
