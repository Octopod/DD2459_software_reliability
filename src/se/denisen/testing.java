package se.denisen;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testing {

    @Test
    void rand() throws IOException{
        String filename = "rand.txt";
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] splitStr;
        int[] testArr;
        testArr = new int[10];
        HashMap<Integer, Integer> newmap = new HashMap<>();
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
   void pair() throws IOException{
       String filename2 = "pair.txt";
       FileReader fileReader2 = new FileReader(filename2);
       BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
       String line2;
       String[] splitStr2;
       int[] testArr2;
       testArr2 = new int[2];
       HashMap<Integer, Integer> newmap2 = new HashMap<>();
       while((line2=bufferedReader2.readLine())!=null){
           splitStr2 = line2.trim().split("\\s+");
           System.out.println();

           for(int i=0; i<splitStr2.length-1;i++){
               int somet2 =Integer.parseInt(splitStr2[i]);

               testArr2[i] = somet2;
               newmap2.put(i,somet2);
           }
           int last2 = Integer.parseInt(splitStr2[2]);

           int ret2 = Main.start(testArr2, last2);


           if(newmap2.containsValue(last2)){
               assertEquals(ret2,last2);
           }else{
               assertEquals(ret2, -1);
           }
       }

   }


}