package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this class is presnted our soltion and his methods
 */
public class Solution<T>{

	private ArrayList<State<T>> solution;// the soltion states
	/**
	 * deafult ctor for our class 
	 */
	public Solution()
	{
		this.solution = new ArrayList<State<T>>();
	}
	

	public void setSolution(ArrayList<State<T>> solution) {
		this.solution = solution;
	}

	/**
	 * this method return our array list of the stated of the soultions
	 * @return -the array list with all the soltions states
	 */
	public ArrayList<State<T>> getSolution()
	{
		return this.solution;
	}
	/**
	 * 
	 * @return the array list size (number of states in the sol)
	 */
	public int getSolutionSize()
	{
		return this.solution.size();
	}
	/**
	 * this methods print the num of states in our sol
	 */
	public void printCountOfStates()
	{
		int count =0;
		for (int i = 0; i < this.solution.size(); i++) {
			count++;
		}
		System.out.println("The number of States of the Solution is: "+count);
	}
	/**
	 * this method print our soltion
	 */
	public void printSolution()
	{
		for (int i = 0; i < this.solution.size(); i++) {
			System.out.println(this.solution.get(i));
		}
	}
	/**
	 * this methods add a new state to our array list
	 * @param s - the state we added into our array list 
	 */
	public void addSolution(State<T> s)
	{
		this.solution.add(s);
	}
	/**
	 * convet  the solution to string
	 * @return String s that presnted our sol
	 */
	@Override
	public String toString()
	{
		String s = new String("");
		for (int i = 0; i < this.solution.size(); i++) {
			s += "\n";
			s += this.solution.get(i);
		}
		return s;
	}
}
