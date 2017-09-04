package armyofdragons.api.aio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodContext;

public class TaskManager {

	public Client client;
	public MethodContext methodContext;
	
	private ArrayList<ITask> tasks;
	
	public TaskManager(Client client, MethodContext methodContext) {
		this.client = client;
		this.methodContext = methodContext;
		this.tasks = new ArrayList<ITask>();
	}
	
	public void poll() {
		
		for(ITask task : tasks) {
			
			if(task.canExecute()) {
				
				task.execute();
				
				return;
			}
		}
	}
	
	/**
	 * 
	 * @param isAscending true if you want to sort in ascending order (0, 1, 2, 3, etc) false for latter vice-versa
	 * @return
	 */
	public void sort(boolean isAscending) {
		Collections.sort(tasks, new Comparator<ITask>() {

			@Override
			public int compare(ITask one, ITask two) {
				if(isAscending)
					return (one.getTaskPriority().compareTo(two.getTaskPriority()));
				
				return -(one.getTaskPriority().compareTo(two.getTaskPriority()));
			}
		
		});
	}
}
