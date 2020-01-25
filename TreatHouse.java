//***************************************************************************************//
//    TreatHouse.java         Author: Khaled Alshatti                                    //
//                                                                                       // 
//    A program that shows what its like to hand out candy on halloween.                 //          
//***************************************************************************************//

import java.util.Random;

public class TreatHouse 
{
   int candyPot1; //amount of candy in pot 1
	int candyPot2; //amount of candy in pot 2
	int currentPot; //1 or 2
	int totalCandy;
	int currentTreaters; 
	int treatsPerTreater;
   int leftOverCandy;

	public TreatHouse(int candyPot, int totalCandy) 
   {
		//Add code here, be sure to split the candy between the pots.
		
      currentPot = 1;
      
      if(candyPot ==2)
      {
         currentPot =2;
      }
      
      if(totalCandy>0)
      {
         candyPot1 = (int)Math.floor(totalCandy/2);
         
         candyPot2 = totalCandy - candyPot1;
      }
      
      else
      {
         System.out.println("We can't give out candy if we dont have any. I think we have " 
                           + "some from last year. Yep, we have 100 pieces of candy  to give out.");
         candyPot1 = 50;
         candyPot2 = 50;
      }
	}

	public int getCandyCount() 
   {
		return candyPot1 + candyPot2;
	}

	public void passOutCandy() 
   {
		//If there are enough treats per treater for the given amount per treater, pass out candy
		//from the current pot and switch to the other one.
		//Else display a message that the treaters have been tricked... (no candy for them.)
		// but do not change the current pot
	   leftOverCandy = (currentTreaters * treatsPerTreater);
      
      if(currentPot == 1)
      {
         if(candyPot1 >= leftOverCandy)
         {
            candyPot1 = candyPot1 - leftOverCandy;
            
            if(candyPot2 > 0)
            {
               currentPot = 2;
            }  
         }
         else
         {
            System.out.println("The treaters have been tricked... (no candy for them.)");
         }
      }
      else 
      {
         if(candyPot2 >= leftOverCandy)
         {
            candyPot2 = candyPot2 - leftOverCandy;
            
            if(candyPot1 > 0)
            {
               currentPot = 1;
            }
         }
         else
         {
            System.out.println("The treaters have been tricked... (no candy for them.)");
         }
      }	
	}

	
	//Sets the number of trick or treaters.
	public void knockKnock() 
   {
	   Random gen = new Random(System.currentTimeMillis());
		this.currentTreaters = gen.nextInt(13) + 1; //1 to 13 treaters.
      System.out.println("Amount of Trick or Treaters: " + currentTreaters);
	}
	
	//Displays how much candy in each pot, total candy left

	public void getCandyStatus() 
   {
		//add in code here
		System.out.println("Candy in pot 1: " + candyPot1);
      System.out.println("Candy in pot 2: " + candyPot2);
      System.out.println("Toatl amount of candy: " + (candyPot1 + candyPot2));
	}

	//returns the pot number for which candy was last given.
	public int getLastPot() 
   {
		//add code here
      return currentPot;
	}

	public void setTreatsPerTreater(int treatsPerTreater) 
   {
		//add code here
      this.treatsPerTreater = treatsPerTreater;
	}
}