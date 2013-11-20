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
		System.out.println(actionType);
		String sub = actionType.charAt(0) + "";
		System.out.println("Sub: " + sub);
		int multiplier = Integer.parseInt(sub);
		
		int newScore = multiplier * score;
		
		return newScore;
	}
	
	public String toString(){
		return actionType;
	}
}
