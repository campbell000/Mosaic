

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.io.Serializable;

public class Record 
{
	private long id;
	
	protected int wins;
	protected int totalGames;
	
	public Record()
	{
		wins = 0;
		totalGames = 0;
	}
	
	public double getWinPercentage()
	{
		try
		{
			return ((double)wins / totalGames);
		}catch(Exception e){return 0;}
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public int getTotalGames()
	{
		return totalGames;
	}
	
	public int getLosses()
	{
		return (totalGames - wins);
	}
	
	public void addWins(int wins)
	{
		this.wins += wins;
	}
	
	public void addLosses(int losses)
	{
		totalGames += losses;
	}
}
