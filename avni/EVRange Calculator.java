import java.util.Scanner;

public class EVRangeCalculator {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

 double battery;
 double efficiency;

 System.out.print("Enter battery percentage: ");
 battery = sc.nextDouble();

 System.out.print("Enter efficiency: ");
  efficiency = sc.nextDouble();

 if (battery < 0 || efficiency < 0) {
      System.out.println("Invalid input");
      return;
        }

   double range = battery * efficiency;

   if (battery == 0 || efficiency == 0) 
{
 System.out.println(0);
        } else {
            
  if (range == (int) range) {
                
      System.out.println((int) range);
   } else {
   System.out.println(range);
            }
        }
  sc.close();
    }
}