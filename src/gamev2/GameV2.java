 package gamev2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.lang.Math;

public class GameV2 extends JPanel implements KeyListener, ActionListener
{
    private boolean start;
    private Timer time;
    private int delay = 4;
    int score;
    Paddle paddle;
    Paddle paddle2;
    Ball ball;
    Ball ball2;
    Font font = new Font("TimesRoman", Font.BOLD, 25);
    
    public GameV2()
    {
        initUI();
    }
    
    private void initUI()
    {
        setBackground(Color.BLACK);
        paddle = new Paddle(460,550,100,8,1);
        paddle2 = new Paddle(160,550,100,8,2);
        ball = new Ball(20+(int)(Math.random()*310),20+(int)(Math.random()*350),20);
        ball2 = new Ball(350+(int)(Math.random()*300),(int)(Math.random()*350),20);
        addKeyListener(this);
        time = new Timer(delay, this);  
        start = false;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //score
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString("Score:"+score, 570, 30);
        paddle.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        ball2.draw(g);
    }
    
    public static void main(String[] args) 
    {
       
        JFrame frame = new JFrame();
        frame.setBounds(10,10,700,600);
        //frame.setBackground(Color.black);
        frame.setTitle("Basic Game");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        GameV2 game = new GameV2();
        frame.setContentPane(game);
        frame.addKeyListener(game);
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                paddle.moveRight();
                break;
            case KeyEvent.VK_D:
                paddle2.moveRight();
                break;
            case KeyEvent.VK_A:
                paddle2.moveLeft();
                break;
            case KeyEvent.VK_LEFT:
                paddle.moveLeft();
                break;
            default:
                break;
        }
        if(start == false)
        {
            time.start();
            start = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            time.stop();
            initUI();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(paddle.getBounds().intersects(ball.getBounds()))
        {
            ball.hitBar();
            score++;
        }
        if(paddle.getBounds().intersects(ball2.getBounds()))
        {
            ball2.hitBar();
            score++;
        }
        if(paddle2.getBounds().intersects(ball.getBounds()))
        {
            ball.hitBar();
            score++;
        }
        if(paddle2.getBounds().intersects(ball2.getBounds()))
        {
            ball2.hitBar();
            score++;
        }
        ball.actionPerformed(e);
        ball2.actionPerformed(e);
        if(ball.lose() == true || ball2.lose() == true)
        {
            time.stop();
        }
        repaint();
    }
}
