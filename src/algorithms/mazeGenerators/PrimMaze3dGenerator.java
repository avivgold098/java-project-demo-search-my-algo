package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
/**
 * the maze generator with using prim algo
 *
 */
public class PrimMaze3dGenerator extends CommonMaze3dGenerator{
	/**
	 *this method ccreate maze using the prim algo
	 * @param the mazes limits
	 * @param y is our maze high
	 * @param x is our maze width
	 * @param z length
	 */
	@Override
	public Maze3d generate(int y, int z, int x) {
		Maze3d mz = new Maze3d(y,z,x);
		ArrayList<Position> arr= new ArrayList<Position>();
		int a1,a2,a3,index,num;
		int b1,b2,b3;
		int [][][] pos = new int [y][z][x];
		Position w1 = new Position();
		Position w2 = new Position();
		Random rnd = new Random();
		w1.setX(rnd.nextInt(x));
		a1= w1.getX();
		w1.setY(rnd.nextInt(y));
		a3 =w1.getY();
		w1.setZ(rnd.nextInt(z));
		a2 =w1.getZ();
		mz.setStartPosition(a3,a2,a1);
		
		num=rnd.nextInt(x-2)+1;	
		w2.setX(num);
		b1=w2.getX();
		num=rnd.nextInt(y-2)+1;
		w2.setY(num);
		b3=w2.getY();
		num=rnd.nextInt(z-2)+1;
		w2.setZ(num);
		b2=w2.getZ();
		mz.setGoalPosition(b3, b2, b1);
		
		for(int i=0; i< pos.length;i++)
		{
			for(int j=0; j < pos[0].length; j++)
			{
				for(int h=0; h< pos[0][0].length;h++)
				{
					mz.changeNumber(i, j, h, 1);
				}
			}
		}
		mz.changeNumber(a3, a2, a1, 0);
		if(a3 > 1)
			if(mz.getMaze()[a3-1][a2][a1]==1 && mz.getMaze()[a3-2][a2][a1]==1)
			{
				arr.add(new Position(a3-1,a2,a1));
			}
		if(a2 > 1)
			if(mz.getMaze()[a3][a2-1][a1]==1 && mz.getMaze()[a3][a2-2][a1]==1)
			{
				arr.add(new Position(a3,a2-1,a1));
			}
		if(a1 > 1)
			if(mz.getMaze()[a3][a2][a1-1]==1 && mz.getMaze()[a3][a2][a1-2]==1)
			{
				arr.add(new Position(a3,a2,a1-1));
			}
		if(a3<pos.length-2)
		{
			if(mz.getMaze()[a3+1][a2][a1]==1 && mz.getMaze()[a3+2][a2][a1]==1)
			{
				arr.add(new Position(a3+1,a2,a1));
			}
		}
		if(a2<pos[0].length-2)
		{
			if(mz.getMaze()[a3][a2+1][a1]==1 && mz.getMaze()[a3][a2+2][a1]==1)
			{
				arr.add(new Position(a3,a2+1,a1));
			}
		}
		if(a1<pos[0][0].length-2)
		{
			if(mz.getMaze()[a3][a2][a1+1]==1 && mz.getMaze()[a3][a2][a1+2]==1)
			{
				arr.add(new Position(a3,a2,a1+1));
			}
		}
		while(!arr.isEmpty()&&(mz.getMaze()[b3][b2][b1]==1))
		{
			//System.out.println("R");
			index= rnd.nextInt(arr.size());
			a1=arr.get(index).getX();
			a2=arr.get(index).getZ();
			a3=arr.get(index).getY();
			//System.out.println(a3+" "+a2+" "+a1);
			mz.changeNumber(a3, a2, a1, 0);
			w2.setX(a1);
			w2.setY(a3);
			w2.setZ(a2);
			if(a3 > 1)
			{
				if(mz.getMaze()[a3-1][a2][a1]==1 && mz.getMaze()[a3-2][a2][a1]==1)
				{
					if(!arr.contains(new Position(a3-1,a2,a1)))
					{
						arr.add(new Position(a3-1,a2,a1));
					}
				}
			}
			if(a2 > 1)
			{
				if(mz.getMaze()[a3][a2-1][a1]==1 && mz.getMaze()[a3][a2-2][a1]==1) 
				{
					if(!arr.contains(new Position(a3,a2-1,a1)))
					{
						arr.add(new Position(a3,a2-1,a1));	
					}
				}
			}
			if(a1 > 1)
			{
				if(mz.getMaze()[a3][a2][a1-1]==1 && mz.getMaze()[a3][a2][a1-2]==1 )
				{
					if(!arr.contains(new Position(a3,a2,a1-1)))
					{
						arr.add(new Position(a3,a2,a1-1));
					}
				}
			}
			if(a3<pos.length-2)
			{
				if(mz.getMaze()[a3+1][a2][a1]==1 && mz.getMaze()[a3+2][a2][a1]==1 )
				{
					if(!arr.contains(new Position(a3+1,a2,a1)))
					{
						arr.add(new Position(a3+1,a2,a1));
					}
				}
			}
			if(a2<pos[0].length-2)
			{
				//w2.setZ(a2+1);
				if(mz.getMaze()[a3][a2+1][a1]==1 && mz.getMaze()[a3][a2+2][a1]==1) 
					{
						if(!arr.contains(new Position(a3,a2+1,a1)))
						{
							arr.add(new Position(a3,a2+1,a1));
					
						}
					}
			}
			if(a1<pos[0][0].length-2)
			{
				if(mz.getMaze()[a3][a2][a1+1]==1 && mz.getMaze()[a3][a2][a1+2]==1) 
				{
					if(!arr.contains(new Position(a3,a2,a1+1)))
					{
						arr.add(new Position(a3,a2,a1+1));
					
					}
				}
			}
			arr.remove(w2);
		}

		return mz;
		
		
	}

}
