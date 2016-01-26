package algorithms.search;

import algorithms.mazeGenerators.Position;
/**
 * this class is presnted the maze air distance calac and this class
 * is also extends from CommonMazeHeuristic 
 */
public class MazeAirDistance extends CommonMazeHeuristic{
	/**
	 * ctor that call to the super ctior
	 * @param exitstate
	 */
	public MazeAirDistance(State<Position> gs) {
		super(gs);
	}
	/**
	 * this method prensted the way to calculate the distance between the exit state and 
	 * specific another state that we sent in our method
	 * @param s- the specific state that we sent
	 * @return the distance that we calc with by air distance
	 */
	@Override
	public double h(State<Position> s) {
		double y = gs.getState().getY() - s.getState().getY();
		double z = gs.getState().getZ() - s.getState().getZ();
		double x = gs.getState().getX() - s.getState().getX();
		double product;
		if(y <0)
			y *= -1;
		if(z <0)
			z *= -1;
		if(x <0)
			x *= -1;
		product = y*y + x*x + z*z;
		product = Math.sqrt(product);
		return product;
	}
	

}
