
import java.io.*;
import java.util.*;

public class SelectionSort {

    void sort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        SelectionSort ob = new SelectionSort();
        int arr[];
        System.out.println("Enter the Number of Elements : ");
        int total = sc.nextInt();
        arr = new int[total];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the " + (i + 1) + " Element : ");
            arr[i] = sc.nextInt();

        }
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}