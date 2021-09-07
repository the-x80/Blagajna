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
public class Blagajna {
    public static database.DatabaseManager db_Manager;
    public static Artikal[] a_Artikli;
    
    public static Racun r_TrenutniRacun;
    public static Racun[] r_AktivniRacuni;
    public static Racun[] r_SprovedeniRacuni;
    
    
    
    public static Racun StvoriNoviRacun(){
        Racun retVal = new Racun();
        r_TrenutniRacun = retVal;
        
        Racun[] buffer = new Racun[r_AktivniRacuni.length + 1];
        for(int i=0;i<r_AktivniRacuni.length;i++){
            buffer[i] = r_AktivniRacuni[i];
        }
        buffer[r_AktivniRacuni.length] = retVal;
        r_AktivniRacuni = buffer;
        
        return retVal;
    }
    public static void StornirajRacun(Racun r){
        
    }
    public static void SprovediRacun(Racun r){
        
    }
    
    public static void DodajNoviArtikal(Artikal a){
        
    }
    public static void UkloniArtikal(Artikal a){
        
    }
    public static void UkloniSveArtiklePoBarKodu(String code){
        
    }
    public static int BrojArtikliTipa(Artikal artikal){
        
        if(DalSadrziArtikalTipa(artikal) == false){
            return 0;
        }
        
        int retVal = 0;
        
        for(int i=0;i<Blagajna.a_Artikli.length;i++){
            if(a_Artikli[i].s_BarCode == null ? artikal.s_BarCode == null : a_Artikli[i].s_BarCode.equals(artikal.s_BarCode)){
                retVal++;
            }
        }
        
        return retVal;
    }
    public static boolean DalSadrziArtikalTipa(Artikal artikal){
        
        return false;
    }
    
    
}
