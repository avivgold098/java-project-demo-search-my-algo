package algorithms.search;
/**
 * our interface of the all herusicies

 */
public interface Heuristic<T> {
	public double h(State<T> s);
}
