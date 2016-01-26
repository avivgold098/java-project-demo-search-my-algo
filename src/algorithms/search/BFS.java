package algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/**
 * this class is presnted the bfs algo for search problem
 * with using this class we create soltion to our search problem
 */
public class BFS<T> extends CommonSearcher<T>{
	/**
	 * ctor for our class
	 */
	public BFS()
	{
		
	}
	/**
	 * ctor
	 * @param c - the way we want to compare
	 */
	public BFS (Comparator<State<T>> c)
	{
		super(c);
	}
	/**
	 * this method is the method that create our soliton with using the bfs algo
	 * @return the soltion
	 */
	public Solution<T> search(Searchable<T> s){
		addToOpenList(s.getInitialState());
		HashSet<State<T>> closedSet = new HashSet<State<T>>();
		
		while(openList.size() > 0)
		{
			State<T> n = popOpenList();
			closedSet.add(n);
			
			if(n.equals(s.getGoalState()))
					return backTrace(n, s.getInitialState());
			ArrayList <State<T>> successors = s.getAllPossibleStates(n);
			
			for(State<T> state : successors)
			{
				if(!closedSet.contains(state) && !openList.contains(state))
				{
					state.setCameFrom(n);
					addToOpenList(state);
				}
				
				else
				{
					if(state.getCost() > this.calculate(state))
					{
						if(!openList.contains(state))
						{
							state.setCameFrom(n);
							addToOpenList(state);
						}
						
						else
						{
							openList.remove(state);
							state.setCameFrom(n);
							addToOpenList(state);
						}
					}
				}
			}
			
		}
		return null;
	}
	/**
	 * this method calculate the cost for state s by using the fater
	 * @param s - the father that we sent
	 * @return the cost
	 */
	public double calculate(State<T> s)
	{ 
		if(s.getCameFrom() == null) return 0;
		return s.getCameFrom().getCost()+1;
	}
	
	
}
