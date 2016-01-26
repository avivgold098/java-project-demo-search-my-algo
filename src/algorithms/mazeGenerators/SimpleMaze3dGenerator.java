package algorithms.mazeGenerators;

import java.util.Random;
/**
 * create randomize  maze
 * 
 */
public class SimpleMaze3dGenerator extends CommonMaze3dGenerator{
	/**
	 * create randomize  maze
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 */
	@Override
	public Maze3d generate(int y, int z, int x) {
		Maze3d maze = new Maze3d(y,z,x);
		Random rand = new Random();
		//set the start position
		int randSY = rand.nextInt(y);
		int randSZ = rand.nextInt(z);
		int randSX = rand.nextInt(x);
		maze.setStartPosition(randSY, randSZ, randSX);
		maze.changeNumber(randSY, randSZ, randSX, 0);
		int i = randSY;
		int j = randSX;
		int k = randSZ;
		//set the goal position
		int randGY = rand.nextInt(y);
		int randGZ = rand.nextInt(z);
		int randGX = rand.nextInt(x);
		maze.setGoalPosition(randGY, randGZ, randGX);
		maze.changeNumber(randGY, randGZ, randGX, 0);
		while(j != randGX || i != randGY || k != randGZ)
		{
			int direction  = rand.nextInt(6);
			
			if(direction == 0 && i<y-1)
				i++;
			if(direction == 1 && i>0)
				i--;
			if(direction == 2 && j<x-1)
				j++;
			if(direction == 3 && j>0)
				j--;
			if(direction == 4 && k<z-1)
				k++;
			if(direction == 5 && k>0)
				k--;
			maze.changeNumber(i, k, j, 0);
		}
		
		return maze;
	}

}
