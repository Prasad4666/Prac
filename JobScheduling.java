import java.util.*;
import java.io.*;

public class JobScheduling {

    char id;
    int deadline, profit;

    public JobScheduling() {
    }

    public JobScheduling(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public void printJob(ArrayList<JobScheduling> arr, int t) {
        int n = arr.size();
        char[] job = new char[t];
        boolean result[] = new boolean[t];

        Collections.sort(arr, (a, b) -> b.profit - a.profit);

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for (char c : job) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<JobScheduling> arr = new ArrayList<JobScheduling>();

        System.out.println("Enter the Number of Jobs : ");
        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            System.out.println("Enter the Id : ");
            char Id = sc.next().charAt(0);
            System.out.println("Enter the Deadline : ");
            int Deadline = sc.nextInt();
            System.out.println("Enter the Profit : ");
            int Profit = sc.nextInt();

            arr.add(new JobScheduling(Id, Deadline, Profit));
        }
        JobScheduling j = new JobScheduling();
        System.out.println("Enter How Many Job u want : ");
        int jb = sc.nextInt();
        j.printJob(arr, jb);
    }
}