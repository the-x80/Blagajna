/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blagajna;

/**
 *
 * @author AMD-PC
 */
public class Application {
    public static database.DatabaseManager db_Manager;
    public static administration.UserManager user_Manager;
    public static administration.User u_Current;
    
    public static gui.UIManager ui_Manager;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        db_Manager = new database.DatabaseManager("jdbc:mysql://193.198.97.7", "ndjedovic", "11");
        db_Manager.Connect();
        u_Current = null;
        
        ui_Manager = new gui.UIManager();
        user_Manager = new administration.UserManager();
        user_Manager.db_Manager = db_Manager;
        
        user_Manager.LoginUser(null);
        
        while(ui_Manager.w_Main.isShowing()){
            
        }
    }
    
}
