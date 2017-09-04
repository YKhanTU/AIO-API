package armyofdragons.api.aio.util;

import java.util.Random;

import org.dreambot.api.methods.Calculations;

import armyofdragons.api.aio.AIOScript;

public final class RandomUtil {
	
	// Logout time out of combat is 5 minutes with on interaction.
	
	public enum RandomType {
		
		NORMAL_REACTION,	// .5-1 second
		SHORT_PAUSE,		// 4-5 seconds
		LONG_PAUSE,			// 20-30 seconds
		AWAY_FROM_KEYBOARD	// 1-3 minutes
	}

	@SuppressWarnings("static-access")
	public static final void sleep(RandomType randomType) {
		switch(randomType) {
			case NORMAL_REACTION:
				
				AIOScript.getInstance().sleep(getSleepTime(500, 1000));
				
				return;
			case SHORT_PAUSE:
				
				AIOScript.getInstance().sleep(getSleepTime(2000, 10000));
				
				return;
			case LONG_PAUSE:
				
				AIOScript.getInstance().sleep(getSleepTime(20000, 30000));
				
				return;
			case AWAY_FROM_KEYBOARD:
				
				AIOScript.getInstance().sleep(getSleepTime(60000, 180000));
				
				return;
			default:
				return;
		}
	}
	
	public static final boolean getBoolean() {
		return new Random().nextBoolean();
	}
	
	private static final int getSleepTime(int min, int max) {
		return Calculations.random(min, max);
	}
}
