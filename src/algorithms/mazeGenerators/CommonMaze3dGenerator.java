package algorithms.mazeGenerators;

/**
 * /this class contains all the common things to different mazes
 */
public abstract class CommonMaze3dGenerator implements Maze3dGenerator{
	/**
	 * //Calculate the time to crate our maze takes
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 * @return the  time our algo takes to build to the maze
	 */
	@Override
	public String measureAlgorithmTime(int y,int z,int x) {
		long timeBefore = System.currentTimeMillis();
		this.generate(y, z, x);
		long timeAfter = System.currentTimeMillis();
		String time = Long.toString(timeAfter - timeBefore); 
		return time;
	}
	/**
	 * this method build our maze with the prim algo
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 * @return maze3d class with updated arr and start and exit position
	 */
	public abstract Maze3d generate(int y,int z, int x);
	
}
