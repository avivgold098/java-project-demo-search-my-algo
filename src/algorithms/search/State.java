package algorithms.search;
/**
 * 
 * @author gabay eldar
 * State - y,z,x cost and who is his father 
 * @param <T> should be type of Position
 */
public class State <T> implements Comparable<State<T>>{
	
	private T state;
	private double cost;
	private State<T> cameFrom;
	/**
	 * our default ctor
	 */
	public State()
	{
	}
	/**
	 * opy ctor of our class 
	 * @param s the state we copied
	 */
	public State(T state)
	{
		this.state = state;
		this.cameFrom = new State<T>();
	}
	/**
	 * this method create hadcode for our state
	 */
	@Override
	public int hashCode() {
		return state.hashCode();
	}
	/**
	 * overloading of the equals methods
	 * @param the other state that we check the equals attribute with him
	 * @return T if the both states are equals otherwise f
	 */
	public boolean equals(State<T> s) {
		return state.equals(s.getState());
	}
	/**
	 * override of the equals methods w using low casting
	 * @param the other object that we check the equals attribute with him
	 * @return T if the both states are equals otherwise f
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass())
			return state.equals(((State<T>) obj).state);
		return false;
	}
	/**
	 * set our came from with another state 
	 * @param cameFrom with this state we set our came from 
	 */
	public void setCameFrom(State<T> n)
	{
		this.cameFrom = n;
	}
	/**
	 * this method return the data member of came from
	 * @return our came from date member
	 */
	public State<T> getCameFrom()
	{
		return cameFrom;
	}
	/**
	 * this method return our state cost
	 * @param our state costr
	 */
	public double getCost()
	{
		return cost;
	}
	/**
	 * this method set our cost value witn antoher value
	 *@param cost- the other value
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	/**
	 * set our state
	 * @param state the other state
	 */
	public void setState(T s)
	{
		this.state = s;
	}
	/**
	 * this methods return our state
	 * @return our state
	 */
	public T getState()
	{
		return this.state;
	}
	/**
	 * compare the costs between two states
	 */
	@Override
	public int compareTo(State<T> other) {
        if (getCost() > other.getCost()) {
            return -1;
        }
        if (getCost() < other.getCost()) {
            return 1;
        }
        return 0;
	}
	/**
	 * convert this class to string
	 */
	public String toString()
	{
		return state.toString();
	}
}
