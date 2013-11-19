/**
 * Special Space on board
 * @author rachelfraczkowski
 *
 */
public class SpecialSpace extends Space {

	
	protected SpecialSpace(String type){
	
		action = new Action(type);
		
	}
}
