/**
 * Action class
 * This class determines what a specialSpace changes with scoring.
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
	
	/**
	 * Accessor for the actionType's letter
	 * @return String of either "L" or "W"
	 */
	protected String getType(){
		return actionType.substring(1, 1);
	}
	
	/**
	 * Takes the score of a word or letter and completes
	 * the correct multiplication on the score. For example,
	 * Given a score of 1, and an action type of 3L, the score
	 * would be 3. 
	 * 
	 * @param score of either a letter or a word
	 * @return the new value of the score
	 */
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
	
	/**
	 * To String method for Action
	 */
	public String toString(){
		return actionType;
	}
}
