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
    private final String s_Box[][]= {   {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76"},
                                        {"CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0"},
                                        {"B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15"},
                                        {"04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75"},
                                        {"09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84"},
                                        {"53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF"},
                                        {"D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8"},
                                        {"51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2"},
                                        {"CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73"},
                                        {"60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB"},
                                        {"E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79"},
                                        {"E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08"},
                                        {"BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A"},
                                        {"70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E"},
                                        {"E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF"},
                                        {"8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"}
                                };
    
    private final String invSBox[][]= { {"52", "09", "6A", "D5", "30", "36", "A5", "38", "BF", "40", "A3", "9E", "81", "F3", "D7", "FB"},
                                        {"7C", "E3", "39", "82", "9B", "2F", "FF", "87", "34", "8E", "43", "44", "C4", "DE", "E9", "CB"},
                                        {"54", "7B", "94", "32", "A6", "C2", "23", "3D", "EE", "4C", "95", "0B", "42", "FA", "C3", "4E"},
                                        {"08", "2E", "A1", "66", "28", "D9", "24", "B2", "76", "5B", "A2", "49", "6D", "8B", "D1", "25"},
                                        {"72", "F8", "F6", "64", "86", "68", "98", "16", "D4", "A4", "5C", "CC", "5D", "65", "B6", "92"},
                                        {"6C", "70", "48", "50", "FD", "ED", "B9", "DA", "5E", "15", "46", "57", "A7", "8D", "9D", "84"},
                                        {"90", "D8", "AB", "00", "8C", "BC", "D3", "0A", "F7", "E4", "58", "05", "B8", "B3", "45", "06"},
                                        {"D0", "2C", "1E", "8F", "CA", "3F", "0F", "02", "C1", "AF", "BD", "03", "01", "13", "8A", "6B"},
                                        {"3A", "91", "11", "41", "4F", "67", "DC", "EA", "97", "F2", "CF", "CE", "F0", "B4", "E6", "73"},
                                        {"96", "AC", "74", "22", "E7", "AD", "35", "85", "E2", "F9", "37", "E8", "1C", "75", "DF", "6E"},
                                        {"47", "F1", "1A", "71", "1D", "29", "C5", "89", "6F", "B7", "62", "0E", "AA", "18", "BE", "1B"},
                                        {"FC", "56", "3E", "4B", "C6", "D2", "79", "20", "9A", "DB", "C0", "FE", "78", "CD", "5A", "F4"},
                                        {"1F", "DD", "A8", "33", "88", "07", "C7", "31", "B1", "12", "10", "59", "27", "80", "EC", "5F"},
                                        {"60", "51", "7F", "A9", "19", "B5", "4A", "0D", "2D", "E5", "7A", "9F", "93", "C9", "9C", "EF"},
                                        {"A0", "E0", "3B", "4D", "AE", "2A", "F5", "B0", "C8", "EB", "BB", "3C", "83", "53", "99", "61"},
                                        {"17", "2B", "04", "7E", "BA", "77", "D6", "26", "E1", "69", "14", "63", "55", "21", "0C", "7D"},
                                };
    
    private final String rcon[][] =    {{"01","00","00","00"},
                                        {"02","00","00","00"},
                                        {"04","00","00","00"},
                                        {"08","00","00","00"},
                                        {"10","00","00","00"},
                                        {"20","00","00","00"},
                                        {"40","00","00","00"},
                                        {"80","00","00","00"},
                                        {"1B","00","00","00"},
                                        {"36","00","00","00"},};
    
    private final String boxMixColumn[][] ={{"02", "03", "01", "01"}, 
                                            {"01", "02", "03", "01"},
                                            {"01", "01", "02", "03"},
                                            {"03", "01", "01", "02"}};
    
    private final String[][] invBoxMixColumn = {{"0E", "0B", "0D", "09"}, 
                                                {"09", "0E", "0B", "0D"},
                                                {"0D", "09", "0E", "0B"},
                                                {"0B", "0D", "09", "0E"}};
    
//    private final String[][] invBoxMixColumn = {{"0E", "09", "0D", "0B"}, 
//                                                {"0B", "0E", "09", "0D"},
//                                                {"0D", "0B", "0E", "09"},
//                                                {"09", "0D", "0B", "0E"}};
    
    private String[][] cipherText = new String[4][4];
    
    private String[][][] roundKeyData = new String[11][4][4];
    
    //Contrucster
    public aesTest(String text, String key){
        this.text = inputToHex(text);
        this.key = inputToHex(key);
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            }
        }
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            }
        }
       
        
        
    }
     public aesTest(){

     }
     

    
    //Getter
    public String[][] getText(){
        return text;
    }
//    -----------------------------------------------------------------  Full Main
    public String maHoa(){
        roundKey(this.key);
        String result ="";
        
        String[][] first = addRoundKey(text, getRoundKey(0));
        
        
//        
//        System.out.println("ADDROUND 0: -------------");
//        showResult2(first);
//        
//        String[][] resultTemp = new String[4][4];
//        
//        resultTemp =  substitutionBytes(first);
//        System.out.println("SUBSTITU 0: -------------");
//        showResult2(resultTemp);
//        // 10Round
//        for (int i = 0; i < 9; i++) {
//            
//            resultTemp = shiftRow(resultTemp);
//            System.out.println("SHIFTROW"+i+": -------------");
//            showResult2(resultTemp);
//            
//            resultTemp = mixColumns(resultTemp);
//            System.out.println("MIXCLOUMN"+i+": -------------");
//            showResult2(resultTemp);
//
//            resultTemp = addRoundKey(getRoundKey(i+1), resultTemp);
//            System.out.println("ADDROUNDKEY"+(i+1)+": -------------");
//            showResult2(resultTemp);
//
//            resultTemp =  substitutionBytes(resultTemp);
//            System.out.println("SUBSTITU"+i+": -------------");
//            showResult2(resultTemp);
//        }
//        // Bước cuối
//            resultTemp = shiftRow(resultTemp);
//            System.out.println("SHIFTROW 10: -------------");
//            showResult2(resultTemp);
//                    
//            resultTemp = addRoundKey(getRoundKey(10), resultTemp);
//            System.out.println("ADDROUND 10: -------------");
//            showResult2(resultTemp);
        
        
        String[][] resultTemp = new String[4][4];
        
        resultTemp =  substitutionBytes(first);

        // 10Round
        for (int i = 0; i < 9; i++) {
            resultTemp = shiftRow(resultTemp);
            resultTemp = mixColumns(resultTemp);
            resultTemp = addRoundKey(getRoundKey(i+1), resultTemp);
            resultTemp =  substitutionBytes(resultTemp);
        }
        // Bước cuối
            resultTemp = shiftRow(resultTemp);    
            resultTemp = addRoundKey(getRoundKey(10), resultTemp);
//        
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result += resultTemp[j][i];
                }
        }

        
        return result;
    }
//    -----------------------------------------------------------------  Full Main
    
    private String[][] getRoundKey(int keyNum){
        String[][] result = new String[4][4];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.roundKeyData[keyNum][i][j];
            }
        }
        return result;
    }
    
//    -----------------------------------------------------------------  Round key     
    
    private String[][] roundKey(String[][] key){
        
        
        String[][] result = new String[4][4];
        
            for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        roundKeyData[0][j][k] = key[j][k];
                    }
                }
        result = key;
        for (int i = 0; i < 10; i++) {
            result = roundKeyGenerate(result, i);
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    roundKeyData[i+1][j][k] = result[j][k];
                }
            }
        }
        return result;
    }
    
    //Kết quả của 1 key
    
    private String[][] roundKeyGenerate(String[][] input, int roundNumber){
        //Clone Data
                String[][] clone = input.clone();
                for (int i = 0; i < input.length; i++) {
                    clone[i]= input[i].clone();
                }
        // Xử lý Đầu tiên
                String result[][] = new String[4][4];
                String[] temp = leftShiftColumn(getColumn(input, 3));
                for (int i = 0; i < 4; i++) {
                    temp[i] = checkSBox(temp[i]);
                }
                temp = xorHexHexHex(getColumn(input, 0), temp, getRow(rcon, roundNumber));
        //Nhét vào kết quả
                for (int i = 0; i < 4; i++) {
                    result [i][0] = temp[i];
        }
        // Xử lý 3 tk sau
                for (int i = 1; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        String[] valueColumn = getColumn(clone, i);
                        result[j][i] = xorHexHex(result[j][i-1], valueColumn[j]);
                    }
        }
        //Trả
        return result;
    }
    
    private String[] getColumn (String[][] input, int column){
        //Clone Data 
                String[][] clone = input.clone();
                for (int i = 0; i < input.length; i++) {
                    clone[i]= input[i].clone();
                }
        // Xử lý
                String result[] = new String[4];
                for (int i = 0 ; i < 4; i++){
                    result[i] = clone[i][column];
                }
        // Trả
        return result;
    }
    
    private String[] getRow (String[][] input, int row){
        //Clone Data 
                String[][] clone = input.clone();
                for (int i = 0; i < input.length; i++) {
                    clone[i]= input[i].clone();
                }
        // Xử lý
                String result[] = new String[4];
                for (int i = 0 ; i < 4; i++){
                    result[i] = clone[row][i];
                }
        // Trả
        return result;
    }
    
    private String[] xorHexHexHex(String[] input, String[] resultAfterSBox, String[] rcon){
        // Clone Data
        String cloneInput[] = input.clone();
        String cloneResultAfterSBox[] =  resultAfterSBox.clone();
        String cloneRcon[] = rcon.clone();

        // Xử lý
        String result[] = new String[4];
        for (int i = 0; i < 4; i++) {
            int n1 = Integer.parseInt(cloneInput[i], 16);
            int n2 = Integer.parseInt(cloneResultAfterSBox[i], 16);
            int n3 = Integer.parseInt(cloneRcon[i], 16);
            result[i] =  String.format("%02x", n1 ^ n2 ^ n3).toUpperCase();
        }
        return result;
    }
    
    private String[] leftShiftColumn(String[] input){
        //Clone Data 
                String[] clone = input.clone();
        // Xử lý
        
                String[] temp = clone.clone();
                String[] result = new String[4];
                result[0] = temp[1];
                result[1] = temp[2];
                result[2] = temp[3];
                result[3] = temp[0];
        // Trả

        return result;
    }
     
//    -----------------------------------------------------------------  Shift Row
    private String[][] shiftRow(String input[][]){
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
    private String[][] mixColumn(String[][] input){
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
            return result;  
    }
    
    
    // Cột nhân dòng  GF(2^8)
    private String mix_1Result (String[] temp, String[] boxMix){
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
            int n1 = Integer.parseInt(resultTemp[0], 16);
            int n2 = Integer.parseInt(resultTemp[1], 16);
            int n3 = Integer.parseInt(resultTemp[2], 16);
            int n4 = Integer.parseInt(resultTemp[3], 16);
            
            int result = n1 ^ n2 ^ n3 ^ n4;
       
            return Integer.toHexString(result).toUpperCase();
        
    }
   
    // Xử lý nhân 2
    private String nhan2(String hexString) {
        int input = (Integer.parseInt(hexString, 16));
        int length = input;
        int shiftedLeft = length << 1;
        if (shiftedLeft > 256){
            shiftedLeft = shiftedLeft ^ 0x11b;
        }
        shiftedLeft &= 0xFF;
        return String.format("%02x", shiftedLeft);
    }
    // Xử lý nhân 3
    private String nhan3(String hexString){
        int input = (Integer.parseInt(hexString, 16));

        int nhan2_output = (Integer.parseInt(nhan2(hexString), 16));
        
        int shiftedLeft = input ^ nhan2_output;
        shiftedLeft &= 0xFF;
        return String.format("%02x", shiftedLeft);
    }
    
    
    
    private String[][] mixColumns(String[][] input) {
        int[][] state = new int[4][4];
        
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 state[i][j] = Integer.parseInt(input[i][j], 16); 
             }
         }
        
        
        int temp0, temp1, temp2, temp3;
        for (int c = 0; c < 4; c++) {

            temp0 = mult(0x02, state[0][c]) ^ mult(0x03, state[1][c]) ^ state[2][c] ^ state[3][c];
            temp1 = state[0][c] ^ mult(0x02, state[1][c]) ^ mult(0x03, state[2][c]) ^ state[3][c];
            temp2 = state[0][c] ^ state[1][c] ^ mult(0x02, state[2][c]) ^ mult(0x03, state[3][c]);
            temp3 = mult(0x03, state[0][c]) ^ state[1][c] ^ state[2][c] ^ mult(0x02, state[3][c]);

            state[0][c] = temp0;
            state[1][c] = temp1;
            state[2][c] = temp2;
            state[3][c] = temp3;
        }

        String[][] resultString = new String[4][4];
        
        for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 resultString[i][j] =  Integer.toHexString(state[i][j]); 
             }
         }
        
        return resultString;
    }
    
    
    
    
    
    
    
    
//    -----------------------------------------------------------------   Substitution Bytes (S-Box)
    
    private String[][] substitutionBytes(String[][] input){
        //Clone Data 
        String[][] clone = input.clone();
        for (int i = 0; i < input.length; i++) {
            clone[i]= input[i].clone();
        }
        String[][] result = new String[4][4];
        // Xử lý
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = checkSBox(clone[i][j]);
            }
        }
        //Trả
        return result;
    }
       
    private String checkSBox(String input){
        int x = Integer.parseInt(String.valueOf(input.charAt(0)), 16);
        int y = Integer.parseInt(String.valueOf(input.charAt(1)), 16);
        
        
        return s_Box[x][y].toUpperCase();
    }
    
//    -----------------------------------------------------------------   Add roundkey
    
    private String[][] addRoundKey (String[][] input, String[][] key){
    // Clone Data
        String[][] cloneInput = input.clone();
        String[][] cloneKey = key.clone();
        for (int i = 0; i < input.length; i++) {
            cloneInput[i]= input[i].clone();
            cloneKey[i]= key[i].clone();
        }
    // Xử lý
        String[][] result = new String[4][4];
    
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = xorHexHex(cloneInput[i][j], cloneKey[i][j]);
            }
        }
    // Trả
        return result;
    }
    
    private String xorHexHex(String a, String b){
        int n1 = Integer.parseInt(a, 16);
        int n2 = Integer.parseInt(b, 16);
        int n3 = n1 ^ n2;
        return  String.format("%02x", n3).toUpperCase();
    }
//    -----------------------------------------------------------------   Input to Hex   
    
    private String[][] inputToHex(String input){
        String[][] result = new String[4][4];
        int temp = 0;
//        Thêm chuỗi đủ 16 ký tự
        for (int i = input.length(); i < 16; i++) {
            input = input.concat(" ");
        }
        
        
        //Xuất chuỗi sang hex
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
//                System.out.println(input.charAt(temp));
                result[i][j] = textToHex(String.valueOf(input.charAt(temp++))).toUpperCase();
                                
            }
        }
//        System.out.println("NEXT______");
        return result;
    }
    
        private String[][] inputToHex2(String input){
        String[][] result = new String[4][4];
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[j][i] = textToHex(String.valueOf(input.charAt(temp++))).toUpperCase();
            }
        }
        return result;
    }
    
//    -----------------------------------------------------------------   Xử lý khác
    private String hexToBin(String s) {
              return new BigInteger(s, 16).toString(2);
    }
    
    private String textToHex (String input){
        return String.format("%02X", new BigInteger(1, input.getBytes()));
    }

    private byte[][] changeInputToByte(String input[][]){
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
    
    private void showResult3 (String[][][] input){
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        System.out.print(input[i][j][k]+ " ");
                    }
                System.out.println("");
                }

                System.out.println("");
            }
    }
    
    private void showResult2 (String[][] input){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(input[i][j]+ " ");
                }
                System.out.println("");
            }
    }
    
    private void showResult1 (String[] input){
            for (int i = 0; i < 4; i++) {
                    System.out.print(input[i]+ " ");
                System.out.println("");
            }
    }
    
     private void showResult (String input){
            for (int i = 0; i < 16; i++) {
                    System.out.print(input+ " ");
            }
    }
     
     
//    -----------------------------------------------------------------   Giải mã   
     
     public String giaiMa(String input, String key_input){
        String[][] temp = new String[4][4];
        temp = inputText(input);
                roundKey(this.key);
        String result ="";
        String[][] first = addRoundKey(temp, getRoundKey(10));
        
        String[][] resultTemp = new String[4][4];
        
        resultTemp = first;
        
//         System.out.println("---Add Round 10 ---");
//         showResult2(resultTemp);
//        // 9 8 7 6 5 4 3 2 1 
//        for (int i = 9; i > 0 ;i--){
//            resultTemp = invShiftRow(resultTemp);
//                System.out.println("---INV Shift ROW " + i + "---");
//                showResult2(resultTemp);
//            resultTemp = invSubstitutionBytes(resultTemp);
//                System.out.println("---INV SUB Byte " + i + "---");
//                showResult2(resultTemp);
//            resultTemp = addRoundKey(resultTemp, getRoundKey(i));
//                System.out.println("---INV ADD ROW " + i + "---");
//                showResult2(resultTemp);
//            resultTemp = invMixColumn(resultTemp);
//                System.out.println("---INV Mix Colum " + i + "---");
//                showResult2(resultTemp);
//        }
//        
//        
//        //Bước cuối 
//        resultTemp = invShiftRow(resultTemp);
//                System.out.println("---INV Shift Colum " + 0 + "---");
//                showResult2(resultTemp);
//        resultTemp = invSubstitutionBytes(resultTemp);
//                System.out.println("---INV SUB BYTE " + 0 + "---");
//                showResult2(resultTemp);
//        resultTemp = addRoundKey(resultTemp, getRoundKey(0));
//                System.out.println("---INV ADD ROUND " + 0 + "---");
//                showResult2(resultTemp);
                

        // 9 8 7 6 5 4 3 2 1 
        for (int i = 9; i > 0 ;i--){
            resultTemp = invShiftRow(resultTemp);

            resultTemp = invSubstitutionBytes(resultTemp);

            resultTemp = addRoundKey(resultTemp, getRoundKey(i));

            resultTemp = invMixColumn(resultTemp);

        }
        
        
        //Bước cuối 
        resultTemp = invShiftRow(resultTemp);
        resultTemp = invSubstitutionBytes(resultTemp);
        resultTemp = addRoundKey(resultTemp, getRoundKey(0));

        for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result += resultTemp[i][j];
                }
        }
        
        byte[] byteArray = new byte[result.length() / 2];
        for (int i = 0; i < result.length(); i += 2) {
            byteArray[i / 2] = (byte) Integer.parseInt(result.substring(i, i + 2), 16);
        }
        // Chuyển mảng bytes thành văn bản
        String text = new String(byteArray);
        
        
        return text.trim();
     }
     
     
     
     
     
     private String[][] inputText(String input){
         String[][] result = new String[4][4];
         
         int count = 0;
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 result[j][i] = String.valueOf(input.substring(count++, count+1));
                 count++;
             }
         }
         
         return result;
     }
     
     
     
//    -----------------------------------------------------------------   Ivn SubStitution    
    private String[][] invSubstitutionBytes(String[][] input){
        //Clone Data 
        String[][] clone = input.clone();
        for (int i = 0; i < input.length; i++) {
            clone[i]= input[i].clone();
        }
        String[][] result = new String[4][4];
        // Xử lý
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = invCheckSBox(clone[i][j]);
            }
        }
        //Trả
        return result;
    }
    
        private String invCheckSBox(String input){
            int x = Integer.parseInt(String.valueOf(input.charAt(0)), 16);
            int y = Integer.parseInt(String.valueOf(input.charAt(1)), 16);
        return invSBox[x][y].toUpperCase();
    }
        
//    ----------------------------------------------------------------- Inv Shift Row
    private String[][] invShiftRow(String input[][]){
        //Clone Data 
                String[][] result = input.clone();
                for (int i = 0; i < input.length; i++) {
                    result[i]= input[i].clone();
                }

        //Xử lý shiftRow
                int right = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        
                        if (right == 4){
                            right = 0;
                        }
                        result [i][j] = input[i][right];
                        if (j != 3 ){
                            right++;
                        }
                    }
                }
        // Trả
            return result;  
    }
//    ----------------------------------------------------------------- Inv Mix Column
    private String[][] invMixColumn(String[][] input){
    //Clone Data 
        String[][] clone = input.clone();
        String[][] box = invBoxMixColumn.clone();
        for (int i = 0; i < input.length; i++) {
            clone[i]= input[i].clone();
            box[i]= invBoxMixColumn[i].clone();
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
                result[j][i] = invMix1Result(column, row);
                // Thêm Số 0 vào bên trái
                if (result[j][i].length() == 1){
                    result[j][i] ="0"+ result[j][i];
                }
            }
        }

    // Trả
            //Show Result
            return result;  
    }
    
    
        private String invMix1Result (String[] temp, String[] boxMix){
        String[] resultTemp = new String[4];
        
        for (int i = 0; i < 4; i++) {
            if (boxMix[i] == "0E"){
                resultTemp[i] = nhanE(temp[i]);
            }
            else if (boxMix[i] == "0D"){
                resultTemp[i] = nhanD(temp[i]);
            }
            else if (boxMix[i] == "09"){
                resultTemp[i] = nhan9(temp[i]);
            }
            else if (boxMix[i] == "0B"){
                resultTemp[i] = nhanB(temp[i]);
            }
                
        }
        
            
        
            int n1 = Integer.parseInt(resultTemp[0], 16);
            int n2 = Integer.parseInt(resultTemp[1], 16);
            int n3 = Integer.parseInt(resultTemp[2], 16);
            int n4 = Integer.parseInt(resultTemp[3], 16);
            
            int result = n1 ^ n2 ^ n3 ^ n4;
            return Integer.toHexString(result).toUpperCase();
        
    }
    
        private String nhan9(String hexString){
            int value = (Integer.parseInt(hexString, 16));
            int input = (value << 3) ^ value;
            if (input > (256<<2)) input = input ^ (0x11b << 2);
            if (input > (256<<1)) input = input ^ (0x11b << 1);
            if (input > 256) input = input ^ 0x11b;
            input &= 0xFF;
//            System.out.println("Nhan9 :"+String.format("%06x", input));
            return String.format("%02X", input).toUpperCase();
        }
        
        private String nhanB(String hexString){
            int value = (Integer.parseInt(hexString, 16));
            int input = (value << 3) ^ (value << 1) ^ value;
            if (input > (256<<2)) input = input ^ (0x11b << 2);
            if (input > (256<<1)) input = input ^ (0x11b << 1);
            if (input > 256) input = input ^ 0x11b;
            input &= 0xFF;
//            System.out.println("NhanB :"+String.format("%06x", input));
            return String.format("%02X", input).toUpperCase();
        }
        
        private String nhanD(String hexString){
            int value = (Integer.parseInt(hexString, 16));
            int input = (value << 3) ^ (value << 2) ^ value;
            if (input >= (256<<2)) input = input ^ (0x11b << 2);
            if (input >= (256<<1)) input = input ^ (0x11b << 1);
            if (input >= 256) input = input ^ 0x11b;
            input &= 0xFF;
//            System.out.println("NhanD :"+String.format("%06x", input));
            return String.format("%02X", input).toUpperCase();
        }
        
        private String nhanE(String hexString){
            int value = (Integer.parseInt(hexString, 16));
            int input = (value << 3) ^ (value << 2) ^ (value << 1);
            if (input >= (256<<2)) input = input ^ (0x11b << 2);
            if (input >= (256<<1)) input = input ^ (0x11b << 1);
            if (input >= 256) input = input ^ 0x11b;
            input &= 0xFF;
//            System.out.println("NhanE :"+String.format("%06x", input));
            return String.format("%02X", input).toUpperCase();
        }
        
        private String[][] textHexToArray(String input){
            String[] temp = new String[16];
            String[][] result = new String[4][4];
            int flag = 0;
            for (int i = 0; i < 32; i++) {
                temp[flag] = input.substring(i, i+2);
                flag++;
                i++;
            }
            flag = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result[j][i] = temp[flag];
                    flag++;
                }
            }
            return result;
        }
        
        
        
        private String hexToText(String input){
            String result = "";
            
            String[] temp = new String[16];

            int flag = 0;
            for (int i = 0; i < 32; i++) {
                temp[flag] = input.substring(i, i+2);
                flag++;
                i++;
            }
            
            flag = 0;
            for (int j = 0; j < 16; j++) {
                    result = temp[flag];
                    flag++;
                }
            
            return result;
        }
        
    private int multiply (int a, int b){
        int poly = 0b100011011;
        int result = 0;

        while (b>0){
            if (b%2 == 1)
                result ^= a;
            a = gmul(a, poly);
            b >>= 1;
        }

        return result;
    }

    private int gmul (int a, int p){
        a <<= 1;
        if ((a&0x100) == 0x100)
            a ^= p;
        return (a&0xff);
    }
     private String[][] invMixColumn2 (String[][] input) {
        int[][] afterAddroundKey = new int[4][4];
        
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 afterAddroundKey[i][j] = Integer.parseInt(input[i][j], 16); 
             }
         }
         
        int[][] result = new int[4][4];
        
        
        for (int i=0;i<4;i++) {
            result[0][i] = multiply(0xe, afterAddroundKey[0][i]) ^ multiply(0xb, afterAddroundKey[1][i]) ^ multiply(0xd, afterAddroundKey[2][i]) ^ multiply(0x9, afterAddroundKey[3][i]);
            result[1][i] = multiply(0x9, afterAddroundKey[0][i]) ^ multiply(0xe, afterAddroundKey[1][i]) ^ multiply(0xb, afterAddroundKey[2][i]) ^ multiply(0xd, afterAddroundKey[3][i]);
            result[2][i] = multiply(0xd, afterAddroundKey[0][i]) ^ multiply(0x9, afterAddroundKey[1][i]) ^ multiply(0xe, afterAddroundKey[2][i]) ^ multiply(0xb, afterAddroundKey[3][i]);
            result[3][i] = multiply(0xb, afterAddroundKey[0][i]) ^ multiply(0xd, afterAddroundKey[1][i]) ^ multiply(0x9, afterAddroundKey[2][i]) ^ multiply(0xe, afterAddroundKey[3][i]);
        }
        
        String[][] resultString = new String[4][4];
        
        for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 resultString[i][j] = String.format("%02X", result[i][j]).toUpperCase();
             }
         }
        
        return resultString;
    }
     
     private String[][] invMixColumnas(String[][] input) {
        int[][] state = new int[4][4];
        
         for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 state[i][j] = Integer.parseInt(input[i][j], 16); 
             }
         }
         
         
        int temp0, temp1, temp2, temp3;
        for (int c = 0; c < 4; c++) {
            temp0 = mult(0x0e, state[0][c]) ^ mult(0x0b, state[1][c]) ^ mult(0x0d, state[2][c]) ^ mult(0x09, state[3][c]);
            temp1 = mult(0x09, state[0][c]) ^ mult(0x0e, state[1][c]) ^ mult(0x0b, state[2][c]) ^ mult(0x0d, state[3][c]);
            temp2 = mult(0x0d, state[0][c]) ^ mult(0x09, state[1][c]) ^ mult(0x0e, state[2][c]) ^ mult(0x0b, state[3][c]);
            temp3 = mult(0x0b, state[0][c]) ^ mult(0x0d, state[1][c]) ^ mult(0x09, state[2][c]) ^ mult(0x0e, state[3][c]);

            state[0][c] = temp0;
            state[1][c] = temp1;
            state[2][c] = temp2;
            state[3][c] = temp3;
        }
        
                
        String[][] resultString = new String[4][4];
        
        for (int i = 0; i < 4; i++) {
             for (int j = 0; j < 4; j++) {
                 resultString[i][j] =  Integer.toHexString(state[i][j]); 
             }
         }
        
        return resultString;
    }
     
     private static int mult(int a, int b) {
        int sum = 0;
        while (a != 0) {
            if ((a & 1) != 0) { 
                sum = sum ^ b; 
            }
            b = xtime(b); 
            a = a >>> 1;
        }
        return sum;

    }
     
     private static int xtime(int b) {
        if ((b & 0x80) == 0) {
            return b << 1;
        }
        return (b << 1) ^ 0x11b;
    }
     
     
}
