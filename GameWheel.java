import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class GameWheel{
  
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel

/* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
    
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for(int i = 0; i < 20; i++){
      int pa = 0;
      String col = "blue";
      if(i < prizes.length)
        pa = prizes[i];
      if (i%5 == 0)
        col = "black";
      else if (i%2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i)
  {
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
        arr[i] = i*1000;
      else if (i%2 == 1)
        arr[i] = i*100;
      else
        arr[i] = i*200;
    }
    return arr;
  }
  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString(){
    //Implement the toString method here
    String total = "";
    
    for (Slice i : slices)
    {
      total += "\n";
      total += i;
    }
    return total;
  }


  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble()
  {
    //Implement the scramble method here
    
    ArrayList<Slice> reds = new ArrayList<Slice> ();
    ArrayList<Slice> blues = new ArrayList<Slice>();
    ArrayList<Slice> blacks = new ArrayList<Slice>();
    
    
    
    for ( int i = 0; i < 20; i ++)
      {
        if ( (i == 0) || (i % 5 == 0))
        {
          blacks.add(slices.get(i));
        }
        else if ( ( i != 0) && (i %2 ==0))
        {
          blues.add(slices.get(i));
        }
        else if ( (i % 2 == 1))
        {
          reds.add(slices.get(i));
        }
      }
    
    
    slices.clear();
     System.out.println(blacks.size());
    for ( int i = 0; i < 20 ; i ++)
    {
      if ( ( i == 0) || (i % 5 == 0) )
      {
        int randomSlice = (int) (Math.random()*(blacks.size()) );
        slices.add(blacks.get(randomSlice));
        blacks.remove(randomSlice);
      }
      
      else if( (i != 0) && (i % 2 == 0) )
      {
        int randomSlice = (int) (Math.random()* (blues.size()) );
        slices.add(blues.get(randomSlice));
        blues.remove(randomSlice);
        
      }
      
      else if( i % 2 == 1)
      {
        int randomSlice = (int) (Math.random() * (reds.size() ));
        slices.add(reds.get(randomSlice));
        reds.remove(randomSlice);
      }
    }

 
    
  }


  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort()
  {
    ArrayList<Slice> reds = new ArrayList<Slice> ();
    ArrayList<Slice> blues = new ArrayList<Slice>();
    ArrayList<Slice> blacks = new ArrayList<Slice>();
  
    
    for ( int i = 0; i < 20; i ++)
      {
        if ( (i == 0) || (i % 5 == 0))
        {
          blacks.add(slices.get(i));
        }
        else if ( ( i != 0) && (i %2 ==0))
        {
          blues.add(slices.get(i));
        }
        else if ( (i % 2 == 1))
        {
          reds.add(slices.get(i));
        }
      }


    //blacks array

    int intSizebl = blacks.size()-1;

    //Slice minColorbl = new Slice();
    
    for ( int i = 1; i < intSizebl ; i ++)
      {
        if ( ((blacks.get(i-1)).getPrizeAmount()) > ((blacks.get(i)).getPrizeAmount()))
        {
          blacks.add(i, (blacks.get(i-1)));
          blacks.remove(i-1);
        }

        //Slice temp = blacks.get(i);

               
      }

   //reds array
    int intSizer = reds.size()-1;

    
    
    for ( int i = 1; i < intSizer ; i ++)
      {
        if ( ((reds.get(i-1)).getPrizeAmount()) > ((reds.get(i)).getPrizeAmount()))
        {
        reds.add(i, reds.get(i-1));
        reds.remove(i-1);
        }
               
      }

    
    //blues
    
    int intSizeb = blues.size()-1;

    //Slice minColorb = new Slice();

    // (i<blues.size()) &&
    for ( int i = 1; i < intSizeb; i ++)
      {
        if ( ((blues.get(i-1)).getPrizeAmount()) > ((blues.get(i)).getPrizeAmount()))
        {
          blues.add(i, blues.get(i-1));
          blues.remove(i-1);       
        }
        
        
      }

    // the sorting

    slices.clear();

    int coun = 0;

    while ( coun < 20)
      {

        int blueI = 0;
        int redI = 0;
        int blackI = 0;
        
        if ( (coun == 0) || ( coun %5 == 0) )
      {
        slices.add(coun, blacks.get(blackI));
        blacks.remove(blackI);
      }
          
      else if ( (coun != 0) && ( coun %2 == 0) )
      {
        slices.add(coun, blues.get(blueI));
        blues.remove(blueI);
        }
        
      else if ( ( coun % 2 == 1))
      {
        slices.add(coun, reds.get(redI));
        reds.remove(redI);
      }
        
        coun = coun + 1;
        
      }
    }
 
}
