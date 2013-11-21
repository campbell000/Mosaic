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
	 * Calculates Score given an ArrayList of Spaces
	 * @param spaces, an arraylist of type Space
	 * @return an int that represents the score of the tiles on these spaces
	 */
	protected int calculateScore(ArrayList<Space> spaces){
		
		int score = 0;
		boolean wordCalc = false;
		ArrayList<Action> wordActions = new ArrayList<Action>();

		//For all the spaces in the array
		for(int i = 0; i < spaces.size(); i++){
			System.out.println("i: " + i);
			
			//Set a temporary space
			Space temp = spaces.get(i);
			
			//If the space hasn't been used yet
			if(!temp.getUsed()){
				
				if(temp.getClass().equals(SpecialSpace.class)){
					System.out.println("Special Space!!!");
					SpecialSpace b = (SpecialSpace)temp;
					Action act = b.getAction();
					temp.setUsed();
					//action is double letter, double letters value
					if(act.getType() == "L"){
							//System.out.println("Temps value is: " + temp.getTile().getValue());
							score += act.newValue(b.getTile().getValue());}
					else{
						score += b.getTile().getValue();
						wordCalc = true;
						wordActions.add(act);
					}
				}
				else if(temp.isOccupied()){
					//System.out.println("isOccupied value" + temp.getTile().getValue());
					score += temp.getTile().getValue();
					//System.out.println("score: " + score);
					temp.setUsed();
				}
				else
					System.out.println("Error");					
				}
			
			}
		
			if(wordCalc){
				for(int j = 0; j < wordActions.size(); j++){
					//System.out.println("OldScore = " + score);
					score = wordActions.get(j).newValue(score);}
			}
		
		//System.out.println("Final Score: " + score);
		return score;
		
	}
}
