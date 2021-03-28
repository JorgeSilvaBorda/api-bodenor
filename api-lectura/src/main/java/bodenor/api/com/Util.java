/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.com;

/**
 *
 * @author jorge
 */
public class Util {
    public static String getAnioTimestamp(String timestamp){
        return timestamp.substring(0, 4);
    }
    
    public static String getMesTimestamp(String timestamp){
        return timestamp.substring(5, 7);
    }
    
    public static String getDiaTimestamp(String timestamp){
        return timestamp.substring(8, 10);
    }
    
    public static String getFechaTimestamp(String timestamp){
        return timestamp.substring(0,10);
    }
}
