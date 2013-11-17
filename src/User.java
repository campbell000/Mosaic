

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.io.Serializable;

public class User 
{
	private long id;
	
	private String username;
	private String password;
	private String email;
	private Record record;
	private ArrayList<OpponentRecord> opponentRecords;
	private String IPAddress;
	
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		record = new Record();
		opponentRecords = new ArrayList<OpponentRecord>();
		
	}
	
	public String getIP()
	{
		return IPAddress;
	}
	
	public void setIP(String ip)
	{
		IPAddress = ip;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String p)
	{
		password = p;
	}
	
	public int getWins()
	{
		return record.getWins();
	}
	
	public int getLosses()
	{
		return record.getLosses();
	}
	
	public double getWinPercentage()
	{
		return record.getWinPercentage();
	}
	
	public void addToRecord(int wins, int losses)
	{
		this.record.addLosses(losses);
		this.record.addWins(wins);
	}
	
	Object [][] getOpponentRecordArray()
	{
		Object [][] opponentData = new Object [10][4];
		for (int i = 0; i < 10; i++)
		{
			if (i < opponentRecords.size())
			{
				OpponentRecord record = opponentRecords.get(i);
				opponentData[i][0] = record.getOpponentName();
				opponentData[i][1] = record.getWins();
				opponentData[i][2] = record.getLosses();
				
				//Create date String
				Calendar c = Calendar.getInstance();
				c.setTime(record.getLastPlayed());
				opponentData[i][3] = c.get(Calendar.MONTH)
						+"/"+c.get(Calendar.DATE)
						+"/"+c.get(Calendar.YEAR);
			}
			else
			{
				opponentData[i][0] = "-";
				opponentData[i][1] = "-";
				opponentData[i][2] = "-";
				opponentData[i][3] = "-";
			}
		}
		return opponentData;
	}
}
