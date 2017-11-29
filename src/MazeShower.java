	import javax.swing.*;
	import java.awt.*;

	public class MazeShower extends JPanel
	{
	     private RandomMaze random;
         private MazeSolver solver;
         private boolean[][] curBoard;
	     private boolean[][] solvedBoard;
         public static void main(String args[])
	     {
	          JFrame frame = new JFrame("Maze creater, and Solver");
	          MazeShower maze = new MazeShower();
	          frame.setPreferredSize(new Dimension(760,530));
	          frame.setLayout(null);
	          
	          frame.add(maze);
	          frame.add(new InputPane(maze));
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.pack();
	          frame.setVisible(true);
	     }    
	     public MazeShower()
	     { 
	          this.setBounds(250,0,500,500);                 
	          random = new RandomMaze(25,25);
              solver = new MazeSolver(random.getBoard(),0,1);
              curBoard = random.getBoard().clone();
              solvedBoard = new boolean[25][25];
              //solver.solveMaze();
              //solvedBoard = solver.getBoard();
              
         }
         public void generate()
         {
              random.generateMaze();
              curBoard = random.getBoard().clone();
              solvedBoard = new boolean[curBoard.length][curBoard.length];
              this.repaint();
         }   
         public void solve()
         {
              solver.loadMaze(curBoard); 
              solver.solveMaze();
              solvedBoard = solver.getBoard();
              this.repaint();
         }

         public void setSize(int size)
         {
            random = new RandomMaze(size, size);
            generate();
         }  
         public void paintComponent(Graphics g)
	     {
	    	 g.clearRect(0,0,this.getWidth(),this.getHeight());
	         int rnd = (int)(Math.random() * 256); 
	         g.setColor(new Color(rnd % 200, rnd % 100, rnd));
	         int scale;
             if(curBoard.length == 25)
                scale = 20;
             else if(curBoard.length == 49)
                scale = 10;
             else
                scale = 5;
	         for(int row = 0; row < curBoard.length; row++)
                 for(int col = 0; col < curBoard.length; col++)
                 {
                     if(solvedBoard[row][col])
                         g.setColor(Color.RED);
                     else if(curBoard[row][col])
                         g.setColor(Color.WHITE);
                     else if(curBoard[row][col] == false)
                         g.setColor(Color.BLACK);
                     g.fillRect(scale*row, scale *col, scale,scale);
                 }
         }
	}
