package se.denisen;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int start(){
        int[] array = new int[3];
        array[0] = 2;
        array[1] = 1;
        array[2] = 3;

        sort(array, (array.length - 1));

        for (int x = 0; x < array.length; x++) {
            System.out.println(" " + array[x]);
        }
        System.out.println("");
        System.out.println("Binary search (R): " + rBsearch(array, 0, (array.length-1), 0));
        return rBsearch(array, 0, (array.length-1), 0);
    }

    public static void sort(int[] a, int last) {
        if (last > 0) {
            int max = findMax(a, last);
            swap(a, last, max);
            sort(a, last - 1);
        }
    }

    public static int rBsearch(int[] L, int low, int high, int k) {

        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        } else if (L[mid] == k) {
            return L[mid];
        } else if (L[mid] < k) {
            int midd = mid+1;
            return rBsearch(L, mid + 1, high, k);
        } else {
            int middd = mid-1;
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
}
