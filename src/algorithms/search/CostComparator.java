package algorithms.search;

import java.util.Comparator;
/**
 * generic  comparator 
 */
public class CostComparator<T> implements Comparator<State<T>>{
	/**
	 * compare between two <T> States
	 * @return like the compare method 1 if s1 cost is bigger the s2 cost
	 * @return like the compare method 0 if both of the costs they are equals
	 * @return like the compare method -1 if s1 cosr is smaller than the cost 
	 * of s2 cost
	 */
	@Override
	public int compare(State<T> st1, State<T> st2) {
		if(st1.getCost() > st2.getCost())
			return 1;
		if(st1.getCost() == st2.getCost())
			return 0;
		return -1;
	}
	
}
