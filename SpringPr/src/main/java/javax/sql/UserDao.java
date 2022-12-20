package javax.sql;

import springbook.ConnectionMaker;
import springbook.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserDao {
    private DataSource dataSource;
    private Connection c;
    private User user;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(springbook.User user) throws ClassNotFoundException, SQLException{
        Connection c= dataSource.getConnection();
        this.user =user;
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");


        ps.setString(1, user.getId());
        ps.setString(2,user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException{
        this.c = dataSource.getConnection();
        PreparedStatement ps = this.c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        this.c.close();

        return this.user;
    }
}
