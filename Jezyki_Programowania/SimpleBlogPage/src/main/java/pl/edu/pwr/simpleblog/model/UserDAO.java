package pl.edu.pwr.simpleblog.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SQUIER on 2015-12-20.
 */
@Repository
public class UserDAO {

    @Autowired
    @Getter
    private DataSource dataSource;

    @Getter
    private User user;

    public UserDAO() {}

    public UserDAO(User user) {
        this.user = user;
    }

    public String getUserPasswordByLogin(String login) {
        String userPass = null;
        Connection connection = null;
        String sql = "SELECT password FROM users WHERE login=\""+login+"\"";

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                userPass = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return userPass;
    }

    public void add(User user) {

        Connection connection = null;
        String sql = "INSERT INTO users (login, email, password) VALUES(?,?,?)";

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.setString(3, PasswordHasher.hashPassword(user.getPassword()));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
