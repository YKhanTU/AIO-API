package armyofdragons.api.aio.pathfinder;

import java.util.ArrayList;

public class NodeDialogue implements INode {

	//https://dreambot.org/javadocs/org/dreambot/api/methods/dialogues/Dialogues.html
	
	private ArrayList<Object> dialogueChoices;
	
	public NodeDialogue() {
		this.dialogueChoices = new ArrayList<Object>();
	}
	
	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}

	
}
