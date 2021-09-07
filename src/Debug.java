/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMD-PC
 */
public class Debug {
    public static boolean isDebugBuild = true;//Set this to false to disable debug output
    
    
    public static void Log(String message){
        if(isDebugBuild == false){
            return;
        }
        System.out.println(message);
    }
}
