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
      double dec = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int i = (int)((double)pixelObj.getRed()* dec);
            if (i > 255)
               i = 255; 
            pixelObj.setRed(i);
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
      double dec = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int i = (int)((double)pixelObj.getGreen()* dec);
            if (i > 255)
               i = 255; 
            pixelObj.setGreen(i);
         }
      }
   
   }
 
/** 
 * Method to modify blue by some percentage parameter between 0% and 200%
 * modifyBlue(100) nets no change, modifyBlue(50) decreases the blue to 50% of its original value
 * modifyBlue(200) increases the blue by 100% 
 * @param x the percentage by which we want to modify the blue pixels by 
 */   
   public void modifyBlue(int x)
   {
      double dec = x / 100.0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int i = (int)((double)pixelObj.getBlue()* dec);
            if (i > 255)
               i = 255; 
            pixelObj.setBlue(i);
         }
      }
   
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
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(255 - pixelObj.getRed());
            pixelObj.setGreen(255 - pixelObj.getGreen());
            pixelObj.setBlue(255 - pixelObj.getBlue());     
         
         }
      }
                                                      
   }
/* method to grayscale the picture - change every pixel to its equivalently bright or dark shade of gray*/
   public void grayscale()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int a = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
            pixelObj.setRed(a);
            pixelObj.setGreen(a);
            pixelObj.setBlue(a);     
         
         }
      }
   
   }

         
/*Method that mirrors the picture around a vertical mirror in the center of the picture from left to right*/
   public void mirrorVertical() 
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length/2; col++)
         {
            Pixel pixelObj = pixels[row][pixels[row].length - col - 1];
            Pixel pixelObj2 = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setGreen(pixelObj2.getGreen());
            pixelObj.setBlue(pixelObj2.getBlue());
         
         }
      }
   }
/** Method that mirrors the picture around a 
 * vertical mirror in the center of the picture
 * from right to left */   
   public void mirrorVerticalRightToLeft()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length/2; col++)
         {
            Pixel pixelObj2 = pixels[row][pixels[row].length - col - 1];
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setGreen(pixelObj2.getGreen());
            pixelObj.setBlue(pixelObj2.getBlue());
         
         }
      }
   
   } 
   
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from top to bottom */   
   public void mirrorHorizontal()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length/2; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[pixels.length - row - 1][col];
            Pixel pixelObj2 = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setGreen(pixelObj2.getGreen());
            pixelObj.setBlue(pixelObj2.getBlue());
         
         }
      }
   
   }
  
/** Method that mirrors the picture around a 
 * horizontal mirror in the center of the picture
 * from bottom to top */   
   public void mirrorHorizontalBotToTop()        // fix this and its buttons 8/31
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length/2; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj2 = pixels[pixels.length - row - 1][col];
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setGreen(pixelObj2.getGreen());
            pixelObj.setBlue(pixelObj2.getBlue());
         
         }
      }
   
   }
	
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-left corner
 * to the lower-right  */   
   public void mirrorDiagonal()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<row; col++)
         {
            if(row > pixels[row].length - 1)
            {
               break;
            }
         
            Pixel pixelObj = pixels[col][row];
            Pixel pixelObj2 = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setBlue(pixelObj2.getBlue());
            pixelObj.setGreen(pixelObj2.getGreen());
         
           
         }
      }   
   }
 
/** Method that mirrors the picture around a 
 * diagonal mirror from the upper-right corner
 * to the lower-left  */   
   public void mirrorDiagonalOpposite()
   {
   
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<row; col++)
         {
            if(row > pixels[row].length - 1)
            {
               break;
            }
         
            Pixel pixelObj = pixels[col][row];
            Pixel pixelObj2 = pixels[row][col];
            pixelObj.setRed(pixelObj2.getRed());
            pixelObj.setBlue(pixelObj2.getBlue());
            pixelObj.setGreen(pixelObj2.getGreen());
         
           
         }
      }   
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
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int sepiaRed = (int)(pixelObj.getRed() * 0.393 + pixelObj.getGreen() * 0.769 + pixelObj.getBlue() * 0.189);
            int sepiaGreen = (int)(pixelObj.getRed() * 0.349 + pixelObj.getGreen() * 0.686 + pixelObj.getBlue() * 0.168);
            int sepiaBlue = (int)(pixelObj.getRed() * 0.272 + pixelObj.getGreen() * 0.534 + pixelObj.getBlue() * 0.131);
            pixelObj.setRed(sepiaRed);
            pixelObj.setGreen(sepiaGreen);
            pixelObj.setBlue(sepiaBlue);     
         
         }
      }
   }	

/** Method to show large changes in color 
 * @param edgeDist the distance for finding edges
 */
   public void edgeDetection(int edgeDist)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length - 1; row++)
      {
         for(int col = 0; col<pixels[row].length - 1; col++)
         {   
            if(distance(pixels[row][col], pixels[row + 1][col].getColor()) > edgeDist || distance(pixels[row][col], pixels[row][col + 1].getColor()) > edgeDist || distance(pixels[row][col], pixels[row + 1][col + 1].getColor()) > edgeDist) {
               pixels[row][col].setColor(Color.black);
            }
            else
               pixels[row][col].setColor(Color.white);
         }
      }
   }
	
/** 
* Method to pixelate the picture (low bit video game effect)
* @param resolution the block size that we simulate for each pixel
*/
   public void pixelate(int resolution)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row+=resolution)
      {
         for(int col = 0; col<pixels[row].length; col+=resolution)
         {   
            for (int gridRow = row; gridRow < row + resolution && gridRow < pixels.length; gridRow++) {
               for(int gridCol = col; gridCol < col + resolution && gridCol < pixels[0].length; gridCol++) {
                  pixels[gridRow][gridCol].setRed(pixels[row][col].getRed());
                  pixels[gridRow][gridCol].setGreen(pixels[row][col].getGreen());
                  pixels[gridRow][gridCol].setBlue(pixels[row][col].getBlue());
               }
            }
         }
      }      
   }
   
/** 
 * Method to blur the picture
 */
   public void blur()
   {
      int avgRed = 0;
      int avgGreen = 0;
      int avgBlue = 0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row+=5)
      {
         for(int col = 0; col<pixels[row].length; col+=5)
         {  
            avgRed = 0;
            avgGreen = 0;
            avgBlue = 0; 
            for (int gridRow = row; gridRow < row + 5 && gridRow < pixels.length; gridRow++) {
               for(int gridCol = col; gridCol < col + 5 && gridCol < pixels[0].length; gridCol++) {
                  avgRed += pixels[gridRow][gridCol].getRed();
                  avgGreen += pixels[gridRow][gridCol].getGreen();
                  avgBlue += pixels[gridRow][gridCol].getBlue();    
               }
            }
            avgRed /= 25;
            avgGreen /= 25;
            avgBlue /= 25; 
                  
            
            for (int gridRow = row; gridRow < row + 5 && gridRow < pixels.length; gridRow++) {
               for(int gridCol = col; gridCol < col + 5 && gridCol < pixels[0].length; gridCol++) {
                  pixels[gridRow][gridCol].setRed(avgRed);
                  pixels[gridRow][gridCol].setGreen(avgGreen);
                  pixels[gridRow][gridCol].setBlue(avgBlue);
                  
               }
                  
            }
         
         
         }
      }     
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
      Color red = new Color(235, 64, 52); 
      Color green = new Color(47, 176, 35);
      Color blue = new Color(37, 51, 207);
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length - 1; row++)
      {
         for(int col = 0; col<pixels[row].length - 1; col++)
         {   
            if (distance(pixels[row][col], red) < distance(pixels[row][col], green) && distance(pixels[row][col], red) < distance(pixels[row][col], blue)) {
               pixels[row][col].setColor(red);
            }
            else if (distance(pixels[row][col], green) < distance(pixels[row][col], red) && distance(pixels[row][col], green) < distance(pixels[row][col], blue)) {
               pixels[row][col].setColor(green);
            }
            else
               pixels[row][col].setColor(blue);
         }
      }
   
         
   }	

/**
* Method for copying the no-green pixels from left side of a picture (with green background) to the right side
*/  
   public void greenScreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      int half = pixels[0].length/2;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            if (distance(pixels[row][col], new Color(0, 255, 1)) > 150) {
               if (col*2 < pixels[row].length) {
                  Pixel temp = pixels[row][col];
                  pixels[row][col + half].setRed(temp.getRed());
                  pixels[row][col + half].setGreen(temp.getGreen());
                  pixels[row][col + half].setBlue(temp.getBlue());
               
               }
            }
         }
      }
   }			

/** 
* Method to color splash a picture
* Keeps any pixel close to Color c, but casts all other pixels to its gray-scale equivalent
* @param c the color we want to keep
*/  	
   public void colorSplash(Color c)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length - 1; row++)
      {
         for(int col = 0; col<pixels[row].length - 1; col++)
         {   
            if(distance(pixels[row][col], c) < 100) {
               pixels[row][col].setColor(c);
            }
            else {
               Pixel pixelObj = pixels[row][col];
               int a = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
               pixelObj.setRed(a);
               pixelObj.setGreen(a);
               pixelObj.setBlue(a);
            }     
         }
      }	
   }	
     
 /** Hide a black and white message in the current
    * picture by changing the red to even and then
    * setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
   public void encode(Picture messagePict)
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel[][] msg = messagePict.getPixels2D();
      int resolution = 50;
      for (int row = 0; row < pixels.length && row<msg.length; row++) {
         for (int col = 0; col < pixels[row].length && col < msg[row].length; col++) {
            if (distance(msg[row][col], Color.white) < resolution && pixels[row][col].getRed() % 2 != 0) {
               pixels[row][col].setRed(pixels[row][col].getRed() - 1);
            }
            else 
               if (distance(msg[row][col], Color.black) < resolution && pixels[row][col].getRed() % 2 == 0) {
                  pixels[row][col].setRed(pixels[row][col].getRed() + 1);  
               }   
               
         }
      }
   }
   
 /**
   * Method to decode a message hidden in the
   * red value of the current picture
   * @return the picture with the hidden message (this)
   */
   public Picture decode()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length; row++) {
         for (int col = 0; col < pixels[row].length; col++) {
            if (pixels[row][col].getRed() % 2 != 0) {
               pixels[row][col].setColor(Color.black);
            }
            else
               pixels[row][col].setColor(Color.white);
               
         }
      }
   
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