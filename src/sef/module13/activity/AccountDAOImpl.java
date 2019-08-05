package sef.module13.activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		List res = new ArrayList();
		try {
			PreparedStatement st = conn.prepareStatement("Select * From ACCOUNT Where FIRST_NAME like ? " +
					"And LAST_NAME = ? Order by ID");
			st.setString(1, firstName+"%");
			st.setString(2, lastName);
			ResultSet rs = st.executeQuery();
			while (rs.next())
				res.add(new AccountImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			try { rs.close(); }
			catch (SQLException ignore) { }
			try { st.close(); }
			catch (SQLException ignore) { }
		}
		catch (SQLException e) {
			System.out.println("There is SQL Exception, so... ");
		}
		return res;
	}

	public Account findAccount(int id) throws AccountDAOException {
		try {
			PreparedStatement st = conn.prepareStatement("Select * From ACCOUNT Where ID = ? ");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return new AccountImpl(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			try { rs.close(); }
			catch (SQLException ignore) { }
			try { st.close(); }
			catch (SQLException ignore) { }
		}
		catch (SQLException e) {
			System.out.println("There is SQL Exception, so... ");
		}
		return null;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		boolean result = false;
		try {
			PreparedStatement st = conn.prepareStatement("INSERT INTO ACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, ?)");
			st.setString(1, firstName);
			st.setString(2, lastName);
			st.setString(3, email);
			int rs = st.executeUpdate();
			if (rs != 0) result = true;
			try { st.close(); }
			catch (SQLException ignore) { }
		}
		catch (SQLException e) {
			System.out.println("There is SQL Exception, so... ");
		}
		return result;
	}

}
