/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author AMD-PC
 */
public class UIManager {
    public MainWindow w_Main;
    
    public UIManager(){
        w_Main = new MainWindow();
        w_Main.show(true);
    }
}
