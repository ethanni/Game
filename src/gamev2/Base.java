
package gamev2;

import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Base 
{
    protected int OriginX, OriginY, CurrentX, CurrentY;
    
    public Base(int x, int y)
    {
        OriginX = x;
        OriginY = y;
        CurrentX = x;
        CurrentY = y;
    }
    public abstract void draw(Graphics g);
    public abstract Rectangle getBounds();
}
