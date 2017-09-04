package armyofdragons.api.aio.state;

import armyofdragons.api.aio.AIOScript;

public enum BehaviorState {

	INITIALIZING,
	WALKING_PATH,
	IDLING,
	IN_COMBAT,
	INTERACTING,
	STOPPING;
	
	public static BehaviorState getCurrentState() {
		if(AIOScript.getInstance().getClient().isLoggedIn())
			return INITIALIZING;
		
		return null;
	}

}
