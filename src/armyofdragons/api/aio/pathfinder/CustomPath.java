package armyofdragons.api.aio.pathfinder;

import java.util.ArrayList;
import java.util.Collections;

public class CustomPath {

	// We will have it so that the custom path will be RANDOMIZED on processing.
	
	private ArrayList<INode> nodes;
	
	private boolean isReversed;
	
	public CustomPath() {
		this.nodes = new ArrayList<INode>();
		this.isReversed = false;
	}
	
	public void addNode(INode node) {
		nodes.add(node);
	}
	
	public void removeNode(INode node) {
		nodes.remove(node);
	}
	
	public void reverse() {
		if(isReversed)
			isReversed = false;
		else
			isReversed = true;
		
		Collections.reverse(nodes);
	}
	
	public boolean isReversed() {
		return isReversed;
	}
	
	public boolean isEmpty() {
		return nodes.isEmpty();
	}
}
