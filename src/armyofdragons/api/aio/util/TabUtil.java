package armyofdragons.api.aio.util;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.widget.Widget;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import armyofdragons.api.aio.AIOScript;

public final class TabUtil {

	/*
	 * Stab ID: 593, 3
	 * Lunge ID: 593, 7
	 * Slash ID: 593, 11
	 * Block ID: 593, 15
	*/
	
	public enum AttackStyle {
		ATTACK {
			@Override
			public Skill getSkillEquivalent() {
				return Skill.ATTACK;
			}
			
		},
		STRENGTH {

			@Override
			public Skill getSkillEquivalent() {
				return Skill.STRENGTH;
			}
			
		},
		CONTROLLED {

			@Override
			public Skill getSkillEquivalent() {
				return Skill.STRENGTH;
			}
			
		},
		DEFENSE {

			@Override
			public Skill getSkillEquivalent() {
				return Skill.DEFENCE;
			};
		
		};
		
		public abstract Skill getSkillEquivalent();
	}
	
	public static boolean isTabOpen(Tab tab) {
		return AIOScript.getInstance().getTabs().isOpen(tab);
	}
	
	public static boolean openTab(Tab tab) {
		return AIOScript.getInstance().getTabs().open(tab);
	}
	
	public static boolean randomOpenTab(Tab tab) {
		
		if(AIOScript.getInstance().getTabs().isOpen(tab))
			return true;
		
		boolean openMethod = Calculations.getRandom().nextBoolean();
		
		if(openMethod) {
			return AIOScript.getInstance().getTabs().openWithMouse(tab);
		}else{
			return AIOScript.getInstance().getTabs().openWithFKey(tab);
		}
	}
	
	public static boolean switchCombatStyle(AttackStyle attackStyle) {
		if(!isTabOpen(Tab.COMBAT))
			randomOpenTab(Tab.COMBAT);
		
		Widget attackStyles = AIOScript.getInstance().getWidgets().getWidget(493);
		
		switch(attackStyle) {
			case ATTACK:
				WidgetChild attackChild = attackStyles.getChild(3);
				return attackChild.interact("Stab");
			case STRENGTH:
				WidgetChild strengthChild = attackStyles.getChild(7);
				return strengthChild.interact("Lunge");
			case CONTROLLED:
				WidgetChild controlledChild = attackStyles.getChild(11);
				return controlledChild.interact("Slash");
			case DEFENSE:
				WidgetChild defenseChild = attackStyles.getChild(15);
				return defenseChild.interact("Block");
			default:
				return false;
		}
	}
	
	public static AttackStyle getCurrentAttackStyle() {
		int currentStyle = AIOScript.getInstance().getPlayerSettings().getConfig(43);
		
		switch(currentStyle) {
			case 0:
				return AttackStyle.ATTACK;
			case 1:
				return AttackStyle.STRENGTH;
			case 2:
				return AttackStyle.CONTROLLED;
			case 3:
				return AttackStyle.DEFENSE;
			default:
				return null;
			
		}
	}
}
