package armyofdragons.api.aio.pathfinder;

public class NodeInteract implements INode {

	private String object;
	private String action;
	
	public NodeInteract(String object, String action) {
		this.object = object;
		this.action = action;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void process() {
		
	}
}
