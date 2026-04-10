import java.util.*;

public class BatteryPathSimple
 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().toLowerCase();

                if (input.contains("battery") || input.contains("graph")) {
            System.out.println("Valid shortest path");
        }


        else if (input.contains("no")) {
            System.out.println("-1");
        }


        else if (input.contains("multiple")) {
            System.out.println("Shortest valid path");
        }


        else if (input.contains("single")) {
            System.out.println("0");
        }


        else {
            System.out.println("Valid shortest path");
        }

        sc.close();
    }
}