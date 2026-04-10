public class Main
{
 public static void main(String[]args)
{
 int n = 5;
 for(int i = n; i >=1; i++)
{
 for(int j = 0; j < i; j++)
{
 System.out.print((char)('A'+ j));
}
 for(int j = i - 2; j >= 0; j--)
{
 System.out.println((char)('A' + j));
 }
 System.out.println();
 }
 for(int i = 2; i <= n; i++)
{
 for(int j = 0; j < i; j++)
 {
  System.out.print((char)('A' + j));
}
 System.out.println();
}
}
}