package montyhallsimulation;
import java.util.*;

/**
 * Monty Hall Problem Computer Simulation
 * 
 * This program simulates the results of monty hall problem,
 * and computes the winning rates of switching door and not
 * switching door, respectively.
 * 
 * @author Haixuan Huang, Purdue CS180, Start Concurrent, Chapter 4
 * 
 * @version 08/29/2018
 * 
 */

public class MontyHallSimulation 
{
    public static void main(String[] args) 
    {
        //Create Scanner and Random objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        //Create counters
        int switchGames = 0;
        int switchWin = 0;
        int notSwitchGames = 0;
        int notSwitchWin = 0;
        
        final int NUM_SIMULATIONS = 1000000000;
        

        //boolean playAgain = true;
        //Start simulation
        for(int j = 0; j<NUM_SIMULATIONS; j++)
        {
        // instantiate 3 doors
        boolean[] door = {false,false,false};
            
        
        //Assign the gold
        int doorNumber = rand.nextInt(3);
        door[doorNumber]=true;
        
        //Prompt
        //System.out.println("Which door do you choose, 0, 1, or 2?");
        int choice = rand.nextInt(3);
        
        //Determine the door to open
        int doorOpened = -1;
        
        if(door[choice]==false)
        {
            for(int i = 0; i < 3; i++)
            {
                if(i!=choice && !door[i])
                {
                    doorOpened = i;
                }
            }
        }
        else
        {
            for(int i=0; i<3; i++)
            {
                if(i!=choice && !door[i])
                {
                    doorOpened = i;
                    if(rand.nextBoolean())
                        break;
                }
            }
        }
        
        
        // Error monitor
        /*if(doorOpened == -1)
        {
            System.out.println("Error! doorOpened = -1");
        }
        */
        
        //Prompt
        //System.out.println("The door #"+doorOpened+" has no gold behind!");
        //System.out.println("Do you wanna switch?(y/n)");
        
        
        //Determine whether to change door
        boolean changeDoor = rand.nextBoolean();
        
        if(changeDoor)
            switchGames++;
        else
            notSwitchGames++;
        
        
        //Determine the result
        if(door[choice] == true && changeDoor)
        {
            //System.out.println("You failed!");
        }
        else if(door[choice] == false && !changeDoor)
        {
            //System.out.println("You failed!");
        }
        else if(door[choice] == false && changeDoor)
        {
            switchWin++;
            //System.out.println("You win!");
        }
        else
        {
            notSwitchWin++;
            //System.out.println("You win!");
        }
        
        
        // System.out.println("Do you wanna play again?(y/n)");
        /*
                switch(input.next())
        {
            case "y":playAgain = true;
            case "n":playAgain = false;
        }
        */
        //playAgain = true;
        }
        
        //Compute and print the simulation result
        System.out.println("#Switch Games: " + switchGames);
        System.out.println("#Switch Wins: "+switchWin);
        System.out.println("#Not Switch Games: "+notSwitchGames);
        System.out.println("#Not Switch Wins: "+notSwitchWin);
        
        System.out.println("Winning Rate of Switching: "
                        + switchWin/(double)switchGames);
        System.out.println("Winning Rate of not Switching: "
                        + notSwitchWin/(double)notSwitchGames);
    }
    
}
