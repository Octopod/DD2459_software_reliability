package se.denisen;

import java.io.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //int[] arr;
        //arr = new int[0];
        //start(arr,0);
        randFile();
    }

    static int start(int[] array, int k) {
        sort(array, (array.length - 1));
        System.out.println("Binary search (R): " + k);
        return rBsearch(array, 0, (array.length-1), k);
    }

    private static void sort(int[] a, int last) {
        if (last > 0) {
            int max = findMax(a, last);
            swap(a, last, max);
            sort(a, last - 1);
        }
    }

    private static int rBsearch(int[] L, int low, int high, int k) {

        int mid = (low + high) / 2;

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

    private static int findMax(int[] arr, int last) {

        int max = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int last, int max) {
        int temp = arr[last];
        arr[last] = arr[max];
        arr[max] = temp;
    }

    private static void randFile() throws IOException{
        Random rand = new Random();
        File fout = new File("rand.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                fos, "UTF-8"))) {
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 11; j++) {
                    out.write(Integer.toString(rand.nextInt(9)) + " ");

                }
                out.newLine();
            }
        }
    }
}
