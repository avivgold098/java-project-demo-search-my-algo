package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * this is presented the class of the maze and include our 3dMaze methods
 */

public class Maze3d implements Serializable{
	/**
	 * this 3d arr is presnted our maze
	 */
	private int [][][] maze;
	private Position startPosition;
	private Position goalPosition;
	
	/**
	 * Default ctor for our maze class
	 * initialize our data members to null
	 */
	public Maze3d() {
		this.maze = null;
		this.startPosition = null;
		this.goalPosition = null;
	}
	
	/**
	 * ctor to our class with another maze
	 * @param maze - the other maze for initialize our maze
	 */
	public Maze3d(int[][][] m)
	{
		this.maze = m;
	}
	/**
	 * the ctor of our maze class with the limits parm
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 */
	public Maze3d(int y,int z,int x)
	{
		this.maze = new int[y][z][x];
		for(int i = 0;i<y;i++)
		{
			for(int j = 0;j<z;j++)
			{
				for(int k = 0;k<x;k++)
				{
					this.maze[i][j][k]=1;
				}
			}
		}
		
	}
	/**
	 * ctor to our maze3d class that build our class from bytes arr
	 * @param b - with this bytes arr we build our class by "reading" the infromation
	 */
	public Maze3d(byte[] b)
	{
		this.maze = new int[(int)b[0]][(int)b[1]][(int)b[2]];
		this.setStartPosition((int)b[3], (int)b[4], (int)b[5]);
		this.setGoalPosition((int)b[6],(int)b[7],(int)b[8]);
		int counter = 9;
		for(int i = 0;i<b[0];i++)
		{
			for(int j = 0;j<b[1];j++)
			{
				for(int k = 0;k<b[2];k++)
				{
					this.maze[i][j][k] = (int)b[counter];
					counter++;
				}
			}
		}
	}
	/**
	 * return our 3d maze by 3darr
	 * @return int[][][] - our 3d arr that presnted our maze
	 */
	public int[][][] getMaze() {
		return maze;
	}
	/**
	 * this method set our maze 3d arr with another 3d arr
	 * @param maze the other maze that copied to our maze
	 */
	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}
	/**
	 * this method return the our  start of the maze position
	 * @return  position the presnted our start of the maze
	 */
	public Position getStartPosition()
	{
		return startPosition;
	}
	/**
	 * this method return the our  end of the maze position
	 * @return  position the presnted our end of the maze
	 */
	public Position getGoalPosition()
	{
		return goalPosition;
	}
	/**
	 * set our start position with another position that we create with the parms
	 * @param y is our position high
	 * @param x is our position width
	 * @param z  is our position length
	 */
	public void setStartPosition(int y,int z,int x)
	{
		this.startPosition = new Position(y,z,x);
	}
	/**
	 * set our end position with another position that we create with the parms
	 * @param y is our position high
	 * @param x is our position width
	 * @param z  is our position length
	 */
	public void setGoalPosition(int y,int z,int x)
	{
		this.goalPosition = new Position(y,z,x);
	}
	/**
	 * this method return our all possibleMoves from some position p 
	 * so this method return the position p neighbors
	 * @param the position for him we check the moves
	 * @return string of all the moves can do (the neighbors)
	 */
	public String[] getPossibleMoves(Position p)
	{
		int x,y,z,counter = 0; 
		String[] moves;
		
		x = p.getX();
		y = p.getY();
		z = p.getZ();
		
		if(y+1 < maze.length)
			if(this.maze[y+1][z][x] == 0)
				counter++;
		if(y-1 >= 0)
			if(this.maze[y-1][z][x] == 0)
				counter++;
		if(z+1 < maze[0].length)
			if(this.maze[y][z+1][x] == 0)
				counter++;
		if(z-1 >= 0)
			if(this.maze[y][z-1][x] == 0)
				counter++;
		if(x+1 < maze[0][0].length)
			if(this.maze[y][z][x+1] == 0)
				counter++;
		if(x-1 >= 0)
			if(this.maze[y][z][x-1] == 0)
				counter++;
		
		moves = new String[counter];
		int j = 0;
		
		if(y+1 < maze.length)
			if(this.maze[y+1][z][x] == 0)
			{
				moves[j] = "Up";
				j++;
			}
		if(y-1 >= 0)
			if(this.maze[y-1][z][x] == 0)
			{
				moves[j] = "Down";
				j++;
			}
		if(z+1 < maze[0].length)
			if(this.maze[y][z+1][x] == 0)
			{
				moves[j] = "Forward";
				j++;
			}
		if(z-1 >= 0)
			if(this.maze[y][z-1][x] == 0)
			{
				moves[j] = "Backward";
				j++;
			}
		if(x+1 < maze[0][0].length)
			if(this.maze[y][z][x+1] == 0)
			{
				moves[j] = "Right";
				j++;
			}
		if(x-1 >= 0)
			if(this.maze[y][z][x-1] == 0)
			{
				moves[j] = "Left";
				j++;
			}
		
		return moves;
		
	}
	/**
	 * this method return cross X of our maze
	 * @param num with this value we make the cross
	 * @return int[][] the presnted the cross section that create by the num
	 */
	public int[][] getCrossSectionByX(int num)
	{
		int[][] arr = new int[maze.length][maze[0].length];
		for(int i = 0; i<arr.length;i++)
		{
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = this.maze[i][j][num];
			}
		}
		return arr;
		
	}
	/**
	 * this method return cross Y of our maze
	 * @param num with this value we make the cross
	 * @return int[][] the presnted the cross section that create by the num
	 */
	public int[][] getCrossSectionByY(int num)
	{
		int[][] arr = new int[maze[0].length][maze[0][0].length];
		for(int i = 0; i<arr.length;i++)
		{
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = this.maze[num][i][j];
			}
		}
		return arr;
		
	}
	/**
	 * this method return cross Z of our maze
	 * @param num with this value we make the cross
	 * @return int[][] the presnted the cross section that create by the num
	 */
	public int[][] getCrossSectionByZ(int num)
	{
		int[][] arr = new int[maze.length][maze[0][0].length];
		for(int i = 0; i<arr.length;i++)
		{
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = this.maze[i][num][j];
			}
		}
		return arr;
		
	}
	/**
	 * this method change value of position(y,z,x) 
	 * @param y is our position high
	 * @param x is our position width
	 * @param z is our position z value
	 * @param value the value we wont to put in the position
	 */
	public void changeNumber(int y,int z,int x,int numChange)
	{
		this.maze[y][z][x] = numChange;
	}
	/**
	 * this method print our 3d maze
	 */
	public void printMaze()
	{
		for(int i = 0;i<maze.length;i++)
		{
			System.out.println("");
			for(int j = 0;j<maze[0].length;j++)
			{
				System.out.println("");
				for(int k = 0;k<maze[0][0].length;k++)
				{
					System.out.print(maze[i][j][k]);
				}
			}
		}
		System.out.println("");
	}
	/**
	 * this method convert our 3d maze class to bytes arr thar presnted all our data members
	 * @return the byte[] that presnted our 3d maze
	 */
	public byte[] toByteArray()
	{
		byte[] b = new byte[(this.maze.length*this.maze[0].length*this.maze[0][0].length)+9];
		b[0] = (byte) this.maze.length;
		b[1] = (byte) this.maze[0].length;
		b[2] = (byte) this.maze[0][0].length;
		b[3] = (byte) this.getStartPosition().getY();
		b[4] = (byte) this.getStartPosition().getZ();
		b[5] = (byte) this.getStartPosition().getX();
		b[6] = (byte) this.getGoalPosition().getY();
		b[7] = (byte) this.getGoalPosition().getZ();
		b[8] = (byte) this.getGoalPosition().getX();
		int counter = 9;
		for(int i = 0;i<maze.length;i++)
		{
			for(int j = 0;j<maze[0].length;j++)
			{
				for(int k = 0;k<maze[0][0].length;k++)
				{
					b[counter] = (byte) this.maze[i][j][k];
					counter++;
				}
			}
		}
		return b;
		
	}
	/**
	 * check if the other maze we sent in the method is equal to our maze
	 * @param m the other maze that we check the equals attribute for him
	 * @return T if the both maze are equals 
	 * else we return F
	 */
	public boolean equals(Maze3d m) {
		if(maze.length!=m.getMaze().length)
			return false;
		if(maze[0].length!=m.getMaze()[0].length)
			return false;
		if(maze[0][0].length!=m.getMaze()[0][0].length)
			return false;
		for(int i=0;i<maze.length;i++)
			for(int j=0;j<maze[0].length;j++)
				for(int k=0;k<maze[0][0].length;k++)
					if(maze[i][j][k]!=m.getMaze()[i][j][k])
						return false;
		if(!m.getStartPosition().equals(this.startPosition))
			return false;
		if(!m.getGoalPosition().equals(this.goalPosition))
			return false;
		return true;
	}
	/**
	 * this method convert our 3d maze to String
	 * @return the string that presnted our maze
	 */
	@Override
	public String toString()
	{
		String s = new String("");
		for (int i = 0; i < maze.length; i++) {
			s+= "\n";
			s+= "Floor #";
			s+= (i+1);
			s+= ":";
			s+= "\n";
			for (int j = 0; j < maze[0].length; j++) {
				s+= "\n";
				for (int j2 = 0; j2 < maze[0][0].length; j2++) {
					s += this.maze[i][j][j2];
					s += "  ";
				}
			}
			s+= "\n";
		}
		return s;
	}
}
