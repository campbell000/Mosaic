/**
 * Special Space on board. It has an action to
 * be performed or calculated for the word or letter
 * @author rachelfraczkowski
 *
 */
public class SpecialSpace extends Space {

	Action action;
	
	/**
	 * Constructor, sets the action
	 * @param type, a string represented the action for the space
	 */
	protected SpecialSpace(String type){
	
		action = new Action(type);
		
	}
	
	/**
	 * ToString Method for SpecialSpace
	 */
	public String toString(){
		return action.toString();
	}
	
	/**
	 * Accessor for the action of the special spcae
	 * @return action, a string designating the action to
	 * 		be performed on the space.
	 */
	protected Action getAction(){
		return action;
	}
}
