/**
 * Actions are an attribute of the SpecialSpace class and they are 
 * @author rachelfraczkowski
 *
 */
public class Action {
	
	String actionType;
	
	protected Action(String type){
		
		//Action type reflects special space type
		//3W for triple word
		actionType = type;
	}
	
	protected String getType(){
		return actionType.substring(1, 1);
	}
	protected int newValue(int score){
		
		//Multiplier defined by type
		if(actionType == null)
			return score;
		int multiplier = Integer.parseInt(actionType.substring(0,0));
		
		int newScore = multiplier * score;
		
		return newScore;
	}
	
	public String toString(){
		return actionType;
	}
}
