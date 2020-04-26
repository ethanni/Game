package gamev2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Paddle extends Base
{
    
    public int width, height;
    private int id;
   
    public Paddle(int XPos, int YPos, int w, int h, int i)
    {
        super(XPos,YPos);
        width = w;
        height = h;
        id = i;
        setFocusTraversalKeyEnabled(false);      
    }
  
    public void draw(Graphics g)
    {       
        //background
        g.setColor(Color.black);
        g.fillRect(OriginX,OriginY,width,height);
        
        //Current
        g.setColor(Color.red);
        g.fillRect(CurrentX,CurrentY,width,height);
        
    }
    
    public void moveRight()
    {
        if(CurrentX >= 600)
           CurrentX = 600;
        else
        {
            OriginX = CurrentX;
            CurrentX += 30;
        }
    }
    
    public void moveLeft()
    {
         if(CurrentX <= 10)
               CurrentX = 0;
         else
         {
            OriginX = CurrentX;
            CurrentX -= 30; 
         }
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(CurrentX, CurrentY, width, height);
    }
    
    public void actionPerformed(ActionEvent e)
    {
     
    }
  
    private void setFocusTraversalKeyEnabled(boolean b) 
    {   
    }
    
}
