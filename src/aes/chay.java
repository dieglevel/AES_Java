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
        String key =  "HDSDOIWHDOIWQDWQ"; 
        String text = "NGUYENTANLOCDEPL";
        
        String key2 = "ngaythi1_105";
        String text2 ="210_46541";
        
        String a,b;
        //Khai báo class
//        aesTest aes = new aesTest(text.clone(),key);

                  String boxMixColumn[][] ={{"02", "03", "01", "01"}, 
                                            {"01", "02", "03", "01"},
                                            {"01", "01", "02", "03"},
                                            {"03", "01", "01", "02"}};
                  
                 String[][] temp = {{"47", "40", "A3", "4C"},
                                    {"37", "D4", "70", "9F"},
                                    {"94", "E4", "3A", "42"},
                                    {"ED", "A5", "A6", "BC"}
                 };
//        aesTest aes = new aesTest(text,key);  
//        a = aes.maHoa();
//        System.out.println("Cipher: " + a);
//        b = aes.giaiMa(a, key);
//        System.out.println("text: " + b);
//        
//////
        aesTest aes2 = new aesTest(text2,key2);  
        a = aes2.maHoa();
        System.out.println("Cipher: " + a);
        b = aes2.giaiMa(a, key2);
        System.out.println("text: " + b);
        
//        String[][] result = new String[4][4];
//
//        
//        aes2.showResult2(aes2.inputText("7D4CFC545180E2B817A57CCF73EAD765"));
//        
       
        // Result
       
    }
    
}
