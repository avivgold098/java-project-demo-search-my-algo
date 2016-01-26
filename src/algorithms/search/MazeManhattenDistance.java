package algorithms.search;

import algorithms.mazeGenerators.Position;
/**
 * this class extends from CommonMazeHeuristic 
 * and this class is also presnted another way for clac our distance
 *
 */
public class MazeManhattenDistance extends CommonMazeHeuristic{
	/**
	 * Ctor that call to the super ctor
	 * @param the end ofthe search problem
	 */
	public MazeManhattenDistance(State<Position> gs)
	{
		super(gs);
	}
	/**
	 * this method prensted the way to calculate the distance between the exit state and 
	 * specific another state that we sent in our method
	 * @param s- the specific state that we sent
	 * @return the distance that we calc with by Manhatten Distance
	 */
	@Override
	public double h(State<Position> s) {
		double y = gs.getState().getY() - s.getState().getY();
		double z = gs.getState().getZ() - s.getState().getZ();
		double x = gs.getState().getX() - s.getState().getX();
		if(y <0)
			y *= -1;
		if(z <0)
			z *= -1;
		if(x <0)
			x *= -1;
		return y+z+x;
	}
}
