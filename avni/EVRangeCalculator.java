import java.util.Scanner;

public class EVRangeCalculator 
{
public static void main(String[] args)
     {
     Scanner input = new Scanner(System.in);
        double batteryPercent = input.nextDouble();
         double efficiencyValue = input.nextDouble();
         double result = batteryPercent * efficiencyValue;
         if (result % 1 == 0)
         {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }

        input.close();
    }
}