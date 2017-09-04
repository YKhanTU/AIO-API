package armyofdragons.api.aio;

public interface ITask {
	
	boolean canExecute();
	void execute();
	TaskPriority getTaskPriority();
}
