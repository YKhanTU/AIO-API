package armyofdragons.api.aio;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;

import armyofdragons.api.aio.goals.GoalManager;

public abstract class AIOScript extends AbstractScript {

	public static AIOScript instance;
	
	private TaskManager taskManager;
	private GoalManager goalManager;
	
	private boolean isRunning = false;
	
	public static AIOScript getInstance() {
		return instance;
	}
	
	public AIOScript() {
		super();
		
		instance = this;
	}
	
	@Override
	public int onLoop() {
		while(!isRunning) {
			sleep(Calculations.random(500, 1000));
		}
		
		if(taskManager == null) {
			taskManager = new TaskManager(this.getClient(), this.getClient().getMethodContext());
		}
		
		if(goalManager == null) {
			goalManager = new GoalManager(this.getClient(), this.getClient().getMethodContext());
		}
		
		taskManager.poll();
		goalManager.poll();
		
		return 0;
	}

	public void setIsRunning(boolean b) {
		this.isRunning = true;
	}
}
