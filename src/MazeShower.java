import javax.swing.*;
import java.awt.*;

public class MazeShower extends JPanel implements Runnable
{

     private Thread thread;
     private boolean suspended;
     public static void main(String args[])
     {
          JFrame frame = new JFrame("Maze creater, and Solver");
          MazeShower maze = new MazeShower();
          frame.setPreferredSize(new Dimension(500,500));
          frame.setLayout(new BorderLayout());
          
          frame.add(maze,BorderLayout.CENTER);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.pack();
          frame.setVisible(true);
          maze.start();
//          maze.suspend();
     }    
     public MazeShower()
     { 
          this.setSize(500,500);                 
     }

     public void start()
     {
          if(thread == null)
               thread = new Thread(this);
          thread.start();          
     }

     public void suspend()
     {
          suspended = true;
     }
     public synchronized void resume()
     {
          suspended = false;
          notify();
     }
     public void paintComponent(Graphics g)
     {
          int rnd = (int)(Math.random() * 256); 
          g.setColor(new Color(rnd % 200, rnd % 100, rnd));
          g.fillRect(0,0,500,500);
     }

     public void run()
     {
          suspended = false;
          

           while(true)
           {
               synchronized(this)
               {
                   try
                   {
//                       System.out.println(suspended);
                       this.repaint();
                       while(suspended)
                           wait();
                   }
                   catch(Exception e)
                   {
                   }
               } 
          }

     }
}
