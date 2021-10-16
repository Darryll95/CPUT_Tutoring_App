/**
 * database
 *
 * @author Anathi Mhlom
 */
package com.tutoringapp.tutoringapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class usersDAO {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    String db = "jdbc:derby://localhost:1527/tutoringApp";
    String userID = "Anathim";
    String pass = "Anathim";

    public usersDAO(String name, String surname, String phone, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public usersDAO() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(db, userID, pass);
            if (con != null) {
                System.out.println("Connected successfully");
            }
        } finally {
            
        }
    }

    public void insertUser() throws SQLException {
        try {
            String insertSQL = "INSERT INTO users (name, surname, phone, email, password)" + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pst = this.con.prepareStatement(insertSQL);
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, phone);
            pst.setString(4, email);
            pst.setString(5, password);
        } finally {
            pst.executeUpdate();
            pst.close();
        }
    }

    public ArrayList<users> getUsers() throws SQLException {
        try {
            String getSQL = "SELECT * FROM users";
            ArrayList<users> Users = new ArrayList<>();
            PreparedStatement pst = this.con.prepareStatement(getSQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users user = new users(name, surname, phone, email, password);
                Users.add(user);
            }
            return Users;
        } finally{
            rs.close();
            pst.close();
        }
    }

    public ArrayList<users> getUser() throws SQLException {
        try {
            String getUserSQL = "SELECT * FROM users WHERE email = ? and password = ?";
            ArrayList<users> User = new ArrayList<>();
            PreparedStatement pst = this.con.prepareStatement(getUserSQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                users u = new users(email, password);
                User.add(u);
            }
            return User;
        } finally {
            rs.close();
            pst.close();
        }
    }

    public ArrayList<users> updateUser() throws SQLException {
        try {
            String updateSQL = "update users SET password WHERE email = ?";
            ArrayList<users> User = new ArrayList<>();
            PreparedStatement pst = this.con.prepareStatement(updateSQL);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                users u = new users(email, password);
                User.add(u);
            }
            return User;
        } finally {
            rs.close();
            pst.close();
        }
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }
}