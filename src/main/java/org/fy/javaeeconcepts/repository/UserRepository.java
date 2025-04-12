package org.fy.javaeeconcepts.repository;

import org.fy.javaeeconcepts.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/University?user=postgres&password=987654java");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

    public static int save(User user) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into user(name,password,email,sex,country) values (?,?,?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getCountry());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }

    public static int update(User user) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update user set name = ?, password = ?, email = ?, sex = ?, country = ? where id = ?");
            ps.setString(1, user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getSex());
            ps.setString(5, user.getCountry());
            ps.setLong(6, user.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }

    public static int delete(User user) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from user where id = ?");
            ps.setLong(1, user.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return status;
    }

    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public static User getUserById(int id) {
        User u = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from user where id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setId(rs.getLong("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return u;
    }
}
