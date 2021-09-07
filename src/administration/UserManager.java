/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administration;

/**
 *
 * @author AMD-PC
 */
public class UserManager {
    public database.DatabaseManager db_Manager;
    int n_NumberOfRegisteredUsers;
    
    public boolean LoginUser(User u){
        this.n_NumberOfRegisteredUsers = this.GetNumberOfRegisteredUsers();
        
        if(this.n_NumberOfRegisteredUsers == 0){
            //Update the users privileges to administrative user.
            
            return true;
        }
        return false;
    }
    public void RegisterUser(User u){
        
    }
    public int GetNumberOfRegisteredUsers(){
        db_Manager.Connect();
        
        //Do the database magic here
        
        db_Manager.Disconnect();
        return 0;
    }
}
