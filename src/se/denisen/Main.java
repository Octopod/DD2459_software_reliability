package se.denisen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int[] arr;
        arr = new int[0];
        start(arr,0);
    }

    public static int start(int[] array, int k) throws IOException {
        randFile();
        sort(array, (array.length - 1));

        System.out.println("");
        System.out.println("Binary search (R): " + rBsearch(array, 0, (array.length-1), k));
        int res = rBsearch(array, 0, (array.length-1), k);
        return res;
    }

    public static void sort(int[] a, int last) {
        if (last > 0) {
            int max = findMax(a, last);
            swap(a, last, max);
            sort(a, last - 1);
        }
    }

    public static int rBsearch(int[] L, int low, int high, int k) {
        //Err4: corr: (low+high)/2
        int mid = (low + high);

        if (low > high) {
            return -1;
        } else if (L[mid] == k) {
            return L[mid];
        } else if (L[mid] < k) {
            return rBsearch(L, mid + 1, high, k);
        } else {
            return rBsearch(L, low, mid - 1, k);
        }
    }

    public static int findMax(int[] arr, int last) {

        int max = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void swap(int[] arr, int last, int max) {
        int temp = arr[last];
        arr[last] = arr[max];
        arr[max] = temp;
    }

    private static void randFile() throws FileNotFoundException, IOException{
        Random rand = new Random();
        File fout = new File("rand.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                fos, "UTF-8"));
        try {
            for (int i = 0; i < 10; i++) {
                for(int j=0; j<11; j++){
                    out.write(Integer.toString(rand.nextInt(9))+ " ");

                }
                out.newLine();
            }
        } finally {
            out.close();
        }
    }
    /*private static void pairFile() throws FileNotFoundException, IOException{
        Random rand = new Random();
        File fout = new File("pair.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                fos, "UTF-8"));
        String[] list1 = {"1", };
        String[] list2 = {"0","1","2","3","4","5","6","7","8","9"};
        try {
            for(int j=0; j<11; j++){
                out.write(Integer.toString(rand.nextInt())+ " ");
            }
            for (int i = 0; i < 4; i++) {

                out.newLine();
            }
        } finally {
            out.close();
        }
    }
    public int[][] cartesianProduct(int[] s1, int[] s2) {
        List<int[]> list = new ArrayList<>();
        for (int v1: s1) {
            for (int v2: s2) {
                list.add(new int[]{v1, v2});
            }
        }
        int[][] result = new int[list.size()][2];
        int k=0;
        for(int[] i: list){
            result[k++] = i;
        }
        return result;
    }*/
}
