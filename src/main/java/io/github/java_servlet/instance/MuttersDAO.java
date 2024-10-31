package io.github.java_servlet.instance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MuttersDAO {
    private final String url = "jdbc:mysql://localhost:3306/dokotubu";
    private final String user = "root";
    private final String pass = "abc123";

    public List<Mutter> findAll() {
        List<Mutter> mutterList = new ArrayList<>();
        String sql = "SELECT ID, NAME, PASS FROM mutters ORDER BY ID DESC";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String userName = rs.getString("NAME");
                String text = rs.getString("TEXT");

                Mutter mutter = new Mutter(id, userName, text);
                mutterList.add(mutter);
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return mutterList;
    }

    public boolean create(Mutter mutter) {
        String sql = "INSERT INTO mutters (NAME, TEXT) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, mutter.getUserName());
            pst.setString(2, mutter.getText());

            int result = pst.executeUpdate();

            if (result != 1) { return  false; }

        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーが読み込めませんでした");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
