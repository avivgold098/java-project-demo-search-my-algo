package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * this class is presnted some position (y,z,x) in our maze
 *
 */
public class Position implements Serializable{
	private int x;
	private int y;
	private int z;

	/**
	 * this method check if two position are equals
	 * @param obj - the other object that we check if he is equal using down casting
	 * @return boolean t if the are equals otherwise f
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	/**
	 * this method make the date to hash cose
	 * @return int the hash code we create
	 */
	@Override
	public int hashCode()
	{
		String s = "" +this.getY() + this.getZ() + this.getX();
		return s.hashCode();
	}
	/**
	 * ctor	with y, z, x parm
	 *
	 */
	public Position(int y, int z, int x) {
		this.y = y;
		this.x = x;
		this.z = z;	
	}
	/**
	 * default ctor that puts in all date mebers 0
	 */
	public Position() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	/**
	 * convert our class from position to string
	 * @return String the string that presnted our class
	 */
	@Override
	public String toString()
	{
		return this.y+" "+this.z+" "+this.x;	
	}
	/**
	 * return x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 *set x
	 *@param x - the parm with him we set our date member
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * return y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 *set y
	 *@param y - the parm with him we set our date member
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * return z
	 * @return z
	 */
	public int getZ() {
		return z;
	}
	/**
	 *set z
	 *@param z - the parm with him we set our date member
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
}
