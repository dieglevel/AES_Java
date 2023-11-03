/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aes;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class chay {
    
    public static void main(String[] args) {
        String text[][] =      {{"63", "EB", "9F", "A0"}, 
                                {"2F", "93", "92", "C0"},
                                {"AF", "C7", "AB", "30"},
                                {"A2", "20", "CB", "2B"}};
        
        String key[][] = {{}};
        //Khai báo class
        aesTest aes = new aesTest(text.clone(),key);

        aes.mixColumn(text);

        

        // Result
       
    }
    
}
