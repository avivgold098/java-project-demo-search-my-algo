package algorithms.mazeGenerators;

/** interface  that include all the common to maze generators
 * 
 */
public interface Maze3dGenerator {
	/**
	 * build our maze
	 * @param y is our maze high
	 * @param z is our maze width
	 * @param x is our maze length
	 * @return the maze
	 */
	public Maze3d generate(int y,int z,int x);
	/** //Calculate the time to crate our maze takes
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 * @return the Algorithm time
	 */
	public String measureAlgorithmTime(int y,int z,int x);
}
