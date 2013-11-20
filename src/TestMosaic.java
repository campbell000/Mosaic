import java.util.ArrayList;


public class TestMosaic {

	public static void main(String[] args){
		
		/*TileSystem test = new TileSystem();
		
		ArrayList<Tile> list = test.drawTiles(7);
		System.out.println("Initial list");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());}
		
		System.out.println("New tiles");
		ArrayList<Tile> newList = new ArrayList<Tile>();
		newList.add(list.get(0));
		list.remove(0);
		newList.add(list.get(1));
		list.remove(1);
		newList.add(list.get(list.size()-1));
		list.remove(list.size()-1);
		
		newList = test.swapTiles(newList);
		for(int i = 0; i < newList.size(); i++){
			System.out.println(newList.get(i).toString());
			list.add(newList.get(i));
		}
		
		
		System.out.println("New List");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());
		}
		*/
		Board board = new Board();
		
		//System.out.println(board.getSpaces(0,0,0,14));
		
		GameSystem game = new GameSystem();
		System.out.println("Place Word result: " + game.placeWord("PICKLE", 0,0,2,0));
		
		
		/*ArrayList<Space> spaces = board.getSpaces(0,0,2,0);
		System.out.println("Spaces size " + spaces.size());
		System.out.println("Score: " + game.getScore(spaces));
		*/
		//Action action = new Action("3W");
		//action.newValue(12);
		
		
		//ScoringSystem score = new ScoringSystem();
		//score.calculateScore(spaces);
	}
}
