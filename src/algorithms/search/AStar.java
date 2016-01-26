package algorithms.search;

import java.util.Comparator;

/**
 * this class is presnted the astar algo
 * also this class exnteds from the bfs class
 */

public class AStar<T> extends BFS<T>{
	/**
	 * distance from the exit of the maze
	 */
	private Heuristic<T> heuristic;
	/**
	 * constructor  ctor of our class 
	 * @param h - it is the distance to the exit
	 */
	public AStar(Heuristic<T> heuristic)
	{
			this.heuristic = heuristic;
	}
	/**
	 * ctor 
	 * @param h - the distance to the end of the maze
	 * @param c - the way we compare two states
	 */
	public AStar(Heuristic<T> heuristic,Comparator<State<T>> c)
	{
		super(c);
		this.heuristic = heuristic;
	}
	/**
	 * 
	 * @param s the our maze or search problem
	 * @return Solution<T> the soltion to our problem
	 */
	@Override
	public Solution<T> search(Searchable<T> s)
	{
		return super.search(s);
	}
	/**
	 * this method calculate the cost for state s from the start
	 * @param the state we calc for him the cost
	 * return the cost from the parm state from the start
	 */
	@Override
	public double calculate(State<T> s)
	{
		return super.calculate(s) + heuristic.h(s);
	}
}
