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
public class Racun {
    public Artikal[] artikli;
    
    public void DodajArtikal(Artikal artikal) throws NullPointerException{
        if(artikal == null){
            throw new NullPointerException("Argument \"Artikli artikal\" can not be null.");
        }
        
        if(artikli == null){
            artikli = new Artikal[1];
            artikli[0] = artikal;
            return;
        }
        
        
        Artikal[] buffer = artikli;
        artikli = new Artikal[buffer.length + 1];
        for(int i=0;i<buffer.length;i++){
            artikli[i] = buffer[i];
        }
        artikli[buffer.length] = artikal;
    }
    public void UkloniArtikal(Artikal artikal){
        
    }
    
    public float IzracunajUkupnuCijenu(){
        if(artikli == null){
            return 0.0f;
        }
        float retVal = 0.0f;
        for(int i=0;i<artikli.length;i++){
            retVal += artikli[i].f_Price;
        }
        return retVal;
    }
}
