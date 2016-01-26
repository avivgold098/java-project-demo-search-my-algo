package algorithms.search;
/**
 * interface 
 * this class is presnted the searcher way we use 
 * the diffrent algos for search
 */
public interface Searcher <T>{
	/**
	 *  search for our soltion
	 * @param s the type of our search problem
	 * @return the solution for our search problem
	 */
	public Solution<T> search(Searchable<T> s);
	/**
	 * return the number of the evaluated Nodes
	 * @return the number of the evaluated Nodes
	 */
	public int getNumberOfNodesEvaluated();
}
