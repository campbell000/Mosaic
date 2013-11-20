/**
 * The Scoring System calculates the score of the game and determines the winner and loser.
 * @author rachelfraczkowski
 *
 */

import java.util.*;

public class ScoringSystem {

	protected ScoringSystem(){
		
	}
	
	/**
	 * Calculates Score
	 * @param spaces
	 * @return
	 */
	protected int calculateScore(ArrayList<Space> spaces){
		
		int score = 0;
		boolean wordCalc = false;
		ArrayList<Action> wordActions = new ArrayList<Action>();
		
		for(int i = 0; i < spaces.size(); i++){
			Space temp = spaces.get(i);
			//If the space hasn't been used yet
			if(!temp.getUsed()){
				if(temp.getClass().isInstance(SpecialSpace.class)){
					SpecialSpace b = (SpecialSpace)temp;
					Action act = b.getAction();
					
					//action is double letter, double letters value
					if(act.getType() == "L")
							score += act.newValue(b.getTile().getValue());
					else
						wordCalc = true;
						wordActions.add(act);
				}
				else
					score += temp.getTile().getValue();
			}
			
			if(wordCalc){
				for(int j = 0; j < wordActions.size(); j++)
					score = wordActions.get(j).newValue(score);
			}
		}
		
		System.out.println(score);
		return score;
		
	}
}
