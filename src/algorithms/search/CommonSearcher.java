package algorithms.search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

import algorithms.mazeGenerators.Position;

/**
 *this class is presnted all  the common of all the searchers we have
 */
public abstract class CommonSearcher<T> implements Searcher<T>{
	
	protected PriorityQueue<State<T>> openList;
	private int evaluatedNodes;
	/**
	 * Ctor of our class
	 * @param c the compartor that we are using
	 */
	public CommonSearcher(Comparator<State<T>> c)
	{
		openList = new PriorityQueue<State<T>>(1,c);
		evaluatedNodes = 0;
	}
	/**
	 * deafult ctor
	 */
	public CommonSearcher()
	{
		openList = new PriorityQueue<State<T>>();
		evaluatedNodes = 0;
	}
	/**
	 * this method is pop from the open list and update the evaluenodes values
	 * @return the value we poped
	 */
	protected State<T> popOpenList()
	{
		evaluatedNodes++;
		return openList.poll();
	}
	/**
	 * the search method in our problem
	 * @param s - the search problem
	 */
	@Override
	public abstract Solution<T> search(Searchable<T> s);
	/**
	 * return the number of the evaluated Nodes
	 * @return the number of the evaluated Nodes
	 */
	@Override
	public int getNumberOfNodesEvaluated()
	{
		return evaluatedNodes;
	}
	/**
	 * set the number of the evaluated Nodes
	 * @param evaluatedNodes - the number of the evaluated Nodes that with him we set our value
	 */
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	/**
	 * calculate the cost by using the father
	 * @param s - the state father
	 * @return the cost
	 */
	protected abstract double calculate(State<T> s);
	/**
	 * add state to our open list
	 * @param s - the state we add to our open l
	 */
	protected void addToOpenList(State<T> state)
	{
		if(state.getCameFrom() != null)
			state.setCost(calculate(state));
		openList.add(state);
	}
	/**
	 * this method update the road from to exit
	 * @param exit - of the our search problem
	 * @param start - of the our search problem
	 * @return the soultion with all the states
	 */
	protected Solution<T> backTrace(State<T> end,State<T> start)
	{
		Solution<T> s = new Solution<T>();
		State<T> current = end;
		while(!current.equals(start))
		{
			s.addSolution(current);
			current = current.getCameFrom();
		}
		return s;
	}

	/**
	 * this method search our state in the queue and if he exist
	 * we change the exist statw with the state
	 * @param state - the new state to input in the queue
	 */
	protected void adjustPriority(State<T> state){
		Iterator<State<T>> iterator = openList.iterator();
		State<T> checkState = null;
		
		while(iterator.hasNext()){
			checkState = iterator.next();
			if(checkState.getState().equals(state.getState())){
					openList.remove(checkState);
					calculate(checkState);
					checkState.setCameFrom(state.getCameFrom());
					addToOpenList(checkState);
					return;
			}	
		}
	}
	/**
	 * this method check if our closed set conatins this state
	 * @param closedSet - the closed set we check
	 * @param state - for this state we checked the contains
	 * @return - return true if it contains otherwise we return f
	 */
	protected boolean closedSetContians(HashSet<State<T>> closedSet, State<T> state){
		Iterator<State<T>> iterator = closedSet.iterator();
		while(iterator.hasNext()){
			State<T> temp = iterator.next();
			if(state.getState().equals(temp.getState()))
				return true;
		}
		return false;
	}
	/**
	 * check this  state is contains in the open list
	 * @param state - the state to check if him conatins in the open list
	 * @return - return true if it contains otherwise f
	 */
	protected boolean openListContains(State<T> state){
		Iterator<State<T>> iterator = openList.iterator();
		while(iterator.hasNext()){
			State<T> temp = iterator.next();
			if(state.getState().equals(temp.getState()))
				return true;
		}
		return false;
	}
}
