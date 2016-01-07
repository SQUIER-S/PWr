package pl.edu.pwr.simpleblog.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SQUIER on 2015-12-21.
 */
@Repository
public class NoteDAO {

    @Autowired
    DataSource dataSource;

    public NoteDAO() {
    }

    public void addNote(String title, String content) {
        Connection connection = null;
        String sql = "INSERT INTO notes (userID, title, content) VALUES(?,?,?)";

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2, title);
            ps.setString(3, content);
            ps.executeUpdate();
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
    }

}
