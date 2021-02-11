//Project CSC-120

import java.util.Scanner;

public class Project_ashley_barber
{
   public static void main(String[] args)
   {
      //Variables declared and initialized
      int gpuSpeed = 0;
      int cpuSpeed = 0;
      int numCores = 0;
      int resolutionChoice = 0;
      double multiplier = 0;
      double performanceScore = 0;
      String toolTitle = "Computer Hardware Graphics Quality Recommendation Tool";
      String resolutionString = "";
      String quality = "";
      
      
      //Scanner object for user input
      Scanner keyboard = new Scanner (System.in);
      
      //Request and receive GPU speed
      System.out.print("Please enter the clock speed (in MegaHertz) of your graphics card: ");
      gpuSpeed = keyboard.nextInt();
      
      //Request and receive CPU speed
      System.out.print("Please enter the clock speed (in MegaHertz) of your processor: ");
      cpuSpeed = keyboard.nextInt();
      
      //Request and receive number of cores
      System.out.print("Please enter the number of cores of your processor: ");
      numCores = keyboard.nextInt();
      
      //Resolution menu and request selection
      System.out.println("What is the resolution of your monitor?");
      System.out.println("    1. 1280 x 720");
      System.out.println("    2. 1920 x 1080");
      System.out.println("    3. 2560 x 1440");
      System.out.println("    4. 3840 x 2160");
      System.out.print("Please select from the options above: ");
      resolutionChoice = keyboard.nextInt();
   
      //Assigns multiplier and assigns string to resolution       
      if (resolutionChoice == 1)
      {
         resolutionString = "1280 x 720";
         multiplier = 1;
      }
      else if (resolutionChoice == 2)
      {
         resolutionString = "1920 x 1080";
         multiplier = 0.75;
      }
      else if (resolutionChoice == 3)
      {
         resolutionString = "2560 x 1440";
         multiplier = 0.55;
      }
      else if (resolutionChoice == 4)
      {
         resolutionString = "3840 x 2160";
         multiplier = 0.35;
      }
      
      //Computes performance score
      performanceScore = ((5 * gpuSpeed) + (numCores * cpuSpeed)) * multiplier;
      
     //Determines recommended graphic quality
     if (performanceScore <= 11000)
     {
        quality = "Unable to play";
     } 
      else if (performanceScore <= 13000)
     {
        quality = "Low";
     } 
     else if (performanceScore <= 15000)
     {
        quality = "Medium";
     } 
     else if (performanceScore <= 17000)
     {
        quality = "High";
     } 
     else if (performanceScore > 17000)
     {
         quality = "Ultra";
     } 
      
      //Display results
      System.out.println(toolTitle);
      System.out.println("");
      System.out.println("GPU Clock Speed: " + gpuSpeed + " MHz");
      System.out.println("CPU Clock Speed: " + cpuSpeed + " MHz");
      System.out.println("Number of cores: " + numCores);
      System.out.println("Monitor Resolution: " + resolutionString);
      System.out.printf("Performance Score: %,.2f \n", performanceScore);
      System.out.println("Recommended Graphics Quality: " + quality);

   }
}