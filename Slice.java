import java.util.*;
import java.io.*;

public class Slice
{
  private String color;
  private int prizeAmount;


  // Creates a slice with color c, and cash prize p
  public Slice(String c, int p) {
   color = c;
   prizeAmount = p;
  }

  public Slice()
  {
    color = "";
    prizeAmount = 0;
}


  // Returns the cash prize in dollars for this slice
  public int getPrizeAmount() {
    return prizeAmount;
    }
  
  public void set(Slice p)
  {
    
  } 
  // Returns the color of this slice as a string
  public String getColor() {
    return color;
  }


  /* Returns a string representation of the slice in the following format:
   * "Color: red, prize amount: $50".
   */
  public String toString() {
    return "Color: " + color + ", Prize Amount: $" + prizeAmount;
  }
}
