package room;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the fourth possible directions 
 */

public enum Direction {

	NORTH, SOUTH, EAST, WEST;
	
	/**
	 * 
	 * @param direction current direction
	 * @return the opposite direction
	 */
	
	public static Direction opposite(Direction direction) {
		switch (direction) {
		case NORTH:
			return SOUTH;
		case SOUTH:
			return NORTH;
		case EAST:
			return WEST;
		case WEST:
			return EAST;
		}
		return direction;
	}
}
