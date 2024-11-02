package io.github.java_servlet.CollectionOfBooks.DAO;

import java.sql.*;

public class UserDAO {
    private final String url = "jdbc:mysql://database:3306/CollectionOfBooks";
    private final String user = "root";
    private final String pass = "abc123";

    public boolean login(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            pst = con.prepareStatement("SELECT (PASSWORD) FROM USERS WHERE USERNAME = ?");
            pst.setString(1, username);
            rs = pst.executeQuery();

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs == null) {
            return false;
        }

        String pass = null;
        while (rs.next()) {
            pass = rs.getString(1);
        }

        if (pass == null) {
            return false;
        }

        return pass.equals(password);
    }
}
