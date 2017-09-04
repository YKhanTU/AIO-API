package armyofdragons.api.aio.goals;

/**
 * Repesents a Goal. Once a Goal is finished, code will execute to
 * do various tasks or, for example, stop the script.
 * @author Yusuf Khan
 *
 */
public interface IGoal {

	/**
	 * Notifies the GoalManager if the Goal has been completed.
	 * @return true if the Goal has been completed.
	 * false if the Goal has not been completed yet.
	 */
	boolean isComplete();
	/**
	 * Executed by the GoalManager once the Goal has been completed.
	 */
	void onComplete();
}
