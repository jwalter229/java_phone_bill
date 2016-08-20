/*write a program that prompts a user for their account number
and their service code "r" for regular and "p" or premium
r service plan is $10 plus .20 for minutes over 50
p serivce plan is $25 plus 
.10 for minutes over 75 during the day 6am to 6pm and
.05 for minutes over 100 during the night 6pm to 6am.
display account number, service plan, total minutes used and amount due 
*/ 

//importing a scanner
   import java.util.Scanner;
   
//Name of the Class   
public class PhoneBill {
   
   //Main Method
   public static void main(String[] args) {
      
      //creating a new scanner
      Scanner scanner = new Scanner(System.in);
      //prompting user for account number and taking input
      System.out.println("What is your account number: ");
      int account_number = scanner.nextInt();
      
      //prompting user for service code and taking input
      System.out.println("Enter your service code: ");
      String service_code_input = scanner.next();        
      char service_code = service_code_input.charAt(0);
      
      String service_code_string = "";//creating empty string named service_code_string
      
      double price = 0.00;  //declaring a string named price
                           //setting its value to empty string
      double minutes = 0.00;                  
      
      // Regular Service
      if (service_code == 'r') {
         service_code_string = "Regular Service";
         System.out.println("Enter minutes used: ");
         minutes = scanner.nextDouble();

         price = 10.00; // price is automatically $10
         
         if(minutes <= 50) {
            // no change to price
         } else {
            double difference = minutes - 50;
            //calculating cost for
            //more than 50 mins being used
            price = 10.00 + (difference * 0.20);
         }
      }
      
      // Premium Service
      if (service_code == 'p') {
          service_code_string = "Premium Service";
          price = 25.00; // price is automatically $25       
          // ??? minutes ???                                         //need two different, one for time from 6am-6pm
          System.out.println("Enter minutes used from 6am-6pm: ");   //                    one for time from 6pm-6am  
          int day_mins = scanner.nextInt();
          System.out.println("Enter minutes used from 6pm-6am: ");
          int night_mins = scanner.nextInt();
          //finding total mins used day + night
          minutes = day_mins + night_mins;
          
          // Day Mins
          if (day_mins < 75) {
            // no change to price
          } else {
               double difference = day_mins - 75;
               //calculating cost for
               //more than 75min being used during the day
               price = price + (difference * 0.10);
          }
          
          // Night Mins
          if (night_mins < 100) {
            // no change to price
          } else {
            double difference = night_mins - 100;
            //calculating cost for
            //more than 100min being used during the night
            price = price + (difference * 0.05);
          }
          
          // price = total day mins + total night mins
      }             
     
      System.out.println("Account Number: \t" +  account_number);
      System.out.println("Service Plan: \t\t" + service_code_string + " (" + service_code + ")");
      System.out.println("Minutes Used: \t\t" + minutes);
      System.out.println("Amount Due: \t\t$" + String.format("%4.2f", price));            
            
   }//end of main block
}//end of class PhoneBill