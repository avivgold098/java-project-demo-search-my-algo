package algorithms.search;

import java.util.ArrayList;

/**
 * Searchable's interface  that presnted our search problem
 */
public interface Searchable <T>{
	/**
	 * @return the start state  of our search problem
	 */
	State<T> getInitialState();
	/**
	 * @return the goal state
	 */
	State<T> getGoalState();
	/**
	 * return arrayList of all the states that have 0 next to the state s
	 * @param s the state you want find it's possible moves (neighbors)
	 */
	ArrayList<State<T>> getAllPossibleStates(State<T> s);
}
