/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disprog_projectuas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Janet Deby Marlien M
 */
public abstract class myModel {
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;
    
    public myModel(){
        this.conn = this._getConnection();
        this.statement = null;
        this.result = null;
    }
    private Connection _getConnection(){
        if(myModel.conn == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost:3307/bivago", "root", "");
            }
            catch(Exception ex){
                System.out.println("Error di getConnection : " + ex);
            }
        }
        return myModel.conn;
    }
    public abstract void insertData();
    public abstract void updateData();
    public abstract void deleteData();
    public abstract ArrayList<Object> viewListData();
}
