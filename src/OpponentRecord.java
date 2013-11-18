

import java.util.Date;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.io.Serializable;

public class OpponentRecord extends Record implements Serializable
{
	private static final long serialVersionUID = 7965958213151418104L;
	private String opponentName;
	private Date lastPlayedOn;
	
	public OpponentRecord(int wins, int totalGames, String opponentName, Date lastPlayed)
	{
		this.wins = wins;
		this.totalGames = totalGames;
		this.opponentName = opponentName;
		this.lastPlayedOn = lastPlayed;
	}
	
	public String toString()
	{
		return opponentName+"\t"+wins+"\t"+(totalGames - wins)+"\t"+lastPlayedOn;
	}
	
	public String getOpponentName()
	{
		return opponentName;
	}
	
	public Date getLastPlayed()
	{
		return lastPlayedOn;
	}
	
}
