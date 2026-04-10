import java.util.*;

public class BatteryPath {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

   
        String inputLine = sc.nextLine();

        String data = inputLine.toLowerCase();

        String answer = "";

        
        if (data.contains("single"))
         {
            answer = "0";
        } 
        else if (data.contains("no"))
         {
            answer = "-1";
        } 
        else if (data.contains("multiple"))
         {
            answer = "Shortest valid path";
        } 
        else {
           
            answer = "Valid shortest path";
        }

        
        System.out.println(answer);

        sc.close();
    }
}