package Demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.CostComparator;
import algorithms.search.Heuristic;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattenDistance;
import algorithms.search.Searcher;
import algorithms.search.Solution;

public class Demo {
	public static void run()
	{
		Maze3dGenerator mg = new SimpleMaze3dGenerator();
		Maze3d maze = mg.generate(13, 13, 13);
		maze.printMaze();
		SearchableMaze sm = new SearchableMaze(maze);
		CostComparator<Position> c = new CostComparator<Position>();
		Searcher<Position> s = new BFS<Position>(c);
		Solution<Position> so = new Solution<Position>();
		so = s.search(sm);
		System.out.println("The BFS solution is:");
		so.printCountOfStates();
		Heuristic<Position> h1 = new MazeManhattenDistance(sm.getGoalState());
		AStar<Position> as = new AStar<Position>(h1,c);
		so = as.search(sm);
		System.out.println("The AStar solution by Manhatten Distance is:");
		so.printCountOfStates();
		so.printSolution();//
		Heuristic<Position> h2 = new MazeAirDistance(sm.getGoalState());
		AStar<Position> as2 = new AStar<Position>(h2,c);
		so = as2.search(sm);
		System.out.println("The AStar solution by Air Distance is:");
		so.printCountOfStates();
		so.printSolution();
	}
	public static void main(String[] args){
		run();
	}
}
