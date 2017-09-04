package armyofdragons.api.aio.goals;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

import armyofdragons.api.aio.AIOScript;
import armyofdragons.api.aio.util.RandomUtil;
import armyofdragons.api.aio.util.TabUtil;
import armyofdragons.api.aio.util.TabUtil.AttackStyle;

public final class GoalFactory {

	public static IGoal getLevelReachGoal(Skills skills, 
			Skill selectedSkill, Skill toSwapSkill, int targetGoal) {
		
		return new IGoal() {

			@Override
			public boolean isComplete() {
				return (skills.getRealLevel(selectedSkill) >= targetGoal);
			}

			@Override
			public void onComplete() {
				
				for(AttackStyle style : AttackStyle.values()) {
					
					if(style.getSkillEquivalent() == toSwapSkill) {
						
						TabUtil.switchCombatStyle(style);
						
						RandomUtil.sleep(RandomUtil.RandomType.NORMAL_REACTION);
						
						break;
					}
				}
				
			}
			
		};
	}
	
	public static IGoal getStopScriptGoal(Skills skills, 
			Skill selectedSkill, int targetGoal) {
		
		return new IGoal() {

			@Override
			public boolean isComplete() {
				return (skills.getRealLevel(selectedSkill) >= targetGoal);
			}

			@Override
			public void onComplete() {
				
				AIOScript.getInstance().stop();
			}
			
		};
	}
}
