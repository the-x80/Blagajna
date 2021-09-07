/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AMD-PC
 */
public class DatabaseManager {
    enum State{
        Disconnected,
        Connecting,
        Connected,
        Error//Unused for now.
    }
    public String s_DatabaseURL;
    public String s_User;
    public String s_Password;
    private Connection connection;
    private Class c_Driver;
    private boolean b_IsConnected;
    public State db_State;
    
    public DatabaseManager(String url, String uname, String pwd){
        this.s_DatabaseURL = url;
        this.s_User = uname;
        this.s_Password = pwd;
    }
    
    public void Connect(){
        if(this.b_IsConnected == true){
            return;
        }
        System.out.println("DatabaseManager.Connect()");
        try {
            System.out.println("Initializing Driver.");
            this.c_Driver = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
            //Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.c_Driver.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println("Connection to database.");
            this.db_State = State.Connecting;
            connection = DriverManager.getConnection(this.s_DatabaseURL, this.s_User, this.s_Password);
        } catch(SQLTimeoutException ex){
            this.db_State = State.Disconnected;
            System.out.println(ex.toString());
        }catch (SQLException ex) {
            this.db_State = State.Disconnected;
            System.out.println(ex.toString());
            //Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.db_State = State.Connected;
        System.out.println("Database connection sucsessfull.");
        this.b_IsConnected = true;
    }
    public void Disconnect(){
        if(this.b_IsConnected == false){
            return;
        }
        
        
        try {
            connection.close();
            this.db_State = State.Disconnected;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.b_IsConnected = false;
    }
}
