//Project CSC-120

import java.util.Scanner;

public class Project_ashley_barber
{
   public static void main(String[] args)
   {
      //Variables declared and initialized
      int   gpuSpeed = 0,
            cpuSpeed = 0,
            numCores = 0,
            resolutionChoice = 0,
            numComputers;
      
      double   multiplier = 0,
               performanceScore = 0,
               highest = 0,
               lowest = 1000000;
      
      String toolTitle = "\nComputer Hardware Graphics Quality Recommendation Tool\n";
      String resolutionString = "";
      String quality = "";
      
      //Constants declared to hold multiplier values      
      final double MULTIPLIER_1280_720 = 1.0, 
                   MULTIPLIER_1920_1080 = .75, 
                   MULTIPLIER_2560_1440 = .55, 
                   MULTIPLIER_3840_2160 = .35; 
      
      //Constants declared to hold graphics quality thresholds 
      final double PERFORMANCE_THRESHOLD_ULTRA = 17000, 
                   PERFORMANCE_THRESHOLD_HIGH = 15000,  
                   PERFORMANCE_THRESHOLD_MEDIUM = 13000,  
                   PERFORMANCE_THRESHOLD_LOW = 11000; 
      
      //Scanner object for user input
      Scanner keyboard = new Scanner (System.in);
      
      //Request and receive GPU speed
      System.out.print("How many computers are being processed? ");
      numComputers = keyboard.nextInt();
      
      //Displays title
      System.out.println(toolTitle);
      
      if (numComputers > 0) {
         while (numComputers > 0) {
            
            //Request and receive GPU speed
            System.out.print("Please enter the clock speed (in MegaHertz) of your graphics card: ");
            gpuSpeed = keyboard.nextInt();
            
            //Input validation
            while (gpuSpeed < 800 || gpuSpeed > 2000) {
               System.out.print("\nINVALID ENTRY. Please enter the clock speed (in MegaHertz) of your graphics card: \n");
               gpuSpeed = keyboard.nextInt();
            }   
            
            //Request and receive CPU speed
            System.out.print("Please enter the clock speed (in MegaHertz) of your processor: ");
            cpuSpeed = keyboard.nextInt();
            
            //Input validation
            while (cpuSpeed < 1000 || cpuSpeed > 5500) {
               System.out.print("\nINVALID ENTRY. Please enter the clock speed (in MegaHertz) of your processor: \n");
               cpuSpeed = keyboard.nextInt();
            }
            
            //Request and receive number of cores
            System.out.print("Please enter the number of cores of your processor: ");
            numCores = keyboard.nextInt();
            
            //Input validation
            while (numCores < 1 || numCores > 16) {
               System.out.print("\nINVALID ENTRY. Please enter the number of cores of your processor: \n");
               numCores = keyboard.nextInt();
            }
            
            //Resolution menu and request selection
            System.out.println("What is the resolution of your monitor?");
            System.out.println("\t1. 1280 x 720");
            System.out.println("\t2. 1920 x 1080");
            System.out.println("\t3. 2560 x 1440");
            System.out.println("\t4. 3840 x 2160");
            System.out.print("Please select from the options above: ");
            resolutionChoice = keyboard.nextInt();
            
            //Input validation
            while (resolutionChoice < 1 || resolutionChoice > 4) {
               System.out.print("\nINVALID ENTRY. Please select a valid choice from the list above: \n");
               resolutionChoice = keyboard.nextInt();
            }

            //Assigns multiplier and assigns string to resolution       
            if (resolutionChoice == 1)
            {
               resolutionString = "1280 x 720";
               multiplier = MULTIPLIER_1280_720;
            }
            else if (resolutionChoice == 2)
            {
               resolutionString = "1920 x 1080";
               multiplier = MULTIPLIER_1920_1080;
            }
            else if (resolutionChoice == 3)
            {
               resolutionString = "2560 x 1440";
               multiplier = MULTIPLIER_2560_1440;
            }
            else if (resolutionChoice == 4)
            {
               resolutionString = "3840 x 2160";
               multiplier = MULTIPLIER_3840_2160;
            }
            
            //Computes performance score
            performanceScore = ((5 * gpuSpeed) + (numCores * cpuSpeed)) * multiplier;
            if (performanceScore > highest) {
               highest = performanceScore;
               }
            
            if (performanceScore < lowest) {
               lowest = performanceScore;
               }
            
            //Determines recommended graphic quality
            if (performanceScore > PERFORMANCE_THRESHOLD_ULTRA)
            {
               quality = "Ultra";
            } 
             else if (performanceScore > PERFORMANCE_THRESHOLD_HIGH)
            {
               quality = "High";
            } 
            else if (performanceScore > PERFORMANCE_THRESHOLD_MEDIUM)
            {
               quality = "Medium";
            } 
            else if (performanceScore > PERFORMANCE_THRESHOLD_LOW)
            {
               quality = "Low";
            } 
            else
            {
               quality = "Unable to play";
            } 
            
            //Display results        
            System.out.println("");
            System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
            System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
            System.out.println("Number of cores: " + numCores);
            System.out.println("Monitor Resolution: " + resolutionString);
            System.out.printf("Performance Score: %,.2f \n", performanceScore);
            System.out.println("Recommended Graphics Quality: " + quality + "\n");
            
            //Deincrimate for loop
            numComputers--;
         }
         
         //Displays highest and lowest performance score
         System.out.println("The highest performance score was: " + highest);
         System.out.println("The lowest performance score was: " + lowest);   
      }
   }
}
