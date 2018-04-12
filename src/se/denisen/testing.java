package se.denisen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

class testing {

   @Test
    void rand() throws IOException {
        String fileName = "rand.txt";
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] splitStr;
        int[] testArr;
        testArr = new int[10];
        while((line = bufferedReader.readLine()) != null) {
            splitStr = line.trim().split("\\s+");
            for(int i=0; i<splitStr.length-1;i++){
                int somet =Integer.parseInt(splitStr[i]);
                testArr[i] = somet;
            }
            int last = Integer.parseInt(splitStr[10]);
            int ret = Main.start(testArr, last);
            if(Arrays.asList(testArr).contains(last)){
                assertEquals(ret,last);
            }else{
                assertEquals(ret, -1);
            }
        }
   }

   @Test
   void pair() throws IOException{
       String filename = "pair.txt";
       FileReader fileReader = new FileReader(filename);
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       String line;
       String[] splitStr;
       int[] testArr;
       testArr = new int[10];
       HashMap newmap = new HashMap();
       while((line=bufferedReader.readLine())!=null){
           splitStr = line.trim().split("\\s+");
           for(int i=0; i<splitStr.length-1;i++){
               int somet =Integer.parseInt(splitStr[i]);
               testArr[i] = somet;
               newmap.put(i,somet);
           }
           int last = Integer.parseInt(splitStr[10]);
           int ret = Main.start(testArr, last);
           if(newmap.containsValue(last)){
               assertEquals(ret,last);
           }else{
               assertEquals(ret, -1);
           }
       }

   }



    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testHello() {
        assertEquals(2, 3);
    }

}