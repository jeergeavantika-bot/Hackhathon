import java.util.Scanner;

public class ChargingStation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vehicles = sc.nextInt();  
        int[] arrivalTime = new int[vehicles];

        
        for (int i = 0; i < vehicles; i++) {
            arrivalTime[i] = sc.nextInt();
        }

        int chargingTime = sc.nextInt();  
        int totalChargers = sc.nextInt(); 
        int[] nextFree = new int[totalChargers]; 
        int[] waiting = new int[vehicles];

       
        for (int i = 0; i < vehicles; i++) {

            int minPos = 0;

                for (int j = 0; j < totalChargers; j++) {
                if (nextFree[j] < nextFree[minPos]) {
                    minPos = j;
                }
            }

            int arrive = arrivalTime[i];

            if (arrive >= nextFree[minPos]) {
                waiting[i] = 0;
                nextFree[minPos] = arrive + chargingTime;
            } else {
                waiting[i] = nextFree[minPos] - arrive;
                nextFree[minPos] += chargingTime;
            }
        }

       
        for (int i = 0; i < vehicles; i++) {
            System.out.print(waiting[i]);
            if (i < vehicles - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}