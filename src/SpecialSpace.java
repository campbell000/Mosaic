/**
 * Special Space on board
 * @author rachelfraczkowski
 *
 */
public class SpecialSpace extends Space {

	Action action;
	
	protected SpecialSpace(String type){
	
		action = new Action(type);
		
	}
	
	public String toString(){
		return action.toString();
	}
	
	protected Action getAction(){
		return action;
	}
}
