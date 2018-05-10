package se.denisen;

import java.io.*;

class generatePairs {

    private static void printAllKLength(int[] set, int k) throws IOException {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    private static void printAllKLengthRec(int[] set,
                                           String prefix,
                                           int n, int k) throws IOException {
        File fout = new File("pair.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                fos, "UTF-8"));

        if (k == 0)
        {
            System.out.println(prefix);
            //out.write((prefix+ " "));
            return;
        }

        for (int i = 0; i < n; ++i)
        {
            String newPrefix = prefix + set[i] + " ";
            printAllKLengthRec(set, newPrefix,
                    n, k - 1);
        }
    }


    public static void main(String[] args) throws IOException {
        int[] set1 = {1,-2,0};
        int k = 3;
        printAllKLength(set1, k);
    }
}