package gamev2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

public class Ball extends Base 
{
    private boolean start = true;
    private int radius;
    private int ballXdir = -1;
    private int ballYdir = -2;
    Font font = new Font("TimesRoman", Font.BOLD, 25);
    
    public Ball(int x, int y, int r)
    {
        super(x,y);
        radius = r;
        
        setFocusTraversalKeyEnabled(false);
    }
  
    public void draw(Graphics g)
    {  
   
        g.setColor(Color.black);
        g.fillOval(OriginX,OriginY, radius, radius);
        
        //ball
        g.setColor(Color.white);
        g.fillOval(CurrentX, CurrentY, radius, radius);  
        
        if(lose() == true)
         {
             ballXdir = 0;
             ballYdir = 0;
             g.setColor(Color.red);
             g.setFont(font);
             g.drawString("You Lose", 300, 300);
             g.drawString("Press Enter To Restart", 230, 350);
         }
    }
    
    public boolean lose()
    {
        if(CurrentY >= 550)
        {
            return true;
        }
        return false;
    }
    
    public void hitBar()
    {
        ballYdir = -ballYdir;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(start)
        {
            OriginX = CurrentX;
            OriginY = CurrentY;
            
            CurrentX += ballXdir;
            CurrentY += ballYdir;
            if(CurrentX < 0)
                ballXdir = -ballXdir;
            if(CurrentY < 0)
                ballYdir = -ballYdir;
            if(CurrentX > 670)
                ballXdir = -ballXdir;
        }
      
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(CurrentX, CurrentY, radius, radius);
    }
    
    private void setFocusTraversalKeyEnabled(boolean b) 
    {   
        
    }   
}
