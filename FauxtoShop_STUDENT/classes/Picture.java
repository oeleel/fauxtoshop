import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author Ria Galanos (TJHSST), Doug Oberle (WTW)...
 */
public class Picture extends SimplePicture 
{
///////////////////// constructors ///////////////////////////////////**
/**
 * Constructor that takes no arguments 
 */
   public Picture ()
   {
   /* not needed but use it to show the implicit call to super()
   * child constructors always call a parent constructor 
   */
      super();  
   }

/**
* Constructor that takes a file name and creates the picture 
* @param fileName the name of the file to create the picture from
*/
   public Picture(String fileName)
   {
   // let the parent class handle this fileName
      super(fileName);
   }

/**
* Constructor that takes the width and height
* @param height the height of the desired picture
* @param width the width of the desired picture
*/
   public Picture(int height, int width)
   {
   // let the parent class handle this width and height
      super(width,height);
   }

/**
* Constructor that takes a picture and creates a 
* copy of that picture
* @param copyPicture the picture to copy
*/
   public Picture(Picture copyPicture)
   {
   // let the parent class do the copy
      super(copyPicture);
   }

/**
* Constructor that takes a buffered image
* @param image the buffered image to use
*/
   public Picture(BufferedImage image)
   {
      super(image);
   }

////////////////////// methods ///////////////////////////////////////

/**
 * Method to return the Picture from the Picture
 * @return the picture (this)
 */
   public Picture getPicture()
   {
      return this;
   }	

/**
* Method to return a string with information about this picture.
* @return a string with information about the picture such as fileName,
* height and width.
*/
   public String toString()
   {
      String output = "Picture, filename " + getFileName() + 
         " height " + getHeight() 
         + " width " + getWidth();
      return output;
   }

/** 
 * Method to set the red to 0  
 */
   public void zeroRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
         }
      }
   }
   
/** 
 * Method to set the green to 0  
 */   
   public void zeroGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
         }
      }
   }	
   
/** 
 * Method to set the blue to 0  
 */
   public void zeroBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue(0);
         }
      }
   }	
   
/** 
* Method to keep just the red  
*/    
   public void keepOnlyRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue(0);
            pixelObj.setGreen(0);
         }
      }
   } 
  
/** 
* Method to keep just the green  
*/    
   public void keepOnlyGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue(0);
            pixelObj.setRed(0);
         }
      }
   }  

/** 
* Method to keep just the blue  
*/       
   public void keepOnlyBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
            pixelObj.setRed(0);
         }
      }
   }  
   
/** 
 * Method to modify red by some percentage parameter between 0% and 200%
 * modifyRed(100) nets no change, modifyRed(50) decreases the red to 50% of its original value
 * modifyRed(200) increases the red by 100% 
 * @param x the percentage by which we want to modify the red pixels by
 */  
   public void modifyRed(int x)
   {
      int dec = x / 100;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(pixelObj.getRed() * dec);
         }
      }
   }
   
/** 
 * Method to modify green by some percentage parameter between 0% and 200%
 * modifyGreen(100) nets no change, modifyGreen(50) decreases the green to 50% of its original value
 * modifyGreen(200) increases the green by 100% 
 * @param x the percentage by which we want to modify the blue pixels by
 * 
 */    
   public void modifyGreen(int x)
   {
      //**COMPLETE THE METHOD HERE***
   }
 
/** 
 * Method to modify blue by some percentage parameter between 0% and 200%
 * modifyBlue(100) nets no change, modifyBlue(50) decreases the blue to 50% of its original value
 * modifyBlue(200) increases the blue by 100% 
 * @param x the percentage by which we want to modify the blue pixels by 
 */   
   public void modifyBlue(int x)
   {
      //**COMPLETE THE METHOD HERE***
   }
   
/** 
 * Method to place a rainbow filter over the picture 
 */
   public void rainbowBar()
   {
      Pixel pixel = null;
      Pixel[][] pixels = this.getPixels2D();
      int numRows = pixels.length/6;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            pixel = pixels[row][col];
            //red orange yellow green blue purple
            if (row<numRows)//red
            {
               pixel.setRed((pixel.getRed()+255)/2);
            }               
            else if (row<numRows*2)//orange
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+127)/2);
               pixel.setBlue((pixel.getBlue()+44)/2);   
            }
            else if (row<numRows*3)//yellow
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+255)/2);
            }
            else if (row<numRows*4)//green
            {
               pixel.setGreen((pixel.getGreen()+255)/2); 
            }
            else if (row<numRows*5)//blue
            {
               pixel.setBlue((pixel.getBlue()+255)/2); 
            }
            else //purple
            {
               pixel.setRed((pixel.getRed()+143)/2);
               pixel.setBlue((pixel.getBlue()+255)/2);
            }
         }
      }          
   }
   
/** 
* Method to negate the picture - change the color of every pixel to its inverse
* 
*/
   public void negate()
   {
      //**COMPLETE THE METHOD HERE***
   }            
 
/** 
* Method to grayscale the picture - change every pixel to its equvalently bright or dark shade of gray
*/
   public void grayscale()
   {
      //**COMPLETE THE METHOD HERE***     
   }              
 
/** Method that mirrors the picture around a 
 * vertical mirror in the center of the picture
 * from left to right */
   public void mirrorVertical()
   {
      //**COMPLETE THE METHOD HERE*** 
   }
 
/** Method that mirrors the picture around a 
 * vertical mirror in the center of the picture
 * from right to left */   
   public void mirrorVerticalRightToLeft()
   {
      //**COMPLETE THE METHOD HERE***
   } 
   
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from top to bottom */   
   public void mirrorHorizontal()
   {
      //**COMPLETE THE METHOD HERE***
   }
  
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from bottom to top */   
   public void mirrorHorizontalBotToTop()
   {
      //**COMPLETE THE METHOD HERE***
   }
	
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-left corner
 * to the lower-right  */   
   public void mirrorDiagonal()
   {
      //**COMPLETE THE METHOD HERE***
   }
 
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-right corner
 * to the lower-left  */   
   public void mirrorDiagonalOpposite()
   {
      //**COMPLETE THE METHOD HERE***
   }	
    
/** copy from the passed fromPic to the
 * specified startRow and startCol in the
 * current picture
 * @param fromPic the picture to copy from
 * @param startRow the start row to copy to
 * @param startCol the start col to copy to
 */
   public void copy(Picture fromPic, int startRow, int startCol)
   {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow; 
      fromRow < fromPixels.length &&
      toRow < toPixels.length; 
      fromRow++, toRow++)
      {
         for (int fromCol = 0, toCol = startCol; 
         fromCol < fromPixels[0].length &&
         toCol < toPixels[0].length;  
         fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }   
   }
 
/** copy from the passed fromPic to the
 * specified startRow and startCol in the
 * current picture to a specific location
 * @param fromPic the picture to copy from
 * @param startRow the start row to copy
 * @param startCol the start col to copy
 * @param finRow the finish row to copy
 * @param finCol the finish col to copy
 * @param startToRow the start row location to copy to
 * @param startToCol the start col location to copy to
 */ 
   public void copySection(Picture fromPic, int startRow, int startCol, 
                           int finRow, int finCol, int startToRow, int startToCol)
   {
      Pixel fromPixel=null;
      Pixel toPixel=null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for( int fromRow = startRow, toRow = startToRow; fromRow < (finRow) 
                   && toRow < toPixels.length; fromRow ++,toRow++)
      {
         for(int fromCol = startCol, toCol = startToCol; fromCol < finCol
              &&  toCol < toPixels[0].length; fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }
   }
      
/** 
* Method to sepia tone the picture
*/
   public void sepiatone()
   {
      //**COMPLETE THE METHOD HERE***
   }	

/** Method to show large changes in color 
 * @param edgeDist the distance for finding edges
 */
   public void edgeDetection(int edgeDist)
   {
      //**COMPLETE THE METHOD HERE***
   }
	
/** 
* Method to pixelate the picture (low bit video game effect)
* @param resolution the block size that we simulate for each pixel
*/
   public void pixelate(int resolution)
   {
      //**COMPLETE THE METHOD HERE***
   }
   
/** 
 * Method to blur the picture
 */
   public void blur()
   {
      //**COMPLETE THE METHOD HERE***
   }

/** 
* Method to calculate the distance between two colors
* @param p the pixel we want to find the color distance from
* @param c the color we want to find the color distance from pixel
* @return the color distance between p and c
*/        
   public double distance(Pixel p, Color c)
   {
   
      return Math.sqrt( Math.pow ( Math.abs (p.getRed()-c.getRed() ),2 ) +
                   Math.pow ( Math.abs (p.getGreen()-c.getGreen() ),2 ) +
             		 Math.pow ( Math.abs (p.getBlue()-c.getBlue() ),2 ) );	
   }

/** 
* Method to posterize the picture - reduce to only 3-4 colors of your choice
*/
   public void posterize()
   {
      //**COMPLETE THE METHOD HERE*** 
   }	

/**
* Method for copying the no-green pixels from left side of a picture (with green background) to the right side
*/  
   public void greenScreen()
   {
      //**COMPLETE THE METHOD HERE***  
   }			

/** 
* Method to color splash a picture
* Keeps any pixel close to Color c, but casts all other pixels to its gray-scale equivalent
* @param c the color we want to keep
*/  	
   public void colorSplash(Color c)
   {
      //**COMPLETE THE METHOD HERE***	
   }	
     
 /** Hide a black and white message in the current
    * picture by changing the red to even and then
    * setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
   public void encode(Picture messagePict)
   {
      //**COMPLETE THE METHOD HERE***
   }
   
 /**
   * Method to decode a message hidden in the
   * red value of the current picture
   * @return the picture with the hidden message (this)
   */
   public Picture decode()
   {
      //**COMPLETE THE METHOD HERE***
      return this;
   }
   
/** 
 * Main method for testing - each class in Java can have a main method
 * @param args 'cause, you know...we need this 
 */
   public static void main(String[] args) 
   {
      //Picture pix = new Picture(); // rg - this doesn't open a picture
      Picture pix = new Picture("640x480.jpg"); //- rg this explores the 640x480 in the images directory
      pix.explore();
   }

}
