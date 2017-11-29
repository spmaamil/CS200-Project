import java.util.*;
public class MazeSolver
{
    //CREDIT FOR MAZE SOLVING ALGORITHM GOES TO WIKIPEDIA
    private int x,y;
    private boolean board[][];
    private boolean wasHere[][];
    private boolean correctPath[][];
    private int row, col;
    public MazeSolver(boolean board[][], int start, int stop)
    {
        this.board = board.clone();
        
        row = board.length;
        col = board.length;
        wasHere = new boolean[row][col];
        correctPath = new boolean[row][col];
        x = 1;
        y = 0;
    }

    public void solveMaze()
    {
        for(int row = 0; row < this.row; row++)
           for(int col = 0; col < this.col; col++)
           {
               wasHere[row][col] = false;
               correctPath[row][col] = false;
           } 
        
        boolean b = solveMaze(1,1); 
    }

    public boolean solveMaze(int x, int y)
    { 
         
        if(x == row - 1 && y == col - 2)
            return true;
        if(board[x][y] == false || wasHere[x][y])
            return false;
        wasHere[x][y] = true;
        if(x != 0)
            if(solveMaze(x - 1, y))
            {
                correctPath[x][y] = true;
                return true;
            }
        if(x != col -1)
            if(solveMaze(x + 1,y))
            {
                correctPath[x][y] = true;
                return true;
            }
        if(y != 0)
            if(solveMaze(x,y-1))
            {
                correctPath[x][y] = true;
                return true;
            }
        if(y != row - 1)
            if(solveMaze(x,y+1))
            {
                correctPath[x][y] = true;
                return true;
            }

       return false;
    } 
	
     //public static void main(String args[])
    // {
     //   MazeSolver m = new MazeSolver(new RandomMaze(20, 20).getBoard(), 1, 0);
      //  m.solveMaze();
     //}  
}
