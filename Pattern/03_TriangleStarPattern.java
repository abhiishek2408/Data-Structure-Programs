
import java.util.Scanner;
public class TriangleStarPattern {

	public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter row ");
     int row = sc.nextInt();
    
     
     for (int i = 1; i <= row; i++) {
	     for (int j = 1; j <=i ; j++) 
			System.out.print("*");
	     System.out.println();
	 }
      System.out.println();

     for (int i = 1; i <= row; i++) {
	     for (int j = 1; j <=i ; j++) 
			System.out.print(i);
	     System.out.println();
	 }

      System.out.println();

     for (int i = 1; i <= row; i++) {
       for (int j = 1; j <=i ; j++) 
      System.out.print(j);
       System.out.println();
   }

      System.out.println();

     for (int i = 1; i <= row; i++) {
       for (int j = 1; j <=i ; j++) 
      System.out.print(i-j+1);
       System.out.println();
   }

   System.out.println();
   
   int count=0;
		
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				count++;
				System.out.print(count);
			}
			System.out.println();
		}


    System.out.println();

     int start = 10; // starting number
        int rows = 4;   // total lines
        
        for (int i = 0; i < rows; i++) {
            // print leading spaces
            for (int s = 0; s < i; s++) {
                System.out.print(" ");
            }
            
            // print numbers decreasing from 'start' to (start - count)
            int count2 = rows - i;  // how many numbers in this row
            for (int j = 0; j < count2; j++) {
                System.out.print(start - j);
            }
            
            System.out.println();
            start -= count2; // adjust next starting number
        }

  }
}