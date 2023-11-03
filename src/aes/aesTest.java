/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aes;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class aesTest {
    private String text[][];
    private String key[][];
    private final String s_Box[][]= { {"63","7c","77","7b","f2","6b","6f","c5","30","01","67","2b","fe","d7","ab","76"},
                                {"ca","82","c9","7d","fa","59","47","f0","ad","d4","a2","af","9c","a4","72","c0"},
                                {"b7","fd","93","26","36","3f","f7","cc","34","a5","e5","f1","71","d8","31","15"},
                                {"04","c7","23","c3","18","96","05","9a","07","12","80","e2","eb","27","b2","75"},
                                {"09","83","2c","1a","1b","6e","5a","a0","52","3b","d6","b3","29","e3","2f","84"},
                                {"53","d1","00","ed","20","fc","b1","5b","6a","cb","be","39","4a","4c","58","cf"},
                                {"d0","ef","aa","fb","43","4d","33","85","45","f9","02","7f","50","3c","9f","a8"},
                                {"51","a3","40","8f","92","9d","38","f5","bc","b6","da","21","10","ff","f3","d2"},
                                {"cd","0c","13","ec","5f","97","44","17","c4","a7","7e","3d","64","5d","19","73"},
                                {"60","81","4f","dc","22","2a","90","88","46","ee","b8","14","de","5e","0b","db"},
                                {"e0","32","3a","0a","49","06","24","5c","c2","d3","ac","62","91","95","e4","79"},
                                {"e7","c8","37","6d","8d","d5","4e","a9","6c","56","f4","ea","65","7a","ae","08"},
                                {"ba","78","25","2e","1c","a6","b4","c6","e8","dd","74","1f","4b","bd","8b","8a"},
                                {"70","3e","b5","66","48","03","f6","0e","61","35","57","b9","86","c1","1d","9e"},
                                {"e1","f8","98","11","69","d9","8e","94","9b","1e","87","e9","ce","55","28","df"},
                                {"8c","a1","89","0d","bf","e6","42","68","41","99","2d","0f","b0","54","bb","16"}
                                };
    
    private final String round_gW[][] = {{"01","00","00","00"},
                                  {"02","00","00","00"},
                                  {"04","00","00","00"},
                                  {"08","00","00","00"},
                                  {"10","00","00","00"},
                                  {"20","00","00","00"},
                                  {"40","00","00","00"},
                                  {"80","00","00","00"},
                                  {"1b","00","00","00"},
                                  {"36","00","00","00"},};
    
    private final String boxMixColumn[][] ={{"02", "03", "01", "01"}, 
                                            {"01", "02", "03", "01"},
                                            {"01", "01", "02", "03"},
                                            {"03", "01", "01", "02"}};
    
    
    //Contrucster
    public aesTest(String[][] text, String[][] key){
        this.text = text;
        this.key = key;
    }
    
    //Getter
    public String[][] getText(){
        return text;
    }
//    -----------------------------------------------------------------  Shift Row
    public String[][] shiftRow(String input[][]){
        //Clone Data 
                String[][] result = input.clone();
                for (int i = 0; i < input.length; i++) {
                    result[i]= input[i].clone();
                }

        //Xử lý shiftRow
                for (int i = 0; i < 4; i++) {
                    int right = i;
                    //
                    for (int j = 0; j < 4; j++) {
                        if (right == 4){
                            right = 0;
                        }
                        result [i][j] = input[i][right];
                        right++;
                    }
                }
        // Trả
            return result;  
    }
//    -----------------------------------------------------------------  Mix Column
    public String[][] mixColumn(String[][] input){
    //Clone Data 
        String[][] clone = input.clone();
        String[][] box = boxMixColumn.clone();
        for (int i = 0; i < input.length; i++) {
            clone[i]= input[i].clone();
            box[i]= boxMixColumn[i].clone();
        }
    //Xử lý 
        String[][] result = new String[4][4];
        
        for (int i = 0; i < 4; i++) {
                    String[] row = new String[4];
                    String[] column = new String[4];
                    //Clone column 
                        for (int j = 0; j < 4; j++) {
                            column[j]= clone[j][i];
                        }         
            for (int j = 0; j < 4; j++) {
                    //Clone Row
                        for (int k = 0; k < 4; k++) {
                            row[k]= box[j][k];
                        }
                // Mix GF(2^8)
                result[j][i] = mix_1Result(column, row);
                // Thêm Số 0 vào bên trái
                if (result[j][i].length() == 1){
                    result[j][i] ="0"+ result[j][i];
                }
            }
        }

    // Trả
            //Show Result
            showResult(result);
            return result;  
    }
    
    
    // Cột nhân dòng  GF(2^8)
    public String mix_1Result (String[] temp, String[] boxMix){
        String[] resultTemp = new String[4];
        
        for (int i = 0; i < 4; i++) {
            if (boxMix[i] == "02"){
                resultTemp[i] = nhan2(temp[i]);
            }
            else if (boxMix[i] == "03"){
                resultTemp[i] = nhan3(temp[i]);
            }
            else{
                resultTemp[i] = temp[i];
            }
                
        }
            for (int i = 0; i < 4; i++) {
            }
            
            int n1 = Integer.parseInt(resultTemp[0], 16);
            int n2 = Integer.parseInt(resultTemp[1], 16);
            int n3 = Integer.parseInt(resultTemp[2], 16);
            int n4 = Integer.parseInt(resultTemp[3], 16);
            
            int result = n1 ^ n2 ^ n3 ^ n4;
       
            return Integer.toHexString(result).toUpperCase();
        
    }
   
    // Xử lý nhân 2
    public String nhan2(String hexString) {
        int input = (Integer.parseInt(hexString, 16));
        int length = input;
        int shiftedLeft = length << 1;
        if (shiftedLeft > 256){
            shiftedLeft = shiftedLeft ^ 0x11b;
        }
        shiftedLeft &= 0xFF;
        return String.format("%06x", shiftedLeft);
    }
    // Xử lý nhân 3
    public String nhan3(String hexString){
        int input = (Integer.parseInt(hexString, 16));

        int nhan2_output = (Integer.parseInt(nhan2(hexString), 16));
        
        int shiftedLeft = input ^ nhan2_output;
        shiftedLeft &= 0xFF;
        return String.format("%06x", shiftedLeft);
    }
    
  
    
       
//    -----------------------------------------------------------------   Xử lý khác
    public String hexToBin(String s) {
              return new BigInteger(s, 16).toString(2);
    }

    public byte[][] changeInputToByte(String input[][]){
        //Clone Data 
        String[][] clone = input.clone();
        for (int i = 0; i < input.length; i++) {
            clone[i]= input[i].clone();
        }
    //Xử lý
        byte[][] result = new byte[4][4] ;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int val = Integer.parseInt(clone[i][j],16);
                        
                result[i][j] = (byte) val;
            }
        }
    

    // Trả
            return result;  
    
    }
    
    public void showResult (String[][] input){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(input[i][j]+ " ");
                }
                System.out.println("");
            }
    }
    
        public void showResult2 (String[] input){
            for (int i = 0; i < 4; i++) {
                    System.out.print(input[i]+ " ");
                System.out.println("");
            }
    }
}
