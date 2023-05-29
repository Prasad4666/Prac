import java.util.*;

public class Selection {

    public void dosorting(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    min_idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

    }

    public void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[];

        Selection s = new Selection();

        System.out.println("Enter the Total Number of Elements : ");
        int total = sc.nextInt();

        arr = new int[total];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the " + (i + 1) + " Element : ");
            arr[i] = sc.nextInt();
        }

        s.dosorting(arr);
        s.display(arr);
    }

}