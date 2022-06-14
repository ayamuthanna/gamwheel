import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class Game
{
  public static void play(GameWheel g)
  {
    // Implement the play method here

    
    ArrayList<Slice> sliceur = new ArrayList<Slice>();
    sliceur.add(0, g.spinWheel());
    sliceur.add(1, g.spinWheel());
    sliceur.add(2, g.spinWheel());
    
    int prizeSum =0;
    
    for( Slice i : sliceur)
    {
      prizeSum+= i.getPrizeAmount();
    }

    ArrayList<String> urstring = new ArrayList<String>();
    
    for ( Slice i : sliceur)
      {
        urstring.add(i.getColor());  
      }

    String strings = "";

      for (String i : urstring)
        {
          strings += i;
        }

    boolean ball = false;
    
    if (strings.equals("blackblackblack"))
    {
      ball = true;
    }
    else if (strings.equals("redredred"))
    {
      ball = true;
    }
    else if (strings.equals("blueblueblue"))
    {
      ball = true;
    }

    if (ball == true)
    {
      prizeSum= 2*prizeSum;
    }
    System.out.println("Total prize money: $" + prizeSum);
    
    int count = 1;
    for( Slice i : sliceur)
    {
      System.out.println("Spin " + count + " - " + i);
      count ++;
    }

    if (ball == true)
    {
      System.out.println("Three " + ((sliceur.get(0)).getColor()) +"s = double your money!");
    }
    
    /*if ( ((sliceur.get(0)).getColor()).equals((sliceur.get(1)).getColor()) && (((sliceur.get(1)).getColor()).equals((sliceur.get(2)).getColor())));
    {
      //if (the color of the first slice == the color of the second slice) and (the color of the second slice == the color of the third slice))
      System.out.println("Three " + ((sliceur.get(0)).getColor()) +"s = double your money!");
    }

    int eqaulsm =0;*/

    
  }
}
