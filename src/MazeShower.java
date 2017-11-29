	import javax.swing.*;
	import java.awt.*;

	public class MazeShower extends JPanel
	{
	     RandomMaze r = new RandomMaze(25,25);
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
	     }    
	     public MazeShower()
	     { 
	          this.setSize(500,500);                 
	     }

	     public void paintComponent(Graphics g)
	     {
	    	 int y = 0;
	    	 int x = 0;
	          int rnd = (int)(Math.random() * 256); 
	          g.setColor(new Color(rnd % 200, rnd % 100, rnd));
	          for (String line: r.toString().split("\n"))
	          {
	        	  String[] charArray = line.split("");
	        	  for (String c : charArray)
	        	  {
	        		  if(c.equals("-"))
	        			g.setColor(Color.BLACK);
	        			    
	        		  else if(c.equals(" "))
	        			  g.setColor(Color.WHITE);
	        			  
	        			  
	        		g.fillRect(x+ 10, y + 10, 10, 10);
	        			
	        		x+= 5;
	        	  }
	        	  y += 10;
	        	  x = 0;
	          }
	      System.out.println(r);    
	     }
	}
