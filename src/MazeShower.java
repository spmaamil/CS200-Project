/* Jett, Cody, Nathan, Colin
 * MazeShower.java
 * <MazeShower.java class utilizes both the RandomMaze and MazeSolver class to create a main method in order to run for our program>
 * <It also includes several supporting methods in order to successfully modify our GUI>
 */
import javax.swing.*;
import java.awt.*;

	public class MazeShower extends JPanel
	{
	     private RandomMaze random;
         private MazeSolver solver;
         private boolean[][] curBoard;
	     private boolean[][] solvedBoard;
         /**main
          * main method is what is ran during execution of our program
         * @param args - String arguments from command line
         * @return void
         */
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
         /**generate
         * Generate method is what is used by the generate button to redraw a new maze
         * @return void
         */
        public void generate()
         {
              random.generateMaze();
              curBoard = random.getBoard().clone();
              solvedBoard = new boolean[curBoard.length][curBoard.length];
              this.repaint();
         }   
         /**solve
         * Solve method is what is used in order to solve the maze on screen when solve button is pressed
         * @return void
         */
        public void solve()
         {
              solver.loadMaze(curBoard); 
              solver.solveMaze();
              solvedBoard = solver.getBoard();
              this.repaint();
         }

         /**setSize
          * Sets the size based upon which button is pressed in GUI (Small, Medium, Large)
         * @param size - Int value of maze to set to
         */
        public void setSize(int size)
         {
            random = new RandomMaze(size, size);
            generate();
         }  
        /**paintComponent
         * paintComponent is what draw and sets up the pane that displays the actual maze in the GUI
         * @return void
         */
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