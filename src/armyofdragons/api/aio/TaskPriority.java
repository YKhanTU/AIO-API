package armyofdragons.api.aio;

/**
 * The priority at which a Task should be executed at.
 * @author Yusuf Khan
 *
 */
public enum TaskPriority {

	VERY_LOW(0),
	
	LOW(1),
	
	MEDIUM(2),
	
	HIGH(3),
	
	VERY_HIGH(4),
	/**
	 * Bypasses all other Task priority levels.
	 */
	BYPASS_ALL(99);
	
	/**
	 * A level that correlates with how high of a priority
	 * the Task is. Used mainly for sorting.
	 */
	private int level;
	
	TaskPriority(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
}
