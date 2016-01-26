package Demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;
/**
 * make the maze to searchable so we can doing search method 
 *
 */
public class SearchableMaze implements Searchable<Position>{
	Maze3d maze;
	/**
	 * the ctor for our SearchableMaze
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 * @return the Algorithm time
	 */
	public SearchableMaze(int y,int z,int x)
	{
		maze = new Maze3d(y,z,x);
	}
	/**
	 * our ctor that copied atnother maze to our maze
	 * @param maze the other maze we copied
	 */
	public SearchableMaze(Maze3d maze)
	{
		this.maze = maze;
	}
	/**
	 * this method return our maze start position
	 * @return our  state of the start position
	 */
	@Override
	public State<Position> getInitialState() {
		State<Position> s = new State<Position>();
		s.setCost(0);
		s.setCameFrom(null);
		s.setState(maze.getStartPosition());
		return s;
	}
	/**
	 * this method return our maze end position
	 * @return our  state of the start position
	 */
	@Override
	public State<Position> getGoalState() {
		State<Position> s = new State<Position>();
		s.setCost(1);
		s.setCameFrom(null);
		s.setState(maze.getGoalPosition());
		return s;
	}
	/**
	 * this method return all the posibble moves nest to the state s
	 * @param s the state we will find the possible moves for him
	 * @return arrlist that presnted with all the stated that presnted the posibble moves
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		ArrayList<State<Position>> arr = new ArrayList<State<Position>>();
		String[] moves = maze.getPossibleMoves(s.getState());
		int i = s.getState().getY();
		int j = s.getState().getZ();
		int k = s.getState().getX();
		for (int m = 0; m < moves.length; m++) {
			if(moves[m].equals("Up"))
				arr.add(new State<Position>(new Position(i+1,j,k)));
			if(moves[m].equals("Down"))
				arr.add(new State<Position>(new Position(i-1,j,k)));
			if(moves[m].equals("Forward"))
				arr.add(new State<Position>(new Position(i,j+1,k)));
			if(moves[m].equals("Backward"))
				arr.add(new State<Position>(new Position(i,j-1,k)));
			if(moves[m].equals("Right"))
				arr.add(new State<Position>(new Position(i,j,k+1)));
			if(moves[m].equals("Left"))
				arr.add(new State<Position>(new Position(i,j,k-1)));
		}
		return arr;
	}

}
