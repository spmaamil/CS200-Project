import java.util.*;

public class RandomMaze
{
	private boolean board[][];
	private int row;
	private int col;


	final int UP = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	final int RIGHT = 4;


	public RandomMaze(int width, int height)
	{
        row = height;
	    row += (height % 2 == 0)? 1:0;
	    col = width;
	    col +=(width % 2 == 0)? 1: 0;
	    board = new boolean[row][col];



	    int r = (int)(Math.random() * row);
	    while(r%2==0)
	        r = (int)(Math.random() * row);

	    int c = (int)(Math.random() * col);
	    while(c%2==0)
	        c = (int)(Math.random() * col);

	    System.out.println(board[0][0]);
	    board[r][c] = true;
	    generateMaze(r, c);
	    board[0][1] = true;
        board[row - 1 ][col - 2] = true;
    }

	private void generateMaze(int row, int col)
	{
		int[] rand = randDirs();
		//Scanner in = new Scanner(System.in);
		//in.nextLine();
		//System.out.println(this);
		for(int k = 0; k < 4; k++)
		{
		//System.out.println(rand[k]);
			switch(rand[k])
			{

				case 0:if(row - 2 > 0)
				{
					if(board[row - 2][col] == false)
					{
					board[row - 1][col] = true;
					board[row - 2][col] = true;
					generateMaze(row - 2, col);
					}
				}break;
				case 1:if(row + 2 < this.row)
				{
					if(board[row + 2][col] == false)
					{
					board[row + 1][col] = true;
					board[row + 2][col] = true;
					generateMaze(row + 2, col);
					}
				}break;
				case 2:if(col - 2 > 0)
				{
					if(board[row][col - 2] == false)
					{
					board[row][col-1] = true;
					board[row][col-2] = true;
					generateMaze(row, col-2);
				}
				}break;
				case 3:if(col + 2 < this.col)
				{
					if(board[row][col + 2] == false)
					{
					board[row][col+1] = true;
					board[row][col+2] = true;
					generateMaze(row, col+2);
				}
				}break;
			}
		}
	}

	private int[] randDirs()
	{
		ArrayList<Integer> randoms = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++)
			randoms.add(i);
		Collections.shuffle(randoms);
		int[] rand = new int[4];
		for(int k = 0; k < 4; k++)
		rand[k] = randoms.get(k);
		return rand;
	}

	public boolean[][] getBoard()
	{
		return board;
	}

	public String toString()
	{
		String toRet = "";
		for(int k = 0; k < row;k++)
		{
		for(int j = 0; j <col;j++)
		toRet += (board[k][j])?"  ":"██";
		toRet += "\n";
		}
		return toRet;
	}

	public static void main(String args[])
	{
	int w = Integer.parseInt(args[0]);
	int h = Integer.parseInt(args[1]);

	RandomMaze s = new RandomMaze(w,h);
	System.out.println(s);
	}
}
