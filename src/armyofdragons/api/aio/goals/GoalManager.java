package armyofdragons.api.aio.goals;

import java.util.ArrayList;
import java.util.Iterator;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodContext;

public class GoalManager {

	public Client client;
	public MethodContext methodContext;
	
	private ArrayList<IGoal> goals;
	
	public GoalManager(Client client, MethodContext methodContext) {
		this.client = client;
		this.methodContext = methodContext;
		this.goals = new ArrayList<IGoal>();
	}

	public void poll() {
		Iterator<IGoal> goalIterator = goals.iterator();
		
		while(goalIterator.hasNext()) {
			
			IGoal goal = goalIterator.next();
			
			if(goal.isComplete()) {
				
				goal.onComplete();
				goalIterator.remove();
			}
		}
	}
}
