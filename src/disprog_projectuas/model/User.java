/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disprog_projectuas.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author Janet Deby Marlien M
 */
public class User extends myModel {

    int id;
    String name;
    String email;
    String username;
    String password;
    Timestamp birthDate;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public User() {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public void insertData() {
        try {
            if (!myModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myModel.conn.prepareStatement("INSERT into tUser(name, username, password, email, tanggalLahir) VALUE (?,?,?,?,?)");
                sql.setString(1, this.name);
                sql.setString(2, this.username);
                sql.setString(3, this.password);
                sql.setString(3, this.email);
                sql.setTimestamp(3, this.birthDate);

                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di insert: " + e);
        }
    }

    @Override
    public void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collection = new ArrayList<>();
        try {
            this.statement = (Statement) myModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM tUser where username = '" + this.username + "' and password = '" + this.password + "'");
            while (this.result.next()) {
                User acc = new User();
                this.result.getInt("id");
                this.result.getString("name");
                this.result.getString("username");
                this.result.getString("password");
                this.result.getString("email");
                this.result.getTimestamp("tanggalLahir");

                collection.add(acc);
            }
        } catch (Exception e) {
            System.out.println("Error di viewList: " + e);
        }
        return collection;
    }

}
