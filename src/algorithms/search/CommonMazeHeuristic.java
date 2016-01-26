package algorithms.search;

import algorithms.mazeGenerators.Position;
/**
 * this class is presnted all the common methods of all heuristics we used
 */
public abstract class CommonMazeHeuristic implements Heuristic<Position>{
	/**
	 * the end state in our problem
	 */
	protected State<Position> gs;
	/**
	 * 	 ctor of our class
	 * @param gs- the exit of our search problem
	 */
	public CommonMazeHeuristic(State<Position> gs)
	{
		this.gs = gs;
	}
	@Override
	public abstract double h(State<Position> s);
}
